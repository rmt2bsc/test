/**
 * 
 */
package test;

import java.util.Random;

import com.util.RMT2File;
import com.util.RMT2SystemUtility;

/**
 * @author appdev
 *
 */
public class WeakPasswordGenerator {
    private static final char[] symbols = new char[36];

    private final Random random = new Random();

    private final char[] buf;

    static {
	for (int idx = 0; idx < 10; ++idx) {
	    symbols[idx] = (char) ('0' + idx);
	}
	for (int idx = 10; idx < 36; ++idx) {
	    symbols[idx] = (char) ('a' + idx - 10);
	}
    }

    public WeakPasswordGenerator(int length) {
	if (length < 1) {
	    throw new IllegalArgumentException("length < 1: " + length);
	}
	buf = new char[length];
    }

    public String nextString() {
	for (int idx = 0; idx < buf.length; ++idx)
	    buf[idx] = symbols[random.nextInt(symbols.length)];
	return new String(buf);
    }

    /**
     * @param args6
     */
    public static void main(String[] args) {
	String data = RMT2File.getTextFileContents("C:\\ProjectServer\\TestIdeas\\data\\passwords2.csv");
	StringBuffer buf = new StringBuffer();
	String p[] = data.split(",");
	int changedTotal = 0;
	int unchangedTotal = 0;
	for (int ndx = 0; ndx < p.length; ndx++) {
	    String item = p[ndx].trim();
	    if (RMT2SystemUtility.isStrongPassword(item)) {
		System.out.println(item + " is valid!");
		buf.append(item);
		buf.append("\n");
		unchangedTotal++;
		continue;
	    }
	    System.out.println("<=========> " + item + " is not valid!");
	    String newPw = null;
	    if (item.length() >= 8) {
		newPw = RMT2SystemUtility.generatePassword(item.length());
	    }
	    else {
		newPw = RMT2SystemUtility.generatePassword(8);
	    }
	    buf.append(newPw);
	    buf.append("\n");
	    changedTotal++;
	}
	RMT2File.outputFile(buf.toString(), "C:\\ProjectServer\\TestIdeas\\data\\results.csv");
	System.out.println("Corrected total: " + changedTotal);
	System.out.println("Unchanged total: " + unchangedTotal);
    }

}
