package com.musicapp.controller;

import com.musicapp.model.User;
import com.musicapp.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("*")
public class RestControllerUser {
    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/users-list", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable allUser() {
        return iUserService.findAll();
    }
    @RequestMapping(value = "/users-create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return iUserService.save(user);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteUser(@PathVariable Long id){
         iUserService.remove(id);
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User editSmartphone(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return iUserService.save(user);
    }
}
