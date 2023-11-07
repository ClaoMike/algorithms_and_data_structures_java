import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 

public class JSONFileReader {

    public JSONFileReader() throws Exception {
        Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));
        JSONObject jo = (JSONObject) obj;
    }
    
}
