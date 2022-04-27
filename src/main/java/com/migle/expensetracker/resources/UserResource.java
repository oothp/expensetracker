package com.migle.expensetracker.resources;

import com.migle.expensetracker.domain.User;
import com.migle.expensetracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
        // response entity is an extension of httpentity o_O

        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
//        return firstName + ", " + lastName + ", " + email + ", " + password;

        User user = userService.registerUser(firstName, lastName, email, password);
        Map<String, String> map = new HashMap<>();
        map.put("message", "registered successfully");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUSer(@RequestBody Map<String, Object> userMap) {
        // email + passwd come in payload body
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
    }
}
