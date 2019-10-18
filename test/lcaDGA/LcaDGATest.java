package lcaDGA;

import lcaDataStructure.DGA;
import lcaDataStructure.NodeDouble;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LcaDGATest {

    DGA dga1;
    DGA dga2;
    /*
        DGA 1 :
        1->2->3->4->5->9->10-->11
                 |->6->7->8->--|

        1(2(3(4(5(9(10(11())))6(7(8(11)))))))

        DGA 2 :
        1->13->4->5->6
                    | down
        2->7->8->9->10
        3->11->12-->|

        1(13(4(5(6(10())))))2(7(8(9(10))))3(11(12(10)))

     */
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
    public void getLCAFromValue(){
        LcaDGA lca1 = new LcaDGA(dga1);
        List<Integer> nodes1 = new ArrayList<>();
        nodes1.add(11);
        List<NodeDouble> res1 = new ArrayList<>(lca1.getLCAFromValue(nodes1));
        assertEquals(res1.size(), 2);
        List<Integer> resBis1 = new ArrayList<>();
        for(int i = 0; i<res1.size(); i++){
            resBis1.add(res1.get(i).getValue());
        }
        assertTrue(resBis1.contains(8));
        assertTrue(resBis1.contains(10));

        List<Integer> nodes2 = new ArrayList<>();
        nodes2.add(10);
        nodes2.add(8);
        List<NodeDouble> res2 = lca1.getLCAFromValue(nodes2);

        assertEquals(res2.size(), 1);

        List<Integer> resBis2 = new ArrayList<>();
        for(int i = 0; i<res2.size(); i++){
            resBis2.add(res2.get(i).getValue());
        }
        assertTrue(resBis2.contains(4));


        LcaDGA lca2 = new LcaDGA(dga2);
        List<Integer> nodes3 = new ArrayList<>();
        nodes3.add(13);
        List<NodeDouble> res3 = lca2.getLCAFromValue(nodes3);

        assertEquals(res3.size(), 1);

        List<Integer> resBis3 = new ArrayList<>();
        for(int i = 0; i<res3.size(); i++){
            resBis3.add(res3.get(i).getValue());
        }

        assertTrue(resBis3.contains(1));


        List<Integer> nodes4 = new ArrayList<>();
        nodes4.add(1);
        List<NodeDouble> res4 = lca2.getLCAFromValue(nodes4);

        assertEquals(res4.size(), 1);

        List<Integer> resBis4 = new ArrayList<>();
        for(int i = 0; i<res4.size(); i++){
            resBis4.add(res4.get(i).getValue());
        }

        assertTrue(resBis4.contains(1));


    }
}