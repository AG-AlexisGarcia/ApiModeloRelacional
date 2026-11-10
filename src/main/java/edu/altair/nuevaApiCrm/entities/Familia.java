package edu.altair.nuevaApiCrm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "familias", schema = "crm")
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_familia")
    private Long idFamilia;

    @Column(name = "nombre_padre")
    private String nombrePadre;

    @Column(name = "nombre_madre")
    private String nombreMadre;

    @Column(name = "apellidos_padres")
    private String apellidosPadres;

    @Column(name = "apellidos_madres")
    private String apellidosMadres;

    @Column(name = "email_padre")
    private String emailPadre;

    @Column(name = "email_madre")
    private String emailMadre;

    @Column(name = "telefono_padre")
    private String telefonoPadre;

    @Column(name = "telefono_madre")
    private String telefonoMadre;

    @Column(name = "direccion_padre")
    private String direccionPadre;

    @Column(name = "direccion_madre")
    private String direccionMadre;

    @Column(name = "codigo_postal_padre")
    private String codigoPostalPadre;

    @Column(name = "codigo_postal_madre")
    private String codigoPostalMadre;

    @Column(name = "municipio_padre")
    private String municipioPadre;

    @Column(name = "municipio_madre")
    private String municipioMadre;

    @Column(name = "provincia_padre")
    private String provinciaPadre;

    @Column(name = "provincia_madre")
    private String provinciaMadre;

    @Column(name = "son_separados")
    private Boolean sonSeparados;

    @Column(name = "es_compartida")
    private Boolean esCompartida;

    @Column(name = "es_padre")
    private Boolean esPadre;

    @Column(name = "es_madre")
    private Boolean esMadre;

    public Familia() {}

    public Long getIdFamilia() { return idFamilia; }
    public void setIdFamilia(Long idFamilia) { this.idFamilia = idFamilia; }
    public String getNombrePadre() { return nombrePadre; }
    public void setNombrePadre(String nombrePadre) { this.nombrePadre = nombrePadre; }
    public String getNombreMadre() { return nombreMadre; }
    public void setNombreMadre(String nombreMadre) { this.nombreMadre = nombreMadre; }
    public String getApellidosPadres() { return apellidosPadres; }
    public void setApellidosPadres(String apellidosPadres) { this.apellidosPadres = apellidosPadres; }
    public String getApellidosMadres() { return apellidosMadres; }
    public void setApellidosMadres(String apellidosMadres) { this.apellidosMadres = apellidosMadres; }
    public String getEmailPadre() { return emailPadre; }
    public void setEmailPadre(String emailPadre) { this.emailPadre = emailPadre; }
    public String getEmailMadre() { return emailMadre; }
    public void setEmailMadre(String emailMadre) { this.emailMadre = emailMadre; }
    public String getTelefonoPadre() { return telefonoPadre; }
    public void setTelefonoPadre(String telefonoPadre) { this.telefonoPadre = telefonoPadre; }
    public String getTelefonoMadre() { return telefonoMadre; }
    public void setTelefonoMadre(String telefonoMadre) { this.telefonoMadre = telefonoMadre; }
    public String getDireccionPadre() { return direccionPadre; }
    public void setDireccionPadre(String direccionPadre) { this.direccionPadre = direccionPadre; }
    public String getDireccionMadre() { return direccionMadre; }
    public void setDireccionMadre(String direccionMadre) { this.direccionMadre = direccionMadre; }
    public String getCodigoPostalPadre() { return codigoPostalPadre; }
    public void setCodigoPostalPadre(String codigoPostalPadre) { this.codigoPostalPadre = codigoPostalPadre; }
    public String getCodigoPostalMadre() { return codigoPostalMadre; }
    public void setCodigoPostalMadre(String codigoPostalMadre) { this.codigoPostalMadre = codigoPostalMadre; }
    public String getMunicipioPadre() { return municipioPadre; }
    public void setMunicipioPadre(String municipioPadre) { this.municipioPadre = municipioPadre; }
    public String getMunicipioMadre() { return municipioMadre; }
    public void setMunicipioMadre(String municipioMadre) { this.municipioMadre = municipioMadre; }
    public String getProvinciaPadre() { return provinciaPadre; }
    public void setProvinciaPadre(String provinciaPadre) { this.provinciaPadre = provinciaPadre; }
    public String getProvinciaMadre() { return provinciaMadre; }
    public void setProvinciaMadre(String provinciaMadre) { this.provinciaMadre = provinciaMadre; }
    public Boolean getSonSeparados() { return sonSeparados; }
    public void setSonSeparados(Boolean sonSeparados) { this.sonSeparados = sonSeparados; }
    public Boolean getEsCompartida() { return esCompartida; }
    public void setEsCompartida(Boolean esCompartida) { this.esCompartida = esCompartida; }
    public Boolean getEsPadre() { return esPadre; }
    public void setEsPadre(Boolean esPadre) { this.esPadre = esPadre; }
    public Boolean getEsMadre() { return esMadre; }
    public void setEsMadre(Boolean esMadre) { this.esMadre = esMadre; }
}