package BuildOrder;

import java.util.ArrayList;
import java.util.HashMap;

public class ProjectNode {
    public String name;
    private ArrayList<ProjectNode> neighbours;
    private HashMap<String, ProjectNode> nameMapNode;
    private int dependencies = 0;

    public ProjectNode(String name) {
        this.name = name;
        this.neighbours = new ArrayList<ProjectNode>();
        this.nameMapNode = new HashMap<String, ProjectNode>();
    }

    public void addNeighbour(ProjectNode toNode) {
        if(!nameMapNode.containsKey(toNode.name)){
            nameMapNode.put(toNode.name, toNode);
            neighbours.add(toNode);
            toNode.incrementDependencies();
        }
    }

    public void incrementDependencies() {
        dependencies++;
    }

    public void decrementDependencies() {
        dependencies--;
    }

    public int getDependencies() {
        return dependencies;
    }

    public ArrayList<ProjectNode> getNeighbours() {
        return neighbours;
    }

    public HashMap<String, ProjectNode> getNameMapNode() {
        return nameMapNode;
    }
}
