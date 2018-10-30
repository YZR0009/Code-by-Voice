package component;

/**
 * The Statement class is defined a Java statement.
 * 
 * @author Yunfan Rao
 *
 */

public class Statement {
	public int type = 0;
	public static final int DECLARE_AND_INITIALIZE = 0;
	public static final int ASSIGNMENT = 1;
	public static final int IF = 2;
	public static final int ELSE_IF = 3;
	public static final int ELSE = 4;
	public static final int FOR = 5;
	public static final int SWITCH = 6;
	public static final int RETURN = 7;
	public static final int PRINT = 8;
	public static final int PRINTLN = 9;
	public static final int CALLMETHOD = 10;
	
	public String theStatement = "";
	
	public Statement() {
		
	}
	
	public Statement(int typeIn) {
		setType(typeIn);
	}
	
	public boolean setType(int typeIn) {
		boolean isSet = false;
		if(typeIn >= DECLARE_AND_INITIALIZE && typeIn <= CALLMETHOD) {
			type = typeIn;
			isSet = true;
		}
		return isSet;
	}
	
	public int getType() {
		return type;
	}
	
	public void setStatement(String theStatementIn){
		theStatement = theStatementIn;
	}
	
	public static Statement printHelloWorld() {
		Statement s = new Statement();
		s.setStatement("System.out.println(\"Hello World!\");");
		return s;
	}
	
	public String getTheStatement() {
		if(!theStatement.equals(""))
			return theStatement;
		else{
			switch(type) {
			default:
				return null;
			}
		}
	}
	
	public String toString() {
		return getTheStatement();
	}
}
