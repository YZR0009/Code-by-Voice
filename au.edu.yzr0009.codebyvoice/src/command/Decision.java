package command;

import UI.InfoBox;
import component.File;
import model.ShowCodes;

/**
 * The Decision class is used to make decision based on different speech.
 * 
 * @author Yunfan Rao
 * @version 10/28/2018
 */

public class Decision {
	public static void makeDecision(String speech, File file) {
		System.out.println("You said: " + speech + "\n");
		if(speech.contains(Commands.HELLO_WORLD)) {
			InfoBox.showInfoBox(Commands.HELLO_WORLD);
			//ShowCodes hw = new ShowCodes(Code.helloWorldCode());
			file.addHelloWorld();
			ShowCodes hw = new ShowCodes(file.fileInfo());
			hw.show();
			return;
		}
		if(speech.contains(Commands.EXAMPLE_CLASS)) {
			InfoBox.showInfoBox(Commands.EXAMPLE_CLASS);
			//ShowCodes hw = new ShowCodes(Code.helloWorldCode());
			file.addHelloWorld();
			ShowCodes hw = new ShowCodes(file.fileInfo());
			hw.show();
			return;
		}
		if(speech.contains(Commands.MAIN_METHOD)) {
			InfoBox.showInfoBox(Commands.MAIN_METHOD);
			//ShowCodes hw = new ShowCodes(Code.mainMethodCode());
			file.addMainMethod();
			ShowCodes hw = new ShowCodes(file.fileInfo());
			hw.show();
			return;
		}
		if(speech.contains(Commands.TO_STRING)) {
			InfoBox.showInfoBox(Commands.TO_STRING);
			//ShowCodes hw = new ShowCodes(Code.toStringCode());
			file.addToString();
			ShowCodes hw = new ShowCodes(file.fileInfo());
			hw.show();
			return;
		}
		if(speech.contains(Commands.CONSTRUCTOR)) {
			InfoBox.showInfoBox(Commands.CONSTRUCTOR);
			file.addConstructor();
			ShowCodes hw = new ShowCodes(file.fileInfo());
			hw.show();
		}
		if(speech.contains(Commands.DELETE_ALL)) {
			InfoBox.showInfoBox(Commands.DELETE_ALL);
			file.removeClass();
			ShowCodes hw = new ShowCodes("");
			hw.show();
		}
		/*
		if(speech.contains("create a class") || speech.contains("create class")) {
			if(speech.contains("named") || speech.contains("called")) {
				int index1 = speech.indexOf("named");
				int index2 = speech.indexOf("called");
				System.out.print("public class ");
				if(index1 != -1 && index1 + 6 < speech.length())
					System.out.print(speech.substring(index1 + 6));
				if(index2 != -1 && index2 + 6 < speech.length())
					System.out.print(speech.substring(index2 + 6));
				
				System.out.println(" {\n}");
			}
			return;
		}
		if(speech.contains("create a constructor") || speech.contains("create constructor")) {
			if(speech.contains("named") || speech.contains("called")) {
				int index1 = speech.indexOf("named");
				int index2 = speech.indexOf("called");
				System.out.print("public ");
				if(index1 != -1 && index1 + 6 < speech.length())
					System.out.print(speech.substring(index1 + 6));
				if(index2 != -1 && index2 + 6 < speech.length())
					System.out.print(speech.substring(index2 + 6));
				
				System.out.println("() {\n}");
			}
			return;
		}
		if(speech.contains("create a method") || speech.contains("create method")) {
			if(speech.contains("named") || speech.contains("called")) {
				int index1 = speech.indexOf("named");
				int index2 = speech.indexOf("called");
				System.out.print("public ");
				
				if(index1 != -1 && index1 + 6 < speech.length())
					System.out.print(speech.substring(index1 + 6));
				if(index2 != -1 && index2 + 6 < speech.length())
					System.out.print(speech.substring(index2 + 6));
				
				System.out.println("() {\n}");
			}
			return;
		}
		*/
	}
}
