import java.util.List;
import java.util.ArrayList;

public class Directorio extends Nodo {
    private List<Nodo> hijos = new ArrayList<>(); //lista de hijos
     
    public Directorio(String nombre, Directorio padre) { //constructor
        super(nombre, padre);
    }
    
    //agrego un hijo(nodo) a la lista de hijos
    public void agregarHijo(Nodo nodo){
        hijos.add(nodo);
    }

    //funcion para buscar un nodo-hijo con el nombre que le paso
    public Nodo buscar(String nombre) { 
        for (Nodo nodo : hijos) {
            if (nodo.getNombre().equals(nombre)) {
                return nodo;
            }
        }
        return null;
    }

     // getter y setter
    public List<Nodo> getHijos() { 
        return hijos;
    }
    
    public void setHijos(List<Nodo> hijos) {
        this.hijos = hijos;
    }
}
