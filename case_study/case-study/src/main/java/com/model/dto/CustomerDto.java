package com.model.dto;

import com.model.customer.CustomerType;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

public class CustomerDto {
    private long id;
    @Pattern(regexp = "^[A-Z]\\p{L}+(\\s[A-Z]\\p{L}*)+$", message = "Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa")
    private String name;

    private String dateOfBirt;
    private String gender;
    @Pattern(regexp = "^[0-9]{9}|[0-9]{12}", message = "id card bao gồm 9 hoặc 12 số")
    private String idCard;
    @Pattern(regexp = "^(\\(84\\)\\+9[01]\\d{7})|(09[01]\\d{7})$",
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx.")
    private String phoneNumber;
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+$", message = "định dạng email xxx@xxx.xxx")
    private String email;

    private String address;

    private CustomerType customerType;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirt() {
        return dateOfBirt;
    }

    public void setDateOfBirt(String dateOfBirt) {
        this.dateOfBirt = dateOfBirt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
