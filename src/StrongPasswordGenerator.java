/**
 * 
 */
package test;

import java.util.Random;

/**
 * @author appdev
 *
 */
public class StrongPasswordGenerator {

    //Verison 1.0
    private static final String dCase = "abcdefghijklmnopqrstuvwxyz";

    private static final String uCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String sChar = "!@#$%^&*";

    private static final String intChar = "0123456789";

    private Random r;

    

    public StrongPasswordGenerator() {
	this.r = new Random();
    }

    public String generate(int size) {
	String pass = "";
	System.out.println("Generating pass...");
	while (pass.length() != size) {
	    int rPick = r.nextInt(4);
	    if (rPick == 0) {
		int spot = r.nextInt(25);
		pass += dCase.charAt(spot);
	    }
	    else if (rPick == 1) {
		int spot = r.nextInt(25);
		pass += uCase.charAt(spot);
	    }
	    else if (rPick == 2) {
		int spot = r.nextInt(7);
		pass += sChar.charAt(spot);
	    }
	    else if (rPick == 3) {
		int spot = r.nextInt(9);
		pass += intChar.charAt(spot);
	    }
	}
	
	return pass;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	StrongPasswordGenerator g = new StrongPasswordGenerator();
	String pass = g.generate(8);
	System.out.println("Generated Pass: " + pass);
    }

}
