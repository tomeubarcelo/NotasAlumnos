/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog.prog08notes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tomeu
 */
public class Alumno {
    private String codi;
    private float[] notes;
    
    //CONSTRUCTOR POR DEFECTO QUE CREA EL ARRAY DE DIMENSIÓN 4
    public Alumno () {
        this.notes = new float[4];
    }
       
    //MÉTODO ESTÁTICO DE CLASE USADO PARA VALIDAR UN CÓDIGO, SE LLAMA 
    //DIRECTAMENTE DESDE CLASE
    public static boolean validaCodi(String codiAlumne) {
        Pattern p=Pattern.compile("[A-Z]{3}[0-9]{2}");
        Matcher m=p.matcher(codiAlumne);
        
        if (m.matches()){ //formato correcto
            return true; 
        } else{ //formato incorrecto
            return false;
        }
    }    
    
    //MÉTODO SETTER DEL CÓDIGO
    //ANTES DE ESTABLECER UN CÓDIGO SIEMPRE VALIDAREMOS EL PATRÓN 
    //LLAMANDO AL MÉTODO DE CLASE validaCodi()
    public void setCodi(String codiAlumne) throws Exception {
        if (!validaCodi(codiAlumne)) { //crea l'excepció
            throw new Exception ("Formato incorrecto");
        } else{ //guarda el codi
            this.codi = codiAlumne;
        }
    }
    
    //SETTER DE UNA NOTA DEL ARRAY DE NOTES, RECIBE EL ÍNDICE DEL ARRAY Y LA NOTA
    //LA NOTA DEBE SER VALIDADA, UN VALOR ENTRE 0 Y 10
    public void setNota(int i, float nota) throws Exception {
        if (nota<0 || nota>10) { //crea l'excepció
            throw new Exception ("Nota incorrecta");
        } else { //guarda la nota
          this.notes[i]=nota;
        }
    }
    
    //SETTER DEL ARRAY DE NOTES, RECIBE EL ARRAY COMPLETO
    //CADA UNA DE LAS NOTAS DEBE SER VALIDADA, UN VALOR ENTRE 0 Y 10
    //Atención: el array es un puntero!!!
    public void setNotes(float[] notesAlumne) throws Exception {
        this.notes = notesAlumne;
    }

    //GETTER DEL CÓDIGO
    public String getCodi () {
        return codi;

    }
    
    //GETTER DE UNA NOTA DEL ARRAY, RECIBE EL ÍNDICE POR PARÁMETRO
    public float getNota(int i) {
        return notes[i];

    }   
    
    //GETTER DEL ARRAY DE NOTAS
    //Atención: el array es un puntero!!!
    public float[] getNotes () {
        return notes;

    }
    
    //MÉTODO QUE DEVUELVE EL CÁLCULO DE LA MEDIA DE LAS NOTAS DEL ARRAY DE NOTAS
    public float mitjanaNotes () {
        float notaMedia = 0;
        for(int i=0;i<notes.length;i++){
            notaMedia = notaMedia + getNota(i);
        }
        return notaMedia/4;
    }
}


