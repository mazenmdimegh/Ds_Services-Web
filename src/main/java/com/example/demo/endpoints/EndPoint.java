package com.example.demo.endpoints;

import com.example.demo.services.Service;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@AllArgsConstructor
public class EndPoint {

    public  static final String nameSpace="http://www.tekup.de/loan/soap/ws/loanEligebilty";

    private Service service;

    @PayloadRoot(namespace = nameSpace,localPart = "StudentRequest")
    @ResponsePayload
    public WhiteTestResponse checkStatus(@RequestPayload StudentRequest studentRequest){
        return service.getStatus(studentRequest);
    }
}
