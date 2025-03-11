package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.domain.dto.auth.AuthenticationDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.repositories.UserRepository;
import com.loja.roupas.trein.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Contact> login(@RequestBody @Valid AuthenticationDTO data) {
        var contact = authenticationService.doLogin(data);

        return ResponseEntity.ok(contact);

    }
    /*private static  class LoginResponse {
        private boolean success;
        private String message;
        private Contact contact;

        public LoginResponse(boolean success, String message, Contact contact) {
            this.success = success;
            this.message = message;
            this.contact = contact;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Contact getContact() {
            return contact;
        }

        public void setContact(Contact contact) {
            this.contact = contact;
        }

        @GetMapping("/user")
    public UserResponse getUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user != null) {
            return new UserResponse(true, user);
        } else {
            return new UserResponse(false, null);
        }
    }
    private static  class UserResponse {
        private boolean success;
        private User user;

        public UserResponse(boolean success, User user) {
            this.success = success;
            this.user = user;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
*/


}
