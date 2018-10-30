package component;

/**
 * Define a Field class to store info of a field.
 * @author Yunfan Rao
 * @version 9/29/2018
 */

public class Field {
	
	private int accessModifier = 0;
	public static final int PUBLIC_MODIFIER = 0;
	public static final int PRIVATE_MODIFIER = 1;
	public static final int PROTECTED_MODIFIER = 2;
	
	private boolean isConstant = false;
	private boolean isStatic = false;
	private boolean isFinal = false;
	private String type = "";
	private String name = "";
	private String value = "";
	
	public Field(String typeIn, String nameIn){
		type = typeIn;
		name = nameIn;
	}
	
	public void setIsConstant(boolean isConstantIn) {
		isConstant = isConstantIn;
		if(isConstant){
			isStatic = true;
			isFinal = true;
		}
	}
	
	public boolean getIsConstant() {
		return isConstant;
	}
	
	public void setIsStatic(boolean isStaticIn) {
		isStatic = isStaticIn;
	}
	
	public boolean getIsStatic() {
		return isStatic;
	}
	
	public void setIsFinal(boolean isFinalIn) {
		isFinal = isFinalIn;
	}
	
	public boolean getIsFinal() {
		return isFinal;
	}
	
	public boolean setType(String typeIn) {
		if(typeIn != null) {
			type = typeIn.trim();
			setDefaultValue();
			return true;
		}
		return false;
	}
	
    public String getType() {
    	return type;
    }
    
    public boolean setName(String nameIn) {
		if(nameIn != null) {
			name = nameIn.trim();
			return true;
		}
		return false;
	}
	
    public String getName() {
    	return name;
    }
    
    public void setDefaultValue(){
    	switch(type) {
    		case "int":
    		case "byte":
    		case "long":
    			value = "0";
    			break;
    		case "float":
    		case "double":
    			value = "0.0";
    			break;
    		case "boolean":
    			value = "false";
    			break;
    		case "String":
    			value = "";
    			break;
    		default:
    			value = "null";
    	}
    }
    
    public boolean setValue(String valueIn) {
		if(valueIn != null) {
			value = valueIn.trim();
			return true;
		}
		return false;
	}
	
    public String getValue() {
    	return value;
    }
}
