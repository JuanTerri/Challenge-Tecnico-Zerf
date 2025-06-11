public class Main {
    public static void main(String[] args) {
       
        System.out.println("Hola equipo de Zerf, realice estas pruebas para ver si todo funcionaba tal lo pensado");
        
        FileSystem fileSystem = new FileSystem(); // creo el FS
        
        // muestro la ruta actual como lo cree recien deberia ser "/"
        fileSystem.pwd();

        // creo la carpeta "home" en la raíz
        fileSystem.mkdir("home");

        // ingreso a "home"
        fileSystem.cd("home");

        // creo nodos (carpetas/archivos)
        fileSystem.mkdir("proyectos");
        fileSystem.touch("notas.txt");
        fileSystem.touch("tareas.txt");

        // quiero ver que tiene "home"
        fileSystem.ls();

        // me muevo a traver de las carpetas, voy a proyectos
        fileSystem.cd("proyectos");

        // creo archivos dentro de /home/proyectos
        fileSystem.touch("miProyecto.java");
        fileSystem.touch("README.md");

        // muestro la ruta actual
        fileSystem.pwd();  // tiene que dar /home/proyectos

        // vuelvo para atras "home"
        fileSystem.cd("..");
        fileSystem.pwd();

        // voy a la raiz
        fileSystem.cd("..");
        fileSystem.pwd();

        // croe un archivo duplicado
        fileSystem.touch("home"); // debería mostrar mensaje de error

        // me intento parar en un archiov
        fileSystem.cd("notas.txt"); // debería mostrar que no es un directorio
    }
}
