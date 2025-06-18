package BST;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree obj = new BinarySearchTree();
        obj.insert(45);
        obj.insert(90);
        obj.insert(6);

        System.out.println(obj.search(78));
        System.out.println(obj.search(90));

        System.out.println("Pre Order Traversal");
        obj.preOrder();
        obj.delete(6);
        System.out.println();
        System.out.println("Post Order Traversal");

        obj.postOrder();
        System.out.println();
        System.out.println("In Order Traversal");

        obj.inOrder();
        System.out.println();
        System.out.println("Level Order Traversal");

        obj.levelOrder(obj.root);
    }
}

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int key) {
        this.key = key;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // Insertion
    public void insert(int key) {
        root = insertRec(root, key);
    }

    public TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (root.key > key) {
            root.left = insertRec(root.left, key);
        } else if (root.key < key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // Search
    public boolean search(int key) {
        if (searchRec(root, key) != null) {
            return true;
        } else {
            return false;
        }
    }

    public TreeNode searchRec(TreeNode root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (root.key > key) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }

    // Deletion

    // Delete A leaf node
    public void deleteLeafNode(int key) {
        root = deleteLeafNodeRec(root, key);
    }

    public TreeNode deleteLeafNodeRec(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key > key) {
            root.left = deleteLeafNodeRec(root.left, key);
        } else if (root.key < key) {
            root.right = deleteLeafNodeRec(root.right, key);
        } else {
            if (root.right == null && root.left == null) {
                return null;
            } else {
                return root;
            }
        }
        return root;
    }

    // Delete node with one child
    public void deleteNodeWithOneChild(int key) {
        root = deleteNodeWithOneChildRec(root, key);
    }

    public TreeNode deleteNodeWithOneChildRec(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key > key) {
            root.left = deleteNodeWithOneChildRec(root.left, key);
        } else if (root.key < key) {
            root.right = deleteNodeWithOneChildRec(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
        }
        return root;
    }

    // Delete Node with two Children
    public void deleteNodeWithTwoChildren(int key) {
        root = deleteNodeWithTwoChildrenRec(root, key);
    }

    public TreeNode deleteNodeWithTwoChildrenRec(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key > key) {
            root.left = deleteNodeWithTwoChildrenRec(root.left, key);
        } else if (root.key < key) {
            root.right = deleteNodeWithTwoChildrenRec(root.right, key);
        } else {
            TreeNode temp = findSuccessor(root.right);
            root.key = temp.key;
            root.right = deleteNodeWithTwoChildrenRec(root.right, temp.key);
        }
        return root;
    }

    // All Delete methods in one function
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    public TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key > key) {
            root.left = deleteRec(root.left, key);
        } else if (root.key < key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.right == null && root.left == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode node = findPredeccessor(root.left);
            root.key = node.key;
            root.left = deleteRec(root.left, node.key);
        }
        return root;
    }

    // Find Successor
    public TreeNode findSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Find predeccessor
    public TreeNode findPredeccessor(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    // Traversal

    // Pre order Traversal
    public void preOrder() {
        preOrderRec(root);
    }

    public void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // In order Traversal
    public void inOrder() {
        inOrderRec(root);
    }

    public void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    // Post order Traversal
    public void postOrder() {
        postOrderRec(root);
    }

    public void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Breadth First search

    // Level Order traversal
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.key + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}