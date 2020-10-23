package com.javamaster.spring_crud.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "address_table")
//@Data              //ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
//@NoArgsConstructor //ломбок аннотация: конструктор без аргуметов
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull(message=" обязателен для заполнения")
    private String region;

    @Column
    @NotNull(message=" обязателен для заполнения")
    private String city;

    @Column
    @NotNull(message=" обязателен для заполнения")
    private String street;

    @Column
    @NotNull(message=" обязателен для заполнения")
    private String house;

    @Column
    private String apartment;


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
        return "AddressEntity{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}