/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.datos;
import agenda.datos.logica.cita;
import java.sql.*;
/**
 *
 * @author PROFESIONAL
 */
public class DBcitas {
    DBconnection cn;
    public DBcitas(){
    cn=new  DBconnection();
    }
         public cita[] getCitas(){
        int registros = 0;

        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                     "SELECT count(1) as cont" +
                                     " FROM citas ");
            
            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close(); 
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        cita[] data = new cita[registros];
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                      "SELECT cit_id, " +
                                      " con_id, " +
                                      " cit_lugar, " +
                                      " cit_fecha, " +
                                      " cit_hora," +
                                      " cit_asunto " +
                                      " FROM citas " + 
                                      " ORDER BY cit_fecha desc, " +
                                      " cit_hora desc ");

            ResultSet res = pstm.executeQuery();
            int i = 0;
            DBcontactos dbc = new DBcontactos();
            while(res.next()){
                data[i] = new cita();
                data[i].setId(res.getInt("cit_id"));
                data[i].setContacto(dbc.getContactoById(res.getInt("con_id")));
                data[i].setLugar(res.getString("cit_lugar"));
                data[i].setFecha(res.getString("cit_fecha"));
                data[i].setHora(res.getString("cit_hora"));
                data[i].setAsunto(res.getString("cit_asunto"));
                i++;
            }
            res.close(); 
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
}
