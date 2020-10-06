package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.UsersDto;
import com.javamaster.spring_crud.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {

    public Users fromUserDtoToUser(UsersDto usersDto) {
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setEmail(usersDto.getEmail());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());

        return users;
    }

    public UsersDto fromUserToUserDto(Users users) {
//        return UsersDto.builder()
//                .id(users.getId())
//                .email(users.getEmail())
//                .login(users.getLogin())
//                .name(users.getName())
//                .build();


        UsersDto usersDto = new UsersDto();
        usersDto.setId(users.getId());
        usersDto.setEmail(users.getEmail());
        usersDto.setName(users.getName());
        usersDto.setLogin(users.getLogin());

        return usersDto;
    }
}