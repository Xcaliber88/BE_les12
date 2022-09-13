package com.example.les11model.controller;

import com.example.les11model.model.Cursus;
import com.example.les11model.model.Les;
import com.example.les11model.repository.LesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessen")
public class LesController {

    private final LesRepository repos;

    public LesController(LesRepository rp) {
        this.repos = rp;
    }

    @PostMapping("")
    public ResponseEntity<Long> createLes(@RequestBody Les les){
        Les savedLes = repos.save(les);

        return new ResponseEntity<>(savedLes.getId(), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<Object> getLessen(){
        return new ResponseEntity<>(repos.findAll(), HttpStatus.OK);
    }
}
