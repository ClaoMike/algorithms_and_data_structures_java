
//////////////////////////////////////////////////////////////////////////////
// Depth-first Search iterative implementation pseudocode                   //
//////////////////////////////////////////////////////////////////////////////
// DFS_iterative(G, v)                                                      //
//     let S be a stack                                                     //
//     S.push(v)                                                            //
//                                                                          //
//     while S is not empty do                                              //
//         v = S.pop()                                                      //
//                                                                          //
//         if v is not labeled as discovered then                           //
//             label v as discovered                                        //
//                                                                          //
//             for all edges from v to w in G.adjacentEdges(v) do           //
//                 S.push(w)                                                //
//////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DepthFirstSearch {
    final private HashMap<String, ArrayList<String>> graph;
    
    private HashSet<String> visited = new HashSet<>();
    private Stack<String> stack = new Stack<>();
    
    public DepthFirstSearch(HashMap<String, ArrayList<String>> graph) {
        this.graph = graph;
    }

    public boolean isThereAPathBetween(String source, String target) {
        stack = new Stack<>();
        visited = new HashSet<>();

        stack.push(source);

        while (!stack.isEmpty()) {
            String v = stack.pop();
            
            System.out.println("--------------------------------------");
            System.out.println("->> Node removed from stack: " + v);

            if(equals(v, target))
                return true;

            if(!visited.contains(v)){
                visited.add(v);

                System.out.print("->> Kids that are being added to the stack: ");
                
                graph.get(v).forEach((kid) -> {
                    stack.push(kid);

                    System.out.print(kid + " ");
                
                });

                System.out.println();
                System.out.println("Current stack: " + stack.asArrayList());
                System.out.println("--------------------------------------");
            }
        }

        return false;
    }

    public ArrayList<String> getShortestPathBetween(String source, String target) {
        ArrayList<String> path = new ArrayList<>();
        ArrayList<ArrayList<String>> paths = new ArrayList<>();
        HashMap<String, ArrayList<String>> visitedEdges = copyGraph(graph);

        stack = new Stack<>();
        visited = new HashSet<>();

        stack.push(source);

        while (!stack.isEmpty()) {
            String v = stack.pop();
            path.add(v);

            if(!v.equals(source)) {
                visitedEdges.get(path.get(path.size()-2)).add(v);
            }

            if(equals(v, target)) {
                ArrayList<String> newPath = new ArrayList<>(path);
                paths.add(newPath);

                String last = v;
                do {
                    path.remove(last);
                    last = path.get(path.size()-1);
                }while(!graph.get(last).contains(stack.top()) || (graph.get(last).contains(stack.top()) && visitedEdges.get(last).contains(stack.top())) );

                continue;
            }
            
            if(!visited.contains(v)){
                visited.add(v);
                
                graph.get(v).forEach((kid) -> {
                    stack.push(kid);            
                });
            }
        }

        int shortesPathIndex = 0;
        int shortestPathSize = paths.get(shortesPathIndex).size();
        for(int i=0; i< paths.size(); i++){
            if(paths.get(i).size() < shortestPathSize) {
                shortestPathSize = paths.get(i).size();
                shortesPathIndex = i;
            }
        }

        return paths.get(shortesPathIndex);
            
    }

    private HashMap<String, ArrayList<String>> copyGraph(HashMap<String, ArrayList<String>> g) {
        HashMap<String, ArrayList<String>> newG = new HashMap<>();

        for (var entry : g.entrySet()) {
            newG.put(entry.getKey(), new ArrayList<String>());

        }

        return newG;
        
    }

    private boolean equals(String str1, String str2) {
        return (Integer.toHexString(str1.hashCode()).equals(Integer.toHexString(str2.hashCode()))) ? true : false;
    }

}
