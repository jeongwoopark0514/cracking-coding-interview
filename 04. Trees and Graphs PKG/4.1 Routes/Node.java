public class Node {
    private Node[] adjacent;
    public String vertex;
    public int ns;
    private int counter = 0;
    public Problem.State state;

    public Node(String vertex, int neighbours) {
        this.vertex = vertex;
        this.ns = neighbours;
        this.adjacent = new Node[this.ns];
        counter = 0;
    }

    public void addAdjacent(Node n) {
        if(this.counter < this.ns) {
            this.adjacent[this.counter] = n;
            this.counter += 1;
        } else {
            System.out.println("ERROR in adding Adjacent Nodes");
        }
    }

    public Node[] getAdjacent() {
        return adjacent;
    }

}