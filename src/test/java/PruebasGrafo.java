import com.cajablanca.grafo.Arco;
import com.cajablanca.grafo.Grafo;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PruebasGrafo {

    @Test
    public void GrafoTest() {
        Grafo grafo = new Grafo();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        grafo.printGraph();


        assertEquals("", outContent.toString());
        assertNotNull(grafo);
    }

    @Test
    public void GrafoTestConParametrosC1() { // no existe el fichero
        Grafo grafo = new Grafo("../grafito.txt");
    }

    @Test
    public void GrafoTestConParametrosC2() { // no existe el fichero
        Grafo grafo = new Grafo("../grafo.txt"); // DIRIGIDO NO \n CONPESO NO
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        grafo.printGraph();


        assertEquals("", outContent.toString());
        assertNotNull(grafo);
    }

    @Test
    public void GrafoTestConParametrosC3() { // no existe el fichero
        Grafo grafo = new Grafo("../grafo.txt"); // DIRIGIDO NO \n CONPESO NO \n 2 2
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        grafo.printGraph();


        assertEquals("2 ——>(2,2) (2,2) \r\n", outContent.toString());
        assertNotNull(grafo);
    }

    @Test
    public void GrafoTestConParametrosC4() { // no existe el fichero
        Grafo grafo = new Grafo("../grafo.txt"); // DIRIGIDO SI \n CONPESO NO \n 2 2
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        grafo.printGraph();


        assertEquals("2 ——>(2,2) \r\n", outContent.toString());
        assertNotNull(grafo);
    }

    @Test
    public void GrafoTestConParametrosC5() { // no existe el fichero
        Grafo grafo = new Grafo("../grafo.txt"); // DIRIGIDO NO \n CONPESO SI \n 2 2 2
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        grafo.printGraph();


        assertEquals("2 ——>(2,2,2) (2,2,2) \r\n", outContent.toString());
        assertNotNull(grafo);
    }

    @Test
    public void GrafoTestConParametrosC6() { // no existe el fichero
        Grafo grafo = new Grafo("../grafo.txt"); // DIRIGIDO SI \n CONPESO SI \n 2 2 2
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        grafo.printGraph();


        assertEquals("2 ——>(2,2,2) \r\n", outContent.toString());
        assertNotNull(grafo);
    }

    @Test
    public void printListaAdyacentesTestC1(){
        Grafo grafo = new Grafo();
        grafo.addVertice(1);
        grafo.printListaAdyacentes(1);
    }

    @Test
    public void printListaAdyacentesTestC2(){
        Grafo grafo = new Grafo();
        Arco arco1 = new Arco(1, 2, 0);
        Arco arco2 = new Arco(1, 3, 0);
        Arco arco3 = new Arco(3, 4, 0);
        grafo.addArco(arco1);
        grafo.addArco(arco2);
        grafo.addArco(arco3);
        grafo.printListaAdyacentes(3);
        assertEquals(arco2.getOrigen(), 1);
        assertEquals(arco2.getDestino(), 3);
        assertEquals(arco3.getOrigen(), 3);
        assertEquals(arco3.getDestino(), 4);
    }

    /*@Test
    public void printListaAdyacentesTest(){
        Grafo grafo = new Grafo();
        Arco arco1 = new Arco(1, 2, 0);
        Arco arco2 = new Arco(1, 3, 0);
        Arco arco3 = new Arco(3, 4, 0);
        grafo.addArco(arco1);
        grafo.addArco(arco2);
        grafo.addArco(arco3);
        grafo.printListaAdyacentes(3);
        assertEquals(arco2.getOrigen(), 1);
        assertEquals(arco2.getDestino(), 3);
        assertEquals(arco3.getOrigen(), 3);
        assertEquals(arco3.getDestino(), 4);
    }*/

    public static void main(String[] args) {
        Grafo grafo = new Grafo(true, false);
        Grafo grafo1 = new Grafo(false, false);

        //Arco arco = new Arco(3, 1, 0);
        Arco arco1 = new Arco(5, 2, 0);
        Arco arco2 = new Arco(0, 4,0);

        /*grafo1.addArco(arco);
        grafo1.printGraph();*/

       // grafo.addArco(arco);
        grafo.addArco(arco1);
        grafo.addArco(arco2);
        grafo.addArco(new Arco(3, 5,0));
        grafo.addArco(new Arco(1, 5,0));

        grafo.printGraph();

        System.out.println(grafo.componentsRelated());
    }
}
