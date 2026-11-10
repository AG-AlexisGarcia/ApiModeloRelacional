package edu.altair.nuevaApiCrm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "modulos", schema = "crm", uniqueConstraints = {
    @UniqueConstraint(name = "uk_modulos_codigo", columnNames = "codigo"),
    @UniqueConstraint(name = "uk_modulos_diminutivo", columnNames = "diminutivo")
})
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo")
    private Long idModulo;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "diminutivo", nullable = false, length = 20)
    private String diminutivo;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 400)
    private String descripcion;

    @Column(name = "horas_semanales")
    private Integer horasSemanales;

    @Column(name = "creditos")
    private Integer creditos;

    public Modulo() {
    }

    public Modulo(Long idModulo, String codigo, String diminutivo, String nombre, 
                  String descripcion, Integer horasSemanales, Integer creditos) {
        this.idModulo = idModulo;
        this.codigo = codigo;
        this.diminutivo = diminutivo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horasSemanales = horasSemanales;
        this.creditos = creditos;
    }

    public Long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
}
