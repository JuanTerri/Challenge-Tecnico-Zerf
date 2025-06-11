import java.util.List;
import java.util.ArrayList;

public class FileSystem {
    private Directorio raiz;
    private Directorio actual;

    public FileSystem() {
        this.raiz =  new Directorio("/",null); // la raiz en linux es "/"
        this.actual = raiz; // apenas creo el FS estoy parado en la raiz
    }

    public void pwd(){
        System.out.println(actual.rutaCompleta());
    }
    
    public void ls(){
        for (Nodo nodo : actual.getHijos()){ //recorro cada directorio hijo y voy mostrando su nombre
            System.out.println(nodo.getNombre());
        } 
    }

    public void mkdir(String dirName){
        if (actual.buscar(dirName)!= null){ //evaluo la posibilidad de que ya exista ese nombre
            System.out.println("Ya existe un NODO con ese nombre"); //  si no cumple es que ya existe un NODO con ese nombre
        } else { 
        Nodo carpetaCrear = new Directorio(dirName,actual); //creo la CARPETA con el nombre que me dieron y el padre es el directorio actual
        actual.agregarHijo(carpetaCrear); //lo agrego a la lista de hijos del directorio actual
            }
    }

    public void touch(String fileName){
        if (actual.buscar(fileName)!= null){ // busco el archivo y me fijo si es distinto de null si no cumple es que ya existe un NODO con ese nombre
            System.out.println("Ya existe un NODO con ese nombre");
        } else {
        Nodo archivoCrear = new Archivo(fileName, actual); // creo el ARCHIVO con el nombre que me dieron y el padre es el directorio actual
        actual.agregarHijo(archivoCrear);// lo agrego a la lista de hijos del directorio actual
            }
    }

    public void cd(String dirName){
        if (dirName.equals("..")) { //comparo si el nombre que me pasaron es ".." 
            if (actual.getPadre()!= null) { // si el padre no es null, el padre pasa a ser el directorio actual
                this.setActual(actual.getPadre());
            }
        } else { Nodo nodoBuscado = actual.buscar(dirName); // encuentro el nodo buscado
                if (nodoBuscado instanceof Directorio){ // si el nodo buscado es una instancia de directorio
                    setActual((Directorio)nodoBuscado); // seteo ese directorio encontrado como actual
                } else 
                 System.out.println("No se encontro el directorio"); //si no es una instancia de directorio o es un archivo o no existe
         }
    }

    // GETTER Y SETTER
    public Directorio getRaiz() {
        return raiz;
    }

    public Directorio getActual() {
        return actual;
    }

    public void setRaiz(Directorio raiz) {
        this.raiz = raiz;
    }

    public void setActual(Directorio actual) {
        this.actual = actual;
    }

  
}
