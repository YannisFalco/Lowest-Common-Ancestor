import java.awt.*;

public class InputTree {
    String input;

    InputTree(String input){
        this.input = input;
    }

    Tree generateTree() {
        return new Tree(new Node(1));
    }

    private int getRoot(String input){
        char[] inputChar = input.toCharArray();
        return Integer.parseInt(Character.toString(inputChar[0]));
    }

    private String getSons(String input){
        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.delete(0,2);
        return stringBuilder.toString();
    }



}
