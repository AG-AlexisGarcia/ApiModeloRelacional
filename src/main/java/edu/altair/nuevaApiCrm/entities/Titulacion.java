package edu.altair.nuevaApiCrm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "titulaciones", schema = "crm", uniqueConstraints = {
    @UniqueConstraint(name = "uk_titulaciones_codigo", columnNames = "codigo"),
    @UniqueConstraint(name = "uk_titulaciones_diminutivo", columnNames = "diminutivo")
})
public class Titulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_titulacion")
    private Long idTitulacion;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "diminutivo", nullable = false, length = 20)
    private String diminutivo;

    @Column(name = "horas_totales")
    private Integer horasTotales;

    public Titulacion() {
    }

    public Titulacion(Long idTitulacion, String codigo, String diminutivo, Integer horasTotales) {
        this.idTitulacion = idTitulacion;
        this.codigo = codigo;
        this.diminutivo = diminutivo;
        this.horasTotales = horasTotales;
    }

    public Long getIdTitulacion() {
        return idTitulacion;
    }

    public void setIdTitulacion(Long idTitulacion) {
        this.idTitulacion = idTitulacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    public Integer getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(Integer horasTotales) {
        this.horasTotales = horasTotales;
    }
}