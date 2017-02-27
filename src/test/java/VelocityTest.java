import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;

public class VelocityTest {

    private static final VelocityEngine velocityEngine = new VelocityEngine();


    @org.junit.Test
    public void testEvaluate() throws IOException {

        Context context = new VelocityContext();
        context.put("key1", "value1");
        context.put("key2", "value2");
        context.put("key3", "value3");
        StringWriter sw = new StringWriter();
        try {
            velocityEngine.evaluate(context, sw, "logTag777", "888888");
            String result = sw.toString();
            if (!StringUtils.isEmpty(result.trim())) {
                BigDecimal bigDecimal = new BigDecimal(Double.valueOf(result));
            }
        } catch (Exception e) {

        } finally {
            sw.close();
        }

//        velocityEngine.evaluate()
    }


}
