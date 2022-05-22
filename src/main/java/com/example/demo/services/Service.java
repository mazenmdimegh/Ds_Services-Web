package com.example.demo.services;

import de.tekup.soap.models.whitetest.ObjectFactory;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@org.springframework.stereotype.Service
public class Service {
    public WhiteTestResponse getStatus (StudentRequest request){
        WhiteTestResponse response = new ObjectFactory().createWhiteTestResponse();
        return  response;
    }
}
