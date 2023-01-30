
package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="carta_productos")
public class carta_productos implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Integer carta_id;
    
  @Column(name="nombre")
  private String nombre;
    
   @Column(name="tipo")
   private String tipo;
      
    @Column(name="precio")
   private double precio;
   
       
     @Column(name="disponibilidad")
   private String disponibilidad;
     
     
     

    @Override
    public String toString() {
        return "carta_productos{" + "carta_id=" + carta_id + ", nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", disponibilidad=" + disponibilidad + '}';
    }

    
 

    
   
    
}
