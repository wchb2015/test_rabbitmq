import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VelocityTest {

    private static final Logger LOG = LoggerFactory.getLogger(VelocityTest.class);


    private static final VelocityEngine velocityEngine = new VelocityEngine();

    @org.junit.Test
    public void testEvaluate() throws IOException {

        LOG.info("start~~!");

        String rule = "#if ($gridSubsidy == \"A1\") 1#elseif ($gridSubsidy == \"A2\")2#elseif ($gridSubsidy == \"B\")3#elseif ($gridSubsidy == \"C\")4#elseif ($gridSubsidy == \"D\")5 #else 0#end";

        Context context = new VelocityContext();
        context.put("gridSubsidy", "D111");
        context.put("key2", "value2");
        context.put("key3", "value3");
        StringWriter sw = new StringWriter();
        try {
            velocityEngine.evaluate(context, sw, "logTag777", rule);
            String result = sw.toString();
            System.out.println("____" + result);
            if (!StringUtils.isEmpty(result.trim())) {
                BigDecimal bigDecimal = new BigDecimal(Double.valueOf(result));
                System.out.println("bigDecimal____" + bigDecimal);

            }
        } catch (Exception e) {

        } finally {
            sw.close();
        }

//        velocityEngine.evaluate()
    }


}
