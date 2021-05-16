import java.util.*;

public class Node {
    String data;
    ArrayList<Link> adjacentNodes = new ArrayList<>();
    
    public Node(String data){
        this.data = data;
    }
    public void addDestination(Node destination, String word){
        adjacentNodes.add(new Link(destination, word));
    }
    
}
