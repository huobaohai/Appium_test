package test2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class ParamsTest {
    private String s;
    public ParamsTest(String ss){
        super();
        this.s = ss;
    }

    @Test
    public void test(){
        System.out.println(s);
    }

    @Parameterized.Parameters
    public static List getParams(){
        return Arrays.asList(new String[][]{{"hello"},{"world"},{"hi"},{"good"}});
    }
}
