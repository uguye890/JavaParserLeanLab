package test;


/**
 * 
 * JavaDocument
 *
 */
public class HelloWorld {
	private final static String message = "Hello World!"; 
	
	/*
	 * BlockComment
	 */
	public HelloWorld() {
		System.out.println(message);
	}
	
	// LineComment
	public static void printHelloWorlds(int aCount) {
		for (int i = 0; i < aCount; i++) {
			System.out.println(message);
		}
		int count = 0;
		while (count < aCount) {
			System.out.println(message);
			count++;
		}
	}
	
	public static void printConditionalHelloWorld(int value) {
		if (value < 0) {
			System.out.println("Negative value : " + message);
		}
		else if (value == 0) {
			System.out.println("Zero value : " + message);
		}
		else {
			System.out.println("Positive value : " + message);
		}
		
		switch (value) {
			case 0:
				System.out.println("Zero value : " + message);
				break;
			case 1:
				System.out.println("One value : " + message);
				break;
			default:
				System.out.println("Value is not binary : " + message);
				break;
		}
	}
}
