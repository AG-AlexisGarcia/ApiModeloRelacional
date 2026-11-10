package edu.altair.nuevaApiCrm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "cursos", schema = "crm", uniqueConstraints = {
    @UniqueConstraint(name = "uk_cursos_diminutivo", columnNames = "diminutivo")
})
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(name = "diminutivo", nullable = false, length = 20)
    private String diminutivo;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    public Curso() {
    }

    public Curso(Long idCurso, String diminutivo, String descripcion) {
        this.idCurso = idCurso;
        this.diminutivo = diminutivo;
        this.descripcion = descripcion;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
