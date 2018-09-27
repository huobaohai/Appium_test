package test1;

import org.junit.Test;

public class people {
    @Test
    public void peopleTest(){
        System.out.println(",,");
    }

    String name;
    int age;

    public people(String n, int i){
        this.name = n;
        this.age = i;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void sayHello(){
        System.out.println("people : my name is " + name);
    }
}
