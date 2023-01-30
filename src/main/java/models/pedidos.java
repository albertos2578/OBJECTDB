
package models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="pedidos")
public class pedidos implements Serializable {



    public pedidos() {
    }
    
    @Id
   @GeneratedValue(strategy=IDENTITY)
     @Column(name="id_pedido")
     private Integer id_pedido;
    
   @ManyToOne(cascade = CascadeType.MERGE)
   @Column
   @JoinColumn(name = "carta_id", referencedColumnName = "carta_id", nullable = true)
    private List<carta_productos> producto_id;
   
    
    @Column(name="cliente")
    private String cliente;
    
    @Column(name="estado")
    private String estado;
    
    @Column(name="fecha")
    private Timestamp fecha;

   

    @Override
    public String toString() {
        return "pedidos{" + "id_pedido=" + id_pedido + ", producto_id=" + producto_id + ", cliente=" + cliente + ", estado=" + estado +", fecha=" + fecha + '}';
    }

  
     
     

    

     
    
}
