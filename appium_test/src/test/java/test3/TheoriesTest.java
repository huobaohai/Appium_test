package test3;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(org.junit.experimental.theories.Theories.class)
public class TheoriesTest {

    @DataPoints
    public static String[] s = {"huo","bao","hai"};

    @DataPoints
    public static int[] i = {23,24,25};

    @Theory
    public void test(String name,int in){
        System.out.println(name + ": " + in);
    }
}
