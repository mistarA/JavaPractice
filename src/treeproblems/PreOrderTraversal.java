package treeproblems;

/**
 * Created by anandmishra on 03/10/17.
 */

/* you only have to complete the function given below.
Node is defined as  */

class Node {
    int data;
    Node left;
    Node right;
}


public class PreOrderTraversal {

    

    void preOrder(Node root) {
       if (root == null)
           return;
       visit(root);
       preOrder(root.left);
       preOrder(root.right);
    }

    private void visit(Node value) {
        System.out.print(value.data);
    }
}


