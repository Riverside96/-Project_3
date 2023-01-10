package graphalgos;
public class Edge {

  private Vertex from;
  public Vertex getFrom() {
    return from;
  }

  private Vertex to;
  public Vertex getTo() {
    return to;
  }

  private Integer weight;
  public Integer getWeight() {
    return weight;
  }

  public Edge(Vertex fromVertex, Vertex toVertex, Integer weight){
   if(weight < 0) throw new IllegalArgumentException
    ("Negative edge weights not permitted");
    this.from = fromVertex;
    this.to = toVertex;
    this.weight = weight;
  }
}
