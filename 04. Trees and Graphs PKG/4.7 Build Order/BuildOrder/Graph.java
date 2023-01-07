package BuildOrder;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private ArrayList<ProjectNode> nodes;
    private HashMap<String, ProjectNode> map;

    public Graph() {
        this.nodes = new ArrayList<ProjectNode>();
        this.map = new HashMap<String, ProjectNode>();
    }

    public ProjectNode addNode(String name) {
        if(!map.containsKey(name)) {
            ProjectNode newNode = new ProjectNode(name);
            map.put(name, newNode);
            nodes.add(newNode);
        }
        return map.get(name);
    }

    public void addEdge(String from, String to) {
        ProjectNode fromNode = addNode(from);
        ProjectNode toNode = addNode(to);

        fromNode.addNeighbour(toNode);
    }

    public ArrayList<ProjectNode> getNodes() {
        return nodes;
    }

    public HashMap<String, ProjectNode> getMap() {
        return map;
    }
}
