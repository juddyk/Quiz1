/**
 *
 * @author Juddy
 */
package booksoftv1;

import java.util.Scanner;

public class BookSoftV1 /*extends LIBROS*/ {
    private int pos;
    private int cuenta;
    private int error;
    private LIBROS[] libro;
    private USUARIO[] persona;
    private int cuentaP;
    private final Scanner t= new Scanner (System.in);
    
    BookSoftV1(){
        pos=0;
        cuenta=0;
        error=0;
        libro=new LIBROS[10];
        for(int i=0;i<10;i++){
            libro[i]=new LIBROS();
        }
        persona=new USUARIO[10];
        for(int i=0;i<10;i++){
            persona[i]=new USUARIO();
        }    
    }
    /////////////////////////////////////////////////////////////////////////
    public void almacenar(){
        cuenta++;
        libro[cuenta-1].ingresar();
        verificar();
    }
    
    public void verificar(){
        for(int i=0;i<cuenta-1;i++){
            if(libro[cuenta-1].getNombre().equals(libro[i].getNombre()) ){
                
             if(libro[cuenta-1].getAutor().equals(libro[i].getAutor())){
                 
              if(libro[cuenta-1].getArea().equals(libro[i].getArea())){                
                  if(libro[cuenta-1].getData_public().equals(libro[i].getData_public())){
                        libro[i].setCantidad(libro[i].getCantidad()+libro[cuenta-1].getCantidad());
                        cuenta--;
                  }
                  else{
                        libro[i].setCantidad(libro[i].getCantidad()+libro[cuenta-1].getCantidad());
                        libro[i].setEdiciones(libro[i].getEdiciones()+1);
                        libro[i].setData_public(libro[i].getData_public()+", "+libro[cuenta-1].getData_public());
                        cuenta--;
                  }
              }
              else{
                  System.out.print("Se presento coincidencia con otro libro ");
                  libro[i].setCantidad(libro[i].getCantidad()+libro[cuenta-1].getCantidad());
                  cuenta--;
              }
              
             }
             
          }
            
        }
    }
     
    public void buscar(){
        String name;
        //String na;
        int [] vector=new int[10];
        int flag=0;
        int flag2=0;
        System.out.println("Nombre del libro: ");
        //a=t.nextLine();
        name=t.nextLine();
        for(int j=0;j<cuenta;j++){
            if(libro[j].getNombre().compareTo(name)==0){
                vector[j]=1;
                flag2++;
            }
            else{
                flag++;
            }
        }
        if(flag==cuenta){
            error=1;
        }
        else{
            error=0;            
            
            int a;
            if(flag2>1){
                System.out.println("Se encontro más de 1 libro con ese nombre ");                
                for(int i=0;i<10;i++){
                    if(vector[i]==1){
                       
                            System.out.println("Es este? Si[1] No [0] ");
                            libro[i].mostrar();
                            a=t.nextInt();
                            if(a==1){
                                pos=i;
                                i=20;
                            }
                            else if(a==0){

                            }
                            else{
                            System.out.println("**ERROR DE COMANDO** ");
                            } 
                    }
                }
            }else{
                if(flag2==1){
                    for(int i=0;i<10;i++){
                        if(vector[i]==1){
                            pos=i;
                        }
                    }
                }
            }
            
        }
        
        
    }
    
    public void verLIBRO(){
        buscar();
        if(error!=1){
            System.out.println("*******************");
            libro[pos].mostrar();
            System.out.println("*******************");
            if(libro[pos].getCantPres()>=1 && libro[pos].getCantidad()==0 ){
                System.out.println("PRESTADO");
            }
        }
        else{
            System.out.println("**ERROR** \n El libro no existe");
        }
    
    }
    
    public void actualizar(){
        int sel;
        buscar();
        if(error!=1){
            System.out.println("**ACTUALIZAR DATOS** ");
            System.out.println("Ingrese el numero de la opcion: ");
            System.out.println("Nombre             [1] ");
            System.out.println("Autor              [2] ");
            System.out.println("Año de Publicacion [3] ");
            System.out.println("Codigo             [4] ");
            System.out.println("Cantidad           [5] ");
            System.out.println("Area               [6] ");
            System.out.println("Todos los datos    [7] ");
            sel=t.nextInt();
            switch(sel){
                case 1:
                    System.out.println("Nombre:");
                    libro[pos].setNombre(t.nextLine());
                    libro[pos].setNombre(t.nextLine());
                    System.out.println("¡¡ACTUALIZADO!! ");
                    break;
                case 2:
                    System.out.println("Autor:");
                    libro[pos].setAutor(t.nextLine());
                    libro[pos].setAutor(t.nextLine());
                    System.out.println("¡¡ACTUALIZADO!! ");
                    break;
                case 3:
                    System.out.println("Año de publicacion:");
                    libro[pos].setData_public(t.nextLine());
                    libro[pos].setData_public(t.nextLine());
                    System.out.println("¡¡ACTUALIZADO!! ");
                    break;
                case 4:
                    System.out.println("Codigo:");
                    libro[pos].setCodigo(t.nextLine());
                    libro[pos].setCodigo(t.nextLine());
                    System.out.println("¡¡ACTUALIZADO!! ");
                    break;
                case 5:
                    System.out.println("Cantidad:");
                    libro[pos].setCantidad(t.nextInt());
                    System.out.println("¡¡ACTUALIZADO!! ");
                    break;
                case 6:
                    String var;
                    System.out.println("        Area: ");
                    System.out.println("Quimica     [0]");
                    System.out.println("Fisica      [1]");
                    System.out.println("Tecnologia  [2]");
                    System.out.println("Calculo     [3]");
                    System.out.println("Programacion[4]");
                    libro[pos].areaLIBRO(t.nextInt());
                    var=t.nextLine();
                    System.out.println("¡¡ACTUALIZADO!! ");
                    break;
                case 7:
                    String var2;
                    var2=t.nextLine();
                    libro[pos].ingresar();
                    System.out.println("¡¡ACTUALIZADO!! ");                    
                    break;
                default:
                    System.out.println("**COMANDO INCORRECTO**");
                    break;
            }    
        }
        else{
            System.out.println("**ERROR** \n El libro no existe");
        }
    }
    
    public void eliminar(){
        buscar();
        if(error!=1){
            
            for(int i=pos;i<cuenta;i++){
                if(libro[i].getCantidad()!=0){    
                    if(libro[i].getCantidad()>1){
                        libro[pos].setCantidad(libro[pos].getCantidad()-1);
                    }
                    else{
                        if(i==cuenta-1){
                            cuenta--;
                        }
                        else{
                            libro[i]=libro[i+1];
                        }
                        System.out.println("¡¡ELIMINADO!! ");
                    }
                }
                else{
                    if(libro[i].getCantPres()!=0){
                        System.out.println("¡¡ESTA PRESTADO!! ");
                    }
                    else{
                        System.out.println("¡¡ERROR!! ");
                    }
                }
            }

        }
        else{
            System.out.println("**ERROR** \n El libro no existe");
        }
    }
    
    public void gertionarINFORMACION(){
        int n;
        System.out.println("\n ***GESTIONAR INFORMACION*** \n ");
        System.out.println("Ingrese el numero de la opcion: ");
        System.out.println("INGRESAR   [1] ");
        System.out.println("ACTUALIZAR [2] ");
        System.out.println("ELIMIAR    [3] ");
        System.out.println("MIRAR      [4] ");
        n=t.nextInt();
        switch(n){
            case 1:
                String f;
                f=t.nextLine();
                almacenar();
                break;
            case 2:
                String f1;
                f1=t.nextLine();
                actualizar();
                break;
            case 3:
                String f2;
                f2=t.nextLine();
                eliminar();
                break;
            case 4:
                String f3;
                f3=t.nextLine();
                verLIBRO();
                break;                        
            default:
                System.out.println("***COMANDO INCORRECTO***");
                break;
        } 
    
    }
    
    ///////////////////////////////////////////////////////////////////////// 
    
    public void prestamo(){
        int var;
        int flag=0;
        int posPers=0;
        int aux;
        System.out.println("Ingrese su cedula: ");
        var=t.nextInt();
        for(int i=0;i<10;i++){
            if(persona[i].getCedula()==0){
                persona[i].setCedula(var);
                flag=1;
                posPers=i;
                i=20;
            }
            else if(persona[i].getCedula()==var){
                flag=1;
                posPers=i;
                i=20;
            }
        }
        if(flag==1){
            int pp;
            String namep;
            aux=persona[posPers].numeroPrestados();
            persona[posPers].mostrarLibros();
            System.out.println("Usted tiene "+aux+" libros prestados");
            System.out.println("Cuantos libros desea prestar?");
            pp=t.nextInt();
            if(pp<=(5-aux)){
                for(int i=0;i<pp;i++){
                    namep=t.nextLine();
                    buscar();
                    if(error!=1){
                        if(libro[pos].getCantidad()==0){
                            System.out.println("Se encuentra Prestado ");                        
                        }
                        else{
                            cuentaP++;
                            persona[posPers].guardarLibro(libro[pos].getNombre());
                            libro[pos].setCantidad(libro[pos].getCantidad()-1);
                        }
                    }
                    else{
                        System.out.println("¡¡Libro no Existe!! ");
                    }
                }
            }
            else{
                System.out.println("¡¡No puede prestar mas de!! "+(5-aux)+" Libros");
            }
        }
    
    }
    
    public void devolucion(){
        System.out.println("no implementado ");
    }
    
    public void gestionar(){
        int s;
        System.out.println("\n ***GESTIONAR*** \n ");
        System.out.println("Prestamo   [0]");
        System.out.println("Devolucion [1] ");
        s=t.nextInt();
        switch(s){
            case 0:
                prestamo();
                break;
            case 1:
                devolucion();
                break;
            default:
                System.out.println("***COMANDO INCORRECTO*** ");
                break;
        }
    
    }
    
    public static void main(String[] args) {
         int n=100;
         BookSoftV1 BS=new BookSoftV1();
         Scanner teclado= new Scanner (System.in);
         while(n!=0){
            System.out.println("\n ***MENU PRINCIPAL*** \n ");
            System.out.println("Ingrese el numero de la opcion: ");
            System.out.println("Gestionar Informacion [1] ");
            System.out.println("Gestionar Prestamo [2] ");
            System.out.println("Salir [0] ");
            n=teclado.nextInt();
            switch(n){
                case 0:
                    System.out.println("\n***HASTA LUEGO***\n");
                    break;
                case 1:
                    BS.gertionarINFORMACION();
                    break;
                case 2:
                    BS.gestionar();
                    break;
                default:
                    System.out.println("***COMANDO INCORRECTO***");
                    break;
            } 
         }
        
    }
    
}
