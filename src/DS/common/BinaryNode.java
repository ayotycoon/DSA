package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryNode {
    public int val;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(int val) {
        this.val = val;
    }

    public Node toNode() {
        Node n = new Node(this.val);
        dfs(this, n);

        return n;

    }
    public String toString(){
        return val+"";
    }
    private void dfs(BinaryNode bTree, Node nTree) {
        List<Node> hash = new ArrayList<>();
        Node left =bTree.left == null ? null : new Node(bTree.left.val);
        Node right =bTree.right == null ? null : new Node(bTree.right.val);
        if(left != null)hash.add(left);
        if(right != null)hash.add(right);
        nTree.children = hash;

        if(left != null){
            dfs(bTree.left, left);
        }
        if(right != null){
            dfs(bTree.right, right);
        }

    }


}
