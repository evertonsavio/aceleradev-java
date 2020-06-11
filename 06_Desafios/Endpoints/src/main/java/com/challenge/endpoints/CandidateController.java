package com.challenge.endpoints;


import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.mappers.CandidateMapperImpl;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private  CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{acceId}/{compId}")
    public ResponseEntity<CandidateDTO> getById(@PathVariable Long userId,
                                                @PathVariable Long acceId,
                                                @PathVariable Long compId)
    {
        return  new ResponseEntity(candidateService
                .mapearCandidatoDTO(candidateService
                .findById(userId, acceId, compId).get()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CandidateDTO> getByCompanyOrAccelarationId(
            @RequestParam(required = false) Long companyId,
            @RequestParam(required = false) Long accelerationId
    ){
        if(companyId != null) {
            return new ResponseEntity(candidateService
                    .mapearCandidatoDTO(candidateService
                            .findByCompanyId(companyId)),HttpStatus.OK);
        }

        if(accelerationId != null){
            return new ResponseEntity(candidateService
                    .mapearCandidatoDTO(candidateService
                            .findByAccelerationId(accelerationId)), HttpStatus.OK);
        }

        return new ResponseEntity(candidateService
                .mapearCandidatoDTO(candidateService
                        .findAll()), HttpStatus.OK);
    }
}

