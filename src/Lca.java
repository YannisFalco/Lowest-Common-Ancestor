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
        if(node.getValue() == node1 || node.getValue() == node2) return node;
        int countTrue = 0;
        Node tmp = null;
        for(Node nodeM : nodeSon){
            Node res = recursiveLCAFromValue(nodeM, node1, node2);
            if(res != null){
                tmp = res;
                countTrue++;
            }
            if(countTrue>=2) return node;
        }
        if(countTrue == 1){
            if(tmp.getValue() != node1 && tmp.getValue() != node2) return tmp;
            if(tmp.getValue() == node1 || tmp.getValue() == node2) return node;
        }
        return null;
    }
}
