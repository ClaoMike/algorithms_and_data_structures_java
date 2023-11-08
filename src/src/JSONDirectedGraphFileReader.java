import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

public class JSONDirectedGraphFileReader {
    final String nodesAsString = "nodes";
    final String nodeAsString = "node";
    final String edgesAsString = "edges";

    HashMap<String, ArrayList<String>> graph = new HashMap<>();

    public JSONDirectedGraphFileReader(String JSONFilePath) throws Exception {
        Object theFullJSONFile = new JSONParser().parse(new FileReader(JSONFilePath)); 
        JSONObject theFullJSONFileAsAJSONObject = (JSONObject) theFullJSONFile;
        JSONArray nodesArray = (JSONArray) theFullJSONFileAsAJSONObject.get(nodesAsString);

        ArrayList<String> nodes = new ArrayList<>();
        ArrayList<ArrayList<String>> kidsForEachNode = new ArrayList<>();
        HashMap<String, String> node2nodeHashMap = new HashMap<>();

        for(Object o: nodesArray) {
            JSONObject entry = (JSONObject) o;  
            String node = (String) entry.get(nodeAsString);
            nodes.add(node);

            node2nodeHashMap.put(node, node);
        }

        for(Object o: nodesArray) {
            JSONObject entry = (JSONObject) o;  
            JSONArray edges = (JSONArray) entry.get(edgesAsString);
            ArrayList<String> kids = new ArrayList<>();

            for(Object e: edges) {
                JSONObject kidJSON = (JSONObject) e;
                String kid = (String) kidJSON.get(nodeAsString);

                kids.add(node2nodeHashMap.get(kid));
            }

            kidsForEachNode.add(kids);
        }

        for(int i=0; i<nodes.size(); i++) {
             graph.put(node2nodeHashMap.get(nodes.get(i)), kidsForEachNode.get(i));
        }

    }

    public void printGraph() {
        for (Map.Entry<String, ArrayList<String>> e : graph.entrySet()){
            System.out.println("--> Node: " + e.getKey() + " (" + Integer.toHexString(e.getKey().hashCode()) + ")");
            
            for(String s: e.getValue()){
                System.out.println("Kid: " + s + " (" + Integer.toHexString(s.hashCode()) + ")");
            }
        }   
    }

    public HashMap<String, ArrayList<String>> getGraph() {
        return graph;
    }
    
}
