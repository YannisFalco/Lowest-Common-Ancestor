import java.util.ArrayList;
import java.util.List;
public class InputTree {
    String input;

    InputTree(String input){
        this.input = input;
    }

    Tree generateTree() {
        return new Tree(treeFromString(this.input));
    }

    private Node treeFromString(String input){
        Node root = new Node(getRoot(input));
        input = this.deleteRoot(input);
        List<String> sons = new ArrayList<>(getNextSons(input));
        for(String tmp : sons){
            if(tmp.length()>2){
                root.addSon(treeFromString(tmp));
            }
        }
        return root;
    }

    private int getRoot(String input){
        char[] inputChar = input.toCharArray();
        return Integer.parseInt(Character.toString(inputChar[0]));
    }

    private String deleteRoot(String input){
        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.deleteCharAt(input.length()-1);
        stringBuilder.delete(0,2);
        return stringBuilder.toString();
    }

    private List<String> getNextSons(String input){
        char[] inputChar = input.toCharArray();
        List<String> res = new ArrayList<>();
        int j = 0;
        int i = 2;
        int countSons = 0;
        int count = 1;
        while(i<inputChar.length){
            while(i<inputChar.length && count != 0) {
                if(inputChar[i] == '(') count++;
                if(inputChar[i] == ')') count--;
                i++;
            }
            System.out.println(j +" "+  i);
            res.add(input.substring(j, i));
            j = i;
            i+=2;
            count = 1;
            countSons++;
        }
        return res;
    }



}
