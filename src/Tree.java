import java.util.List;

public class Tree {
    private Node root = null;

    Tree(Node node){
        root = node;
    }

    boolean isEmpty() {
        return root == null;
    }

    boolean isLeaf() {
        try {
            return !root.hasSon();
        } catch(NullPointerException e) {
            System.out.println("Tree must not be empty");
            throw new NullPointerException();
        }
    }

    String output() {
        return treeStruct(this.root);
    }

    private String treeStruct(Node node){
        List<Node> nodes = node.getSons();
        if(nodes.size() == 0) return "()";
        String res = "(";
        for(Node node1 : nodes){
            res = res.concat(Integer.toString(node1.getValue()));
            res = res.concat("-");
        }
        res = res.concat(")");
        for(Node node1 : nodes){
            res =res.concat(treeStruct(node1));
        }
        return res;
    }

}
