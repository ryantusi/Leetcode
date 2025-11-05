=+// Node class representing each vertex in the graph
class Node {
    int value;
    List<Node> neighbors;

    Node(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    void addNeighbor(Node node) {
        neighbors.add(node);
    }
}

// BFS class encapsulating the BFS traversal logic
public class BFS {
    public void bfs(Node start) {
        if (start == null)
            return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            for (Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }
}

// Driver class to demonstrate the BFS functionality
class Main {
    public static void main(String[] args) {
        // Create nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        // Build graph connections (undirected for simplicity)
        node1.addNeighbor(node2);
        node1.addNeighbor(node3);
        node2.addNeighbor(node4);
        node3.addNeighbor(node5);

        // Perform BFS traversal
        BFS bfsTraversal = new BFS();
        bfsTraversal.bfs(node1);
    }
}
