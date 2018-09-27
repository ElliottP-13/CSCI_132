package Labs;
import Assets.Helper;

public class FindMatch {
	public static void main(String[] args) {
		Helper h = new Helper();
		int[] inputs = new int[5];
		for(int i = 0; i < 5; i++) {
			System.out.println("Enter element number: " + (i+1));
			inputs[i] = h.readInt();
		}
		boolean matches = false;
		for(int i = 0; i < inputs.length; i++) {
			int x = inputs[i];
			for(int j = i+1; j<inputs.length; j++) {
				if(inputs[i] == inputs[j]) {
					System.out.println(inputs[i] + " is a match");
					matches = true;
				}
			}
		}
		if(!matches) {
			System.out.println("No Matches :(");
		}
	}
}
