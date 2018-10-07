/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.datos;
import agenda.datos.logica.Contacto;
import java.sql.*;
/**
 *
 * @author Estudiantes
 */
public class DBcita {
    DBconnection cn;
  public DBcita() {
    cn = new DBconnection();
 }  
   public Contacto[] getContactos(){
        int registros = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT count(1) as cont" +
            " FROM contactos ");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("cont");
            res.close();
             }catch(SQLException e){
            System.out.println(e);
        }
        Contacto[] data = new Contacto[registros];
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, " +
            " con_nombre, " +
             " con_apellido, " +
             " con_telefono_domicilio, " +
            " con_telefono_oficina," +
            " con_celular, " +
            " con_correo, " +
            " con_direccion_residencia," +
            " con_direccion_trabajo " +
            " FROM contactos " +
            " ORDER BY con_nombre, con_apellido ");

            ResultSet res = pstm.executeQuery();   
            int i = 0;
            while(res.next()){
                data[i] = new Contacto();
                data[i].setId(res.getInt("con_id"));
                data[i].setNombre(res.getString("con_nombre"));
                data[i].setApellido(res.getString("con_apellido"));
                data[i].setTelefonoDomicilio(res.getString("con_telefono_domicilio"));
                data[i].setTelefonoOficina(res.getString("con_telefono_oficina"));
                data[i].setCelular(res.getString("con_celular"));
                data[i].setCorreo(res.getString("con_correo"));
                data[i].setDireccionResidencia(res.getString("con_direccion_residencia"));
                data[i].setDireccionTrabajo(res.getString("con_direccion_trabajo"));
                data[i].setDireccionCita(res.getString("con_direccion cita"));
                i++;
            }
            res.close();
            }catch(SQLException e){
            System.out.println(e);
            }
            return data;
            }
}
