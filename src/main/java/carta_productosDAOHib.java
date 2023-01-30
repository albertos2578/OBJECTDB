/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.TypedQuery;
import models.carta_productos;
import models.pedidos;



public class carta_productosDAOHib implements carta_productosDAO {

 
    @Override
    public carta_productos get(int a) {
         carta_productos salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<carta_productos> q = em.createQuery("select u from carta_productos u WHERE carta_id = :id",carta_productos.class);
                q.setParameter("id",a);
               
        salida=q.getSingleResult();
        em.close();
        return salida;  
        }
    

    @Override
    public List<carta_productos> getAll() {
  List<carta_productos> salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<carta_productos> q = em.createQuery("select  from carta_productos ",carta_productos.class);
        salida = (List<carta_productos>) q.getResultList();
        em.close();
        return salida;  
        }
    @Override
     public void save(carta_productos m) {
         
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();        
    
        }

  

    }
    

