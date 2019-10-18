package lcaDataStructure;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DGATest {

     DGA dga1;
     DGA dga2;

    @Before
    public void initialize(){
        NodeDouble node1 = new NodeDouble(1);
        NodeDouble node2 = new NodeDouble(2);
        NodeDouble node3 = new NodeDouble(3);
        NodeDouble node4 = new NodeDouble(4);
        NodeDouble node5 = new NodeDouble(5);
        NodeDouble node6 = new NodeDouble(6);
        NodeDouble node7 = new NodeDouble(7);
        NodeDouble node8 = new NodeDouble(8);
        NodeDouble node9 = new NodeDouble(9);
        NodeDouble node10 = new NodeDouble(10);
        NodeDouble node11 = new NodeDouble(11);

        node1.addSon(node2);
        node2.addSon(node3);
        node3.addSon(node4);
        node4.addSon(node5);
        node4.addSon(node6);
        node5.addSon(node9);
        node6.addSon(node7);
        node7.addSon(node8);
        node8.addSon(node11);
        node9.addSon(node10);
        node10.addSon(node11);

        dga1 = new DGA(node1);
        dga1.computeDepth();

        NodeDouble node1_2 = new NodeDouble(1);
        NodeDouble node2_2 = new NodeDouble(2);
        NodeDouble node3_2 = new NodeDouble(3);
        NodeDouble node4_2 = new NodeDouble(4);
        NodeDouble node5_2 = new NodeDouble(5);
        NodeDouble node6_2 = new NodeDouble(6);
        NodeDouble node7_2 = new NodeDouble(7);
        NodeDouble node8_2 = new NodeDouble(8);
        NodeDouble node9_2 = new NodeDouble(9);
        NodeDouble node10_2 = new NodeDouble(10);
        NodeDouble node11_2 = new NodeDouble(11);
        NodeDouble node12_2 = new NodeDouble(12);
        NodeDouble node13_2 = new NodeDouble(13);

        node1_2.addSon(node13_2);
        node2_2.addSon(node7_2);
        node3_2.addSon(node11_2);
        node4_2.addSon(node5_2);
        node5_2.addSon(node6_2);
        node6_2.addSon(node10_2);
        node7_2.addSon(node8_2);
        node8_2.addSon(node9_2);
        node9_2.addSon(node10_2);
        node11_2.addSon(node12_2);
        node12_2.addSon(node10_2);
        node13_2.addSon(node4_2);

        List<NodeDouble> root = new ArrayList<>();
        root.add(node1_2);
        root.add(node2_2);
        root.add(node3_2);
        dga2 = new DGA(root);
    }
    @Test
    public void output() {
        assertEquals("1(2(3(4(5(9(10(11())))6(7(8(11)))))))",dga1.output());
        assertEquals("1(13(4(5(6(10())))))2(7(8(9(10))))3(11(12(10)))", dga2.output());
    }

    @Test
    public void getNodeFromValue(){
        NodeDouble nodeDouble = dga1.getNodeFromValue(3);
        assertEquals(nodeDouble.getValue(), 3);
    }

    @Test
    public void computeDepth() {

        List<NodeDouble> t1Roots = dga1.getRoots();
        for(NodeDouble node : t1Roots){
            assertEquals(0, node.getDepth());
        }

        NodeDouble nodeDouble = dga1.getNodeFromValue(3);


        assertEquals(2, nodeDouble.getDepth());
    }

}