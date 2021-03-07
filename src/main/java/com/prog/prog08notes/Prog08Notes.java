/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog.prog08notes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author tomeu
 */
public class Prog08Notes {
    // Declaramos la constante de los nombres obligatorios de los módulos    
    private static final String[] moduls = {"SiPROG", "SiMSO", "SiWEB", "SiXAR"};
    private ArrayList <Alumno> alumnes;
    private float[][] totesNotes;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Instanciamos la clase Prog08notes para usar sus atributos
        Prog08Notes pn = new Prog08Notes(); 
        byte opcio = 0;
        do {
            opcio = menuOpcions();
            switch (opcio) {
                case 1 -> pn.inserirAlumne();
                case 2 -> pn.mitjanesAlumnes();
                case 3 -> pn.mitjanaModul();
                case 4 -> pn.matriuNotes();    
                case 5 -> pn.notaAlumneModul();     
                case 0 -> System.out.println("PROGRAMA FINALITZAT!!!");
                default -> System.out.println("Aquesta opció no existeix.");
            } 
        } while (opcio != (byte) 0); 
    }
    
    //Definición de los métodos 
    
    //CONSTRUCTOR POR DEFECTO DE LA CLASE Prog08Notes QUE CREA EL ARRAYLIST
    public Prog08Notes() {
       this.alumnes = new ArrayList<Alumno>();
    }

    //MÉTODO PARA AÑADIR UN ALUMNO A LA LISTA alumnes
    public void inserirAlumne() {
    
    }   

    //MÉTODO PARA MOSTRAR LA NOTA MEDIA DE CADA ALUMNO
    public void mitjanesAlumnes() {

    }

    //MÉTODO PARA CALCULAR Y MOSTRAR LA NOTA MEDIA DE UN MÓDULO PEDIDO POR TECLADO
    public void mitjanaModul() {
   
    }

    //MÉTODO PARA MOSTRAR PARA CADA ALUMNO TODAS SUS NOTAS USANDO
    //EL ARRAY DE DOS DIMENSIONES totesNotes[][]
    public void matriuNotes() {

    }

    //MÉTODO PARA PEDIR POR TECLADO UN ALUMNO Y UN MÓDULO,
    //BUSCARLO EN LA LISTA Y MOSTRAR SU NOTA
    public void notaAlumneModul() {
        
    }
    
    //MENÚ DE OPCIONES
    private static byte menuOpcions ()  {

    } 
   
}

