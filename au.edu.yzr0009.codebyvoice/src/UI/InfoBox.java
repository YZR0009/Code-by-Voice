package UI;

import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * The InfoBox class is used to create and open a SWT dialog.
 * 
 * @author Yunfan Rao
 * @version 10/28/2018
 */

public class InfoBox {
	public static void showInfoBox(String message) {
		new Thread(new Runnable() {
		      public void run() {
		         //while (true) {
		            try { Thread.sleep(1000); } catch (Exception e) { }
		            Display.getDefault().asyncExec(new Runnable() {
		               public void run() {
		            	   MessageDialog dialog = new MessageDialog(new Shell(), "Code by Voice is working", null,
		       			        "You are saying [ " + message + " ]", MessageDialog.NONE, new String[] { "Okay"}, 0);
		            	   int result = dialog.open();
		               }
		            });
		         //}
		      }
		  }).start(); 
	}
}
