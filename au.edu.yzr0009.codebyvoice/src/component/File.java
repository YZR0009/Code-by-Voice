package component;

/**
 * The File class is used to manage the file.
 * 
 * @author Yunfan Rao
 * @version 10/28/2018
 */

public class File {
	private Class theClass = new Class("NotSigned");
	
	public boolean hasSignedClass() {
		boolean result = false;
		if(!theClass.getName().equals("NotSigned")) {
			result = true;
		}
		return result;
	}
	
	public void setTheClass(Class theClassIn) {
		theClass = theClassIn;
	}
	
	public void addHelloWorld() {
		theClass = new Class("HelloWorld");
		Method main = new Method("Main");
		main = Method.getMainMethod();
		theClass.addMethod(main);
		//return theClass.toString();	
	}
	
	public void addMainMethod() {
		if(theClass.findMethod("main") == -1) {
			Method main = new Method("Main");
			main = Method.getMainMethod();
			theClass.addMethod(main);
			//return main.toString();
		}
	}
	
	public void addToString() {
		Method toString = new Method("Main");
		toString = Method.getToString();
		theClass.addMethod(toString);
		//return toString.toString();
	}
	
	public void addConstructor() {
		Constructor constructor = new Constructor(theClass.getName());
		theClass.addConstructor(constructor);
	}
	
	public void removeClass() {
		theClass = new Class("NotAssigned");
	}
	
	public String fileInfo() {
		return theClass.toString();
	}
	
	
}
