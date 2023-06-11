package LOGIC;

import java.io.*;
import java.util.ArrayList;
import DATA.*;
import IU.*;
import java.util.Arrays;
public class Agenda {
    
    private static ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();
    
    public static ArrayList getListaContactos(){
        return listaContactos;
    }
    
    public static String[] getVectorNombres(){
        String listaNombres[] = new String[listaContactos.size()];
        for(int i=0;i<listaContactos.size();i++){
            listaNombres[i] = listaContactos.get(i).getNombre();
        }
        Arrays.sort(listaNombres);
        return listaNombres;
    }
    
    public static String cargarArchivo(){
        try{
            FileInputStream archivoGuardado = new FileInputStream("datosContactos.obj");
            ObjectInputStream archivo = new ObjectInputStream(archivoGuardado);
            
            ArrayList<Contacto> listaContactosGuardados = new ArrayList<Contacto>();
            Boolean band = true;
            while(band){ 
                try{
                    Contacto contacto = (Contacto)archivo.readObject();
                    listaContactosGuardados.add(contacto);
                    System.out.println(contacto.toString());
                }
                catch(EOFException error){
                    System.out.println(error+" Limite de lista alcanzado");
                    band = false;
                }
                
            }
            
            if(listaContactosGuardados.isEmpty()){
                return "No habian contactos guardados previamente";
            }
            else{
                listaContactos = listaContactosGuardados;

                System.out.println("Archivo cargado exitosamente");

                return "Archivo cargado exitosamente";
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e+" No se encontro un archivo guardado");
            return "No se encontro un archivo guardado";
        }
        catch(IOException e){
            System.out.println(e+" No se pudo leer correctamente el archivo");
            return "No se pudo leer correctamente el archivo";
        }
        catch(ClassNotFoundException e){
            System.out.println(e+" No se encontro la clase del objeto guardado");
            return "No se encontro la clase del objeto guardado";
        }
    }
    
    public static String guardarArchivo(ArrayList listaContactos){
        try{
            FileOutputStream archivoGuardado = new FileOutputStream("datosContactos.obj");
            ObjectOutputStream archivo = new ObjectOutputStream(archivoGuardado);
            
            for(int i=0;i<listaContactos.size();i++){
                archivo.writeObject(listaContactos.get(i));
            }
            
            archivo.close();
            listaContactos = listaContactos;
            System.out.println("Archivo guardado exitosamente");
            return "Archivo guardado exitosamente";
        }
        catch(FileNotFoundException e){
            System.out.println(e+" No se pudo guardar el archivo correctamente");
            return "No se pudo guardar el archivo correctamente";
        }
        catch(IOException e){
            System.out.println(e+" No se pudo guardar uno o varios objetos correctamente");
            return "No se pudo guardar uno o varios objetos correctamente";
        }
    }
    
    public static Contacto buscarContactoPorNombre(String nombre){
        Contacto contactoEncontrado = null;
        for(Contacto contacto:listaContactos){
            if(contacto.getNombre().equals(nombre)){
                contactoEncontrado = contacto;
            }
        }
        return contactoEncontrado;
    }
    
    public static void eliminarContacto(String nombre){
        listaContactos.remove(buscarContactoPorNombre(nombre));
    }
    
    public static void editarContactoCliente(String nombre, String nuevoNombre, String celular, String email, String cedula, int edad){
        Contacto cliente = buscarContactoPorNombre(nombre);
        Cliente clienteEditado = new Cliente(nuevoNombre, celular, email, cedula, edad);
        listaContactos.set(listaContactos.indexOf(cliente), clienteEditado);
    }
    
    public static void editarContactoProovedor(String nombre, String nuevoNombre, String celular, String email, String NIT, Boolean internacional){
        Contacto proovedor = buscarContactoPorNombre(nombre);
        CompanyProovedora proovedorEditado = new CompanyProovedora(nuevoNombre, celular, email, NIT, internacional);
        listaContactos.set(listaContactos.indexOf(proovedor), proovedorEditado);
    }
    
    public static void guardarContacto(Contacto contacto){
        listaContactos.add(contacto);
    }
    
    Cliente cliente1 = new Cliente("David Chaparro", "3007183303", "dachaparrop@unal.edu.co", "27889729", 23);
    Cliente cliente2 = new Cliente("Juan Torres", "3201533381", "saleonn@unal.edu.co", "55678221", 21);
    Cliente cliente3 = new Cliente("Angie Perez", "3109833419", "angiep@unal.edu.co", "17019324", 19);
    CompanyProovedora compania1 = new CompanyProovedora("Gucci", "3310533817", "gucci@gmail.com", "338457929-1", true);
    CompanyProovedora compania2 = new CompanyProovedora("Zara", "3120559824", "zara@hotmail.com", "928651029-1", false);
    
}
