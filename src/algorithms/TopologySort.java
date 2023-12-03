import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TopologySort {
    final private HashMap<String, ArrayList<String>> graph;
    
    private HashSet<String> visited = new HashSet<>();
    private ArrayList<String> topologicalSort = new ArrayList<>();

    public TopologySort(HashMap<String, ArrayList<String>> graph) {
        this.graph = graph;
    }

    public ArrayList<String> getTopologicalSort() {
        visited = new HashSet<>();
        topologicalSort = new ArrayList<>();

        for (Map.Entry<String, ArrayList<String>> entry : graph.entrySet()) {
            if(!visited.contains(entry.getKey())) {
                dfs(entry.getKey());
            }
        }

        Collections.reverse(topologicalSort);

        return topologicalSort;
    }

    private void dfs(String source) {
        visited.add(source);

        for (String kid : graph.get(source)) {
            if (!visited.contains(kid))
                dfs(kid);
        }

        topologicalSort.add(source);
    }
}
