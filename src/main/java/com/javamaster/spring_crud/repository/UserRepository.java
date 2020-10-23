package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.dto.UserDto;
import com.javamaster.spring_crud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
//public interface UserRepository extends JpaRepository<UserDto, Integer> {
//public interface UserRepository extends PagingAndSortingRepository<UserDto, Long>, JpaSpecificationExecutor<UserDto> { // TODO
    UserEntity findByLogin(String login);
}