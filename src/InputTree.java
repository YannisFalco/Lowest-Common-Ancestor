import java.util.ArrayList;
import java.util.List;
public class InputTree {
    private String input;

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
        int i=0;
        for(;i<inputChar.length && inputChar[i] != '('; i++);
        return Integer.parseInt(input.substring(0,i));
    }

    private String deleteRoot(String input){
        char[] inputChar = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.deleteCharAt(input.length()-1);
        int i=0;
        for(;i<inputChar.length && inputChar[i] != '('; i++);
        stringBuilder.delete(0,++i);
        return stringBuilder.toString();
    }

    private List<String> getNextSons(String input){
        char[] inputChar = input.toCharArray();
        List<String> res = new ArrayList<>();
        int j = 0;
        int i=0;
        int count = 1;
        while(i<inputChar.length){
            for(;i<inputChar.length && inputChar[i] != '(';i++);
            i++;
            while(i<inputChar.length && count != 0) {
                if(inputChar[i] == '(') count++;
                if(inputChar[i] == ')') count--;
                i++;
            }
            System.out.println(j +" "+  i);
            res.add(input.substring(j, i));
            j = i;
            count = 1;
        }
        return res;
    }



}
