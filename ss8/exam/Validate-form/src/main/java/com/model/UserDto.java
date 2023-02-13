package com.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Component
public class UserDto implements Validator {

    private int id;
    @NotBlank(message = "cần đủ 4-45 ký tự")
    @Pattern(regexp = "^[a-zA-Z]{4,45}", message = "cần đủ 4-45 ký tự")
    private String firstName;

    @NotBlank(message = "cần đủ 4-45 ký tự")
    @Pattern(regexp = "^[a-zA-Z]{4,45}", message = "cần đủ 4-45 ký tự")
    private String lastName;
    @Pattern(regexp = "^0[0-9]{9}", message = "số điện thoại bắt đầu bằng 0 và 10 số")
    private String phoneNumber;
    @Pattern(regexp = "^(18|[2-9][0-9]|[1-9][0-9]{2,})$", message = "tuổi phải lớn hơn 17")
    private String age;
    @Email(message = "email không đúng ddihj dạng")
    private String email;



    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        String phoneNumber = userDto.getPhoneNumber();
        if (phoneNumber.length()!=10) {
            errors.rejectValue("phoneNumber", "phoneNumber","sdt là 10 số");
        }
    }
}
