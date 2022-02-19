package common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Node {
    public int val;
    public List<Node> children;
    public Node(int val) {
        this.val = val;
    }
    public String toString(){
        if(this == null) return "-";
        return val+"";
    }
    public Node addChild(Node child){
        if(children == null){
            children = new ArrayList<>();
        }
        children.add(child);
        return this;
    }

    public Node addChildren(Node... child){
        if(children == null){
      children = new ArrayList<>();
        }
        for(Node n: child) children.add(n);
        return this;
    }

}
