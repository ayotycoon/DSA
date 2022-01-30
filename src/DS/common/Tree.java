package common;

import java.util.*;
import java.util.stream.Collectors;


public class Tree {
    private final TreeNode headNode;
    private final Map<Integer, List<TreeNode>> levelsMap = new LinkedHashMap<>();

    private int maxChildren = 0;
    private int maxHeight = 0;
    private int maxShadowWidth = 0;
    private String string;


    public Tree(TreeNode headNode) {
        this.headNode = headNode;
        this.maxChildren = widthBfs();
        this.maxHeight = heightDfs(this.headNode, 1);
        this.string = generateString();

        constructDfs(this.headNode, 1);

    }

    public Tree(BinaryTreeNode headNode) {
        this.headNode = headNode.toTreeNode();
    }


    private int heightDfs(TreeNode node, int level) {
        if (node == null) return 0;
        int max = level;
        if (node.children != null) {
            int i = 0;
            for (TreeNode child : node.children.values()) {
                max = Math.max(max, heightDfs(child, level + 1));
                i++;
            }

        }

        return max;
    }


    private void constructDfs(TreeNode node, int level) {
        if (node == null) return;

        List<TreeNode> levels = levelsMap.containsKey(level) ? levelsMap.get(level) : new ArrayList<>();
        levels.add(node);
        levelsMap.put(level, levels);
        maxShadowWidth = Math.max(maxShadowWidth, levels.size());
        if (node.children != null) {

            depthNullPrinter(maxChildren - node.children.size(), level + 1);
            for (TreeNode child : node.children.values()) {
                constructDfs(child, level + 1);
            }

        } else {

            depthNullPrinter(maxChildren, level + 1);
        }


    }


    private int widthBfs() {
        if (headNode == null) return 0;
        int max = 1;
        Queue<TreeNode> s = new LinkedList<>();
        s.add(this.headNode);


        while (!s.isEmpty()) {
            var ref = s.remove();


            if (ref.children != null) {
                max = Math.max(max, ref.children.size());
                for (TreeNode child : ref.children.values()) {
                    s.add(child);
                }

            }

        }


        return max;
    }

    private void depthNullPrinter(int num, int initialLevel) {
        if (num <= 0) return;
        int level = initialLevel;
        int localLevel = 0;
        int added = 0;
        while (level <= maxHeight) {
            List<TreeNode> levels = levelsMap.containsKey(level) ? levelsMap.get(level) : new ArrayList<>();

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

    private void spacePrinter(int num, StringBuilder sb) {

        while (num > 0) {
            sb.insert(0, " ");
            num--;
        }

    }

    public String generateString() {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> breadthPos = new LinkedHashMap<>();

        var allLevels = levelsMap.values().stream().collect(Collectors.toList());

        Collections.reverse(allLevels);
        boolean isMaxChildrenEven = maxChildren % 2 == 0;
        Set<Integer> set = new LinkedHashSet<>();
        int i = 0;
        for (List<TreeNode> levels : allLevels) {
            int nodeWithSpaceIndex = 0;
            for (int k = levels.size() - 1; k >= 0; k--) {
                boolean isNewChildrenSet = k + 1 % maxChildren == 0;
                boolean isMid = !isMaxChildrenEven && (k + 1 + (maxChildren / 2)) % maxChildren == 0;
                boolean isNextSpaceMid = isMaxChildrenEven && (k + 1 + (maxChildren / 2)) % maxChildren == 0;

                if (i == 0 && isMid) set.add(nodeWithSpaceIndex);
                if (i == 0 && isNextSpaceMid) set.add(nodeWithSpaceIndex + 1);

                TreeNode child = levels.get(k);

                //sb.insert( 0,isMid  ? "T" : "N");
                sb.insert(0, child == null ? "n" : child);
                sb.insert(0, " ");
                nodeWithSpaceIndex += 2;
            }
            sb.insert(0, "\n");

            if (i == 0) {
                System.out.println(set);
            }

            i++;
        }


        return sb.toString();
    }


    public String toString() {
return this.string;
    }
}

/*



                          2                                 28
        9                 7                6                8,17,
  n     n     n     n     n     8     n     n     n         2,5
n n n n n n n n n n n n n n n n n 3 n n n n n n n n n       0,1


  */