package lk.ijse.absd.pos.controller;

import lk.ijse.absd.pos.dto.UserDTO;
import lk.ijse.absd.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-22
 * Time: 12:22 PM
 */
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "api/v1/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean authenticateUser(@RequestBody UserDTO userDTO) {
        return userService.authenticateUser(userDTO.getUsername(), userDTO.getPassword());
    }

}
