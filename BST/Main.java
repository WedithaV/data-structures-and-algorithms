package BST;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        System.out.println(tree.search(6));
        tree.insert(10);
        System.out.println(tree.search(5));
    }
}

class Node {
    int key;
    Node left;
    Node right;

    public Node(int data) {
        key = data;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data <= root.key) {
            root.left = insertRec(root.left, data);
        } else if (data > root.key) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public boolean search(int value) {
        if (searchRec(root, value) == null) {
            return false;
        } else {
            return true;
        }
    }

    private Node searchRec(Node tempNode, int value) {
        if (tempNode == null || tempNode.key == value) {
            return tempNode;
        }
        if (value < tempNode.key) {
            return searchRec(tempNode.left, value);
        } else if (value > tempNode.key) {
            return searchRec(tempNode.right, value);
        }
        return null;
    }
}
