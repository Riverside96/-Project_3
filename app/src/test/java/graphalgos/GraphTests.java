package graphalgos;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GraphTests {

    @Test
    public void testGraphProperties() {
        // create a weighted, directional graph
        Graph testGraph = new Graph(true, true);
        assertTrue(testGraph.isGraphWeighted());
        assertTrue(testGraph.isGraphDirectional());

        // create a non-weighted, non-directional graph
        Graph testGraph2 = new Graph(false, false);
        assertFalse(testGraph2.isGraphWeighted());
        assertFalse(testGraph2.isGraphDirectional());
    }

    @Test
    public void testAddVertex() {
        Graph testGraph = new Graph(true, true);
        Vertex v1 = testGraph.addVertex("A");
        Vertex v2 = testGraph.addVertex("B");
        assertEquals("A", v1.getData());
        assertEquals("B", v2.getData());
    }

    @Test
    public void testNonDirectedAddEdge() {
        Graph testGraph = new Graph(true, true);
        Vertex v1 = testGraph.addVertex("A");
        Vertex v2 = testGraph.addVertex("B");
        testGraph.addEdge(v1, v2, 10);
        assertEquals(1, v1.countEdges());
        assertEquals(0, v2.countEdges());
    }

     @Test
    public void testDirectedAddEdge() {
        Graph testGraph = new Graph(true, false);
        Vertex v1 = testGraph.addVertex("A");
        Vertex v2 = testGraph.addVertex("B");
        testGraph.addEdge(v1, v2, 10);
        assertEquals(1, v1.countEdges());
        assertEquals(1, v2.countEdges());
    }

    @Test
    public void testDeleteEdge() {
        Graph testGraph = new Graph(true, true);
        Vertex v1 = testGraph.addVertex("A");
        Vertex v2 = testGraph.addVertex("B");
        testGraph.addEdge(v1, v2, 10);
        testGraph.deleteEdge(v1, v2);
        assertEquals(0, v1.countEdges());
        assertEquals(0, v2.countEdges());
    }

    @Test
    public void testNonDirectedDeleteEdge() {
        Graph testGraph = new Graph(true, false);
        Vertex v1 = testGraph.addVertex("A");
        Vertex v2 = testGraph.addVertex("B");
        testGraph.addEdge(v1, v2, 10);
        testGraph.deleteEdge(v1, v2);
        assertEquals(0, v1.countEdges());
        assertEquals(0, v2.countEdges());
    }
}
