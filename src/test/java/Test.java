import org.springframework.util.Assert;

public class Test {


    @org.junit.Test
    public void testAssert() {

        Object object = new Object();

        object = null;

        assert object != null;

        System.out.println("success");

    }

    @org.junit.Test
    public void test01() {
        Assert.notNull(new Object(), "Object must not be null");
//        Assert.notNull(null, "Object must not be null");

        System.out.println("end");
    }
}
