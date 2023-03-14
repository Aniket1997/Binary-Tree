import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Method to insert a new node in the binary tree
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Node currentNode = root;
        while (currentNode != null) {
            if (data < currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    return;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    return;
                }
                currentNode = currentNode.right;
            }
        }
    }

    // Method to check if the binary tree is full
    public boolean isDegeneratedBinaryTree(Node node) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right != null) {
            return true;
        }
        if (node.left != null && node.right == null) {
            return true;
        }

        if (node.left == null || node.right != null) {
            return isDegeneratedBinaryTree(node.left) && isDegeneratedBinaryTree(node.right);
        }
        if (node.left != null || node.right == null) {
            return isDegeneratedBinaryTree(node.left) && isDegeneratedBinaryTree(node.right);
        }

        return false;
    }
}

public class ProofDegeberatedBinaryTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BinaryTree binaryTree = new BinaryTree();

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i+1) + ": ");
            int element = scanner.nextInt();
            binaryTree.insert(element);
        }
       
        if (binaryTree.isDegeneratedBinaryTree(binaryTree.root)) {
            System.out.println("The binary tree is a Degenerated binary tree");
        } else {
            System.out.println("The binary tree is not a Degenerated binary tree");
        }
    }
}
