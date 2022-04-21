package com.quizendpoint.controller;


import com.quizendpoint.domain.User;
import com.quizendpoint.exception.IdNotFoundException;
import com.quizendpoint.response.AllUserResponse;
import com.quizendpoint.response.User_QuestionResponse;
import com.quizendpoint.service.AsyncService;
import com.quizendpoint.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    
    @Autowired
    AsyncService asyncService;

    @GetMapping()
    public AllUserResponse getAllUser(){
    	List<User> users = userService.getAllUser(); 
    	
        return new AllUserResponse(users);
    }

//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Integer id){
//        //Optional<User> userOpt = accountList.stream().filter(ac -> ac.getId().equals(id)).findFirst();
//    	User u = userService.getuser(username);
//    	
//        return new User();
//    }
    
    @GetMapping("/{username}")
    public User getUserByUN(@PathVariable String username){
        Optional<User> userOpt = Optional.ofNullable(userService.getuser(username));
        User u = userService.getuser(username);
        
        return u;
    }

    
    @PostMapping("/{id}")
    public User changeStatus (@PathVariable Integer id) throws IdNotFoundException{
    	User u = userService.changeStatusById(id);
        return u;
    }
    
    @GetMapping("/async/{id}")
    public User_QuestionResponse getAllInfo(@PathVariable Integer id) throws IdNotFoundException{
    	User_QuestionResponse uq = (User_QuestionResponse) asyncService.getAllInfoAsync(id);
    	return uq;
    }
    
    @GetMapping("/idException")
    public ResponseEntity<User> errorDemoEndPoint() throws IdNotFoundException {
    	User response = userService.throwIdException();
        return ResponseEntity.ok(response);
    }
}
