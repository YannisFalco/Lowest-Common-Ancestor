import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputTreeTest {

    InputTree inputTree1;
    InputTree inputTree2;
    InputTree inputTree3;
    InputTree inputTree4;
    InputTree inputTree5;


    @Test
    public void generateTree() {
        inputTree1 = new InputTree("0(1()2()3()4()5()6()7()8()9())");
        assertEquals(inputTree1.generateTree().output(), "0(1()2()3()4()5()6()7()8()9())");

        inputTree2 = new InputTree("0(-1(1(2(3(4(5(6(7(8(9()))))))))))");
        //assertEquals(inputTree1.generateTree().output(), "0(-1(1(2(3(4(5(6(7(8(9()))))))))))");

        inputTree3 = new InputTree("0(1(3())2(4()))");
        assertEquals(inputTree3.generateTree().output(), "0(1(3())2(4()))");

    }
}