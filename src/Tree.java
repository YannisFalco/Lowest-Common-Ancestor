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

}
