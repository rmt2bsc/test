package test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JobInterview {

    private static String[] data = { "1", "two", "3", "four", "5" };
    private final String data2;

    /**
     * 
     */
    public JobInterview() {
        super();
        this.data2 = "Final empty variable initialized at runtime";
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("Non Null Key", "String");
        map.put("Null Value", null);
    }

    protected int getJob(String item) {
        try {
            int ii = Integer.parseInt(item);
            return ii;
        } catch (NullPointerException e) {
            return 0;
        } catch (NumberFormatException e) {
            return -1;
        } finally {
            String.valueOf(true);
            return 3;
        }
    }

    public synchronized static void testStaticDeclaration() {
        return;

    }

    public void testStringPool() {
        // Test Memory pool and heap usage pertaining to Strings
        String s1 = "Welcome";
        String s2 = "Welcome";
        String s3 = "Welcome";
        String s4 = new String("Welcome");
        String s5 = new String("Welcome2");
        String s6 = "Welcome2";
        String s7 = "Welcome2";
        s1 += ", Roy";
        return;

    }

    public static void main(String[] args) {
        JobInterview j = new JobInterview();
        for (int ndx = 1; ndx < data.length; ndx++) {
            int rc = j.getJob(data[ndx]);
            System.out.println(rc);
        }

        j.testStringPool();
    }
}
