package Assets;
import java.util.Scanner;
import java.awt.Graphics;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;

public class Helper {
	private long startTime;
	private long elapsedTime;
	public Graphics g;

	public Helper() {
		startTime = System.currentTimeMillis(); // starts the timer
	}

	/**
	 * Fills an array an array with random ints 0 to 99
	 *
	 * @param size The size of the array to generate
	 */
	public int[] fillRandomly(int size) {
		int[] array = new int[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt(100);
		}
		return array;
	}

	public void start() {
		startTime = System.currentTimeMillis();
	}

	public long getElapsedTime() {
		elapsedTime = System.currentTimeMillis() - startTime;
		return elapsedTime;
	}

	public void print(String text) {// shortens System.out.println(text);
		System.out.println(text);
	}

	public static void printlnTextSlowly(String text) {
		try {
			for (int i = 0; i < text.length(); i++) {
				System.out.print(text.substring(i, i + 1));
				Thread.sleep(250);
			}
			System.out.println();
		} catch (InterruptedException e) {
		}
	}

	public static void printlnTextSlowly(String text, int time) {
		try {
			for (int i = 0; i < text.length(); i++) {
				System.out.print(text.substring(i, i + 1));
				Thread.sleep(time);
			}
			System.out.println();
		} catch (InterruptedException e) {
		}
	}

	public void tone(int hz, int msecs) throws LineUnavailableException {
		tone(hz, msecs);
	}

	public void tone(int hz, int msecs, double vol) throws LineUnavailableException {
		byte[] buf = new byte[1];
		float SAMPLE_RATE = 8000f;
		AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 1, true, false); // sampleRate,
																			// sampleSizeInBits,
																			// channels,
																			// signed,
																			// bigEndian
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		sdl.open(af);
		sdl.start();
		for (int i = 0; i < msecs * 8; i++) {
			double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
			buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
			sdl.write(buf, 0, 1);
		}
		sdl.drain();
		sdl.stop();
		sdl.close();
	}

	public boolean isAgreement(String responce) {
		String[] consent = { "Yes", "Yeah", "Ya", "Ye", "Sure", "Yup", "Sounds good" };
		for (int i = 0; i < consent.length; i++) {
			if (consent[i].equalsIgnoreCase(responce)) {
				return true;
			}
		}
		if (responce.startsWith("ye")) {
			responce = readString("Please answer with just yes or no");
			isAgreement(responce);
		}
		return false;
	}

	public void playSound(String file) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	public String readString() {
		Scanner scan = new Scanner(System.in);
		scan.close();
		return scan.nextLine();
	}

	/**
	 * Prompts a user with text and returns the input from the console as a string
	 *
	 * @param text the text printed to the console as a prompt
	 * @return a string value scanned in from the console
	 */
	public String readString(String text) {
		System.out.println(text);
		return readString();
	}

	public int readInt() {
		boolean valid = false;
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int in = 0;
		while(!valid) {
			try {
				in = Integer.parseInt(input);
				valid = true;
			} catch (NumberFormatException e) {
				
			}
		}
		scan.close();
		return in;
	}

	/**
	 * Guarantees an int value. Will continue looping if not given an integer value
	 *
	 * @param text The text printed to the console as a prompt
	 * @return an int value scanned in from the console
	 */
	public int readInt(String text) {
		System.out.println(text);
		return readInt();
	}

	public double readDouble() {
		boolean valid = false;

		Scanner scan = new Scanner(System.in);
		String input;
		double in = 0;

		while(!valid) {
			input = scan.nextLine();
			try {
				in = Double.parseDouble(input);
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("Please enter an actual number");
			}
		}
		scan.close();
		return in;
	}

	public double readDouble(String text) {
		System.out.println(text);
		return readDouble();
	}

	public void printBox(String text) {
		JOptionPane.showMessageDialog(null, text); // Simple JOption pane dialog
													// box
	}

	public String inputBox(String text) {
		return JOptionPane.showInputDialog(text); // Simple JOption pane input
													// box
	}

	public int yesNoBox(String text) {
		return JOptionPane.showConfirmDialog(null, text);// Simple JOption pane
															// confirm box
	}

	public int rand(int start, int end) {
		Random a = new Random();
		return (a.nextInt(end) + start);
	}


	public String[][] parcer(String base, String div1, String div2) {
		String[] d1 = base.split(div1); // divides the base string
		String[] d2;
		String[][] endP = null;
		String curr;
		boolean first = true;
		for (int i = 0; i < d1.length; i++) {// starts at 1 so it avoids 1st
												// delemiter
			curr = d1[i];
			d2 = curr.split(div2); // divides stuff within 1st division
			if (first) {
				first = false;
				endP = new String[d1.length][d2.length - (d2.length - 1) / 2];
				//assumes all entries have same number of sub-entries
			}
			int k = 0;
			for (int j = 0; j < d2.length; j += 2) {
				endP[i][k] = d2[j];// puts it in double array
				k++;//loops 2 variables because the endP spot increases by  1, while the other increases by 2 because
				//split leaves a ? in where the second delemiter was
			}
		}
		return endP;
	}

	
	public void nap(int milli) {
		try { // try's and catches Thread.sleep
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			e.getCause();
			e.printStackTrace();
		}
	}

	public void snooze(Long time) {
		try {
			wait(time);// same as nap, but with wait, in case not thread bound
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
