package com.example.damsem6;

public class Orase {

    private String nume;
    private float populatie;
    private String descriere;

    public Orase(String nume, float populatie, String descriere) {
        this.nume = nume;
        this.populatie = populatie;
        this.descriere = descriere;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getPopulatie() {
        return populatie;
    }

    public void setPopulatie(float populatie) {
        this.populatie = populatie;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Orase{" +
                "nume='" + nume + '\'' +
                ", populatie=" + populatie +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
