package com.example.landingpage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "CONTACT_MESSAGES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq")
    @SequenceGenerator(name = "contact_seq", sequenceName = "CONTACT_MESSAGES_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100)
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Column(name = "EMAIL", nullable = false, length = 150)
    private String email;

    @Size(max = 2000)
    @Column(name = "MESSAGE", length = 2000)
    private String message;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
