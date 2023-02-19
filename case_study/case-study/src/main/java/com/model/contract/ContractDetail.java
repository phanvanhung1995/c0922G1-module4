package com.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "contract_id",nullable = false,referencedColumnName = "id")
    private Contract contractID;
    @ManyToOne
    @JoinColumn(name = "attach_facility_id",nullable = false,referencedColumnName = "id")
    private AttachFacility attachFacilityID;

    public ContractDetail() {
    }

    public ContractDetail(long id, int quantity, Contract contractID, AttachFacility attachFacilityID) {
        this.id = id;
        this.quantity = quantity;
        this.contractID = contractID;
        this.attachFacilityID = attachFacilityID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContractID() {
        return contractID;
    }

    public void setContractID(Contract contractID) {
        this.contractID = contractID;
    }

    public AttachFacility getAttachFacilityID() {
        return attachFacilityID;
    }

    public void setAttachFacilityID(AttachFacility attachFacilityID) {
        this.attachFacilityID = attachFacilityID;
    }
}
