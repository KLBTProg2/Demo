import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberTest {
//    public static void main(String[] args) {
//        System.out.println(test(5));
//        System.out.println(test(15));
//        System.out.println(test(3));
//    }
    public static String test(int num) {
        String result;
        if ((num % 3) == 0 && (num % 5) == 0) {
            return "TM";
        } else if ((num % 5) == 0) {
            return "M";
        } else if  ((num % 3) == 0) {
            return "T";
        }
        else return "bla";

    }
    @Test
    public void test(){
        String result = test(3);
        Assert.assertEquals(result,"T");
    }
    @Test
    public void test1(){
        String result = test(5);
        Assert.assertEquals(result,"M");
    }
    @Test
    public void test2(){
        String result = test(15);
        Assert.assertEquals(result,"TM");
    }
    @Test
    public void test3(){
        String result = test(4);
        Assert.assertEquals(result,"bla");
    }
    @Test
    public void test4(){
        String result = test(-5);
        Assert.assertEquals(result,"M");
    }
    @Test
    public void test5(){
        String result = test(0);
        Assert.assertEquals(result,"TM");
    }
}
