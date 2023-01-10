package graphalgos;


public class Graph {
  
  private MyLinkedList<Vertex> vertices;
  public MyLinkedList<Vertex> getVertices() {return vertices;}

  private boolean isGraphWeighted;
  public boolean isGraphWeighted() {return isGraphWeighted;}

  private boolean isGraphDirectional;
  public boolean isGraphDirectional() {return isGraphDirectional;}

  public Graph(boolean setIsGraphWeighted, boolean setIsGraphDirectional){
    this.vertices = new MyLinkedList<Vertex>();
    this.isGraphWeighted = setIsGraphWeighted;
    this.isGraphDirectional = setIsGraphDirectional;
  }

  public Vertex addVertex(String data){
    Vertex newOne = new Vertex(data);
    this.vertices.pushEnd(newOne); // push start or end?
    return newOne;
  }
  public void addEdge(Vertex from, Vertex to, Integer weight){
    if (!this.isGraphWeighted){
      weight = null;
    }
    from.addEdge(to, weight);
    if (!this.isGraphDirectional){
      to.addEdge(from, weight);
    }
  }
  public void deleteEdge(Vertex from, Vertex to){
    from.deleteEdge(to);
    if (!this.isGraphDirectional){
      to.deleteEdge(from);
    }
  }
  public void deleteVertex(Vertex vertex){
    this.vertices.deleteValue(vertex);
  }
  public Vertex getVertexWithVal(String val){
    for(Vertex v : this.vertices){
      if (v.getData() == val) {
        return v;
      }
    }
    return null;
  }
  public void print() {
    for(Vertex each : this.vertices){
      each.print(isGraphWeighted());
    }
  }
}
