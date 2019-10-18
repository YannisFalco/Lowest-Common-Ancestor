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

    void computeDepth(){
        for(int i =0; i<this.roots.size(); i++){
            NodeDouble nodeDouble = this.roots.get(i);
            nodeDouble.setDepth(0);
            recursiveDepth(nodeDouble, 0);
        }
    }

    private void recursiveDepth(NodeDouble node, int depth){
        List<NodeDouble> nodes = node.getSons();
        for(NodeDouble node1 : nodes){
            if(node.getDepth() < (depth+1)){
                node.setDepth(depth+1);
            }
        }


    }

    String output() {
        String res = "";
        for(NodeDouble nodeDouble: this.roots){
            res += dGAStruct(nodeDouble);
        }
        return res;
    }

    private String dGAStruct(NodeDouble node){
        String res = Integer.toString(node.getValue());
        List<NodeDouble> nodes = node.getSons();
        res += "(";
        for(NodeDouble node1 : nodes){
            res =res.concat(dGAStruct(node1));
        }
        res = res.concat(")");
        return res;
    }
}
