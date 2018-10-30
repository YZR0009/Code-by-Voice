package model;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.editors.text.TextEditor;

import editorActions.EditorActions;

public class ShowCodes {
	
	private String statements = "";
	private int len = 0;
	
	public ShowCodes() {
		
	}
	
	public ShowCodes(String statementsIn){
		statements = statementsIn;
		len = statements.length();
	}
	
	public void setStatements(String statementsIn) {
		statements = statementsIn;
	}
	
	public void show() {
		//boolean isShow = false;
		Display.getDefault().asyncExec(() ->
	     {
	    	TextEditor iEditorPart = (TextEditor) EditorActions.getEditor();
	 		int cursorPosition = EditorActions.getcursorPosition(iEditorPart);
	 		//EditorActions.addEditorContents(statements);
	 		EditorActions.setEditorContents(statements, iEditorPart, 0);
	     });
		
		//return isShow;
	}
}
