package com.model.dto;

import com.model.contract.AttachFacility;
import com.model.contract.Contract;

import javax.validation.constraints.Pattern;

public class ContractDetailDto {
    private Contract contract;
    @Pattern(regexp = "^[0-9]+", message = "số lượng phải lớn hơn không")
    private int quantity;
    private AttachFacility attachFacility;

    public Contract getContract() {
        return contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
