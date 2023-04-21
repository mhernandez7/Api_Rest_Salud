package com.salud.persistence;

import com.salud.domain.PatientDto;
import com.salud.domain.repository.PatientDtoRepository;
import com.salud.persistence.crud.PatientCrudRepository;
import com.salud.persistence.entity.Patient;
import com.salud.persistence.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientRepostitory implements PatientDtoRepository {
    @Autowired
    private PatientCrudRepository patientCrudRepository;
    @Autowired
    private PatientMapper mapper;
    @Override
    public List<PatientDto> getAll() {
        List<Patient> patients = (List<Patient>) patientCrudRepository.findAll();
        return mapper.toPatientDtos(patients);
    }

    @Override
    public Optional<PatientDto> getById(int idPatient) {

        return patientCrudRepository.findById(idPatient).map(patient -> mapper.toPatientDto(patient));
    }

    @Override
    public PatientDto save(PatientDto patientDto) {
        Patient patient = mapper.toPatient(patientDto);
        return mapper.toPatientDto(patientCrudRepository.save(patient));
    }

    @Override
    public void delete(int idPatient) {
        patientCrudRepository.deleteById(idPatient);
    }
}
