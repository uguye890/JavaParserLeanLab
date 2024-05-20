package test;


/**
 * 
 * JavaDocument
 *
 */
public class HelloWorld {
	private final static String messageHello = "Hello World!"; 
	
	/*
	 * BlockComment
	 */
	public HelloWorld() {
		System.out.println(messageHello);
	}
	
	// LineComment
	public static void printHelloWorlds(int aCount) {
		for (int i = 0; i < aCount; i++) {
			System.out.println(messageHello);
		}
		int cnt = 0;
		while (cnt < aCount) {
			System.out.println(messageHello);
			cnt++;
		}
	}
	
	public static void printConditionalHelloWorld(int aValue) {
		if (aValue < 0) {
			System.out.println("Negative value : " + messageHello);
		}
		else if (aValue == 0) {
			System.out.println("Zero value : " + messageHello);
		}
		else {
			System.out.println("Positive value : " + messageHello);
		}
		
		switch (aValue) {
			case 0:
				System.out.println("Zero value : " + messageHello);
				break;
			case 1:
				System.out.println("One value : " + messageHello);
				break;
			default:
				System.out.println("Value is not binary : " + messageHello);
				break;
		}
	}
}
