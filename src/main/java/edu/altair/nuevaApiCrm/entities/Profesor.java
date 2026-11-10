package edu.altair.nuevaApiCrm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "profesores", schema = "crm", uniqueConstraints = {
    @UniqueConstraint(name = "uk_profesores_dni", columnNames = "dni")
})
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombreProfesor;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidosProfesor;

    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @Column(name = "email_centro", length = 100)
    private String emailCentroProfesor;

    @Column(name = "email_personal")
    private String emailPersonalProfesor;

    @Column(name = "descripción", length = 400)
    private String descripcionProfesor;

    @Column(name = "telefono", length = 15)
    private String telefonoProfesor;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    public Profesor() {}

    public Long getIdProfesor() { return idProfesor; }
    public void setIdProfesor(Long idProfesor) { this.idProfesor = idProfesor; }
    public String getNombreProfesor() { return nombreProfesor; }
    public void setNombreProfesor(String nombreProfesor) { this.nombreProfesor = nombreProfesor; }
    public String getApellidosProfesor() { return apellidosProfesor; }
    public void setApellidosProfesor(String apellidosProfesor) { this.apellidosProfesor = apellidosProfesor; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getEmailCentroProfesor() { return emailCentroProfesor; }
    public void setEmailCentroProfesor(String emailCentroProfesor) { this.emailCentroProfesor = emailCentroProfesor; }
    public String getEmailPersonalProfesor() { return emailPersonalProfesor; }
    public void setEmailPersonalProfesor(String emailPersonalProfesor) { this.emailPersonalProfesor = emailPersonalProfesor; }
    public String getDescripcionProfesor() { return descripcionProfesor; }
    public void setDescripcionProfesor(String descripcionProfesor) { this.descripcionProfesor = descripcionProfesor; }
    public String getTelefonoProfesor() { return telefonoProfesor; }
    public void setTelefonoProfesor(String telefonoProfesor) { this.telefonoProfesor = telefonoProfesor; }
    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
}