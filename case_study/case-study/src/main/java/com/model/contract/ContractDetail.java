package com.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "contract",nullable = false,referencedColumnName = "id")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_facility",nullable = false,referencedColumnName = "id")
    private AttachFacility attachFacility;

    public ContractDetail() {
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




    public AttachFacility getAttachFacility() {
        return attachFacility;
    }


    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }
}
