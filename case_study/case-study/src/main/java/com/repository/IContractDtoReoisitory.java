package com.repository;

import com.model.contract.AttachFacility;
import com.model.contract.Contract;
import com.model.dto.IAttachFacilityDto;
import com.model.dto.IContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDtoReoisitory extends JpaRepository<Contract, Long> {

    @Query(value = "select contract.id as contractId, facility.name as facilityName, customer.name as customerName,contract.star_date as starDate\n" +
            "  , contract.end_date as endDate, contract.deposit as deposit,(sum(ifnull(attach_facility.cost,0)* ifnull(contract_detail.quantity,0) \n" +
            "  + facility.cost)) as total from `contract` \n" +
            "  left join `facility` on facility.id = contract.facility_id\n" +
            "  left join `customer` on customer.id = contract.customer_id\n" +
            "  left join `contract_detail` on contract_detail.contract = contract.id\n" +
            "  left join `attach_facility` on attach_facility.id = contract_detail.attach_facility\n" +
            "  group by contract.id", nativeQuery = true)
    Page<IContractDto> findAllContract(Pageable pageable);

    @Query(value = "select contract_detail.contract as contractId, attach_facility.name as name,attach_facility.cost as cost,\n" +
            "  attach_facility.status as status,attach_facility.unit as unit,contract_detail.quantity as quantity from contract \n" +
            "  left join contract_detail on contract_detail.contract = contract.id\n" +
            "  left join attach_facility on attach_facility.id = contract_detail.attach_facility\n" +
            "  where contract.id = :contractId", nativeQuery = true)
    List<IAttachFacilityDto> findAttachFacility(@Param("contractId") long id);
}