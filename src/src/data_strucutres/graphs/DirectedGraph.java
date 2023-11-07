import java.util.ArrayList;

public class DirectedGraph {
    ArrayList<DirectedGraphNode> adjacencyList = new ArrayList<>();

        public void addNode(DirectedGraphNode n) {
            adjacencyList.add(n);
        }
}
