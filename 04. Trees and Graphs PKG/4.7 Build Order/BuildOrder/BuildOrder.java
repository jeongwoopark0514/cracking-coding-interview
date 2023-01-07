package BuildOrder;

import java.util.ArrayList;

public class BuildOrder {
    public static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();

        // Create Nodes
        for(int i = 0; i < projects.length; i++) {
            graph.addNode(projects[i]);
        }

        // Add Edges based on the dependencies
        for(String[] dep : dependencies) {
            String from = dep[0];
            String to = dep[1];

            graph.addEdge(from, to);
        }
        return graph;
    }

    public static ProjectNode[] findOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        ArrayList<ProjectNode> nodes = graph.getNodes();

        ProjectNode[] order = new ProjectNode[nodes.size()];

        int index = addNonDependent(order, nodes, 0);
        int processNumber = 0;

        while(processNumber < order.length) {
            ProjectNode current = order[processNumber];

            // Circular dependency
            if(current == null) {
                return null;
            }

            ArrayList<ProjectNode> children = current.getNeighbours();
            for (ProjectNode child : children) {
                child.decrementDependencies();
            }

            // Add children that have no one depending on them
            index = addNonDependent(order, children, index);
            processNumber+=1;
        }

        return order;
    }

    public static String[] buildOrder(String[] projects, String[][] dependencies) {
        ProjectNode[] projectOrder = findOrder(projects, dependencies);

        String[] buildOrder = new String[projectOrder.length];
        for (int i = 0; i < projectOrder.length; i++) {
            buildOrder[i] = projectOrder[i].name;
        }
        return buildOrder;
    }

    public static int addNonDependent(ProjectNode[] order, ArrayList<ProjectNode> projects, int ind) {
        for(ProjectNode pro : projects) {
            if(pro.getDependencies() == 0) {
                order[ind] = pro;
                ind++;
            }
        }

        return ind;
    }


    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};
        String[] buildOrder = buildOrder(projects, dependencies);
        if (buildOrder == null) {
            System.out.println("Circular Dependency.");
        } else {
            for (String s : buildOrder) {
                System.out.println(s);
            }
        }
    }
}
