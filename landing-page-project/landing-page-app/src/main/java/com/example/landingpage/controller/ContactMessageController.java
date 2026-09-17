package com.example.landingpage.controller;

import com.example.landingpage.model.ContactMessage;
import com.example.landingpage.service.ContactMessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:4200") // AngularJS dev server origin; see CorsConfig for global setup
public class ContactMessageController {

    private final ContactMessageService service;

    @Autowired
    public ContactMessageController(ContactMessageService service) {
        this.service = service;
    }

    // POST /api/contact  -> called when the landing page contact form is submitted
    @PostMapping
    public ResponseEntity<ContactMessage> submit(@Valid @RequestBody ContactMessage message) {
        ContactMessage saved = service.save(message);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET /api/contact -> list all submissions (e.g. for an admin view)
    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
