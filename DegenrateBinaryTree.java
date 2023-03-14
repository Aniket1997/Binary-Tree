import java.util.Scanner;

class DegenerateBinaryTree {
    
    private Node root;
    
    private class Node {
        int data;
        Node child;
        
        public Node(int data) {
            this.data = data;
            this.child = null;
        }
    }
    
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (current.child != null) {
                current = current.child;
            }
            current.child = newNode;
        }
    }
    
    public void traverse() {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.child;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DegenerateBinaryTree tree = new DegenerateBinaryTree();
        System.out.print("Enter node value (or -1 to exit): ");
        int data = scanner.nextInt();
        while (data != -1) {
            tree.addNode(data);
            System.out.print("Enter node value (or -1 to exit): ");
            data = scanner.nextInt();
        }
        tree.traverse();
    }
}
