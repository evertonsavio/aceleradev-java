package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @GetMapping
    public ResponseEntity<List<Challenge>> getByAccelerationIdAndUserId(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long accelerationId){

        return new ResponseEntity<>(challengeService.findByAccelerationIdAndUserId(accelerationId, userId), HttpStatus.OK);
    }

}
