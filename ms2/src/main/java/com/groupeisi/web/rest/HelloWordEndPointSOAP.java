package com.groupeisi.web.rest;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloWordEndPointSOAP {

//    @PayloadRoot(namespace = "http://ws.groupeisi.com",localPart = "getInfoRequest")
//    public @ResponsePayload GetInfoResponse getInfoResponse(@RequestPayload GetInfoRequest request){
//        GetInfoResponse response = new GetInfoResponse();
//        response.setOutput("Bonjour M2GL " + request.getInput());
//        return response;
//    }
}
