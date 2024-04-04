package oop2.refactoring.parametros.salida;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var disco = new Disco("/home/enrique");
        var archivo = disco.contenido("archivo.txt");
        //retornar null me obliga a no olvidarme de chequear conun if
        if (archivo != null) {

        }
        //no usemos nunca mas null !

        //fail fast
//        try {
//            String contenido = disco.contenido2("nombre.txt");
//            //hacer algo con contenido...
//        } catch (IllegalArgumentException e) {
//            //hacer algo cuando no existe el archivo
//        }

        //Optional
//        Optional<String> contenidoLeido = disco.contenido3("nombre.txt");
//        contenidoLeido.ifPresent((contenido) -> System.out.println(contenido));
//
//        Optional<String> hayContenido = disco.contenido3("nombre.txt");
//        String resultado = hayContenido.orElse("El Archivo no se encuentra...");
    }
}
