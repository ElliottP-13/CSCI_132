package Projects;



/**
 * Is the driver for the Dice.java class
 * @author Elliott Pryor
 *
 */
public class DiceDemo {

	public static void main(String[] args) {
		Dice d = new Dice();//declare the instance because of non-static context of Dice
		d.avg();
	}

}
