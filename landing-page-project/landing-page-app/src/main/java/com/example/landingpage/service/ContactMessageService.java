package com.example.landingpage.service;

import com.example.landingpage.model.ContactMessage;
import com.example.landingpage.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageService {

    private final ContactMessageRepository repository;

    @Autowired
    public ContactMessageService(ContactMessageRepository repository) {
        this.repository = repository;
    }

    public ContactMessage save(ContactMessage message) {
        return repository.save(message);
    }

    public List<ContactMessage> findAll() {
        return repository.findAll();
    }
}
