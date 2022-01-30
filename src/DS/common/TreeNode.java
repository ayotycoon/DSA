package common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNode {
    public int val;
    public Map<Integer,TreeNode> children;
    public TreeNode(int val) {
        this.val = val;
    }
    public String toString(){
        if(this == null) return "-";
        return val+"";
    }

}
