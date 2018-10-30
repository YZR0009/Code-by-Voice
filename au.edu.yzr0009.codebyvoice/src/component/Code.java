package component;

/**
 * The Code class is used to generate some basic code.
 * 
 * @author Yunfan Rao
 * @version 10/28/2018
 */

public class Code {
	public static final String helloWorldCode = "public class HelloWorld {"
			+ "\n\tpublic static void main(String[] args) {"
			+ "\n\t\tSystem.out.println(\"Hello World!\")"
			+ "\n\t}"
			+ "\n}\n";
	public static final String mainMethodCode = "\tpublic static void main(String[] args) {"
			+ "\n\t\tSystem.out.println(\"Hello World!\")"
			+ "\n}\n";
	public static final String toStringCode = "\tpublic String toString() {"
			+ "\n\n}\n";
	
	public static String helloWorldCode() {
		Class hw = new Class("HelloWorld");
		Method main = new Method("Main");
		main = Method.getMainMethod();
		hw.addMethod(main);
		return hw.toString();
		
	}
	
	public static String mainMethodCode() {
		Method main = new Method("Main");
		main = Method.getMainMethod();
		return main.toString();
		
	}
	
	public static String toStringCode() {
		Method toString = new Method("Main");
		toString = Method.getToString();
		return toString.toString();
		
	}
}
