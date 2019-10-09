import java.util.ArrayList;
import java.util.List;

class Node {
    private List<Node> nodesSon;

    Node(){
        nodesSon = new ArrayList<>();
    }

    void addSon(Node node){
        nodesSon.add(node);
    }

    List<Node> getSons() {
        return new ArrayList<>(nodesSon);
    }

    boolean hasSon() {
        return (nodesSon.size() > 0);
    }

}
