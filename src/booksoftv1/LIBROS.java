
package booksoft_v1;

import java.util.Scanner;

public class LIBROS {
    
    private String nombre;
    private String autor;
    private String data_public;
    private String codigo;
    private int cantidad;
    private String area;
    private int ediciones;
    private int cantPres;
    
    private final Scanner teclado= new Scanner (System.in);//para entrada por teclado

    LIBROS(){
        nombre="NN";
        autor="NN";
        data_public="NN";
        codigo="NN";
        cantidad=0;
        area="NN";
        ediciones=0;
        cantPres=0;
    }

    public int getCantPres() {
        return cantPres;
    }

    public void setCantPres(int cantPres) {
        this.cantPres = cantPres;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getData_public() {
        return data_public;
    }

    public void setData_public(String data_public) {
        this.data_public = data_public;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEdiciones() {
        return ediciones;
    }

    public void setEdiciones(int ediciones) {
        this.ediciones = ediciones;
    }

    public void areaLIBRO(int a){
        switch(a){
            case 0:
                area="Quimica";
                break;
            case 1:
                area="Fisica";
                break;
            case 2:
                area="Tecnologia";
                break;
            case 3:
                area="Calculo";
                break;
            case 4:
                area="Programacion";
                break;
            default:
                System.out.println("**COMANDO INCORRECTO**");                      
                break;
        
        }
    } 
        
    public void ingresar(){
        System.out.println("Nombre: ");
        nombre=teclado.nextLine();
        System.out.println("Autor: ");
        autor=teclado.nextLine();
        System.out.println("Año de publicación: ");
        data_public=teclado.nextLine();
        System.out.println("Codigo: ");
        codigo=teclado.nextLine();
        System.out.println("Cantidad: ");
        cantidad=teclado.nextInt();
        System.out.println("        Area: ");
        System.out.println("Quimica     [0]");
        System.out.println("Fisica      [1]");
        System.out.println("Tecnologia  [2]");
        System.out.println("Calculo     [3]");
        System.out.println("Programacion[4]");
        areaLIBRO(teclado.nextInt());
        setEdiciones(1);
    }
          
    public void mostrar(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Autor: "+autor);
        System.out.println("Año de publicacion: "+data_public);
        System.out.println("Codigo: "+codigo);
        System.out.println("Cantidad: "+cantidad);
        System.out.println("Area: "+area);      
        System.out.println("Ediciones: "+ediciones);
        
    }
    
}
