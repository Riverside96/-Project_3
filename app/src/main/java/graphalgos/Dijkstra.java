package graphalgos;
import java.util.PriorityQueue;
public class Dijkstra {
  

   public static HashMap[] dijkstra(Graph graph, Vertex startV) {

        if (startV.getEdges().peek() == null) 
        return null;    

        HashMap<String, Integer> distTable = new HashMap<>();
        HashMap<String, Vertex> prevTable = new HashMap<>();
        PriorityQueue<PQObj> queue = new PriorityQueue<PQObj>();



        queue.add(new PQObj(startV, 0));

        for (Vertex v: graph.getVertices()) {
            if (v != startV) {
                distTable.put(v.getData(), Integer.MAX_VALUE);
            }
            prevTable.put(v.getData(), new Vertex("Null"));
        }

        distTable.put(startV.getData(), 0);


        while (queue.size() != 0) {
            Vertex current = queue.poll().vertex;
            for (Edge e: current.getEdges()) {
                Integer alt = distTable.get(current.getData()) + e.getWeight();
                String neighbour = e.getTo().getData();
                if (alt < distTable.get(neighbour)) {
                    distTable.put(neighbour, alt);
                    prevTable.put(neighbour, current);
                    queue.add(new PQObj(e.getTo(), distTable.get(neighbour)));
                }
            }
        }
        return new HashMap[]{distTable, prevTable};
    }



    public static void shortestPathBetween(Graph g, Vertex startingVertex, Vertex targetVertex) {
        HashMap[] tables = dijkstra(g, startingVertex);
        HashMap distances = tables[0];
        HashMap previous = tables[1];

        Integer distance = (Integer) distances.get(targetVertex.getData());
        System.out.println("Dijkstra's alogirthim concludes:");
        System.out.print("Shortest Distance between " + startingVertex.getData() + " and " + targetVertex.getData() + ":");
        System.out.println(distance);

        MyLinkedList<Vertex> path = new MyLinkedList<>();
        Vertex v = targetVertex;

        while (v.getData() != "Null") {
            path.addAtIndex(0, v);
            v = (Vertex) previous.get(v.getData());
        }
        System.out.print( "via: ");
        for (Vertex pathVertex: path){
            System.out.print(pathVertex.getData());
            if(pathVertex != targetVertex)
              System.out.print("->");
        }
    }








}
