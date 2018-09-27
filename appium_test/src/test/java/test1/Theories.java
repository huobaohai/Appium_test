package test1;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(org.junit.experimental.theories.Theories.class)
public class Theories {

    @DataPoints
    public static String[] s = {"huo","bao","hai"};

    @DataPoints
    public static int[] i = {23,24,25};

    @Theory
    public void test(String name,int in){
        System.out.println(name + ": " + in);
    }
}
