package BST;

public class Test {
    public void lowestCommonAncesstor(int key1, int key2){
        Node node = searchRec(key1);
        if(node == null){
            System.out.println("not exits");
            return;
        }
        node = searchRec(key2);
        if(node == null){
            System.out.println("not exits");
            return;
        }
        node = lowestCommonAncesstorRec(root, key1, key2);
        System.out.println(node.key);
    }
    private Node lowestCommonAncesstorRec(Node node, int key1, int key2){
        if(key1 < node.key && key2 < node.key){
            return lowestCommonAncesstorRec(node.left, key1, key2);
        }
        else if(key1 > node.key && key2 > node.key){
            return lowestCommonAncesstorRec(node.right, key1,key2);
        }
        else{
            return node;
        }
    }
}


