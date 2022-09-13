package com.example.les11model.controller;

import com.example.les11model.dto.DocentDto;
import com.example.les11model.model.Docent;
import com.example.les11model.repository.DocentRepository;
import com.example.les11model.service.DocentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
public class DocentController {

    private final DocentService service;

    public DocentController(DocentService service) {
        this.service = service;
    }

    @PostMapping("/docenten")
    public ResponseEntity<Object> createTeacher(@Valid @RequestBody DocentDto docentDto, BindingResult br) {

        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {

            Long docentId = service.createTeacher(docentDto);
            return new ResponseEntity<>(docentId, HttpStatus.CREATED);
        }


//        @GetMapping("/docenten/{id}")
//                public ResponseEntity<Object> getDocentById(@PathVariable Long id){
//            return new ResponseEntity<>(service.getDocentById(id), HttpStatus.OK);
//        }

//    @GetMapping("/docenten/oud")
//    public ResponseEntity<Object> getOldFarts(){
//        return new ResponseEntity<>(repos.findByDobBefore(LocalDate.of(1981,1,1)), HttpStatus.OK);
//    }
    }


    @GetMapping("/docenten/{id}")
    public ResponseEntity<Object> getDocentById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getDocentById(id),HttpStatus.OK);
    }

    @GetMapping("/docenten")
    public ResponseEntity<Object> getDocenten() {
        return new ResponseEntity<>(service.getDocenten(), HttpStatus.OK);
    }


}
