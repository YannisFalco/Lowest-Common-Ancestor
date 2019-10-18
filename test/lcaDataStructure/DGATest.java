package lcaDataStructure;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DGATest {

     DGA t1;
     DGA t2;

    @Before
    public void initialize(){
        NodeDouble node1 = new NodeDouble(0);

        NodeDouble node2 = new NodeDouble(10);
        NodeDouble node3 = new NodeDouble(20);


        for(int i = 1; i<10; i++){
            NodeDouble n = new NodeDouble(i);
            node1.addSon(n);

        }

        NodeDouble value1 = new DGA(node1).getNodeFromValue(1);
        NodeDouble n2 = new NodeDouble(-1);
        node2.addSon(n2);
        n2.addSon(value1);
        for(int j=2; j<10; j++){
            NodeDouble n4 = new DGA(node1).getNodeFromValue(j);
            value1.addSon(n4);
            value1 = n4;
        }

        NodeDouble left = new DGA(node2).getNodeFromValue(1);
        NodeDouble right = new DGA(node1).getNodeFromValue(2);
        node3.addSon(left);
        node3.addSon(right);
        left.addSon(new DGA(node1).getNodeFromValue(3));
        right.addSon(new DGA(node1).getNodeFromValue(4));

        ArrayList<NodeDouble> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        t2 = new DGA(list);

        list.add(node3);
        t1 = new DGA(list);

        t1.computeDepth();
    }
    @Test
    public void output() {
        assertEquals(t1.output(), "0(1(2(3(4(5(6(7(8(9()))))))4())3())2()3()4()5()6()7()8()9())10(-1(1()))20(1()2())");
        assertEquals(t2.output(), "0(1(2(3(4(5(6(7(8(9()))))))4())3())2()3()4()5()6()7()8()9())10(-1(1()))");
    }

    @Test
    public void getNodeFromValue(){
        NodeDouble nodeDouble = t1.getNodeFromValue(1);
        assertEquals(nodeDouble.getValue(), 1);
    }

    @Test
    public void computeDepth() {

        List<NodeDouble> t1Roots = t1.getRoots();
        for(NodeDouble node : t1Roots){
            assertEquals(0, node.getDepth());
        }

        NodeDouble nodeDouble = t1.getNodeFromValue(1);


        assertEquals(2, nodeDouble.getDepth());
    }

}