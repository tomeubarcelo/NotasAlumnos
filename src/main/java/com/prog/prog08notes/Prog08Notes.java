/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog.prog08notes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    //el formato de las notas sera con 2 decimales
    DecimalFormat formatoDosDecimales = new DecimalFormat("#.00");

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
        
        //Creació de l'objecte alumno amb el constructor per defecte
        Alumno alumno1 = new Alumno();
        
        //variable per controlar que el codi alu sigui correcte
        boolean dadaOk;
               
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
        try {
            alumnes.add(alumno1);
            System.out.println("Alumne inserit.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /*for(int i = 0; i< alumnes.size(); i++){
            System.out.println(alumnes.get(i).getCodi());  
        }*/
    }   

    //MÉTODO PARA MOSTRAR LA NOTA MEDIA DE CADA ALUMNO
    public void mitjanesAlumnes() {
        //bucle que recorre el array de alumnos y asigna a cada alumno su media de notas
        for(int i = 0; i< alumnes.size(); i++){
            float notaMediaAlu = alumnes.get(i).mitjanaNotes();
            System.out.println("La nota media del alumno con código " +alumnes.get(i).getCodi() + " es " +formatoDosDecimales.format(notaMediaAlu));
        }
    }

    //MÉTODO PARA CALCULAR Y MOSTRAR LA NOTA MEDIA DE UN MÓDULO PEDIDO POR TECLADO
    public void mitjanaModul() {
        
        boolean dadaOk;
        do { 
            try {
                //pedimos de que modulo desea mostrar la nota media
                Scanner entradaScanner = new Scanner (System.in);
                System.out.println("Introduce el módulo (SiPROG, SiMSO, SiWEB, SiXAR):");
                String modulo = entradaScanner.nextLine();

                float notaPorAlumno = 0;
                float notaMediaModulo = 0;

                dadaOk = true; //boolean a true

                if (Arrays.asList(moduls).contains(modulo)) { //si el array moduls contiene el modulo introducido

                    for (int i = 0; i < moduls.length; i++) { //recorre todos los modulos
                      if (modulo.equals(moduls[i])){ //si el modulo introducido por el usuario coincide con alguno
                            for(int j = 0; j< alumnes.size(); j++){ //recorremos el array de alumnos
                                notaPorAlumno = notaPorAlumno + alumnes.get(j).getNota(i);
                                notaMediaModulo = notaPorAlumno/alumnes.size();
                                //obtenemos la nota de cada alumno de un determinado modulo y se divide por el total de alumnos
                            }
                            System.out.println("La nota media en el módulo " + moduls[i]+ " es: " +formatoDosDecimales.format(notaMediaModulo));
                        } 
                    }
                }
                else{ //si no contiene el modulo introducido
                    dadaOk = false;
                }
            }catch (Exception e){ //tractam l'excepció generada
                        System.out.println(e.getMessage()+ ". Error");
                        dadaOk = false;
            }
        } while (!dadaOk); //fin bucle
    }

    //MÉTODO PARA MOSTRAR PARA CADA ALUMNO TODAS SUS NOTAS USANDO
    //EL ARRAY DE DOS DIMENSIONES totesNotes[][]
    public void matriuNotes() {
        totesNotes = new float[alumnes.size()][moduls.length]; 
        //declaramos el array bidimiensional con la cantidad de alumnos y de modulos
        
        for(int i = 0; i< alumnes.size(); i++){ //recorre la cantidad de alumnos
            for(int j = 0; j< moduls.length; j++){ //recorre la cantidad de modulos
                totesNotes[i][j] = alumnes.get(i).getNota(j); //asignaremos la nota correspondiente 
                System.out.println(alumnes.get(i).getCodi());
                System.out.println(moduls[j]);
                System.out.println(formatoDosDecimales.format(totesNotes[i][j]));
                System.out.println("-------");
            }
        }
        //System.out.println(totesNotes.length);
    }

    //MÉTODO PARA PEDIR POR TECLADO UN ALUMNO Y UN MÓDULO,
    //BUSCARLO EN LA LISTA Y MOSTRAR SU NOTA
    public void notaAlumneModul() {
        Scanner entradaScanner = new Scanner (System.in);
        
        //creamos arrayList donde almacenamos el cod de cada alumno
        ArrayList <String> arrayCodAlu = new ArrayList<String>();
        for(int i = 0; i< alumnes.size(); i++){ //recorremos el array de alumnos
            //System.out.println(alumnes.get(i).getCodi());  
            String codAlu = alumnes.get(i).getCodi();
            arrayCodAlu.add(codAlu); //guardamos en el array el codigo del alumno
        }

        System.out.println("Códigos de alumnos:");
        for(int i = 0; i< alumnes.size(); i++){ //bucle que muestra el codigo de alumnos para que el usuario los vea
            System.out.print(alumnes.get(i).getCodi()+" | ");  
        }
        
        boolean dadaOk;
        String codiAlu = "";
        //PEDIR POR CONSOLA EL CODIGO DEL ALUMNO
        do { 
            try {
                System.out.println("Introduce el código del alumno: ");
                codiAlu = entradaScanner.nextLine();
                
                if (arrayCodAlu.contains(codiAlu)) { //si el array contiene el codigo introducido por el usuario
                    dadaOk = true;
                }
                else{ //si no contiene el cod introducido
                    dadaOk = false;
                }
            }catch (Exception e){ //tractam l'excepció generada
                        System.out.println(e.getMessage()+ ". Error");
                        dadaOk = false;
            }
        } while (!dadaOk); //fin bucle
                

        String modulo = "";
        do { 
            try {
                //el usuario introduce el cod de alumno y el modulo del cual quiere ver la nota
                System.out.println("Introduce el módulo (SiPROG, SiMSO, SiWEB, SiXAR):");
                modulo = entradaScanner.nextLine();
                dadaOk = true; //boolean a true

                if (Arrays.asList(moduls).contains(modulo)) { 

                for (int i = 0; i < moduls.length; i++) { //recorre todos los modulos
                      if (modulo.equals(moduls[i])){ //si el modulo introducido por el usuario coincide con alguno
                            System.out.println("Has elegido "+moduls[i]);
                        } 
                    }
                }
                else{ //si no contiene el modulo introducido
                    dadaOk = false;
                }
            }catch (Exception e){ //tractam l'excepció generada
                        System.out.println(e.getMessage()+ ". Error");
                        dadaOk = false;
            }
        } while (!dadaOk); //fin bucle

        
        for(int z = 0; z< alumnes.size(); z++){ //recorremos el array de alumnos
            if (codiAlu.equals(alumnes.get(z).getCodi())){ //si el cod alu existe..

                for (int i = 0; i < moduls.length; i++) { //recorre array de modulos
                  if (modulo.equals(moduls[i])){ //si el modulo existe 
                        float notaAluConcreta = alumnes.get(z).getNota(i);
                        System.out.println(alumnes.get(z).getCodi() + " - " + moduls[i]);
                        System.out.println(formatoDosDecimales.format(notaAluConcreta));                   
                    }  
                }
            }     
        }
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

