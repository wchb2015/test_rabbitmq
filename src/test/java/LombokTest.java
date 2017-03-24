import com.ele.rabbitmq.dto.OrderDTO;

import java.util.Date;

public class LombokTest {


    @org.junit.Test
    public void test01() {
        OrderDTO.builder().createdAt(new Date()).orderId(1111).build().toString();

        System.out.println("end");
    }
}
