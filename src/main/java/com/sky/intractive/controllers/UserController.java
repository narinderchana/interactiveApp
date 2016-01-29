package com.sky.intractive.controllers;


import com.sky.intractive.persistence.User;
import com.sky.intractive.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    @Value("${env.name}")
    String something;


    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(path="/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> get(@PathVariable String username) {
        User user = userRepository.findByUsername(username);
        if (user == null){
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public User put(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path="/{username}",method = RequestMethod.DELETE)
    public void delete(@PathVariable String username) {
        userRepository.delete(userRepository.findByUsername(username));
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public Object list() {
        return userRepository.findAll();
    }


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public Object ping() {
       return something;
    }

}
