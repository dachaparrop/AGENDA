package DATA;
import java.io.Serializable;

public abstract class Contacto implements Serializable{
    private String nombre;
    private String celularContacto;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelularContacto() {
        return celularContacto;
    }

    public void setCelularContacto(String celularContacto) {
        this.celularContacto = celularContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contacto(String nombre) {
        this.nombre = nombre;
    }
    
    public Contacto(String nombre, String celularContacto, String email) {
        this.nombre = nombre;
        this.celularContacto = celularContacto;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nCelularContacto: " + celularContacto + "\nEmail: " + email;
    }

    
}
