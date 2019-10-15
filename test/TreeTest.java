import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {
    Tree t1;

    @Before
    public void initialize(){
        Node node = new Node(0);
        t1 = new Tree(node);
        for(int i = 1; i<10; i++){
            Node n = new Node(i);
            node.addSon(n);
        }

    }

    @Test
    public void output() {
        String s1 = t1.output();
        System.out.println(s1);
        assertTrue(t1.output().equals("(0(1-2-3-4-5-6-7-8-9-))"));

    }
}