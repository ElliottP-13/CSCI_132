import java.io.File;

import Assets.ReadWrite;

public class KillEnter {
	public static void main(String[] args) {
		
		String x = "Hello World This IS a new String 	 thing that kills \nspaces";
		
		ReadWrite r = new ReadWrite();
		String y = r.readEntireFile("Info.txt");
		
		String dead = killEnters(y);
		File save = r.createFileIfNotExists("Info2.java");
		r.overwriteFileWithString(dead, save);
		System.out.println("Written");
	}
	
	public static void printChars(String x) {
		for(int i = 0; i < x.length(); i++) {
			Character y = x.charAt(i);
			System.out.println("Character Found: " + y);
			
			System.out.println("ID: " + y.getNumericValue(y));
		}
	}
	
	public static String killEnters(String x) {
		String y = "";
		for(int i = 0; i < x.length(); i++) {
			if(x.charAt(i) == "\n".charAt(0)) {
				
			} else if(x.charAt(i) == "	".charAt(0)) {
				
			} else {
				y = y + x.charAt(i);
			}	
		}
		return y;
	}
	
}
