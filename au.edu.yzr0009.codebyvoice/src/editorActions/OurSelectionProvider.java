package editorActions;


import org.eclipse.jface.text.ITextSelection;

/**
 * A open source java file from the following wesite:
 * https://www.programcreek.com/java-api-examples
 * /?code=joereddington/EclipseEditorPluginExample
 * /EclipseEditorPluginExample-master/EditorActions
 * /src/editoractions/EditorActions.java#
 */

final class OurSelectionProvider implements ITextSelection {
	private final int correctionToOffset;
	private final int currentCursorPosition;

	OurSelectionProvider(int correctionToOffset, int currentCursorPosition) {
		this.correctionToOffset = correctionToOffset;
		this.currentCursorPosition = currentCursorPosition;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStartLine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOffset() {
		// TODO Auto-generated method stub
		return currentCursorPosition+correctionToOffset;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEndLine() {
		// TODO Auto-generated method stub
		return 0;
	}
}