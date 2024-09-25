package com.medway.doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.medway.doc.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Map;
import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-type")
    public ResponseEntity<Map<String, String>> getUserType(@RequestParam String userEmail) {
        String userType = userService.getUserType(userEmail);
        Map<String, String> response = new HashMap<>();
        response.put("userType", userType);
        return ResponseEntity.ok(response);
    }
}
