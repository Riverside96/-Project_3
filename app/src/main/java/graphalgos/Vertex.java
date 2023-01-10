package graphalgos;

public class Vertex {
  private String data;
  private MyLinkedList<Edge> edges;
  private int numberOfEdges;

  public String getData(){return this.data;}
  public MyLinkedList<Edge> getEdges(){return this.edges;}

  public Vertex(String data){
    this.data = data;
    this.edges = new MyLinkedList<Edge>();
    this.numberOfEdges=0; 
  }

  public void addEdge(Vertex to, int weight){
    this.edges.push(new Edge(this, to, weight));
    numberOfEdges++;
  }

  public void deleteEdge(Vertex rhsTo){
    this.edges.removeIf(edge -> edge.getTo().equals(rhsTo));
    numberOfEdges--;
  }

  public int countEdges(){return this.numberOfEdges;}

  public void print(boolean showWeight){
    String toPrint = "";
    if(this.edges.getSize() == 0){
      System.out.println(this.data + "-->");
      return;
    }

    for(int i =0; i<this.edges.getSize(); i++){

      if (i == 0){
        toPrint += this.edges.get(i).getFrom().data + "-->";
      }
      toPrint += this.edges.get(i).getTo().data;

      if(showWeight){
        toPrint += " (" + this.edges.get(i).getWeight() + ")";
      }
      if (i != this.edges.getSize() -1){
        toPrint += ", ";
      }
    }
    System.out.println(toPrint);
  }
}
