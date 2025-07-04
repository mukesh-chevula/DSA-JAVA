import java.util.ArrayList;
import java.util.List;

public class GraphRepresentationUsingEdges {
    private int vertices;
    private List<int[]> edges;

    public GraphRepresentationUsingEdges(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int u, int v) {
        edges.add(new int[]{u, v});
    }

    public void printEdges() {
        System.out.println("Graph edges:");
        for (int[] edge : edges) {
            System.out.println(edge[0] + " -> " + edge[1]);
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        GraphRepresentationUsingEdges graph = new GraphRepresentationUsingEdges(vertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printEdges();
    }
}