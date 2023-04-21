package com.salud.domain.repository;

import com.salud.domain.PatientDto;
import com.salud.persistence.entity.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface PatientDtoRepository {

    List<PatientDto> getAll();
    Optional<PatientDto>getById(int idPatient);
    PatientDto save (PatientDto patientDto);
    void delete(int idPatient);

}
