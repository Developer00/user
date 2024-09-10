package com.robert.test.app.controllers;

import com.robert.test.app.models.Userul;
import com.robert.test.app.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "allUsers")
    public List<Userul> getAllUsers() {
        return this.userService.getUser();
    }

    @PostMapping(path = "addUser")
    public void addUser(@RequestBody Userul userul) {
        this.userService.addUser(userul);
    }

    @DeleteMapping(path = "delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping(path = "updateUser/{userId}")
    public void upDateUser
            (@PathVariable("userId") Long id,
             @RequestParam(required = false) String name,
             @RequestParam(required = false) String email) {
        userService.updateUser(id, name, email);
    }
}
