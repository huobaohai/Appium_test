package test1;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class peopleTest{
    people p;
    @Before
    public void people(){
        p  = new people("huo",23);
    }
    @Category(AttributeFun.class)
    @Test
    public void testName(){
        System.out.println(p.getName());
    }
    @Category(AttributeFun.class)
    @Test
    public void testAge(){
        System.out.println(p.getAge());
    }
    @Category(BehaviorFun.class)
    @Test
    public void testSay(){
        p.sayHello();
    }
}