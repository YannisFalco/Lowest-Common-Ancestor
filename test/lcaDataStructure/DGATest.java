package lcaDataStructure;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DGATest {

     DGA t1;
     DGA t2;

    @Before
    public void initialize(){
        NodeDouble node1 = new NodeDouble(0);

        NodeDouble node2 = new NodeDouble(10);


        for(int i = 1; i<10; i++){
            NodeDouble n = new NodeDouble(i);
            node1.addSon(n);

        }

        NodeDouble n2 = new NodeDouble(-1);
        node2.addSon(n2);
        NodeDouble n3 = new NodeDouble(1);
        n2.addSon(n3);
        for(int j=2; j<10; j++){
            NodeDouble n4 = new NodeDouble(j);
            n3.addSon(n4);
            n3 = n4;
        }

        NodeDouble node3 = new NodeDouble(20);
        NodeDouble left = new NodeDouble(1);
        NodeDouble right = new NodeDouble(2);
        node3.addSon(left);
        node3.addSon(right);
        left.addSon(new NodeDouble(3));
        right.addSon(new NodeDouble(4));

        ArrayList<NodeDouble> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        t2 = new DGA(list);

        list.add(node3);
        t1 = new DGA(list);

    }
    @Test
    public void output() {
        assertEquals(t1.output(), "0(1()2()3()4()5()6()7()8()9())10(-1(1(2(3(4(5(6(7(8(9()))))))))))20(1(3())2(4()))");
        assertEquals(t2.output(), "0(1()2()3()4()5()6()7()8()9())10(-1(1(2(3(4(5(6(7(8(9()))))))))))");
    }

    @Test
    public void computeDepth() {
    }

}