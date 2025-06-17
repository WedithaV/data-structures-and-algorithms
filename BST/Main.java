package BST;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(8);
        tree.insert(7);
        System.out.println(tree.search(8));
        tree.delete(8);
        System.out.println(tree.search(8));
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
        return null; // To avoid compiler warnings
    }

    public void delete(int value) {
        deleteNodeWithTwoChilds(root, value);
    }

    private Node deleteLeafNode(Node tempnode, int value) {
        if (tempnode == null) {
            return null;
        }
        if (value < tempnode.key) {
            tempnode.left = deleteLeafNode(tempnode.left, value);
        } else if (value > tempnode.key) {
            tempnode.right = deleteLeafNode(tempnode.right, value);
        } else if (value == tempnode.key) {
            tempnode = null;
        }
        return tempnode;
    }

    private Node deleteNodeWithOneChild(Node tempnode, int value) {
        if (tempnode == null) {
            return null;
        }
        if (value < tempnode.key) {
            tempnode.left = deleteNodeWithOneChild(tempnode.left, value);
        } else if (value > tempnode.key) {
            tempnode.right = deleteNodeWithOneChild(tempnode.right, value);
        } else if (value == tempnode.key) {
            if (tempnode.left == null) {
                return tempnode.right;
            } else if (tempnode.right == null) {
                return tempnode.left;
            }
        }
        return tempnode;
    }

    private Node deleteNodeWithTwoChilds(Node tempnode, int value) {
        if (tempnode == null) {
            return null;
        }
        if (value < tempnode.key) {
            tempnode.left = deleteNodeWithTwoChilds(tempnode.left, value);
        } else if (value > tempnode.key) {
            tempnode.right = deleteNodeWithTwoChilds(tempnode.right, value);
        } else if (value == tempnode.key) {
            Node successor = findSuccessor(tempnode.right);
            tempnode.key = successor.key;
            tempnode.right = deleteNodeWithTwoChilds(tempnode.right, successor.key);
        }
        return tempnode;
    }

    public Node findSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
