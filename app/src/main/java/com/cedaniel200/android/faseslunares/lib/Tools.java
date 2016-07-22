package com.cedaniel200.android.faseslunares.lib;

import java.util.Calendar;

/**
 * Created by cedaniel200 on 13/07/2016.
 */
public class Tools {

    public static final int INDEX_MARZO = 2;

    public static final int LUNA_NUEVA = 0;
    public static final int LUNA_POCO_CRECIENTE = 1;
    public static final int LUNA_CUARTO_CRECIENTE = 2;
    public static final int LUNA_MUY_CRECIENTE = 3;
    public static final int LUNA_LLENA = 4;
    public static final int LUNA_POCO_MENGUANTE = 5;
    public static final int LUNA_CUARTO_MENGUANTE = 6;
    public static final int LUNA_MUY_MENGUANTE = 7;

    public static final int SAGITARIO = 0;
    public static final int ESCORPIO = 1;
    public static final int LIBRA = 2;
    public static final int VIRGO = 3;
    public static final int LEO = 4;
    public static final int CANCER = 5;
    public static final int GEMINIS = 6;
    public static final int TAURO = 7;
    public static final int ARIES = 8;
    public static final int PISCIS = 9;
    public static final int ACUARIO = 10;
    public static final int CAPRICORNIO = 11;

    public int obtenerFaseLunar(Calendar fecha){
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        if(mes < INDEX_MARZO){
            anio -= 1;
            mes += 12;
        }

        mes += 1;

        double c = 365.25 * anio;
        double e = 30.6 * mes;
        double tiempoTotalTranscurrido = c + e + dia - 694039.09;
        tiempoTotalTranscurrido /= 29.5305882;

        tiempoTotalTranscurrido -= (int)tiempoTotalTranscurrido;

        int b = (int) Math.rint(tiempoTotalTranscurrido * 8);

        if(b >= 8){
            b = 0;
        }

        return b;
    }

    public int obtenerSignozodiacal(Calendar fecha){

        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int signoZodiacal = 0;


        if (( dia >= 21 &&  mes == 3) || ( dia <= 20 && mes == 4)) {
            signoZodiacal = ARIES;
        } else if ((dia>=24 && mes == 9) || (dia<=23 && mes == 10)){
            signoZodiacal = LIBRA;
        } else if ((dia>=21 && mes == 4) || (dia<=21 && mes == 5)){
            signoZodiacal = TAURO;
        } else if ( (dia>=24 && mes == 10) || (dia<=22 && mes == 11)){
            signoZodiacal = ESCORPIO;
        } else if ((dia>=22 && mes == 5) || (dia<=21 && mes == 6) ){
            signoZodiacal = GEMINIS;
        }else if ((dia>=23 && mes == 11) || (dia<=21 && mes == 12)){
            signoZodiacal = SAGITARIO;
        }else if ((dia>=22 && mes == 6) || (dia<=22 && mes == 7)){
            signoZodiacal = CANCER;
        }else if ((dia>=22 && mes == 12) || (dia<=20 && mes == 1)){
            signoZodiacal = CAPRICORNIO;
        }else if ((dia>=23 && mes == 7) || (dia<=23 && mes == 8)){
            signoZodiacal = LEO;
        }else if ((dia>=21 && mes == 1) || (dia<=18 && mes == 2)){
            signoZodiacal = ACUARIO;
        }else if ((dia>=24 && mes == 8) || (dia<=23 && mes == 9)){
            signoZodiacal = VIRGO;
        }else if ((dia>=19 && mes == 2) || (dia<=20 && mes == 3)){
            signoZodiacal = PISCIS;
        }

        return signoZodiacal;

    }

}
