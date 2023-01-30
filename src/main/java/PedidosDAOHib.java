/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.pedidos;



public class PedidosDAOHib implements PedidosDAO {

    @Override
    public void save(pedidos m) {
         
       
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();        
    
        }
    

    @Override
    public void update(pedidos m) {
    
       var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();     
        em.getTransaction().begin();
        TypedQuery<pedidos> query = em.createQuery(
        "update  pedidos set estado = 'recogido' where id_pedido= :id",pedidos.class);
          query.setParameter("id",m.getId_pedido());
      
        query.executeUpdate();
        em.getTransaction().commit();
        em.close(); 
  
        }
    

    @Override
    public pedidos get(Integer id) {
      pedidos salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<pedidos> q = em.createQuery("select u from pedidos u WHERE id_pedido = :x",pedidos.class);
        q.setParameter("x",id);
     
        salida=q.getSingleResult();
        em.close();
       return salida; 
    }
 
    

    @Override
    public void delete(pedidos m) {
       var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        pedidos user = em.find(pedidos.class, m.getId_pedido());
        em.remove(user); 
        em.getTransaction().commit();
        em.close();   
        }

    @Override
    public List<pedidos> AllPedidos() {
    List<pedidos> salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<pedidos> q = em.createQuery("select  from pedidos ",pedidos.class);
        salida = (List<pedidos>) q.getResultList();
        em.close();
        return salida; 

}

    @Override
    public List<pedidos> PedidosHoy() {
         Timestamp hoy = new Timestamp(System.currentTimeMillis());
        Date date = new Date(hoy.getTime());
      
      List<pedidos> salida =AllPedidos();
         for(int i = 0;i < salida.size(); i++)     {
               java.util.Date fechaConHora=  salida.get(i).getFecha();
              String texto = fechaConHora+"";
            int posicion = texto.indexOf(" ");
            if (posicion == -1)
                posicion = texto.length();
            String fechaSinHora = texto.substring(0,posicion);
            if (fechaSinHora.equals(date+"")){
               
            }else{
                      salida.remove(salida.get(i));
            }
         }
  
      return salida;
    }

    
    }
    
    
    
    
    
    

