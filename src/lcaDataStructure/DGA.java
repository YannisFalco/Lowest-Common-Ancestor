package lcaDataStructure;

import java.util.ArrayList;
import java.util.List;

public class DGA {
    private List<NodeDouble> roots;
    private List<Integer> valueSavedOutput;

    DGA(){
        roots = new ArrayList<>();
    }

    public DGA(NodeDouble root){
        this.roots = new ArrayList<>();
        this.roots.add(root);
    }
    public DGA(List<NodeDouble> roots){
        this.roots = new ArrayList<>(roots);
    }

    public List<NodeDouble> getRoots() {
        return new ArrayList<>(roots);
    }

    public void computeDepth(){
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

        valueSavedOutput = new ArrayList<>();
        String res = dGAStruct(this.roots);


        return res;
    }

    private String dGAStruct(List<NodeDouble> nodes){

        StringBuilder st = new StringBuilder();
        for(int i =0; i<nodes.size(); i++){
            NodeDouble nodeDouble = nodes.get(i);
            st.append(nodeDouble.getValue());

            if(!valueSavedOutput.contains(nodeDouble.getValue())){
                st.append('(');
                valueSavedOutput.add(nodeDouble.getValue());
                st.append(dGAStruct(nodeDouble.getSons()));
                st.append(')');
            }

        }
        return st.toString();
    }

    //mainly used for testing
    public NodeDouble getNodeFromValue(int value){
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

    public void computeParents(){

        for(int i =0; i<this.roots.size(); i++){
            NodeDouble nodeDouble = this.roots.get(i);
            recursiveParent(nodeDouble, null);
        }

    }

    private void recursiveParent(NodeDouble nodeDouble, NodeDouble parents){

        List<NodeDouble> nodes = nodeDouble.getSons();
        for(NodeDouble node1 : nodes){
            recursiveParent(node1, nodeDouble);

        }
        nodeDouble.addParent(parents);
    }
}
