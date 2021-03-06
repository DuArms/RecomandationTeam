package com.ipproject.recommendation.controllers;


import com.ipproject.recommendation.models.Address;
import com.ipproject.recommendation.models.User;
import com.ipproject.recommendation.service.AddressService;
import com.ipproject.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/addresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping
    public ResponseEntity<List<Address>> getUsers() {
        List<Address> addresses = service.getAllAddresses();
        return new ResponseEntity<List<Address>>(addresses, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> createOrUpdateUser(@RequestBody Address address) {
        Address address1 = service.createOrUpdate(address);

        return new ResponseEntity<Address>(address1, new HttpHeaders(), HttpStatus.CREATED);
    }
}
