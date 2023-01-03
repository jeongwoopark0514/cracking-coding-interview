package Routes;

public class Graph {
    public static int MAX_VERTICES = 6;
    private Node nodes[];
    public int count;

    public Graph() {
        this.nodes = new Node[MAX_VERTICES];
        count = 0;
    }

    public void addNode(Node n) {
        if(count < MAX_VERTICES) {
            this.nodes[count] = n;
            count += 1;
        }
        else {
            System.out.println("Routes.Graph is full");
        }
    }

    public Node[] getNodes() {
        return nodes;
    }
}
