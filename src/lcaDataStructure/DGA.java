package lcaDataStructure;

import java.util.ArrayList;
import java.util.List;

public class DGA {
    private List<NodeDouble> roots;

    DGA(){
        roots = new ArrayList<>();
    }

    DGA(List<NodeDouble> roots){
        this.roots = new ArrayList<>(roots);
    }

    public List<NodeDouble> getRoots() {
        return new ArrayList<>(roots);
    }

    String output() {
        String res = "";
        for(NodeDouble nodeDouble: this.roots){
            res += dGAStruct(nodeDouble);
        }
        return res;
    }

    private String dGAStruct(Node node){
        String res = Integer.toString(node.getValue());
        List<Node> nodes = node.getSons();
        res += "(";
        for(Node node1 : nodes){
            res =res.concat(dGAStruct(node1));
        }
        res = res.concat(")");
        return res;
    }
}
