import com.cajablanca.editor.Editor;
import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PruebasEditor {

    Editor editor;

    @Before
    public void setUp(){
      editor = new Editor();
      editor.cargarEditor("editor.txt");
    }


    /*@Test(expected = EmptyCollectionException.class)
    public void getLineaTestC1o() throws EmptyCollectionException { //funciona
        //poner el editor vacío
            this.editor.getLinea(1);
    }*/

    @Test
    public void getLineaTestC1(){ //funciona
        //Poner el editor vacío
        boolean thrown = false;
        try{
            this.editor.getLinea(1);
        }catch (EmptyCollectionException e){
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getLineaTestC2() throws EmptyCollectionException { //funciona
        //Poner tamaño 3 en el editor
        this.editor.getLinea(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getLineaTestC3() throws EmptyCollectionException { //funciona
        //Poner tamaño 1 en el editor
        this.editor.getLinea(2);
    }

    @Test
    public void getLineaTestC4() throws EmptyCollectionException { //funciona pero no se si se prueba así
        //Poner tamaño 3 en el editor
        AbstractSingleLinkedListImpl<String> lista = new SingleLinkedListImpl<String>();
        lista.addAtPos("[tamaño, 1]", 1);
        lista.addAtPos("[tamaño, 2]", 2);
        lista.addAtPos("[tamaño, 3]", 3);
        assertEquals(lista.getAtPos(2), this.editor.getLinea(2).toString());
    }

    @Test
    public void numAparicionesTestC1(){ //funciona
        // Poner vacio el editor.txt
        String mensajeError = null;
        String mensaje = "La línea de inicio no puede ser menor o igual a cero";
        try {
            editor.numApariciones(0,0,"tamañoUno");
        }catch (IllegalArgumentException e){
            mensajeError = e.getMessage();
        }
        assertEquals(mensaje, mensajeError);
    }

    /*@Test(expected = IllegalArgumentException.class) //funciona
    public void numAparicionesTestC1(){ //otra manera
        //poner vacío el editor.txt
        editor.numApariciones(0,0, "tamaño");
    }*/

    @Test
    public void numAparicionesTestC2(){ //funciona
        // Poner hasta tamañoDos en editor.txt
        String mensajeError = null;
        String mensaje = "La línea fin no puede ser mayor que el máximo de líneas";
        try {
            editor.numApariciones(1,3,"tamañoUno");
        }catch (IllegalArgumentException e){
            mensajeError = e.getMessage();
        }
        assertEquals(mensaje, mensajeError);
    }

    /*@Test(expected = IllegalArgumentException.class) //funciona
    public void numAparicionesTestC2(){
        //poner hasta tamañoDos en editor.txt
        editor.numApariciones(1,3, "tamaño");
    }*/

    @Test
    public void numAparicionesTestC3(){
        //poner vacío el editor.txt
        assertEquals(0, editor.numApariciones(2,0, "tamañoUno"));
    }

    @Test
    public void numAparicionesTestC4(){ // se para en la primera condición, es un camino que no será posible
        //poner hasta tamañoDos en editor.txt
        assertEquals(0, editor.numApariciones(3,2, "tamañoUno"));
    }

    @Test
    public void numAparicionesTestC6(){
        //poner hasta tamañoUno en editor.txt
        assertEquals(0, editor.numApariciones(1,1, "tamañoDos"));
    }

    @Test
    public void numAparicionesTestC7(){
        //poner hasta tamañoUno en editor.txt
        assertEquals(1, editor.numApariciones(1,1, "tamañoUno"));
    }

    @Test
    public void numPalabrasTestC1(){
        //poner vacío el editor.txt
        String mensajeError = null;
        String mensaje = "El editor está vacío";
        try {
            this.editor.numPalabras();
        }catch (EmptyCollectionException e){
            mensajeError = e.getMessage();
        }
        assertEquals(mensaje, mensajeError);
    }

   /* @Test (expected = EmptyCollectionException.class) //otra manera
    public void numPalabrasTestC1o() throws EmptyCollectionException {
        //poner vacío el editor.txt
        this.editor.numPalabras();
    }*/

    @Test
    public void numPalabrasTestC6() throws EmptyCollectionException {
        //Poner tamañoUno en el editor.txt
        assertEquals(1, this.editor.numPalabras());
    }
}
