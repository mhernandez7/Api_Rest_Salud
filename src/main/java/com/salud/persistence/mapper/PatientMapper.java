package com.salud.persistence.mapper;

import com.salud.domain.PatientDto;
import com.salud.persistence.entity.Patient;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(source = "id", target = "idPatient")
    PatientDto toPatientDto(Patient patient);
    List<PatientDto> toPatientDtos(List<Patient> patients);
    @InheritInverseConfiguration

    Patient toPatient(PatientDto patientDto);


}
