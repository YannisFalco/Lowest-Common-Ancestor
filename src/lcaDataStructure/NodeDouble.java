package lcaDataStructure;

import java.util.ArrayList;
import java.util.List;

public class NodeDouble{
    private int depth = -1;
    private int value;
    private List<NodeDouble> parents = new ArrayList<>();
    private List<NodeDouble> sons = new ArrayList<>();

    NodeDouble(int value){
        this.value = value;
    }
    NodeDouble(int value, int depth){
        this.value = value;
        this.depth = depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    void addSon(NodeDouble node){
        sons.add(node);
    }
    void addSons(List<NodeDouble> nodes){
        sons.addAll(nodes);
    }

    public void addParent(NodeDouble parent) {
        this.parents.add(parent);
    }

    public List<NodeDouble> getSons() {
        return new ArrayList<NodeDouble>(sons);
    }

    public int getValue() {
        return value;
    }
}
