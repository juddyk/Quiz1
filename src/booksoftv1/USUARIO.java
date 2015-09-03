package booksoft_v1;


public class USUARIO {
        private int cedula;
        private String[] librosPRES;
        

    USUARIO(){
        cedula=0;
        librosPRES=new String[10];
        for(int i=0;i<5;i++){
            librosPRES[i]=new String();
            librosPRES[i]="NN";
        }
                
    }
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String[] getLibrosPRES() {
        return librosPRES;
    }

    public void setLibrosPRES(String[] librosPRES) {
        this.librosPRES = librosPRES;
    }
    
    public int guardarLibro(String name){
        int flag=0;
        for(int i=0;i<5;i++){
            if(librosPRES[i].compareTo("NN")==0){
                librosPRES[i]=name;
                i=10;
            }
            else{
                flag++;
            }
            
        }
        if(flag==5){
            return 0;    
        }
        else{
            return 1;
        }
    
    }
    
    public int numeroPrestados(){
        int flag=0;
        for(int i=0;i<5;i++){
            if(librosPRES[i].compareTo("NN")!=0){
                flag++;
            }
        }
        return flag;
    }
    
    public void mostrarLibros(){
        for(int i=0;i<5;i++){
            System.out.println((i+1)+": "+librosPRES[i]);
            
        }
    
    }

}
