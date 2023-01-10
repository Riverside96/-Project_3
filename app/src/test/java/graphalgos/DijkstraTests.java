package graphalgos;
import static org.junit.Assert.*;
import org.junit.Test;

public class DijkstraTests {

    @Test
    public void testDijkstra() {
    
        Graph testGraph = new Graph(true, true);
        Vertex A = testGraph.addVertex("A");
        Vertex B = testGraph.addVertex("B");
        Vertex C = testGraph.addVertex("C");
        testGraph.addEdge(A, B, 3);
        testGraph.addEdge(A, C, 2);

        HashMap[] result = Dijkstra.dijkstra(testGraph, A);
        HashMap<String, Integer> distTable = result[0];
        HashMap<String, Vertex> prevTable = result[1];
        // check distance table is correct
        assertEquals(0, (int)distTable.get("A"));
        assertEquals(3, (int)distTable.get("B"));
        assertEquals(2, (int)distTable.get("C"));
        // check previous table is correct
        assertEquals("Null", prevTable.get("A").getData());
        assertEquals("A", prevTable.get("B").getData());
        assertEquals("A", prevTable.get("C").getData());
    
}
    @Test
    public void testNegativeWeight() {
      try {
          Graph testGraph = new Graph(true, true);
          Vertex A = testGraph.addVertex("A");
          Vertex B = testGraph.addVertex("B");
          Vertex C = testGraph.addVertex("C");
          testGraph.addEdge(A, B, 3);
          testGraph.addEdge(A, C, 2);
          testGraph.addEdge(A, B, -1);
          testGraph.addEdge(A, C, 2);
          Dijkstra.dijkstra(testGraph, A);
          fail("Expected IllegalArgumentException");
      } catch (IllegalArgumentException e) {
          // exception expected
      }
    }

   @Test
      public void testGraphNoEdges() {
          Graph testGraph = new Graph(true, true);
          Vertex A = testGraph.addVertex("A");
          Vertex B = testGraph.addVertex("B");
          Vertex C = testGraph.addVertex("C");
          // not adding any edges
          HashMap[] result = Dijkstra.dijkstra(testGraph, A);
          assertNull(result);
      }
}
