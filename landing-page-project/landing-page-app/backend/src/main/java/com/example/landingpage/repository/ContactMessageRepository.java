package com.example.landingpage.repository;

import com.example.landingpage.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    // JpaRepository already provides save(), findAll(), findById(), deleteById(), etc.
    // Add custom query methods here as needed, e.g.:
    // List<ContactMessage> findByEmail(String email);
}
