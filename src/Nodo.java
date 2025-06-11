public abstract class Nodo {
    private String nombre;
    private Directorio padre;

     public Nodo(String nombre, Directorio padre) { //constructor
        this.nombre = nombre;
        this.padre = padre;
    }

    // GETTER Y SETTER
    public String getNombre() {
        return nombre;
    }

    public Directorio getPadre() {
        return padre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPadre(Directorio padre) {
        this.padre = padre;
    }

    // funcion para saber la ruta completa de un NODO 
    public String rutaCompleta() { 
    if (padre == null){ //si el padre es null devuelve "/" seria la raiz
        return "/";
    } 
    String rutaPadre = padre.rutaCompleta(); //si no entro en el primer if sigue y agarra la ruta del padre, recursividad

    if (rutaPadre.equals("/")) { // si la ruta del padre es / devuelve / + su nombre
        return rutaPadre + nombre;  
    } else {
        return rutaPadre + "/" + nombre;  // sino devuelve toda la ruta del padre + "/" + su nombre
    }
}
   
}
    