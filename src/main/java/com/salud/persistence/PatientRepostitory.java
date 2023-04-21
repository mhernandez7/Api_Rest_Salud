package com.salud.persistence;

import com.salud.domain.PatientDto;
import com.salud.domain.repository.PatientDtoRepository;
import com.salud.persistence.crud.PatientCrudRepository;
import com.salud.persistence.entity.Patient;
import com.salud.persistence.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    @Override
    public Optional<List<PatientDto>> getByName(String name) {
        List<Patient> patients = patientCrudRepository.findByNameLike(name);
        return Optional.of(mapper.toPatientDtos(patients));
    }

    @Override
    public Optional<List<PatientDto>> getByBirthDate(LocalDate begin, LocalDate end) {
        List<Patient> patients = patientCrudRepository.findByBirthDateBetween( begin, end);
        return Optional.of(mapper.toPatientDtos(patients));
    }

    @Override
    public PatientDto update(PatientDto patientDto, int idPatient) {
        return patientCrudRepository.findById(idPatient)
                .map(patient -> {
                    patientDto.setNumberPatient(patientDto.getNumberPatient());
                    patientDto.setTypeDocument(patientDto.getTypeDocument());
                    patientDto.setNumberDocument(patientDto.getNumberDocument());
                    patientDto.setRegisterTime(patientDto.getRegisterTime());
                    patientDto.setName(patientDto.getName());
                    patientDto.setLastName(patientDto.getLastName());
                    patientDto.setBirthDate(patientDto.getBirthDate());
                    patientDto.setDirection(patientDto.getDirection());
                    patientDto.setNumber(patientDto.getNumber());
                    patientDto.setEmail(patientDto.getEmail());
                    patient = mapper.toPatient(patientDto);
                    return mapper.toPatientDto(patientCrudRepository.save(patient));
                }).get();
    }
}
