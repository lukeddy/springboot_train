package com.yocool.controller.api;

import com.yocool.model.User;
import com.yocool.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * 用户管理接口
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final String APT_TAG="用户管理";

    @Autowired
    UserService userService;

    /**
     * 所有用户
     * @return
     */
    @ApiOperation(value = "所有用户", httpMethod = "GET", notes = "所有用户！",tags =APT_TAG)
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    /**
     * 单个用户
     * @param id
     * @return
     */
    @ApiOperation(value = "单个用户", httpMethod = "GET", notes = "单个用户！",tags =APT_TAG)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        logger.info("Fetching User with id {}" , id);

        User user = userService.findById(id);
        if (user == null) {
            logger.warn("User with id {} not found",id);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    /**
     * 创建用户
     * @param user
     * @param ucBuilder
     * @return
     */
    @ApiOperation(value = "创建用户", httpMethod = "POST", notes = "创建用户！",tags =APT_TAG)
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsername());
        logger.info("Creating User {}" , user.getUsername());
        if (userService.isUserExist(user)) {
            logger.warn("A User with name {} already exist", user.getUsername());
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    /**
     * 更新用户
     * @param id
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户", httpMethod = "PUT", notes = "更新用户！",tags =APT_TAG)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        logger.info("Updating User {}",id);
         
        User currentUser = userService.findById(id);
         
        if (currentUser==null) {
            logger.warn("User with id {} not found",id);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUsername(user.getUsername());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());
         
        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
 
    
    
    /**
     * 删除用户
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", httpMethod = "DELETE", notes = "删除用户！",tags =APT_TAG)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting User with id {}",id);
 
        User user = userService.findById(id);
        if (user == null) {
            logger.warn("Unable to delete. User with id {} not found",id);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
     
    
    /**
     * 删除所有用户
     * @return
     */
    @ApiOperation(value = "删除所有用户", httpMethod = "DELETE", notes = "删除所有用户！",tags =APT_TAG)
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        logger.info("Deleting All Users");
        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
}