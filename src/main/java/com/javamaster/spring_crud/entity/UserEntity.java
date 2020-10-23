package com.javamaster.spring_crud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.DateTimeException;

@Entity
@Table(name = "user_table")
//@Data              //ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
//@NoArgsConstructor //ломбок аннотация: конструктор без аргуметов
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
//    @NotNull(message="Имя должно быть задано обязательно")
//    @Size(min = 3, message="Длина имени должна быть минимум три символа")
    private String name;

    @Column
    private String surname;

    @Column
    @NotNull
    private String login;

    @Column
    private String password;

    @Column
    private String phone;

    @Column
//    @Email(message = "заданный Email не может существовать")
//    @NotNull(message="Email должен быть задан")
//    @Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
//            "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
//            "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
//            "+(?:[a-zA-Z]){2,}\\.?)$",
//            message = "заданный имэйл не может существовать")
    private String email;

    @Column
//    @PastOrPresent
    private Timestamp birthday;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

//    @ManyToOne
//    @JoinColumn(name = "address_id")
//    private AddressEntity addressEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", roleEntity=" + roleEntity +
                '}';
    }
}