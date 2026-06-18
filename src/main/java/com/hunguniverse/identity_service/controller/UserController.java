package com.hunguniverse.identity_service.controller;

import com.hunguniverse.identity_service.dto.request.UserCreationRequest;
import com.hunguniverse.identity_service.dto.request.UserUpdateRequest;
import com.hunguniverse.identity_service.entity.User;
import com.hunguniverse.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);

    }

    @GetMapping
    List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    User getUserById(@PathVariable String userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@RequestBody UserUpdateRequest request, @PathVariable String userId){
        return userService.updateUser(request, userId);

    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
