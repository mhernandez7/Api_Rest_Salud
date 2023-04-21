package com.salud.web.controller;

import com.salud.domain.PatientDto;
import com.salud.domain.service.PatientDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientDtoService patientDtoService;

    @GetMapping("/all")
    public ResponseEntity<List<PatientDto>> getAll(){
        return new ResponseEntity<>(patientDtoService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientDto>getById(@PathVariable("id") int idPatient){
        /*
        if (patientDtoService.getById(idPatient).isPresent()){
            return new ResponseEntity(patientDtoService.getById(idPatient), HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
      return patientDtoService.getById(idPatient)
               .map(patientDto -> new ResponseEntity(patientDto, HttpStatus.OK))
               .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<PatientDto> save(@RequestBody PatientDto patientDto){
        return new ResponseEntity<>(patientDtoService.save(patientDto), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{idPatient}")
    public ResponseEntity<PatientDto>delete(@PathVariable("idPatient") int idPatient){
        if(patientDtoService.delete(idPatient)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PatientDto>> getByName(@PathVariable("name") String name){
        return patientDtoService.getByName("%"+name+"%")
                .map(patientDtos -> new ResponseEntity<>(patientDtos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/date")
    public ResponseEntity<List<PatientDto>> getByBirthDate( LocalDate begin, LocalDate end){
     return patientDtoService.getByBirthDate(LocalDate.of(1997,1,1), LocalDate.of(1997,12,31))
             .map(patientDtos -> new ResponseEntity<>(patientDtos, HttpStatus.OK))
             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //NO he podido generar un metodo en donde se envie la fecha por postman
    /*
    @GetMapping("/date/{begin}/{end}")
    public ResponseEntity<List<PatientDto>> getByBirthDate( @PathVariable("begin") LocalDate begin,@PathVariable("end") LocalDate end){
        return patientDtoService.getByBirthDate(begin, end)
                .map(patientDtos -> new ResponseEntity<>(patientDtos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<PatientDto>update(@RequestBody PatientDto patientDto,@PathVariable("id") int idPatient){
        return new ResponseEntity<>(patientDtoService.update(patientDto, idPatient), HttpStatus.OK);
    }
}
