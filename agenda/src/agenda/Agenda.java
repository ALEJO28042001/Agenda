/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import agenda.datos.DBcontactos;
import agenda.datos.logica.Contacto;

/**
 *
 * @author Estudiantes
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBcontactos dbcontactos=new DBcontactos();
        Contacto[] contactos=dbcontactos.getContactos();
        int contador=0;
        int aux=0;
        for (Contacto contacto:contactos){
            if (contador<5) {
                if (aux==0) {
                    contacto.setDireccionCita("punto encuentro: auditorio sabio caldas ");
                }
                System.out.println("nombre: "+contacto.getNombre()+" "+contacto.getApellido()+" celular "+contacto.getCelular());
            }           
            contador++;    
        }
        System.out.println("_______________________________");
    }

    
    
}
