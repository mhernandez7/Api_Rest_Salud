package com.salud.domain.service;

import com.salud.domain.PatientDto;
import com.salud.domain.repository.PatientDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientDtoService {

    @Autowired
    private PatientDtoRepository patientDtoRepository;

    public List<PatientDto> getAll() {return patientDtoRepository.getAll();}
    public Optional<PatientDto> getById(int idPatient){return patientDtoRepository.getById(idPatient);}
    public PatientDto save(PatientDto patientDto){return patientDtoRepository.save(patientDto);}
    public boolean delete(int idPatient){

      return   getById(idPatient).map(patientDto -> {
            patientDtoRepository.delete(idPatient);
            return true;
        }).orElse(false);
    }
    public Optional<List<PatientDto>> getByName(String name){
        return patientDtoRepository.getByName(name);
    }
    public Optional<List<PatientDto>> getByBirthDate(LocalDate begin, LocalDate end){return patientDtoRepository.getByBirthDate(begin, end);}
    public PatientDto update(PatientDto patientDto, int idPatient){return  patientDtoRepository.update(patientDto, idPatient);}
}
