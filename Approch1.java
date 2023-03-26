
import java.util.LinkedList;
import java.util.Queue;
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
    public Node insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return newNode;
        }

        Node currentNode = root;
        while (currentNode != null) {
            if (data < currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    return currentNode;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    return currentNode;
                }
                currentNode = currentNode.right;
            }
        }
        return currentNode;
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

    
    public static void InOrder(Node root) {
        if (root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }
    
    
public static void PreOrder(Node root)
{
    if(root == null)
    {
        return;
    }
    System.out.println(root.data+" ");
    PreOrder(root.left);
    PreOrder(root.right);
}
public static void PostOrder(Node root)
{
    if(root == null)
    {
        return;
    }
    PostOrder(root.left);
    PostOrder(root.right);
    System.out.println(root.data+" ");
    
    
}

public static void LevelOrder(Node root)
{
    
Queue<Node> q = new LinkedList<>() ;
    q.add(root);
    q.add(null);

    while(!q.isEmpty())
    {
        Node currentNode = q.remove();
        if(currentNode == null)
        {
           System.out.println();
           if(q.isEmpty())
           {
             break;
           }
           else{
             q.add(null);
           }
        }else{
           System.out.println(currentNode.data+" ");
           if(currentNode.left != null)
           {
               q.add(currentNode.left);
           }
           else
           {
               q.add(currentNode.right);
           }
        }
    }
    }
    
public static int HeightOfBinaryTree(Node root)
{
    if(root == null)
    {
        return 0;
    }
    else{
        return 1+Math.max(HeightOfBinaryTree(root.left),HeightOfBinaryTree(root.right));
    }
}

public static int Diameter(Node root)
{
    if(root == null)
    {
        return 0;
    }
    int diam1 = Diameter(root.left);
    int diam2 = Diameter(root.right);
    int diam3 = HeightOfBinaryTree(root.left)+HeightOfBinaryTree(root.right)+1;
    return Math.max(diam3,Math.max(diam1,diam2));
    
}

public class Approch1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FullBinaryTree binaryTree = new FullBinaryTree();

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i+1) + ": ");
            int element = scanner.nextInt();
            Node root = binaryTree.insert(element);
        }
        // System.out.println("Pre-order traversal of the binary tree: ");
        // PreOrder(binaryTree.root);
        // System.out.println("Post-order traversal of the binary tree: ");
        // PostOrder(binaryTree.root);
        // // System.out.println("In-order traversal of the binary tree: ");
        // // InOrder(binaryTree.root);
        // if (binaryTree.isFullBinaryTree(binaryTree.root)) {
        //     System.out.println("The binary tree is a full binary tree");
        // } else {
        //     System.out.println("The binary tree is not a full binary tree");
        // }

        // System.out.println("Level Order Traversal:");
        // LevelOrder(binaryTree.root);
        System.out.print("Diameter of Binary tree : "+Diameter(binaryTree.root));
        ;
    }
}
}
