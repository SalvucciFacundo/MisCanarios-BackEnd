package com.fdsdevs.miscanarios.Interface;

import com.fdsdevs.miscanarios.Models.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUser(Long userId);
    /*List<User> get();
    void save (User user);
    void delete(Long id);
    User find(Long id);
    */


}
