package common;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    public TreeNode toTreeNode() {
        TreeNode n = new TreeNode(this.val);
        dfs(this, n);

        return n;

    }
    public String toString(){
        return val+"";
    }
    private void dfs(BinaryTreeNode bTree, TreeNode nTree) {
        Map<Integer, TreeNode> hash = new HashMap<>();
        TreeNode left =bTree.left == null ? null : new TreeNode(bTree.left.val);
        TreeNode right =bTree.right == null ? null : new TreeNode(bTree.right.val);
        if(left != null)hash.put(left.val,left);
        if(right != null)hash.put(right.val,right);
        nTree.children = hash;

        if(left != null){
            dfs(bTree.left, left);
        }
        if(right != null){
            dfs(bTree.right, right);
        }

    }


}
