package lcaTree;
import lcaDataStructure.InputTree;
import lcaDataStructure.Tree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LcaTreeTest {

    Tree t1;
    Tree t2;
    Tree t3;
    Tree t4;
    Tree t5;

    LcaTree l1;
    LcaTree l2;
    LcaTree l3;
    LcaTree l4;
    LcaTree l5;

    @Before
    public void initialize(){
        InputTree i1 = new InputTree("0(1()2()3()4()5()6()7()8()9())");
        InputTree i2 = new InputTree("0(-1(1(2(3(4(5(6(7(8(9()))))))))))");
        InputTree i3 = new InputTree("0(1(3()5(6()))2(4()))");
        InputTree i4 = new InputTree("0(1()2()3()4()5()6()7()8()9())");;
        InputTree i5 = new InputTree("0(1()2()3()4()5()6()7()8()9())");;

        t1 = i1.generateTree();
        t2 = i2.generateTree();
        t3 = i3.generateTree();
        t4 = i4.generateTree();
        t5 = i5.generateTree();

        l1 = new LcaTree(t1);
        l2 = new LcaTree(t2);
        l3 = new LcaTree(t3);
        l4 = new LcaTree(t4);
        l5 = new LcaTree(t5);
    }

    @Test
    public void getLCAFromValue() {
        assertEquals(l1.getLCAFromValue(1,9).getValue(),0);
        assertEquals(l1.getLCAFromValue(0,3).getValue(), 0);
        assertEquals(l1.getLCAFromValue(1,1).getValue(), 0);

        assertEquals(l2.getLCAFromValue(9,1).getValue(), -1);
        assertEquals(l2.getLCAFromValue(9,0).getValue(), 0);

        assertEquals(l3.getLCAFromValue(3,5).getValue(), 1);
        assertEquals(l3.getLCAFromValue(4,6).getValue(), 0);
    }
}