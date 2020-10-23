package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.UserDto;
import com.javamaster.spring_crud.entity.UserEntity;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.repository.UserEntityRepository;
import com.javamaster.spring_crud.repository.UserRepository;
import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class DefaultUsersService implements UsersService {

//    private final UserEntityRepository usersRepository; // TODO
    private final UserRepository usersRepository;
    private final UsersConverter usersConverter;

    private static final int ROW_PER_PAGE = 20;

//    @Autowired
//    private ContactRepository contactRepository;

//    public DefaultUsersService(UserEntityRepository usersRepository, UsersConverter usersConverter) {
    public DefaultUsersService(UserRepository usersRepository, UsersConverter usersConverter) {
        this.usersRepository = usersRepository;
        this.usersConverter  = usersConverter;
    }

    @Override
    public UserDto saveUser(UserDto userDto) throws ValidationException {
        validateUserDto(userDto);
        UserEntity savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(userDto));
//        UserEntity savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(userDto));

//        return usersConverter.fromUserToUserDto(savedUser);
        return usersConverter.fromUserToUserDto(savedUser);
    }

    private void validateUserDto(UserDto userDto) throws ValidationException {
        if (isNull(userDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(userDto.getLogin()) || userDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UserDto findByLogin(String login) {
        UserEntity user = usersRepository.findByLogin(login);
        if (user != null) {
            return usersConverter.fromUserToUserDto(user);
        }

        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }

    // TODO https://www.dariawan.com/tutorials/spring/spring-boot-thymeleaf-crud-example/
    public List<UserDto> findAll(int pageNumber, int rowPerPage) {
        List<UserEntity> users = new ArrayList<>();
        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage, Sort.by("id").ascending());
        usersRepository.findAll(sortedByIdAsc).forEach(users::add);

        return usersConverter.fromUsersToUsersDto(users); // TODO проверить на работоспособность
    }

    public List<UserDto> findAll(int pageNumber) {
        return findAll(pageNumber, ROW_PER_PAGE);
    }
}