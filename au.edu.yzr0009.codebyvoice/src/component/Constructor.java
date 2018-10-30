package component;

import java.util.ArrayList;

public class Constructor {
	private int accessModifier = 0;
	public static final int PUBLIC_MODIFIER = 0;
	
	private String name = "";
	private ArrayList<String> paraTypeList = new ArrayList<String>();
	private ArrayList<String> paraNameList = new ArrayList<String>();
	private ArrayList<Statement> statementList = new ArrayList<Statement>();
	
	public Constructor(String nameIn) {
		name = nameIn;
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

	public String getName() {
		return name;
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
	
	public String toString() {
		
		StringBuffer output = new StringBuffer();
		switch(accessModifier) {
			case PUBLIC_MODIFIER: 
				output.append("\tpublic");
				break;		
		}
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
			output.append("\n\t\t" + statementList.get(i) +  ";");
		}
		output.append("\n\t}\n");
		return output.toString();
	}
}
