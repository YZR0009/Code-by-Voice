package model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import UI.AlertBox;
import UI.InfoBox;
import command.Commands;
import command.Decision;
import component.Code;
import component.File;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import helloworldplugin.handlers.SpeechHandler;

public class SpeechRecognition {

	// EnglishNumberToWords
	//EnglishNumberToString	numberToString	= new EnglishNumberToString();
	//EnglishStringToNumber	stringToNumber	= new EnglishStringToNumber();

	// Logger
	private Logger logger = Logger.getLogger(getClass().getName());
	private File file = new File();

	// Variables
	private String result;
	private boolean isPause = false;

	// Threads
	Thread	speechThread;
	Thread	resourcesThread;

	// LiveRecognizer
	private LiveSpeechRecognizer recognizer;

	/**
	 * Constructor
	 */
	public SpeechRecognition() {

		// Loading Message
		logger.log(Level.INFO, "Loading..\n");

		// Configuration
		Configuration configuration = new Configuration();

		// Load model from the jar
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");

		// if you want to use LanguageModelPath disable the 3 lines after which
		// are setting a custom grammar->

		// configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin")

		// Grammar
		configuration.setGrammarPath("resource:/grammars");
		configuration.setGrammarName("grammar");
		configuration.setUseGrammar(true);

		try {
			recognizer = new LiveSpeechRecognizer(configuration);
		} catch (IOException ex) {
			logger.log(Level.SEVERE, null, ex);
		}

		// Start recognition process pruning previously cached data.
		recognizer.startRecognition(true);

		// Start the Thread
		startSpeechThread();
		startResourcesThread();
	}

	/**
	 * Starting the main Thread of speech recognition
	 */
	protected void startSpeechThread() {

		// alive?
		if (speechThread != null && speechThread.isAlive())
			return;

		// initialize
		speechThread = new Thread(() -> {
			logger.log(Level.INFO, "You can start to speak...\n");
			try {
				while (true) {
					/*
					 * This method will return when the end of speech is
					 * reached. Note that the end pointer will determine the end
					 * of speech.
					 */
					SpeechResult speechResult = recognizer.getResult();
					if (speechResult != null) {

						result = speechResult.getHypothesis();
						
						//Yunfan
						if(result.contains("wake up"))
							isPause = false;
						if(result.contains("sleep"))
							isPause = true;
						if(!isPause)
							makeDecision(result);
						// logger.log(Level.INFO, "You said: " + result + "\n")

					} else
						logger.log(Level.INFO, "I can't understand what you said.\n");

				}
			} catch (Exception ex) {
				logger.log(Level.WARNING, null, ex);
			}

			logger.log(Level.INFO, "SpeechThread has exited...");
		});

		// Start
		speechThread.start();

	}

	/**
	 * Starting a Thread that checks if the resources needed to the
	 * SpeechRecognition library are available
	 */
	protected void startResourcesThread() {

		// alive?
		if (resourcesThread != null && resourcesThread.isAlive())
			return;
        
		resourcesThread = new Thread(() -> {
			try {

				// Detect if the microphone is available
				while (true) {
					if (AudioSystem.isLineSupported(Port.Info.MICROPHONE)) {
						// logger.log(Level.INFO, "Microphone is available.\n")
					} else {
						// logger.log(Level.INFO, "Microphone is not
						// available.\n")
					}

					// Sleep some period
					Thread.sleep(350);
				}

			} catch (InterruptedException ex) {
				logger.log(Level.WARNING, null, ex);
				resourcesThread.interrupt();
			}
		});
		

		// Start
		resourcesThread.start();
	}

	//Yunfan
	/**
	 * Takes a decision based on the given result
	 */
	public void makeDecision(String speech) {
		
		Decision.makeDecision(speech, file);
		/*System.out.println("You said: " + speech + "\n");
		if(speech.contains(Commands.helloWorld)) {
			InfoBox.showInfoBox(Commands.helloWorld);
			//ShowCodes hw = new ShowCodes(Code.helloWorldCode());
			file.addhelloWorld();
			ShowCodes hw = new ShowCodes(file.fileInfo());
			hw.show();
			return;
		}
		if(speech.contains(Commands.exampleClass)) {
			InfoBox.showInfoBox(Commands.exampleClass);
			//ShowCodes hw = new ShowCodes(Code.helloWorldCode());
			file.addhelloWorld();
			ShowCodes hw = new ShowCodes(file.fileInfo());
			hw.show();
			return;
		}
		if(speech.contains(Commands.mainMethod)) {
			InfoBox.showInfoBox(Commands.mainMethod);
			//ShowCodes hw = new ShowCodes(Code.mainMethodCode());
			file.addmainMethod();
			ShowCodes hw = new ShowCodes(file.fileInfo());
			hw.show();
			return;
		}
		if(speech.contains(Commands.toString)) {
			InfoBox.showInfoBox(Commands.toString);
			//ShowCodes hw = new ShowCodes(Code.toStringCode());
			file.addtoString();
			ShowCodes hw = new ShowCodes(file.fileInfo());
			hw.show();
			return;
		}*/
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

	/**
	 * Java Main Application Method
	 * 
	 * @param args
	 */
	//public static void main(String[] args) {

		// // Be sure that the user can't start this application by not giving
		// the
		// // correct entry string
		// if (args.length == 1 && "SPEECH".equalsIgnoreCase(args[0]))
		//new Main();
		// else
		// Logger.getLogger(Main.class.getName()).log(Level.WARNING, "Give me
		// the correct entry string..");

	//}

}