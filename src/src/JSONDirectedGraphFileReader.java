import java.io.FileReader;
import java.util.ArrayList;
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

public class JSONDirectedGraphFileReader {
    final String nodesAsString = "nodes";
    final String nodeAsString = "node";
    final String edgesAsString = "edges";

    DirectedGraph g;

    public JSONDirectedGraphFileReader(String JSONFilePath) throws Exception {
        g = new DirectedGraph();

        Object theFullJSONFile = new JSONParser().parse(new FileReader(JSONFilePath)); 
        JSONObject theFullJSONFileAsAJSONObject = (JSONObject) theFullJSONFile;
        JSONArray nodesArray = (JSONArray) theFullJSONFileAsAJSONObject.get(nodesAsString);

        for(Object o: nodesArray) {
            JSONObject entry = (JSONObject) o;  
            String node = (String) entry.get(nodeAsString);
            
            System.out.println("--> " + node);

            JSONArray edges = (JSONArray) entry.get(edgesAsString);
            ArrayList<String> kids = new ArrayList<>();

            for(Object e: edges) {
                JSONObject kidJSON = (JSONObject) e;
                String kid = (String) kidJSON.get(nodeAsString);
            
                System.out.println(kid);
                kids.add(kid);
            }

            DirectedGraphNode n = new DirectedGraphNode(node, kids);
            g.addNode(n);
        }
    }

    public DirectedGraph getGraph() {
            return g;
        }
    
}
