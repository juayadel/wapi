package com.wapi.api.controllers;

import com.wapi.api.objects.request.hooks.notification.Notification;
import com.wapi.api.objects.request.hooks.verification.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webhooks")
public class whatsAppController {

    @PostMapping("")
    public ResponseEntity<String> hookNotification(@RequestParam(value = "notification") Notification name) {
        return ResponseEntity.ok("Hi whatsApp notification");
    }

    @GetMapping("")
    public ResponseEntity<Response> verification(@RequestParam(value = "hub.mode") String mode,//
                                                @RequestParam(value = "hub.challenge") int challenge, //
                                                @RequestParam(value = "hub.varify_token") String varify_token) {        
        Response response = new Response();
        response.setChallenge(challenge);
        return ResponseEntity.ok(response);
    }
}