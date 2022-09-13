package com.example.les11model.service;

import com.example.les11model.dto.DocentDto;
import com.example.les11model.model.Docent;
import com.example.les11model.repository.DocentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocentService {
   private final DocentRepository repos;

    public DocentService(DocentRepository repos){
        this.repos = repos;
    }

    public Long createTeacher(DocentDto docentDto){
        Docent docent = new Docent();

        docent.setFirstname(docentDto.firstname);
        docent.setLastname(docentDto.lastname);
        docent.setDob(docentDto.dob);

        Docent savedDocent = this.repos.save(docent);

        return savedDocent.getId();

    }

    public Optional<Docent> getDocentById(Long id){
        return repos.findById(id);
    }

    public Iterable<Docent> getDocenten() {
        return repos.findAll();
    }
}
