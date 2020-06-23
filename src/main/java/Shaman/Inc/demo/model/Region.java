package Shaman.Inc.demo.model;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity
@Table(name = "Region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reg_id")
    private Long id;
    @Column(name = "reg_nombre")
    private String nombre;
    @Column(name = "reg_casos_totales")
    private String casos_totales;

    @Column(name= "reg_casos_nuevos_totales")
    private String casos_nuevos_totales;
    @Column(name= "reg_casos_nuevos_sin_sintomas")
    private String casos_nuevos_sin_sintomas;

    @Column(name= "reg_casos_nuevos_con_sintomas")
    private String casos_nuevos_con_sintomas;

    @Column(name= "reg_fallecidos")
    private String fallecidos;



    public String getCasos_nuevos() {
        return casos_nuevos_con_sintomas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCasos_totales() {
        return casos_totales;
    }

    public void setCasos_totales(String casos_totales) {
        this.casos_totales = casos_totales;
    }

    public String getCasos_nuevos_totales() {
        return casos_nuevos_totales;
    }

    public void setCasos_nuevos_totales(String casos_nuevos_totales) {
        this.casos_nuevos_totales = casos_nuevos_totales;
    }

    public String getCasos_nuevos_sin_sintomas() {
        return casos_nuevos_sin_sintomas;
    }

    public void setCasos_nuevos_sin_sintomas(String casos_nuevos_sin_sintomas) {
        this.casos_nuevos_sin_sintomas = casos_nuevos_sin_sintomas;
    }

    public String getCasos_nuevos_con_sintomas() {
        return casos_nuevos_con_sintomas;
    }

    public void setCasos_nuevos_con_sintomas(String casos_nuevos_con_sintomas) {
        this.casos_nuevos_con_sintomas = casos_nuevos_con_sintomas;
    }

    public String getFallecidos() {
        return fallecidos;
    }

    public void setFallecidos(String fallecidos) {
        this.fallecidos = fallecidos;
    }

    public Region() {
    }



}
