/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import java.util.List;
import models.carta_productos;


public interface carta_productosDAO {
  public void save (carta_productos m);
  public carta_productos get(int a);
    public List<carta_productos> getAll();
}
