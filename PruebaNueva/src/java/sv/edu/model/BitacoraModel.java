/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.entity.Bitacora;

/**
 *
 * @author neon
 */
public class BitacoraModel {
  SessionFactory factory = HibernateUtil.getSessionFactory();

    public int insertarBitacora(Bitacora bet) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(bet);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public List<Bitacora> listarBitacoras() {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT b FROM Bitacora b");
            List<Bitacora> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }

    public Bitacora obtenerBitacora(String id) {
        Session ses = factory.openSession();
        try {
            Bitacora beten = (Bitacora) ses.get(Bitacora.class, id);
            ses.close();
            return beten;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
    
    public int modificarBitacora(Bitacora betent){
        Session ses = factory.openSession();
        try{
            Transaction tran = ses.beginTransaction();
            ses.update(betent);
            tran.commit();
            ses.close();
            return 1;
        }catch(Exception e){
            ses.close();
            return 0;
        }
    }
    
    public int eliminarBitacora(String id){
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try{
            Bitacora bet = (Bitacora) ses.get(Bitacora.class, id);
            if(bet !=null){
                Transaction tran = ses.beginTransaction();
                ses.delete(bet);
                tran.commit();
                filasAfectadas  = 1;
            }
            ses.close();
            return filasAfectadas;
        }catch(Exception e){
            ses.close();
            return 0;
        }
    }  
}
