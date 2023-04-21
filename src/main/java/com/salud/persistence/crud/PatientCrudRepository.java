package com.salud.persistence.crud;

import com.salud.persistence.entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientCrudRepository extends CrudRepository<Patient, Integer> {

        List<Patient>findByNameLike(String name);
        List<Patient>findByBirthDateBetween(LocalDate begin, LocalDate end);
}
