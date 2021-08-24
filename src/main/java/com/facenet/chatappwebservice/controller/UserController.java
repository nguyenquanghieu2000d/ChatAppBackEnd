/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 11/08/2021 4:28 PM 
*/
package com.facenet.chatappwebservice.controller;

import com.facenet.chatappwebservice.config.AllowHost;
import com.facenet.chatappwebservice.config.ListResponse;
import com.facenet.chatappwebservice.config.Response;
import com.facenet.chatappwebservice.entity.User;
import com.facenet.chatappwebservice.error.NotFoundException;
import com.facenet.chatappwebservice.model.dto.UserDto;
import com.facenet.chatappwebservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "api/user")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    /**
     * Request đăng nhập
     *
     * @return
     */
    @PostMapping(path = "/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody User user) {

        LOGGER.info("Request login user: " + user.getUsername());
        if (userService.validateUser(user)) {
            LOGGER.info("User " + user.getUsername() + " - " + ListResponse.LOGIN_SUCCESS);
            return new ResponseEntity<>(userService.getUserById(user.getUsername()), HttpStatus.OK);
        } else {
            LOGGER.info("User " + user.getUsername() + " - " + ListResponse.LOGIN_FAILED);
            throw new NotFoundException("Đăng nhập không thành công");

//            return new ResponseEntity<>(ListResponse.LOGIN_FAILED, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        LOGGER.info("getAllUsers");
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    /**
     * @param user
     * @Valid để kiểm tra xem đối tượng có hợp lệ hay không
     */
    @PostMapping
    public void addUser(@RequestBody User user) {

        userService.addUser(user);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") String id, @RequestBody User user) {

        userService.updateUser(id, user);
    }

    @DeleteMapping(path = {"{id}"})
    public void deleteUser(@PathVariable("id") String id) {

        userService.deleteUser(id);
    }
}
