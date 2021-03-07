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
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        // Instanciamos la clase Prog08notes para usar sus atributos
        Prog08Notes pn = new Prog08Notes(); 
        byte opcio = 0;
        do {
            opcio = menuOpcions();
            switch (opcio) {
                case 1: 
                    //procedimiento: https://fpadistancia.caib.es/mod/forum/discuss.php?d=14877
                    pn.inserirAlumne();
                    break;
                case 2:
                    pn.mitjanesAlumnes();
                    break;
                case 3:
                    pn.mitjanaModul();
                    break;
                case 4:
                    /*Obligatorio construir un array bidimensional que almacenará las notas de todos los alumnos 
                    de la lista y los mostrará por pantalla.*/
                    pn.matriuNotes(); 
                    break;
                case 5:
                    pn.notaAlumneModul();
                    break;
                case 0:
                    System.out.println("PROGRAMA FINALITZAT!!!");
                    break;
                default:
                    System.out.println("Aquesta opció no existeix.");
            } 
        } while (opcio != (byte) 0);
    }
    
    //Definición de los métodos 
    
    //CONSTRUCTOR POR DEFECTO DE LA CLASE Prog08Notes QUE CREA EL ARRAYLIST
    public Prog08Notes() {
       this.alumnes = new ArrayList<Alumno>();
    }

    //MÉTODO PARA AÑADIR UN ALUMNO A LA LISTA alumnes
    public void inserirAlumne() throws Exception {
        //variable per controlar que el codi alu sigui correcte
        boolean dadaOk;
        //Creació de l'objecte alumno amb el constructor per defecte
        Alumno alumno1 = new Alumno();
        
        //Demanar el codi fins que sigui correcte
        do { 
            try {
                dadaOk = true;
                //demanam codi alumne 
                System.out.println("Codi alumne: ");
                Scanner sc = new Scanner (System.in);
                String codiAlu = sc.next();
                alumno1.setCodi(codiAlu);
                //System.out.println("El codi del alumne es "+alumno1.getCodi());
        }catch (Exception e){ //tractam l'excepció generada per setCodi
                System.out.println(e.getMessage()+ ". Torna a introduir el codi de l'alumne: ");
                dadaOk = false;
            }
        } while (!dadaOk);
        
        //demanar notes alumne
        //Demanar el codi fins que sigui correcte
        for (int i = 0; i < moduls.length; i++) {
            do { 
                try {
                    dadaOk = true;
                    Scanner sc = new Scanner (System.in);

                        System.out.println("Introdueix la nota de "+moduls[i]);
                        float notesAlu = sc.nextFloat();
                        alumno1.setNota(i,notesAlu);
                        //System.out.println("La nota de l'alumne al mòdul "+moduls[i]+" és "+alumno1.getNota(i));

                }catch (Exception e){ //tractam l'excepció generada per setCodi
                    System.out.println(e.getMessage()+ ". Torna a introduir el codi de l'alumne: ");
                    dadaOk = false;
                }
            } while (!dadaOk);
        }
        
        //guardar objecte alumne a l'arrayList alumnes
        alumnes.add(alumno1);
        //System.out.println(alumnes.get(0));
        /*
        for (int i=0;i<alumnes.size();i++) {
            System.out.println(alumnes.get(i));
        }
        */


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
        byte opcio=0;
        do{
            try{
                Scanner op = new Scanner (System.in);
                //menú d'opcions del programa
                System.out.println("1. Entrada de datos de un alumno e inserción en la lista de alumnos. ");
                System.out.println("2. Visualizar las medias de todos los alumnos. ");
                System.out.println("3. Visualizar la nota media de un determinado módulo. ");
                System.out.println("4. Visualizar todos los datos en pantalla (informe global del curso)."); 
                System.out.println("5. Visualizar una nota determinada de un aluno.");
                System.out.println("0. Salir de la aplicación.");
                System.out.println("Introdueix l'opcio elegida: ");
                opcio=op.nextByte();
                if (opcio < 0 || opcio > 5) {
                System.out.println("Escollir entre (0..5)!.");    
                }
            }    
            catch(Exception e){
                System.out.println("Error al llegir del teclat(0..5)!.");
            }
            
        }while (opcio < 0 || opcio > 5);
        return opcio;
    } 
   
}

