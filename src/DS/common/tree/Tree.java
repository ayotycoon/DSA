package common.tree;

import common.BinaryNode;
import common.Node;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ayotycoon
 * @
 */
public class Tree {
    /**
     * Stores the tree head node
     */

    private  Node headNode;
    /**
     * Maps the tree's depth to each of the node levels
     */
    private final Map<Integer, List<Node>> levelsMap = new LinkedHashMap<>();

    private int maxChildren = 1;
    private int maxDepth = 1;
    private int maxShadowWidth = 1;
    private String string;
    TreeConfig config = new TreeConfig();


    public Tree(Node headNode) {
        this.init(headNode);

    }
    public Tree(Node headNode, TreeConfig config) {
        this.config = config;
        this.init(headNode);

    }

    public Tree(BinaryNode headNode) {
        this.init(headNode.toNode());
    }

    private void init(Node headNode) {
        this.headNode = headNode;
        getMaxDepthAndMaxChildrenDfs(this.headNode, 1);


        constructTreeStructureDfs(this.headNode, 1);
        this.string = generateString();

    }

    private int getMaxDepthAndMaxChildrenDfs(Node node, int level) {
        if (node == null) return 0;
        int max = level;
        if (node.children != null) {
            this.maxChildren = Math.max(this.maxChildren, node.children.size());
            for (Node child : node.children) {
                max = Math.max(max, getMaxDepthAndMaxChildrenDfs(child, level + 1));

            }

        }
        if (level == 1) this.maxDepth = max;

        return max;
    }


    private void constructTreeStructureDfs(Node node, int level) {
        if (node == null) return;

        List<Node> levels = levelsMap.containsKey(level) ? levelsMap.get(level) : new ArrayList<>();
        levels.add(node);
        levelsMap.put(level, levels);
        maxShadowWidth = Math.max(maxShadowWidth, levels.size());
        if (node.children != null) {

            depthNullPrinter(maxChildren - node.children.size(), level + 1);
            for (Node child : node.children) {
                constructTreeStructureDfs(child, level + 1);
            }

        } else {

            depthNullPrinter(maxChildren, level + 1);
        }


    }


    private void depthNullPrinter(int num, int initialLevel) {
        if (num <= 0) return;
        int level = initialLevel;
        int localLevel = 0;
        int added = 0;
        while (level <= maxDepth) {
            List<Node> levels = levelsMap.containsKey(level) ? levelsMap.get(level) : new ArrayList<>();

            double computeCount = num * Math.pow(maxChildren, localLevel);

            for (int currWidth = 0; currWidth < computeCount; currWidth++) {
                levels.add(null);
                added++;
            }
            levelsMap.put(level, levels);
            level++;
            localLevel++;
        }

    }


    public String generateString() {
        StringBuilder sb = new StringBuilder();
        var allLevels = levelsMap.values().stream().collect(Collectors.toList());
        Collections.reverse(allLevels);
        boolean isMaxChildrenEven = maxChildren % 2 == 0;
        int maxNodeWithSpace = 0;
        Map<Integer, LinkedList<Integer>> levelsIndexMap = new LinkedHashMap<>();

        for (int i =0; i < 1;i++) {
            LinkedList<Integer> queue = new LinkedList<Integer>();
            List<Node> levels = allLevels.get(i);
            for (int k = levels.size() - 1; k >= 0; k--) {
                boolean isNewChildrenSet = (k  % maxChildren) == 0;
                boolean isMid = !isMaxChildrenEven && (k + 1 + (maxChildren / 2)) % maxChildren == 0;
                boolean isNextSpaceMid = isMaxChildrenEven && (k + 1 + (maxChildren / 2)) % maxChildren == 0;



                if (isMid) queue.add(maxNodeWithSpace);
                if ( isNextSpaceMid) queue.add(maxNodeWithSpace);

                Node child = levels.get(k);

                //sb.insert( 0,isMid  ? "T" : "N");
                sb.insert(0, child == null ? this.config.getNullChar() : child);

                if(isNewChildrenSet && k != 0){
                    sb.insert(0, " ");
                    maxNodeWithSpace++;
                }

                if(k != 0 ) {
                    maxNodeWithSpace++;

                    if(maxChildren %2 == 0) {
                        maxNodeWithSpace++;
                        sb.insert(0, " ");
                    }
                }

            }
            sb.insert(0, "\n");

            levelsIndexMap.put(i, queue);
            // System.out.println(set);
            // System.out.println(nodeWithSpaceIndex);

        }

System.out.println("maxNodeWithSpace "+ maxNodeWithSpace);


        for (int i =1; i < allLevels.size();i++) {
            List<Node> levels = allLevels.get(i);
            int k = levels.size()-1;
            int j =maxNodeWithSpace;
            LinkedList<Integer> prevMid = levelsIndexMap.get(i-1);
            System.out.println(prevMid);
            Integer ind = prevMid.removeLast();
            LinkedList<Integer> queue = new LinkedList<Integer>();
            while (j >= 0 && k >=0) {
                // Add extra spaces to the end of the line, so it can align appropriately
                while(j > ind){
                    sb.insert(0," ");
                    j--;
                }
                boolean isMid = !isMaxChildrenEven && (k + 1 + (maxChildren / 2)) % maxChildren == 0;
                boolean isNextSpaceMid = isMaxChildrenEven && (k + 1 + (maxChildren / 2)) % maxChildren == 0;



                if (isMid) queue.add(0,j);
                if ( isNextSpaceMid) queue.add(0,j + 1);

                Node child = levels.get(k);

                //sb.insert( 0,isMid  ? "T" : "N");
                sb.insert(0, child == null ? this.config.getNullChar() : child);

                // Add extra spaces to the beginning of the line and between nodes, so it can align appropriately
                if(k == 0){
                    while(j > 0){
                        sb.insert(0," ");
                        j--;
                    }
                }

                j--;
                k--;
                if(!prevMid.isEmpty()){
                    ind = prevMid.removeLast();
                }

            }

            sb.insert(0, "\n");
            // add the Linked list to the hash map to the next level can use it
            levelsIndexMap.put(i, queue);

            // System.out.println(set);
            // System.out.println(nodeWithSpaceIndex);

        }




        return sb.toString();
    }


    public String toString() {
        return this.string;
    }
    public static Tree fromTextBlocks(String str) {
        return null;
    }
}

/*
max child = 3
depth = 4

                              2                                 30 0
         9                    7                    6            9 20
  n      n      n      n      n      8      n      n      n     2 6
n n n  n n n  n n n  n n n  n n n  n n 3  n n n  n n n  n n n   0 1


  */