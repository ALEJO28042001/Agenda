/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import agenda.datos.DBcontactos;
import agenda.datos.DBcitas;
import agenda.datos.logica.Contacto;
import agenda.datos.logica.cita;

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
        DBcitas dbcitas=new DBcitas();
        Contacto[] contactos=dbcontactos.getContactos();
        cita[] citacion=dbcitas.getCitas(); 
        for (cita cita:citacion) {
            System.out.println(cita.getAsunto()+cita.getLugar()+cita.getFecha()+cita.getHora());
            for (Contacto contacto:contactos){
                System.out.println("nombre: "+contacto.getNombre()+" "+contacto.getApellido());     
            }
        System.out.println("_______________________________");
        }
        
    }

    
    
}
