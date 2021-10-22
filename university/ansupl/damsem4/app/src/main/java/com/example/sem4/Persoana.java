package com.example.sem4;

import java.io.Serializable;

public class Persoana implements Serializable {
    private  String nume;
    private String prenume;
    private String dataNasterii;
    private String email;

    public Persoana(String nume, String prenume, String dataNasterii, String email) {
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.email = email;
    }

    public Persoana() {
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", dataNasterii='" + dataNasterii + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
