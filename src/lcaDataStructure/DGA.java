package lcaDataStructure;

import java.util.ArrayList;
import java.util.List;

public class DGA {
    private List<NodeDouble> roots;

    DGA(){
        roots = new ArrayList<>();
    }

    DGA(NodeDouble root){
        this.roots = new ArrayList<>();
        this.roots.add(root);
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
            recursiveDepth(nodeDouble, 0);
        }
    }

    private void recursiveDepth(NodeDouble node, int depth){
        List<NodeDouble> nodes = node.getSons();
        for(NodeDouble node1 : nodes){
            recursiveDepth(node1, depth+1);

        }
        if(node.getDepth() < (depth)){
            node.setDepth(depth);
        }

    }

    String output() {

        if(roots.size() < 0) return "";

        String res = dGAStruct(this.roots, new ArrayList<Integer>());


        return res;
    }

    private String dGAStruct(List<NodeDouble> nodes, List<Integer> valueSaved){

        StringBuilder st = new StringBuilder();
        for(int i =0; i<nodes.size(); i++){
            NodeDouble nodeDouble = nodes.get(i);
            st.append(nodeDouble.getValue());
            st.append('(');
            if(!valueSaved.contains(nodeDouble.getValue())){
                valueSaved.add(nodeDouble.getValue());
                st.append(dGAStruct(nodeDouble.getSons(),valueSaved));
            }

            st.append(')');

        }
        return st.toString();
    }

    //mainly used for testing
    NodeDouble getNodeFromValue(int value){
        NodeDouble res;
        for(int i =0; i<this.roots.size(); i++){
            NodeDouble nodeDouble = this.roots.get(i);
            res = recursiveGetNodeFromValue(nodeDouble, value);
            if(res != null) return res;
        }
        return null;
    }

    private NodeDouble recursiveGetNodeFromValue(NodeDouble nodeDouble,int value){
        if(nodeDouble.getValue() == value) return nodeDouble;
        for(NodeDouble nodeDouble1 : nodeDouble.getSons()){
            NodeDouble res = recursiveGetNodeFromValue(nodeDouble1, value);
            if(res != null) return res;
        }
        return null;
    }
}
