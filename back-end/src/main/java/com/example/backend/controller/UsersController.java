package com.example.backend.controller;

import com.example.backend.models.Users;
import com.example.backend.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addSalaries( @RequestBody Users user) {
        usersService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity getSalaries() {
        List<Users> salaries = usersService.getListUsers();
        if (salaries != null) {
            return new ResponseEntity<>(salaries, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity getSalariesById(@PathVariable("id") long id) throws Exception {
        Users salarie = usersService.findUserById(id);
        if (salarie != null) {
            return new ResponseEntity<>(salarie, HttpStatus.OK);
        }
        throw new Exception();
    }


    @PutMapping
    public ResponseEntity updateSalaries(@RequestBody Users users) throws Exception {
        if (usersService.findUserById(users.getId()) != null) {
            usersService.updateUser(users);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        throw new Exception();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteSalaries(@PathVariable("id") Long id) {
        Users salarie = usersService.findUserById(id);
        if (salarie != null) {
            usersService.deleteUser(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
        //   throw new ResourceNotFoundException();
    }
}