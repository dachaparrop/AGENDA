package DATA;
import java.io.Serializable;

public class Cliente extends Contacto implements Serializable{
    private String cedula;
    private int edad;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public Cliente(String nombre, int edad){
        super(nombre);
        this.edad = 0;
    }
    
    public Cliente(String nombre, String celularContacto, String email, String cedula, int edad){
        super(nombre, celularContacto, email);
        this.cedula = cedula;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return super.toString()+"\nCedula: " + cedula +"\nEdad: " + edad;
    }
    
    
}
