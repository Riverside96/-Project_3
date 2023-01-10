package graphalgos;
public class PQObj implements Comparable<PQObj> {
    public Vertex vertex;
    public int priority;

    public PQObj(Vertex v, int p){
        this.vertex = v;
        this.priority = p;
    }

    @Override
    public int compareTo(PQObj o) {
        if (this.priority == o.priority){
            return 0;
        }
        else if (this.priority > o.priority){
            return 1;
        }
        else {
            return -1;
        }
    }
}
