package com.javamaster.spring_crud.dto;

import com.javamaster.spring_crud.exception.ValidationException;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;

import static java.util.Objects.isNull;

@Data
public class AddressDto {

    private Integer id;
    private String region;
    private String city;
    private String street;
    private String house;
    private String apartment;


    private void validateUserDto(AddressDto addressDto) throws ValidationException {
        if (isNull(addressDto)) {
            throw new ValidationException("Object user is null");
        }
//        if (isNull(addressDto.getLogin()) || addressDto.getLogin().isEmpty()) {
//            throw new ValidationException("Login is empty");
//        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}