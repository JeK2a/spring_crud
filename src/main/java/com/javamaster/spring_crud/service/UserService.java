package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.entity.RoleEntity;
import com.javamaster.spring_crud.entity.UserEntity;
import com.javamaster.spring_crud.repository.RoleEntityRepository;
import com.javamaster.spring_crud.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private RoleEntityRepository roleEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity saveUser(UserEntity userEntity) {
        RoleEntity userRole = roleEntityRepository.findByName("ROLE_USER");
        userEntity.setRoleEntity(userRole);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntityRepository.save(userEntity);
    }

    public UserEntity findByLogin(String login) {
        return userEntityRepository.findByLogin(login);
    }

    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}