package component;

import java.util.ArrayList;

/**
 * The Class class is used to define a Java Class.
 * @author Yunfan Rao
 * @version 9/29/2018
 */
public class Class {
	// The name of this class.
	private String name = "";
	// The import list of this class.
	private ArrayList<String> importList = new ArrayList<String>();
	// The field of this class.
	private ArrayList<Field> fieldList = new ArrayList<Field>();
	private ArrayList<Constructor> constructorList = new ArrayList<Constructor>();
	// The method list of this class, see UnitInMethod for detail.
	private ArrayList<Method> methodList = new ArrayList<Method>();
	
	/**
	 * Constructor that accept a name to initialize name.
	 * @param nameIn used to assign to name.
	 */
	public Class(String nameIn) {
		nameIn = nameIn.trim();
		name = nameIn.substring(0, 1).toUpperCase() + nameIn.substring(1);	
	}
	
	/**
	 * Get the name.
	 * @return the name of the class
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the name.
	 * @param nameIn used to set to name
	 */
	public void setName(String nameIn) {
		name = nameIn;
	}
	
	/**
	 * Add an import to import list.
	 * @param newImport the import gonna add to list.
	 */
	public void addImport(String newImport) {
		importList.add(newImport);
	}
	
	/**
	 * Find the index of an import
	 * @param removeImport the import need to find
	 * @return the index of that import
	 */
	public int findImport(String removeImport) {
		int index = -1;
		for(int i = 0; i < methodList.size(); i++) {
			if( removeImport.equalsIgnoreCase(importList.get(i)))
				index = i;
		}
		return index;
	}
	
	/**
	 * Remove an import from import list
	 * @param removeImport the import gonna remove
	 * @return true if find and remove, return false if that import doesn't exist.
	 */
	public boolean removeImport(String removeImport) {
		int index = findImport(removeImport);
		if(index == -1)
			return false;
		importList.remove(index);
		return true;
	}
	
	/**
	 * Add an field to field list.
	 * @param newField the field gonna add to list.
	 */
	public void addField(Field newField) {
		fieldList.add(newField);
	}
	
	/**
	 * Find the index of an field
	 * @param fieldName the field need to find
	 * @return the index of that field
	 */
	public int findField(String fieldName) {
		int index = -1;
		for(int i = 0; i < methodList.size(); i++) {
			if( fieldName.equalsIgnoreCase(fieldList.get(i).getName()))
				index = i;
		}
		return index;
	}
	
	/**
	 * Remove an field from field list
	 * @param fieldName the field gonna remove
	 * @return true if find and remove, return false if that field doesn't exist.
	 */
	public boolean removeField(String fieldName) {
		int index = findMethod(fieldName);
		if(index == -1)
			return false;
		fieldList.remove(index);
		return true;
	}
	
	/**
	 * Add an constructor to constructor list.
	 * @param newConstructor gonna add to the list.
	 */
	public void addConstructor(Constructor newConstructor) {
		constructorList.add(newConstructor);
	}
	
	/**
	 * Find the index of an constructor
	 * @param constructorName the constructor need to find
	 * @return the index of that constructor
	 */
	public int findConstructor(String constructorName) {
		int index = -1;
		for(int i = 0; i < constructorList.size(); i++) {
			if( constructorName.equalsIgnoreCase(constructorList.get(i).getName()))
				index = i;
		}
		return index;
	}
	
	/**
	 * Remove an constructor from constructor list
	 * @param constructorName the method gonna remove
	 * @return true if find and remove, return false if that constructor doesn't exist.
	 */
	public boolean removeConstructor(String constructorName) {
		int index = findConstructor(constructorName);
		if(index == -1)
			return false;
		constructorList.remove(index);
		return true;
	}
	
	/**
	 * Add an method to method list.
	 * @param newMethod the method gonna add to list.
	 */
	public void addMethod(Method newMethod) {
		methodList.add(newMethod);
	}
	
	/**
	 * Find the index of an method
	 * @param methodName the method need to find
	 * @return the index of that method
	 */
	public int findMethod(String methodName) {
		int index = -1;
		for(int i = 0; i < methodList.size(); i++) {
			if( methodName.equalsIgnoreCase(methodList.get(i).getName()))
				index = i;
		}
		return index;
	}
	
	/**
	 * Remove an method from method list
	 * @param methodName the method gonna remove
	 * @return true if find and remove, return false if that method doesn't exist.
	 */
	public boolean removeMethod(String methodName) {
		int index = findMethod(methodName);
		if(index == -1)
			return false;
		methodList.remove(index);
		return true;
	}

	
	/**
	 * Generate and return a string represented itself.
	 * @return a string represented this object.
	 */
	/*public String toString() {
		String output = getName() + "class:\n";
		output += "\tMethod List:\n";
		for(int i = 0; i < methodList.size(); i++) {
			output += methodList.get(i) + "\n";
		}
		return output;
	}*/
	
	/**
	 * Generate the code represented itself.
	 * @return a string represented this object.
	 */
	public String toString() {
		StringBuffer output = new StringBuffer();
		for(int i = 0; i < importList.size(); i++) {
			output.append(importList.get(i) + "\n");
		}
		output.append("public class");
		output.append(" " + name + " {");
		for(int i = 0; i < constructorList.size(); i++) {
			output.append("\n" + constructorList.get(i));
		}
		for(int i = 0; i < methodList.size(); i++) {
			output.append("\n" + methodList.get(i));
		}
		output.append("\n}\n");
		return output.toString();
	}
}
