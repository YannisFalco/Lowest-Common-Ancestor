import java.util.ArrayList;
import java.util.List;

public class Lca {
    Tree tree;

    Lca(Tree tree){
        this.tree = tree;
    }



    Node getLCAFromValue(int node1, int node2){
        Node root = tree.getRoot();
        if(root.getValue() == node1 || root.getValue() == node2) return root;
        return recursiveLCAFromValue(root, node1, node2);
    }

    Node recursiveLCAFromValue(Node node, int node1, int node2){
        List<Node> nodeSon = new ArrayList<>(node.getSons());
        int countTrue = 0;
        if(node.getValue() == node1 || node.getValue() == node2) return node;
        for(Node nodeM : nodeSon){
            Node res = recursiveLCAFromValue(nodeM, node1, node2);
            if(res != null){
                countTrue++;
                if(res.getValue() != node1 && res.getValue() != node2) return node;
            }
            if(countTrue>2) return node;
        }
        return null;
    }
}
