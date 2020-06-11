package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable("id") Long id){
        return new ResponseEntity(companyService.findById(id) ,HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<Company> getByAccelerationOrUserId(
            @RequestParam(required = false) Long accelerationId,
            @RequestParam(required = false) Long userId){

        if(accelerationId != null){
            return new ResponseEntity(companyService
                    .findByAccelerationId(accelerationId), HttpStatus.OK);
        }
        if(userId != null){
            return new ResponseEntity(companyService
                    .findByUserId(userId), HttpStatus.OK);
        }

        return new ResponseEntity(companyService.findAll(), HttpStatus.OK);
    }
}