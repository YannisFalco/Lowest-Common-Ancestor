import java.awt.*;

public class InputTree {
    List input;

    InputTree(List input){
        this.input = input;
    }

    Tree generateTree() {
        return new Tree(new Node(1));
    }

}
