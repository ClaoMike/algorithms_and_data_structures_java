import java.util.ArrayList;

public class DirectedGraphNode {
    String name;
        ArrayList<String> kids = new ArrayList<>();
        
        public DirectedGraphNode(String name, ArrayList<String> kids) {
            this.name = name;
            this.kids = kids;
        }
}
