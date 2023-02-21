package com.repository;

import com.model.customer.Customer;
import com.model.faccility.Facility;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Long> {
   @Query(value = "select * from Facility where name like concat('%',:name,'%') " +
           "and facility_type_id like concat('%',:facilityTypeId,'%')",nativeQuery = true)
    Page<Facility> findAll(@Param("name") String name, @Param("facilityTypeId") String facilityTypeId,Pageable pageable);
}
