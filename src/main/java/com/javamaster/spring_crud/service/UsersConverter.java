package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.UserDto;
import com.javamaster.spring_crud.entity.UserEntity;
//import com.javamaster.spring_crud.entity.Users;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersConverter {

    public UserEntity fromUserDtoToUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setLogin(userDto.getLogin());

        return user;
    }

    public UserDto fromUserToUserDto(UserEntity user) {
//        return UsersDto.builder()
//                .id(users.getId())
//                .email(users.getEmail())
//                .login(users.getLogin())
//                .name(users.getName())
//                .build();


        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setLogin(user.getLogin());

        return userDto;
    }

    public List<UserDto> fromUsersToUsersDto(List<UserEntity> userEntityList) {
        return userEntityList.stream()
                .map(this::fromUserToUserDto)
                .collect(Collectors.toList());
    }

    public List<UserEntity> fromUsersDtoToUsers(List<UserDto> userEntityList) {
        return userEntityList.stream()
                .map(this::fromUserDtoToUser)
                .collect(Collectors.toList());
    }
}