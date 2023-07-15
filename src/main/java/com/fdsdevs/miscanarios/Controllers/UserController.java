package com.fdsdevs.miscanarios.Controllers;


import com.fdsdevs.miscanarios.Models.User;
import com.fdsdevs.miscanarios.Services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@AllArgsConstructor
@RequestMapping("api/user")
public class UserController {
   private UserService userService;

   @PostMapping("/create")
    public ResponseEntity<?> createuser(@Valid @RequestBody User user, BindingResult bindingResult){
      if(bindingResult.hasErrors())
         return new ResponseEntity<>(new Mensaje(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage()),HttpStatus.BAD_REQUEST);
       User saveUser = userService.createUser(user);
       return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
   }
   @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
       User user = userService.getUserById(userId);
       return new ResponseEntity<>(user,HttpStatus.OK);
   }
   @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
       List<User> users = userService.getAllUser();
       return new ResponseEntity<>(users,HttpStatus.OK);
   }
   @PutMapping("/{id}")
   public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user){
       user.setId(userId);
       User updatedUser = userService.updateUser(user);
       return new ResponseEntity<>(updatedUser,HttpStatus.OK);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
       userService.deleteUser(userId);
       return new ResponseEntity<>("Usuario eliminado",HttpStatus.OK);
   }

}
