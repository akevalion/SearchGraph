
import java.util.*;

public class Graph {
    Set<Node> nodes = new HashSet<>();
    ArrayList<Path2> paths = new ArrayList<>();

    public void add(Node newNode){
        nodes.add(newNode);
    }
    public void addLink(String i1, String i2, String word) {
        Node n1 = this.getOrCreate(i1);
        Node n2 = this.getOrCreate(i2);
        n1.addDestination(n2, word);
        n2.addDestination(n1, word);
    }
    private Node getOrCreate(String id) {
        Node n = null;
        for(Node node: nodes){
            if(node.data.equals(id)){
                n = node;
                break;
            }
        }
        if(n == null){
            n = new Node(id);
            nodes.add(n);
        }
        return n;
    }
    
    public String shortestPath(String origin, String dest) {
        return this.shortestPath(this.getOrCreate(origin), this.getOrCreate(dest));
    }
    
    public String shortestPath(Node origin, Node dest) {
        
        Set<Node> visited = new HashSet<>();
        shortestPath(origin, dest, new Path2(), visited);
        if(paths.isEmpty())
            return "impossivel";
        Path2 min = paths.get(0);

        for(Path2 path: paths){
            if(path.size() < min.size())
                min = path;
        }
        return min.size()+"";
    }

    private void shortestPath(Node current, Node dest, Path2 path, Set<Node> visited) {
        if(visited.contains(current)) return;
        if(!path.isValid()) return;
        if(current == dest){
            paths.add(path);
            return;
        }
        visited.add(current);
        for (Link link: current.adjacentNodes){
            Path2 newPath = new Path2(path.words);
            newPath.add(link.word);
            this.shortestPath(link.toNode, dest, newPath, new HashSet<>(visited) );
        }
    }
}
