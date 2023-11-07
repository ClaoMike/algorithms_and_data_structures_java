import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 

public class JSONFileReader {

    public JSONFileReader(String JSONFilePath) throws Exception {
        Object obj = new JSONParser().parse(new FileReader(JSONFilePath));
        JSONObject jo = (JSONObject) obj;
        JSONArray ja = (JSONArray) jo.get("nodes"); 
    }
    
}
