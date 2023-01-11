package graphalgos;

public class App {
    public static void main(String[] args) {

    Graph usa = new Graph(true, true);
    Vertex newYork = usa.addVertex("New York");
    Vertex chicago = usa.addVertex("Chicago");
    Vertex denver = usa.addVertex("Denver");
    Vertex dallas = usa.addVertex("Dallas");
    Vertex miami = usa.addVertex("Miami");
    Vertex sanFran = usa.addVertex("San Fran");
    Vertex sanDiego = usa.addVertex("San Diego");
    Vertex losA = usa.addVertex("LA");

    usa.addEdge(newYork, chicago, 75);
    usa.addEdge(newYork, denver, 100);
    usa.addEdge(newYork, dallas, 125);
    usa.addEdge(newYork, miami, 90);
    usa.addEdge(chicago, sanFran, 25);
    usa.addEdge(chicago, denver, 20);
    usa.addEdge(miami, dallas, 50);
    usa.addEdge(dallas, losA, 80);
    usa.addEdge(dallas, sanDiego, 90);
    usa.addEdge(denver, sanFran, 75);
    usa.addEdge(denver, losA, 100);
    usa.addEdge(sanDiego, losA, 45);
    usa.addEdge(sanFran, losA, 45);



    System.out.println("Here is a list of all links");
    usa.print();
    System.out.println();

    
    MyLinkedList<Vertex> visitedList = new MyLinkedList<>();
    MyLinkedList<Vertex> path = new MyLinkedList<>();
    int totalWeight = 0;
    System.out.println("Depth First Search: ");
    Traverser.depthFirstSearch(newYork, losA, visitedList, path, totalWeight);

    System.out.println();

    MyLinkedList<Vertex> visitedList2 = new MyLinkedList<>();
    MyLinkedList<Vertex> path2 = new MyLinkedList<>();
    int totalWeight2 = 0;
    System.out.println("Breadth First Search: ");
    Traverser.breadthFirstSearch(newYork, losA, visitedList2, path2, totalWeight2);

    System.out.println();

    Dijkstra.shortestPathBetween(usa, newYork, losA);
    

    }

    

}
