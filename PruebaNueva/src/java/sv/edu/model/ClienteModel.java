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
import sv.edu.entity.Cliente;

/**
 *
 * @author neon
 */
public class ClienteModel {

    SessionFactory factory = HibernateUtil.getSessionFactory();

    public int insertarCliente(Cliente cli) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(cli);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public List<Cliente> listarClientes() {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT e FROM Cliente e");
            List<Cliente> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }

    public Cliente obtenerCliente(String id) {
        Session ses = factory.openSession();
        try {
            Cliente clien = (Cliente) ses.get(Cliente.class, id);
            ses.close();
            return clien;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
    
    public int modificarCliente(Cliente client){
        Session ses = factory.openSession();
        try{
            Transaction tran = ses.beginTransaction();
            ses.update(client);
            tran.commit();
            ses.close();
            return 1;
        }catch(Exception e){
            ses.close();
            return 0;
        }
    }
    
    public int eliminarCliente(String id){
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try{
            Cliente cli = (Cliente) ses.get(Cliente.class, id);
            if(cli !=null){
                Transaction tran = ses.beginTransaction();
                ses.delete(cli);
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
