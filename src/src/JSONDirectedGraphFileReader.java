import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 

public class JSONDirectedGraphFileReader {

    public JSONDirectedGraphFileReader(String JSONFilePath) throws Exception {
        Object theFullJSONFile = new JSONParser().parse(new FileReader(JSONFilePath)); 
          
        JSONObject theFullJSONFileAsAJSONObject = (JSONObject) theFullJSONFile;

        JSONArray nodesArray = (JSONArray) theFullJSONFileAsAJSONObject.get("nodes");
        System.out.println(nodesArray.get(0));
        
        JSONObject entry1 = (JSONObject) nodesArray.get(0);
        String parentNode1Value = (String) entry1.get("node");
        System.out.println(parentNode1Value);

        JSONArray edgesArray = (JSONArray) entry1.get("edges");

        JSONObject node1 = (JSONObject) edgesArray.get(0);
        String edge1 = (String) node1.get("node");
        System.out.println(edge1);

        JSONObject node2 = (JSONObject) edgesArray.get(1);
        String edge2 = (String) node2.get("node");
        System.out.println(edge2);
        // System.out.println(edgesArray.get(0));
        

        // Iterator itr2 = nodesArray.iterator(); 
          
        // while (itr2.hasNext())  
        // { 
        //     Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator(); 
        //     while (itr1.hasNext()) { 
        //         Map.Entry pair = itr1.next(); 
        //         System.out.println(pair.getKey() + " : " + pair.getValue());

        //         JSONParser parser = new JSONParser();  
        //         JSONObject json = (JSONObject) parser.parse(pair.getValue());  
        //     } 
        // } 
    
    }
    
}
