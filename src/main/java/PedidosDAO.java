/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import java.util.ArrayList;
import java.util.List;
import models.pedidos;


public interface PedidosDAO {
    
    public void save( pedidos m);
    public void update( pedidos m);
    public pedidos get( Integer id);
    public void delete( pedidos m);
    public List<pedidos> AllPedidos();
    public List<pedidos> PedidosHoy();
  

}
