
//////////////////////////////////////////////////////////////////////////////
// Depth-first Search recursive implementation pseudocode                   //
//////////////////////////////////////////////////////////////////////////////
// DFS(G, v)                                                                //
//     mark v as visited                                                    //
//                                                                          //
//     for all directed edges from v to w that are in G.adjacentEdges(v) do //
//         if vertex w is not marked as visited then                        //
//             recursively call DFS(G, w)                                   //
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
    
    public DepthFirstSearch(HashMap<String, ArrayList<String>> graph) {
        this.graph = graph;
    }

    private void execute(String source, String target) {
        visited.add(source);
 
        for (String kid : graph.get(source)) {
            if(!visited.contains(kid))
                execute(kid, target);
        }
    }

    public boolean isThereAPathBetween(String source, String target) {
        execute(source, target);

        if (visited.contains(target)) {
            return true;
        }

        return false;
    }

}
