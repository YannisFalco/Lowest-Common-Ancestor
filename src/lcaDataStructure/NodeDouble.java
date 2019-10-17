package lcaDataStructure;

import java.util.ArrayList;
import java.util.List;

public class NodeDouble extends Node {
    int depth;
    List<Node> parents = new ArrayList<>();
    NodeDouble(int value){
        super(value);
    }
    NodeDouble(int value, int depth){
        super(value);
        this.depth = depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    public void addParent(Node parent) {
        this.parents.add(parent);
    }
}
