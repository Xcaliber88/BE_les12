package com.example.les11model.controller;

import com.example.les11model.model.Cursus;
import com.example.les11model.repository.CursusRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursussen")
public class CursusController {

    private final CursusRepository repos;

    public CursusController(CursusRepository rp){ // constructor injection
        this.repos = rp;
    }

    @PostMapping("")
    public ResponseEntity<Long> createCourse(@RequestBody Cursus course){
        Cursus savedCourse = repos.save(course);

        return new ResponseEntity<>(savedCourse.getId(), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<Object> getCourses(){
        return new ResponseEntity<>(repos.findAll(), HttpStatus.OK);
    }
}
