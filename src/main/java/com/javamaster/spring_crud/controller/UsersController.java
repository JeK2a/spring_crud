package com.javamaster.spring_crud.controller;

import com.javamaster.spring_crud.dto.UserDto;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.service.DefaultUsersService;
import com.javamaster.spring_crud.service.UsersService;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
//@RestController
@RequestMapping("/users")
@Log
public class UsersController {

    private final UsersService usersService;
    private final DefaultUsersService defaultUsersService;

    public UsersController(UsersService usersService, DefaultUsersService defaultUsersService) {
        this.usersService        = usersService;
        this.defaultUsersService = defaultUsersService;
    }

    @PostMapping("/save")
    public @ResponseBody UserDto saveUsers(@RequestBody UserDto userDto) throws ValidationException {
        log.info("Handling save users: " + userDto);

        return usersService.saveUser(userDto);
    }

    @GetMapping("/findAll")
    public @ResponseBody List<UserDto> findAllUsers() {
//    public List<UserDto> findAllUsers() {
        log.info("Handling find all users request");

        return usersService.findAll();
    }

    @GetMapping("/findByLogin")
    public @ResponseBody UserDto findByLogin(@RequestParam String login) {
        log.info("Handling find by login request: " + login);

        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        usersService.deleteUser(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        return "greeting";
    }

    @GetMapping("/users_list")
//    public String users_list(String name, Model model) {
//    public String getUsers(Model model, @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
    public String getUsers(Model model, @RequestParam(value = "page", defaultValue = "0") int pageNumber) {

        List<UserDto> users = (pageNumber < 1) ?
                usersService.findAll() :
                defaultUsersService.findAll(pageNumber); // TODO пагинация

        model.addAttribute("users", users);

        return "users_list";
    }

}
