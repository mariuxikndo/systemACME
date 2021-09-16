/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemacme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import systemacme.controlador.GestionSalarioEmpleado;

/**
 *
 * @author mcando
 */
public class EjecutableSystemACME {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        File archivo;
        FileReader fr;
        BufferedReader br;
        String nombre_archivo, linea;
        Scanner entradaEscaner; //Para gestionar la entrada de datos por teclado
        GestionSalarioEmpleado gestion= new GestionSalarioEmpleado();
        fr = null;

        try {
            System.out.println("Ingrese la dirección en donde se encuentra el archivo de texto");
            entradaEscaner = new Scanner(System.in); 

            nombre_archivo = entradaEscaner.nextLine();

            // Apertura del archivo y creación de BufferedReader para poder leerlo.
            archivo = new File(nombre_archivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del archivo
            while ((linea = br.readLine()) != null) {
                //Llamada al método que calcula el total a pagar por cada empleado
                System.out.println(gestion.gestionarTotalPagarEmpleado(linea));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException ex2) {
                System.out.println(ex2.getMessage());
            }
        }

    }

}
