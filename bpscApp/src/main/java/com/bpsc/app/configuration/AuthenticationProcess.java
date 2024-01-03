package com.bpsc.app.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import  com.bpsc.app.model.Users;
import com.bpsc.app.service.UsersService;

@Service
public class AuthenticationProcess {
	
	private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UsersService userServices;

    public AuthenticationProcess(UserDetailsService userDetailsService, JwtUtil jwtUtil, UsersService userServices) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.userServices = userServices;
    }

    public ResponseEntity<?> authenticateAndRetrieveUser(String authorizationHeader) {
        String jwt = "";

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7); // Remove "Bearer " prefix
        }

        // Validate the token
        UserDetails userDetails = userDetailsService.loadUserByUsername(getAuthenticatedUsername());

        if (!jwtUtil.validateToken(jwt, userDetails)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        Users existingCollege = userServices.getUserByEmail(getAuthenticatedUsername());

//        NewCollegeRegistrationService existingUser = collegeService.getCollegeByCollegeEmail(getAuthenticatedUsername());

        if (existingCollege == null) {
            return ResponseEntity.notFound().build();
        }

        // You can return the existingUser or any other data as needed
        return ResponseEntity.ok(existingCollege);
    }

    
    private String getAuthenticatedUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new SecurityException("Unauthorized");
        }
        return authentication.getName();
    }
}
