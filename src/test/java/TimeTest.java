import org.junit.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {


    @org.junit.Test
    public void test01() {

        long startTime = getTime("03-02 17:01:09");
        long endTime = getTime("03-02 17:11:20");

        int diffTimeInt = (int) (endTime - startTime) / 1000 / 60;
        float diffTimeFloat = (float) (endTime - startTime) / 1000 / 60;

        System.out.println(diffTimeInt);
        System.out.println(diffTimeFloat);
    }


    private long getTime(String timeStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(timeStr);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
