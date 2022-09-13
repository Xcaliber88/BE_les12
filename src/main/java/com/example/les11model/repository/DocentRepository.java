package com.example.les11model.repository;

import com.example.les11model.model.Docent;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface DocentRepository extends CrudRepository<Docent,Long> {
    List<Docent> findByDobBefore(LocalDate date);
}
