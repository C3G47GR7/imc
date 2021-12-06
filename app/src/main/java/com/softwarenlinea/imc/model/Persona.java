package com.softwarenlinea.imc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Persona implements Serializable {
    private  String id;
    private  int peso;
    private  double estatura;
    private  int edad;
    private  String sexo;
    private  double imc;
    private  String clasificacion;
    private  double metabolismob;
    private  double pesoideal;

    public Persona() {
    }

    public Persona(String id, int peso, double estatura, int edad, String sexo, double imc, String clasificacion, double metabolismob, double pesoideal) {
        this.id = id;
        this.peso = peso;
        this.estatura=estatura;
        this.edad = edad;
        this.sexo = sexo;
        this.imc = imc;
        this.clasificacion = clasificacion;
        this.metabolismob = metabolismob;
        this.pesoideal = pesoideal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getEstatuta() {
        return estatura;
    }

    public void setEstatuta(double estatuta) {
        this.estatura = estatuta;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public double getMetabolismob() {
        return metabolismob;
    }

    public void setMetabolismob(double metabolismob) {
        this.metabolismob = metabolismob;
    }

    public double getPesoideal() {
        return pesoideal;
    }

    public void setPesoideal(double pesoideal) {
        this.pesoideal = pesoideal;
    }

       public Map<String, Object> getMap(){
        Map<String, Object> mapa= new HashMap<>();
        mapa.put("id", this.getId());
        mapa.put("peso", this.getPeso());
        mapa.put("estatura", this.getEstatuta());
        mapa.put("edad", this.getEdad());
        mapa.put("sexo", this.getSexo());
        mapa.put("imc", this.getImc());
        mapa.put("clasificacion", this.getClasificacion());
        mapa.put("metabolismo", this.getMetabolismob());
        mapa.put("pesoideal", this.getPesoideal());
        mapa.put("fecha_registro", new Date());//genera la fecha actual
        return mapa;
    }
    public String getReference (){
        return this.getId();
    }
}


