import common.tree.Tree;
import common.Node;
import common.tree.TreeConfig;

public class Test {


    public static void main(String[] args){

  var t = Tree.fromTextBlocks(
          """
                 2
              9           7                 6
   n     n     n     n     n     8     n     n   
nnnn nn nn nn nn nn nn nn nn nn 3n nn nn nn nn

  
"""
  );


        var root = new Node(2);
        var one =  new Node(9);
        var two = new Node(7).addChildren(new Node(8).addChild(new Node(3)), new Node(7));
        var three = new Node(0).addChild(new Node(5));




        root.addChildren(one,two,three);


        var tree = new Tree(root, new TreeConfig('.'));
        System.out.println(tree);

    }

}
