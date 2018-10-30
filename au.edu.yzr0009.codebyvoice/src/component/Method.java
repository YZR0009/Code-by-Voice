package component;

import java.util.ArrayList;

/**
 * The Method class is defined a Java method.
 * @author Yunfan Rao
 * @version 9/21/2018
 */

public class Method {
	
	private int accessModifier = 0;
	public static final int PUBLIC_MODIFIER = 0;
	public static final int PRIVATE_MODIFIER = 1;
	public static final int PROTECTED_MODIFIER = 2;
	
	private boolean isStatic = false;
	private boolean isFinal = false;
	
	private String returnType = "void";
	private String name = "";
	private ArrayList<String> paraTypeList = new ArrayList<String>();
	private ArrayList<String> paraNameList = new ArrayList<String>();
	private ArrayList<Statement> statementList = new ArrayList<Statement>();
	
	public Method(String nameIn) {
		name = nameIn;
	}
	
	public String getReturnType() {
		return returnType;
	}
	
	public void setReturnType(String returnTypeIn) {
		returnType = returnTypeIn;
	}
	
	public int getAccessModifier() {
		return accessModifier;
	}
	
	public boolean setAccessModifier(int type) {
		boolean isSet = false;
		if(type > 0 && type < 2)
			accessModifier = type;
		return isSet;
	}
	
	public boolean getIsStatic() {
		return isStatic;
	}
	
	public void setIsStatic(boolean isStaticIn) {
		isStatic = isStaticIn;
	}
	

	public String getName() {
		return name;
	}
	
	public void setName(String nameIn) {
		name = nameIn;
	}
	
	public void addParameter(String paraType, String paraName) {
		paraTypeList.add(paraType);
		paraNameList.add(paraName);
	}
	
	public void deleteParameter(String paraType, String paraName) {
		int index = paraNameList.indexOf(paraName);
		paraNameList.remove(paraName);
		paraTypeList.remove(index);
	}
	
	public void editParameterType(String paraType, String oldName, String newName) {
		int index = paraNameList.indexOf(oldName);
		paraTypeList.set(index, newName);
	}

	public void addStatement(Statement newStatement) {
		statementList.add(newStatement);
	}
	
	public static Method getMainMethod() {
		Method main = new Method("main");
		main.setIsStatic(true);
		main.addParameter("String[]", "args");
		Statement printHelloWorld = new Statement();
		printHelloWorld = Statement.printHelloWorld();
		main.addStatement(printHelloWorld);
		return main;
	}
	
	public static Method getToString() {
		Method toString = new Method("toString");
		toString.setReturnType("String");
		return toString;
	}
	/*
	public String toString() {
		
		String output = getName() + "method:\n";
		output += "\tParameter List:\n";
		for(int i = 0; i < paraTypeList.size(); i++) {
			output += paraTypeList.get(i) + " " + paraNameList.get(i) + "\n";
		}
		output += "\tReturn type: " + returnType + "\n";
		return output;
	}*/
	
public String toString() {
		
		StringBuffer output = new StringBuffer();
		switch(accessModifier) {
			case PUBLIC_MODIFIER: 
				output.append("\tpublic");
				break;
			case PRIVATE_MODIFIER:
				output.append("\tprivate");
				break;
			case PROTECTED_MODIFIER:
				output.append("\tprotected");
				break;
		
		}
		if(isStatic) {
			output.append(" static");
		}
		if(isFinal) {
			output.append(" final");
		}
		output.append(" " + returnType);
		output.append(" " + name + "(");
		int i = 0;
		for(; i < paraTypeList.size() - 1; i++) {
			output.append(paraTypeList.get(i) + " " + paraNameList.get(i) + ", ");
		}
		if(i == paraTypeList.size() - 1) {
			output.append(paraTypeList.get(i) + " " + paraNameList.get(i));
		}
		output.append(") {");
		for(i = 0; i < statementList.size(); i++) {
			output.append("\n\t\t" + statementList.get(i));
		}
		output.append("\n\t}\n");
		return output.toString();
	}
}
