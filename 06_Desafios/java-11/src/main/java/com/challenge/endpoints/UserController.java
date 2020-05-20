package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getByAccelNameAndCompId(
            @RequestParam(required = false) String accelerationName,
            @RequestParam(required = false) Long companyId){

        if (accelerationName != null){
            return new ResponseEntity(userService
                    .findByAccelerationName(accelerationName), HttpStatus.OK);
        }
        if (companyId != null){
            return new ResponseEntity(userService
                    .findByCompanyId(companyId), HttpStatus.OK);
        }

        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }



}
