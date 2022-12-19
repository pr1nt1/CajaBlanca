import com.cajablanca.grafo.Arco;
import com.cajablanca.grafo.Grafo;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class PruebasGrafo {

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

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Grafo grafo1 = new Grafo(false, false);
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(6);
        grafo.printGraph();



        Arco arco = new Arco(1, 2, 0);
        Arco arco1 = new Arco(6, 2, 0);

        grafo1.addArco(arco);
        grafo1.printGraph();

        grafo.addArco(arco);
        grafo.addArco(arco1);
        grafo.printGraph();
        grafo.printArcos();

        System.out.println(grafo.numVertices());
        grafo.printListaAdyacentes(1);
    }
}
