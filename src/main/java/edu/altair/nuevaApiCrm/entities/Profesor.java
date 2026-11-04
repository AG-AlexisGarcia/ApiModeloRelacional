package edu.altair.nuevaApiCrm.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
@Entity
@Table(name = "profesores", schema = "crm", uniqueConstraints ={
		@UniqueConstraint(name = "uk_profesores_dni", columnNames = "dni")
})

public class Profesor {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_profesor")
    private long idProfesor;
    
    @Column(name = "nombre", nullable = false, length = 100 )
    private String nombreProfesor;
    
    @Column(name = "apellidos", nullable = false, length = 100 )
    private String apellidosProfesor;
    
    @Column(name = "dni", nullable = false, length = 9 )
    private String dniProfesor;
    
    @Column(name = "email_centro", length = 100 )
    private String emailCentroProfesor;
    
    @Column(name = "email_personal", length = 100 )
    private String emailPerosnalProfesor;
    
    @Column(name = "descripción", length = 400 )
    private String descripcionProfesor;
    
    @Column(name = "telefono", length = 15 )
    private String telefonoProfesor;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "id_departamento", nullable = false)
    private Departamento departamento;
    
    @ManyToMany
    @JoinTable(
    		name = "profesor_imparte",
    		joinColumns = @JoinColumn(name = "id_profesor"),
    		inverseJoinColumns = @JoinColumn(name = "id_modulo")
	)
    private list<Modulo> modulos;
    
	public Profesor() {
	}

	public Profesor(long idProfesor, String nombreProfesor, String apellidosProfesor, String dniProfesor,
			String emailCentroProfesor, String emailPerosnalProfesor, String descripcionProfesor,
			String telefonoProfesor, Departamento departamento) {
		super();
		this.idProfesor = idProfesor;
		this.nombreProfesor = nombreProfesor;
		this.apellidosProfesor = apellidosProfesor;
		this.dniProfesor = dniProfesor;
		this.emailCentroProfesor = emailCentroProfesor;
		this.emailPerosnalProfesor = emailPerosnalProfesor;
		this.descripcionProfesor = descripcionProfesor;
		this.telefonoProfesor = telefonoProfesor;
		this.departamento = departamento;
	}

	public long getIdProfesor() {
		return idProfesor;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public String getApellidosProfesor() {
		return apellidosProfesor;
	}

	public void setApellidosProfesor(String apellidosProfesor) {
		this.apellidosProfesor = apellidosProfesor;
	}

	public String getDniProfesor() {
		return dniProfesor;
	}

	public void setDniProfesor(String dniProfesor) {
		this.dniProfesor = dniProfesor;
	}

	public String getEmailCentroProfesor() {
		return emailCentroProfesor;
	}

	public void setEmailCentroProfesor(String emailCentroProfesor) {
		this.emailCentroProfesor = emailCentroProfesor;
	}

	public String getEmailPerosnalProfesor() {
		return emailPerosnalProfesor;
	}

	public void setEmailPerosnalProfesor(String emailPerosnalProfesor) {
		this.emailPerosnalProfesor = emailPerosnalProfesor;
	}

	public String getDescripcionProfesor() {
		return descripcionProfesor;
	}

	public void setDescripcionProfesor(String descripcionProfesor) {
		this.descripcionProfesor = descripcionProfesor;
	}

	public String getTelefonoProfesor() {
		return telefonoProfesor;
	}

	public void setTelefonoProfesor(String telefonoProfesor) {
		this.telefonoProfesor = telefonoProfesor;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
    
    
    
    
    
    
}
