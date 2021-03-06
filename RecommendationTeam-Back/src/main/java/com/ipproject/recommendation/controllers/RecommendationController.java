package com.ipproject.recommendation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipproject.recommendation.helpers.PrepareInput;
import com.ipproject.recommendation.models.Doctor;
import com.ipproject.recommendation.models.SymptomsInfo;
import com.ipproject.recommendation.models.User;
import com.ipproject.recommendation.service.DoctorsService;
import com.ipproject.recommendation.service.PrefferencesService;
import com.ipproject.recommendation.service.SymptomsInfoService;
import com.ipproject.recommendation.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.print.Doc;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class RecommendationController {

    @Autowired
    private SymptomsInfoService service;
    @Autowired
    private DoctorsService serviceDoctor;

    @RequestMapping(path = "/recommendation", method = RequestMethod.GET)
    public ResponseEntity<List<SymptomsInfo>> getRecommendation() {

        List<SymptomsInfo> symptomsInfo = service.getAllSymptomsInfo();
        return new ResponseEntity<List<SymptomsInfo>>(symptomsInfo, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/recommendation", method = RequestMethod.POST)
    public ResponseEntity<List<Doctor>> postRecommendation(@RequestBody String input) {
        // System.out.println(json);

        try {
            PrepareInput prepareInput = new PrepareInput(input, serviceDoctor);
            return new ResponseEntity<List<Doctor>>(prepareInput.findMatch(), new HttpHeaders(), HttpStatus.OK);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    @RequestMapping(path = "/test", method = RequestMethod.POST)
    public ResponseEntity<List<Doctor>> postTest(@RequestBody String input) {
        // System.out.println(json);

        try {
            PrepareInput prepareInput = new PrepareInput(input, serviceDoctor);
            return new ResponseEntity<List<Doctor>>(prepareInput.findByZone(), new HttpHeaders(), HttpStatus.OK);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

}
