package lcaDataStructure;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> nodesSon;
    private int value;

    Node(int value){
        nodesSon = new ArrayList<>();
        this.value = value;
    }

    void addSon(Node node){
        nodesSon.add(node);
    }

    public List<Node> getSons() {
        return new ArrayList<>(nodesSon);
    }

    boolean hasSon() {
        return (nodesSon.size() > 0);
    }

    public int getValue(){
        return this.value;
    }

}
