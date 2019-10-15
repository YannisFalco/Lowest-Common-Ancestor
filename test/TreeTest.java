import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {
    Tree t1;
    Tree t2;
    Tree t3;

    @Before
    public void initialize(){
        Node node1 = new Node(0);
        t1 = new Tree(node1);

        Node node2 = new Node(0);
        t2 = new Tree(node2);

        for(int i = 1; i<10; i++){
            Node n = new Node(i);
            node1.addSon(n);

        }

        Node n2 = new Node(-1);
        node2.addSon(n2);
        Node n3 = new Node(1);
        n2.addSon(n3);
        for(int j=2; j<10; j++){
            Node n4 = new Node(j);
            n3.addSon(n4);
            n3 = n4;
        }

        Node node3 = new Node(0);
        t3 = new Tree(node3);
        Node left = new Node(1);
        Node right = new Node(2);
        node3.addSon(left);
        node3.addSon(right);
        left.addSon(new Node(3));
        right.addSon(new Node(4));



    }

    @Test
    public void output() {
        String s1 = t1.output();
        assertTrue(s1.equals("0(1()2()3()4()5()6()7()8()9())"));

        String s2 = t2.output();
        assertTrue(s2.equals("0(-1(1(2(3(4(5(6(7(8(9()))))))))))"));

        String s3 = t3.output();
        assertTrue(s3.equals("0(1(3())2(4()))"));
    }
}