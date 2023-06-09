package DATA;
import java.io.Serializable;

public class CompanyProovedora extends Contacto implements Serializable{
    private String NIT;
    private Boolean internacional;

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public Boolean getInternacional() {
        return internacional;
    }

    public void setInternacional(Boolean internacional) {
        this.internacional = internacional;
    }

    public CompanyProovedora(String nombre, String celularContacto, String email, String NIT, Boolean internacional) {
        super(nombre, celularContacto, email);
        this.NIT = NIT;
        this.internacional = internacional;
    }

    
    
    @Override
    public String toString() {
        return super.toString()+"\nNIT: " + NIT +"\nInternacional: " + internacional;
    }
    
}
