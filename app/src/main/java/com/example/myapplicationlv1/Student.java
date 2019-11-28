package com.example.myapplicationlv1;

public class Student {
    private String ime;
    private String prezime;
    //private String datum_rodenja;
    private String predmet;
   /* private String imePrezimeProfesora;
    private String akademskaGodina;
    private Integer satiPredavanja;
    private Integer satiLV;*/

    public Student(String ime, String prezime,/* String datum_rodenja,*/ String predmet/*, String imePrezimeProfesora, String akademskaGodina, Integer satiPredavanja, Integer satiLV*/) {
        this.ime = ime;
        this.prezime = prezime;
        //this.datum_rodenja = datum_rodenja;
        this.predmet = predmet;/*
        this.imePrezimeProfesora = imePrezimeProfesora;
        this.akademskaGodina = akademskaGodina;
        this.satiPredavanja = satiPredavanja;
        this.satiLV = satiLV;*/
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }
/*
    public String getDatum_rodenja() {
        return datum_rodenja;
    }*/

    public String getPredmet() {
        return predmet;
    }
/*
    public String getImePrezimeProfesora() {
        return imePrezimeProfesora;
    }

    public String getAkademskaGodina() {
        return akademskaGodina;
    }

    public Integer getSatiPredavanja() {
        return satiPredavanja;
    }

    public Integer getSatiLV() {
        return satiLV;
    }*/
}
