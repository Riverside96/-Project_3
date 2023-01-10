package graphalgos;

class Traverser {
  
  public static void depthFirstTraversal(Vertex startV, MyLinkedList<Vertex> visitedList){
    System.out.println(startV.getData());

    for(Edge e : startV.getEdges()){
      Vertex thisNeighbour = e.getTo();

      if (!visitedList.contains(thisNeighbour)){
        visitedList.push(thisNeighbour);
        Traverser.depthFirstTraversal(thisNeighbour, visitedList);
      }
    }
  }

  public static void depthFirstSearch(Vertex startV, Vertex endV, MyLinkedList<Vertex> visitedList, MyLinkedList<Vertex> path, int totalWeight){
    path.push(startV);


    
    if (startV.equals(endV)){
      for(int i=path.getSize()-1; i >= 0; i--) {
          System.out.print(path.get(i).getData());
          if(path.get(i) != endV)
            System.out.print("->");
          else
            System.out.print("\n");
      }

      System.out.println("This journey has a total weight of: "+totalWeight);

    } else {
        for(Edge e : startV.getEdges()){
            Vertex thisNeighbour = e.getTo();

            if (!visitedList.contains(thisNeighbour)){
              visitedList.push(thisNeighbour);
              Traverser.depthFirstSearch(thisNeighbour, endV, visitedList, path, totalWeight + e.getWeight());
            }
          }
        }
      //remove current vertex from path before returning
      path.deleteAt(path.getSize() -1);
    }



  public static void breadthFirstTraversal(Vertex startV, MyLinkedList<Vertex> visitedList){
    Queue<Vertex> visitQueue = new Queue<Vertex>();
    visitQueue.enqueue(startV);

    while (!visitQueue.isEmpty()){
      Vertex current = visitQueue.dequeue();
      System.out.println(current.getData());

      for(Edge e : current.getEdges()){
        Vertex thisNeighbour = e.getTo();
        if(!visitedList.contains(thisNeighbour)){
          visitedList.push(thisNeighbour);
          visitQueue.enqueue(thisNeighbour);
        }
      }
    }
  }

  public static void breadthFirstSearch(Vertex startV, Vertex endV, MyLinkedList<Vertex> visitedList, MyLinkedList<Vertex> path, int totalWeight){
    Queue<Vertex> visitQueue = new Queue<Vertex>();
    visitQueue.enqueue(startV);

    while (!visitQueue.isEmpty()){
      Vertex current = visitQueue.dequeue();
      path.push(current);

      if(current.equals(endV)){
        for(int i=path.getSize()-1; i!=0; i--){
          System.out.print(path.get(i).getData());
          if(path.get(i) != endV)
            System.out.print("->");
        }
        System.out.println(endV.getData());

        System.out.println("total traversal weight for this search: " + totalWeight);
        return;

      } else {
        for(Edge e : current.getEdges()){
            Vertex thisNeighbour = e.getTo();
            if(!visitedList.contains(thisNeighbour)){
              visitedList.push(thisNeighbour);
              visitQueue.enqueue(thisNeighbour);
              totalWeight += e.getWeight();
            }
          }
    }
  }  
}




  




}

