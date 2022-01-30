import common.Tree;
import common.TreeNode;

import java.util.LinkedHashMap;

public class Test {

    public static void main(String[] args){

        var n = new TreeNode(2);
        var left =  new TreeNode(9);
        var right = new TreeNode(7);
        var rightRight = new TreeNode(8);
        var rightRightRight = new TreeNode(3);

        rightRight.children = new LinkedHashMap<>();
        rightRight.children.put(rightRightRight.val,rightRightRight);

        right.children = new LinkedHashMap<>();
        right.children.put(rightRight.val,rightRight);

        n.children = new LinkedHashMap<>();
        n.children.put(left.val,left);
        n.children.put(right.val, right);
       n.children.put(6, new TreeNode(6));

        var tree = new Tree(n);
        System.out.println(tree);

    }
}
