package com.cedaniel200.android.faseslunares.entities;

import java.util.Calendar;

/**
 * Created by cedaniel200 on 2016/07/11.
 */
public class FaseLunar {
    private int idImagen;
    private int idNombre;
    private int IdImagenSignoZodiacal;
    private int IdNombreSignoZodiacal;
    private int IdPeriodoSignoZodiacal;

    private Calendar fecha;

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public int getIdImagenSignoZodiacal() {
        return IdImagenSignoZodiacal;
    }

    public void setIdImagenSignoZodiacal(int idImagenSignoZodiacal) {
        IdImagenSignoZodiacal = idImagenSignoZodiacal;
    }

    public int getIdNombreSignoZodiacal() {
        return IdNombreSignoZodiacal;
    }

    public void setIdNombreSignoZodiacal(int idNombreSignoZodiacal) {
        IdNombreSignoZodiacal = idNombreSignoZodiacal;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public int getIdNombre() {
        return idNombre;
    }

    public void setIdNombre(int idNombre) {
        this.idNombre = idNombre;
    }

    public int getIdPeriodoSignoZodiacal() {
        return IdPeriodoSignoZodiacal;
    }

    public void setIdPeriodoSignoZodiacal(int idPeriodoSignoZodiacal) {
        IdPeriodoSignoZodiacal = idPeriodoSignoZodiacal;
    }
}
