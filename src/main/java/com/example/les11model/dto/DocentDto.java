package com.example.les11model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class DocentDto {

    public Long id;

    @NotBlank
    public String firstname;

    @Size(min=3, max=128)
    public String lastname;

    @Past
    public LocalDate dob;
}
