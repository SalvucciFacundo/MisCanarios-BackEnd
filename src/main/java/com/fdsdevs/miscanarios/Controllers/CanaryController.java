package com.fdsdevs.miscanarios.Controllers;

import com.fdsdevs.miscanarios.Models.Canary;
import com.fdsdevs.miscanarios.Services.CanaryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("api/canary")
public class CanaryController {

    private CanaryService canaryService;
    @GetMapping("/all")
    public ResponseEntity<List<Canary>> getAllCanaries(){
        List<Canary> canaries = canaryService.getAllCanary();
        return new ResponseEntity<>(canaries, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Canary>>getUserCanaries(Long userId){
        List<Canary>userCanaries = canaryService.findCanariesByUserId(userId);
        return new ResponseEntity<>(userCanaries,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Canary>getCanaryById(@PathVariable("id") Long canaryId){
        Canary canary = canaryService.getCanaryById(canaryId);
        return new ResponseEntity<>(canary,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createCanary(@Valid @RequestBody Canary canary, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new Mensaje(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage()),HttpStatus.BAD_REQUEST);
        Canary saveCanary = canaryService.createCanary(canary);
        return new ResponseEntity<>(saveCanary,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Canary> updateCanary(@PathVariable("id") Long canaryId,
                                               @RequestBody Canary canary){
        canary.setId(canaryId);
        Canary updateCanary = canaryService.updateCanary(canary);
        return new ResponseEntity<>(updateCanary,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCanary(@PathVariable("id") Long canaryId){
        canaryService.deleteCanary(canaryId);
        return new ResponseEntity<>("Canario eliminado",HttpStatus.OK);
    }
}
