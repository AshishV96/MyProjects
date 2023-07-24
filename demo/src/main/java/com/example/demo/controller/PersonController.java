package com.example.demo.controller;

import com.example.demo.dao.PersonRepository;
import com.example.demo.models.AuthenticationRequest;
import com.example.demo.models.AuthenticationResponse;
import com.example.demo.models.Person;
import com.example.demo.service.PersonService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private PersonService service;
    @Autowired
    private PersonRepository repo;
    @Autowired
    private Person person;

    @PostMapping("authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
    {
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrent username or password",e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> credentialException() {
        return new ResponseEntity<String>("Bad Credentials",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("add")
    public ResponseEntity<Person> create(@RequestBody Person person)
    {
        Person saved = service.create(person);
        return new ResponseEntity<Person>(saved, HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Person> get(@PathVariable Integer id)
    {
        return new ResponseEntity<>(repo.getById(id), HttpStatus.FOUND);
    }

}
