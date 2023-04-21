package com.salud.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name ="pacientes")
public class Patient {

    @Id
    @Column(name = "h_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "h_numero")
    private String numberPatient;
    @Column(name = "h_tipo_doc")
    private String typeDocument;
    @Column(name = "h_identificacion")
    private String numberDocument;
    @Column(name = "h_fecha")
    private LocalDateTime registerTime;
    @Column(name = "h_nombres")
    private String name;
    @Column(name = "h_apellidos")
    private String lastName;
    @Column(name= "h_fecha_nacimiento")
    private LocalDate birthDate;
    @Column(name = "h_sexo")
    private String typeSex;
    @Column(name = "h_direccion")
    private String direction;
    @Column(name = "h_telefono")
    private String number;
    @Column(name = "h_mail")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumberPatient() {
        return numberPatient;
    }

    public void setNumberPatient(String numberPatient) {
        this.numberPatient = numberPatient;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getTypeSex() {
        return typeSex;
    }

    public void setTypeSex(String typeSex) {
        this.typeSex = typeSex;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
