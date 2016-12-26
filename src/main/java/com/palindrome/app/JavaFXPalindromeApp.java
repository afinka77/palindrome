package com.palindrome.app;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX application
 *  
 * @author Alina Goncarko
 *
 */
public class JavaFXPalindromeApp extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		PalindromeGui palindromeGui = new PalindromeGui(stage);		
	}

}
