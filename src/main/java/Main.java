
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;
import models.carta_productos;
import models.pedidos;



public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
 Timestamp hoy = new Timestamp(System.currentTimeMillis());
        Date date = new Date(hoy.getTime());
        limpiaPantalla();	
        int opcion =1;
        while (opcion!=6) {
	imprimirMenu();
	
	opcion=leerEntrada();
    switch (opcion){
    case 0 : opcion= 0;
    		AñadirProducto();
    		  break;
    
    case 1:  opcion = 1;
     
    			Meter(date);
             break;
    case 2:  opcion = 2;
    			Borrar();
             break;
    case 3:  opcion = 3;
    			Actualizar();
             break;
    case 4:  opcion = 4;
			PedidosHoy();
             break;
    case 5:  opcion = 5;
			TodosLosPedidos();
             break;
   
	case 6:
	
		System.out.println("Has salido del programa");
		break;
		default:{System.out.println("ese número no existe en el menu");}
			
	} 
		
	if (opcion!=6) 
	System.out.println();
	System.out.println("Pulse enter para continuar");
	esperaPulsacion();
		}
	}
	
public static void esperaPulsacion() {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    sc.nextLine();
				
	}

public static int leerEntrada() {
Scanner sc = new Scanner(System.in);
                int numero = sc.nextInt();
                return numero;
	}
private static void limpiaPantalla() {
        for (int i=0;i<200;i++) {
                System.out.println();
        }
}
					

    public static void imprimirMenu() {
            System.out.println("************************************");
            System.out.println("************ Menu Principal ********");
            System.out.println("************ Menu de Programas ********");
             System.out.println("0 Añadir producto");
             System.out.println("1 Anadir pedido");
  System.out.println("2 Borrar pedido");
  System.out.println("3 Marcar como recogido un pedido");
  System.out.println("4 Pedidos de hoy");
    System.out.println("5 Ver todos los pedidos");


            System.out.println("6 Salir ");
            System.out.println("************************************");
            System.out.println("Introduzca una opción:");
    }
      Scanner sc = new Scanner(System.in);
 
        
        
    private static void Meter(Date hoy){
        long millis=System.currentTimeMillis(); 
        java.sql.Timestamp date = new java.sql.Timestamp(millis); 

        carta_productosDAOHib carta = new carta_productosDAOHib();
        int Numeracion=1;
         for (var aa : carta.getAll()){  System.out.println(Numeracion+++ " " +aa); };

    	    Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre del cliente ");
            String nombre = sc.nextLine();
            
        pedidos p = new pedidos();
        p.setCliente(nombre);
        System.out.println("Introduce los numeros de los productos que desea si ya termino la comanda pulse 6" );
       int opcion =1;
   
        carta_productos produc = new carta_productos();
        ArrayList <carta_productos> ListaConPedidos= new ArrayList<carta_productos>() ;
     
         while (opcion!=6) {

	
	opcion=leerEntrada();
        switch (opcion){
        case 1:  opcion = 1;
        produc=carta.get(1);
        ListaConPedidos.add(produc);
                             
                                
                 break;
        case 2:  opcion = 2;
                 produc=carta.get(2);
		ListaConPedidos.add(produc);
     break;
        case 3:  opcion = 3;
         produc=carta.get(3);
        ListaConPedidos.add(produc);
     break;
      case 4:  opcion = 4;
         produc=carta.get(4);
        ListaConPedidos.add(produc);
     break;
     case 5:  opcion = 5;
         produc=carta.get(5);
        ListaConPedidos.add(produc);
     break;
     case 6 : opcion = 6;
         
		System.out.println("Has salido del pedido");
		break;
		default:{System.out.println("ese número no existe en el menu");}
			
	}
        }
     
        p.setProducto_id(ListaConPedidos);
        p.setEstado("En preparacion");
        p.setFecha(date);
        System.out.println(p.getFecha());
         PedidosDAOHib a = new PedidosDAOHib();
           
        a.save(p);
        System.out.println("Pedido añadido con exito:");
       p.setProducto_id(ListaConPedidos);
       System.out.println(a.get(p.getId_pedido()));
       p.getFecha();
      
     
        
    }
    
      
        private static void AñadirProducto(){//Mejora adicional
   carta_productosDAOHib carta = new carta_productosDAOHib();
     carta_productos produc = new carta_productos();
      Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre del producto ");
            String nombre = sc.nextLine();
                   System.out.println("Introduce la disponibilidad del producto ");
            String disponi = sc.nextLine();
                System.out.println("Introduce el tipo de producto ");
            String tipo = sc.nextLine();
              System.out.println("Introduce el precio del producto ");
            double precio = sc.nextDouble();
        pedidos p = new pedidos();
     produc.setDisponibilidad(disponi);
     produc.setNombre(nombre);
     produc.setPrecio(precio);
     produc.setTipo(tipo);
 
   carta.save(produc);
   System.out.println(produc+" ha sido añadido a la lista de productos");
        }
        
        
        private static void  Borrar(){
            PedidosDAOHib a = new PedidosDAOHib();
         for (var aa : a.AllPedidos()){ System.out.println("Numero del pedido: "+aa.getId_pedido()); System.out.println(" "+ aa);}
         System.out.println("Introduzca el numero del pedido a borrar");
             Scanner sc = new Scanner(System.in);
            int numero = sc.nextInt();
          a.delete(a.get(numero));
           System.out.println();
          System.out.println("Pedido borrado, la nueva lista de pedidos es:");
         for (var aa : a.AllPedidos()){  System.out.println(aa);}
        }

          private static void  Actualizar(){
         PedidosDAOHib a = new PedidosDAOHib();
         for (var aa : a.AllPedidos()){ System.out.println("Numero del pedido: "+aa.getId_pedido()); System.out.println(" "+ aa);}
         System.out.println("Introduzca el numero del pedido recogido");
         Scanner sc = new Scanner(System.in);
         int numero = sc.nextInt();
         a.update(a.get(numero));
         System.out.println(a.get(numero));
         
        
        }
             private static void  PedidosHoy(){
                   PedidosDAOHib a = new PedidosDAOHib();
                    for (var aa : a.PedidosHoy()){  System.out.println(aa); };
             }
              
            private static void TodosLosPedidos() {//Mejora adicional
                  PedidosDAOHib a = new PedidosDAOHib();
                 for (var aa : a.AllPedidos()){  System.out.println(aa); };
    }
       
}
    
    
        
    
    