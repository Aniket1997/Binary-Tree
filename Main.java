import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class FullBinaryTree {
    Node root;

    public FullBinaryTree() {
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
    public boolean isFullBinaryTree(Node node) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return true;
        }

        if (node.left != null && node.right != null) {
            return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FullBinaryTree binaryTree = new FullBinaryTree();

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i+1) + ": ");
            int element = scanner.nextInt();
            binaryTree.insert(element);
        }
       
        if (binaryTree.isFullBinaryTree(binaryTree.root)) {
            System.out.println("The binary tree is a full binary tree");
        } else {
            System.out.println("The binary tree is not a full binary tree");
        }
    }
}
