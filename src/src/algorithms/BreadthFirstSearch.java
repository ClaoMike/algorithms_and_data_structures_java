import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BreadthFirstSearch {
    final private HashMap<String, ArrayList<String>> graph;
    private Queue<String> queue;
    private HashSet<String> visited;
    private Queue<ArrayList<String>> pathQueue;
    private ArrayList<String> path;
    private ArrayList<ArrayList<String>> paths;
    
    public BreadthFirstSearch(HashMap<String, ArrayList<String>> graph) {
        this.graph = graph;
    }

    public boolean isThereAPathBetween(String source, String target) {
        initQueueAndVisited(source);

        while(!queue.isEmpty()){
            String v = queue.dequeue();
            
            if(equals(v, target))
                return true;

            processKidsOf(v, KidsProcessingMethodWhenRequestingPath.NO_PATH);

        }

        return false;
    }

    public ArrayList<String> getPathBetween(String source, String target) {
        initQueueVisitedPathQueueAndArray(source);

        while(!queue.isEmpty()){
            String v = queue.dequeue();
            path = pathQueue.dequeue();

            if(equals(v, target))
                return path;

            processKidsOf(v, KidsProcessingMethodWhenRequestingPath.ONE_PATH);

        }

        return null;
    }

    public ArrayList<ArrayList<String>> getAllPathsFrom(String source) {
        initQueueVisitedPathQueueAndArray(source);
        paths = new ArrayList<>();

        while(!queue.isEmpty()){
            String v = queue.dequeue();
            path = pathQueue.dequeue();

            processKidsOf(v, KidsProcessingMethodWhenRequestingPath.ALL_PATHS);

        }

        return paths;
    }

    private ArrayList<String> createNewPathWithTarget(String target) {
        ArrayList<String> newPath = new ArrayList<>(path);
        newPath.add(target);

        return newPath;
    }

    private void initQueueAndVisited(String source) {
        queue = new Queue<>();
        visited = new HashSet<>();

        queue.enqueue(source);
        visited.add(source);
    }

    private void initQueueVisitedPathQueueAndArray(String source) {
        cleanInternalVariables();
        initQueueAndVisited(source);
    
        pathQueue = new Queue<>();

        initPathArray(source);
    }

    private boolean equals(String str1, String str2) {
        return (Integer.toHexString(str1.hashCode()).equals(Integer.toHexString(str2.hashCode()))) ? true : false;
    }

    private void initPathArray(String source) {
        path = new ArrayList<>();
        path.add(source);
        pathQueue.enqueue(path);
    }

    private void visitAndEnqueueNode(String node) {
        visited.add(node);
        queue.enqueue(node);
    }

    enum KidsProcessingMethodWhenRequestingPath {
        NO_PATH,
        ONE_PATH,
        ALL_PATHS
    }

    private void processKidsOf(String v, KidsProcessingMethodWhenRequestingPath method) {
        graph.get(v).forEach((kid) -> {
                if(!visited.contains(kid)) {
                    visitAndEnqueueNode(kid);

                    if(method == KidsProcessingMethodWhenRequestingPath.ALL_PATHS || method == KidsProcessingMethodWhenRequestingPath.ONE_PATH) {
                        ArrayList<String> newPath = createNewPathWithTarget(kid);
                        pathQueue.enqueue(newPath);

                        if(method == KidsProcessingMethodWhenRequestingPath.ALL_PATHS) {
                            paths.add(newPath);
                        }
                    }

                }
            });
    }

    private void cleanInternalVariables() {
        queue = null;
        visited  = null;
        pathQueue = null;
        path = null;
        paths = null;
    }

}
