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
        String res = Integer.toString(node.getValue());
        List<Node> nodes = node.getSons();
        res += "(";
        for(Node node1 : nodes){
            res =res.concat(treeStruct(node1));
        }
        res = res.concat(")");
        return res;
    }

}
