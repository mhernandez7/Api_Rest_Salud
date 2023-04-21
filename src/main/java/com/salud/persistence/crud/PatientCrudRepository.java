package com.salud.persistence.crud;

import com.salud.persistence.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientCrudRepository extends CrudRepository<Patient, Integer> {


}
