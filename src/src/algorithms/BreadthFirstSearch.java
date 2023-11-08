import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BreadthFirstSearch {
    final private HashMap<String, ArrayList<String>> graph;
    Queue<String> queue = new Queue<>();
    HashSet<String> visited = new HashSet<>();
    
    public BreadthFirstSearch(HashMap<String, ArrayList<String>> graph) {
        this.graph = graph;
    }

    public boolean isThereAPathBetween(String source, String target) {
        Queue<String> queue = new Queue<>();
        HashSet<String> visited = new HashSet<>();

        queue.enqueue(source);
        visited.add(source);

        while(!queue.isEmpty()){
            String v = queue.dequeue();

            if(Integer.toHexString(v.hashCode()).equals(Integer.toHexString(target.hashCode())))
                return true;

            for(String kid: graph.get(v)) {
                if(!visited.contains(kid)) {
                    visited.add(kid);
                    queue.enqueue(kid);
                }
            }

        }

        return false;
    }

    public ArrayList<String> getPathBetween(String source, String target) {
        Queue<String> queue = new Queue<>();
        HashSet<String> visited = new HashSet<>();

        Queue<ArrayList<String>> pathQueue = new Queue<>();

        queue.enqueue(source);
        visited.add(source);

        ArrayList<String> path = new ArrayList<>();
        path.add(source);
        pathQueue.enqueue(path);

        while(!queue.isEmpty()){
            String v = queue.dequeue();
            path = pathQueue.dequeue();

            if(Integer.toHexString(v.hashCode()).equals(Integer.toHexString(target.hashCode()))) {
                return path;
            }
            

            for(String kid: graph.get(v)) {
                if(!visited.contains(kid)) {
                    visited.add(kid);
                    queue.enqueue(kid);

                    ArrayList<String> newPath = new ArrayList<>(path);
                    newPath.add(kid);
                    pathQueue.enqueue(newPath);
                }
            }

        }

        return null;
    }

    public ArrayList<ArrayList<String>> getAllPathsFrom(String source) {
        Queue<String> queue = new Queue<>();
        HashSet<String> visited = new HashSet<>();

        Queue<ArrayList<String>> pathQueue = new Queue<>();
        ArrayList<ArrayList<String>> paths = new ArrayList<>();

        queue.enqueue(source);
        visited.add(source);

        ArrayList<String> path = new ArrayList<>();
        path.add(source);
        pathQueue.enqueue(path);

        while(!queue.isEmpty()){
            String v = queue.dequeue();
            path = pathQueue.dequeue();

            for(String kid: graph.get(v)) {
                if(!visited.contains(kid)) {
                    visited.add(kid);
                    queue.enqueue(kid);

                    ArrayList<String> newPath = new ArrayList<>(path);
                    newPath.add(kid);
                    pathQueue.enqueue(newPath);
                    paths.add(newPath);
                }
            }

        }

        return paths;
    }

}
