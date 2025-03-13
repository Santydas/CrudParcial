package com.example.crud1.controllers;

import com.example.crud1.models.userModel;
import com.example.crud1.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class userController extends userModel {

    @Autowired
    private userService userService;

    @GetMapping

    public ArrayList<userModel> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping

    public userModel saveUser(@RequestBody userModel user) {
        return this.userService.saveUser(user);
    }

     @GetMapping(path = "/{id}")

    public Optional<userModel> getUserById(@PathVariable Long id){
        return this.userService.getUserById(id);
     }

     @PutMapping(path = "/{id}")

    public userModel updateUserById(@RequestBody userModel request, @PathVariable long id) {
        return this.userService.updateById(request,id);
     }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable Long id){
        boolean deleted = this.userService.deleteUserById(id);
        if (deleted) {
            return "Usuario " + id + " eliminado correctamente";
        } else {
            return "Error, usuario no encontrado o no se pudo eliminar";
        }
    }

}
