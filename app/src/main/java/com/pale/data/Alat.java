package com.pale.data;

public class Alat {
    private int id;
    private int idKolam;
    private int pemilik;
    private String namaKolam;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }



    public int getIdKolam(){
        return idKolam;
    }

    public void setIdKolam(int idKolam){
        this.idKolam = idKolam;
    }


    public int getPemilik(){
        return pemilik;
    }

    public void setPemilik(int pemilik){
        this.pemilik = pemilik;
    }



    public String getNamaKolam(){
        return namaKolam;
    }

    public void setNamaKolam(String namaKolam){
        this.namaKolam = namaKolam;
    }

















    @Override
    public String toString(){
        return
                "DataItem{" +
                        "nama_kolam = '" + namaKolam + '\'' +
                        ",pemilik = '" + pemilik + '\'' +
                        ",id = '" + id + '\'' +
                        ",id_kolam = '" + idKolam + '\'' +
                        "}";
    }
}
