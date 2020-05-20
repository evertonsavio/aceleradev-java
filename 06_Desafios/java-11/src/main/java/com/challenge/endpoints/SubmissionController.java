package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @GetMapping
    public ResponseEntity<List<SubmissionDTO>> getByChallengeIdAndAcceleerationId(
            @RequestParam(required = false) Long challengeId,
            @RequestParam(required = false) Long accelerationId){

        if (challengeId != null && challengeId != null){
            return new ResponseEntity(submissionService
                    .mapearSubmissionDTO(submissionService
                            .findByChallengeIdAndAccelerationId(challengeId, accelerationId)), HttpStatus.OK);
        }

        return new ResponseEntity(submissionService
                .mapearSubmissionDTO(submissionService.findAll()), HttpStatus.OK);
    }

}
