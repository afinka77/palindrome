package com.palindrome.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Class creating GUI interface using JavaFX
 *  
 * @author Alina Goncarko
 *
 */
public class PalindromeGui {


	/* Basic GUI components */
	private Stage stage;
	private Scene scene;
	private Group root = new Group();
	private GridPane grid = new GridPane();
	private TextArea textArea = new TextArea();
	private Button buttonCheck = new Button("Check Palindrome");

	public PalindromeGui(Stage pStage) {
		this.stage = pStage;
		drawGUI();
	}

	/**
	 * Draws desktop application window
	 */
	private void drawGUI() {
		setUpGrid();
		addComponents();
		completeAndShowStage();
	}

	/**
	 * Adding UI components - text field, button
	 */
	private void addComponents() {
		Label labelTextField = new Label("Enter text:");
		labelTextField.setTextFill(Color.WHITE);
		grid.add(labelTextField, 0, 5);

		textArea.setPromptText("Enter text");
		textArea.setPrefColumnCount(50);
		textArea.setPrefRowCount(10);
		textArea.setWrapText(true);
		grid.add(textArea, 1, 5);

		buttonCheck.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String text = textArea.getText();
				if (Palindrome.isTextEmpty(text)) {
					showPopup("You should enter a text fist.");
				} else if (!Palindrome.isTextValid(text)){
					showPopup("Only latin letters and symbols \"!.,-:;\"?()\" are allowed");
				} else if (Palindrome.isTextPalindrome(text)) {
					showPopup("Congratulations! It's a palindrome!");
				} else {
					showPopup("Sorry, it's not a palindrome :(");
				}
			}
		});
		buttonCheck.setStyle("-fx-font: 14 arial; -fx-base: #b6e7c9;");
		grid.add(buttonCheck, 1, 7);

	}

	/**
	 * Setting up GUI grid
	 */
	private void setUpGrid() {
		scene = new Scene(root, 700, 300, Color.BLACK);

		stage.initStyle(StageStyle.UTILITY);
		stage.setResizable(false);

		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(5, 5, 5, 5));
	}

	/**
	 * Completes and shows up GUI window
	 */
	private void completeAndShowStage() {
		BorderPane borderLayout = new BorderPane();
		borderLayout.setPadding(new Insets(0, 0, 0, 5));
		borderLayout.setCenter(grid);

		stage.setTitle("Palindrome");
		scene.setRoot(borderLayout);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Shows popup with provided text
	 * 
	 * @param pText
	 *            - popup output text
	 */
	private void showPopup(String pText) {
		final Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.initOwner(stage);
		VBox dialogVbox = new VBox(20);
		Text text = new Text(pText);
		text.setStyle("-fx-font: 14 arial;");
		dialogVbox.getChildren().add(text);
		Scene dialogScene = new Scene(dialogVbox, 400, 50);
		dialog.setScene(dialogScene);
		dialog.show();
	}
}
