
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import javafx.stage.FileChooser;

import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.*;

import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.event.ActionEvent;
import java.util.Scanner;
import javafx.scene.text.Text;
/**
 * 'TextEditor.fxml' Controller Class
 * Controller for the button Effects within the text Editor
 * Author: Blaine Jacques
 */
public class TextEditorController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="file"
    private Menu file; // Value injected by FXMLLoader

    @FXML // fx:id="newFileMenu"
    private MenuItem newFileMenu; // Value injected by FXMLLoader

    @FXML // fx:id="openFileMenu"
    private MenuItem openFileMenu; // Value injected by FXMLLoader

    @FXML // fx:id="saveFileMenu"
    private MenuItem saveFileMenu; // Value injected by FXMLLoader

    @FXML // fx:id="saveAsFileMenu"
    private MenuItem saveAsFileMenu; // Value injected by FXMLLoader

    @FXML // fx:id="exitFileMenu"
    private MenuItem exitFileMenu; // Value injected by FXMLLoader

    @FXML // fx:id="textMenu"
    private Menu textMenu; // Value injected by FXMLLoader

    @FXML // fx:id="chgTextMono"
    private RadioButton chgTextMono; // Value injected by FXMLLoader

    @FXML // fx:id="chgTextSerif"
    private RadioButton chgTextSerif; // Value injected by FXMLLoader

    @FXML // fx:id="chgText"
    private ToggleGroup chgText; // Value injected by FXMLLoader

    @FXML // fx:id="chgTextSansSerif"
    private RadioButton chgTextSansSerif; // Value injected by FXMLLoader

    @FXML // fx:id="chgTextItalic"
    private CheckBox chgTextItalic; // Value injected by FXMLLoader

    @FXML // fx:id="chgTextBold"
    private CheckBox chgTextBold; // Value injected by FXMLLoader

    @FXML // fx:id="textArea"
    private TextArea textArea; // Value injected by FXMLLoader

	
	private String content;//String to hold the users text
    private String fontName;//holds the users font style
    private String fileName;//holds the filename
	private File fileToSave;//holds the fileToSave
	
	/**
     * exit Program ends the application 
	 * 
     * @param event fires when the exit is selected in the file menu
     */
    @FXML
    void exitProgram(ActionEvent event) 
	{
		System.exit(0);
    }
	/**
     *font Style sets the font to be a font style and sets the text
	 * to be bold or italic
     * @param event fires when the font Style is selected
     */
    @FXML
    void fontStyleListener(ActionEvent event) 
	{
		
		//if both bold and Italic are selected
		if(chgTextBold.isSelected() && chgTextItalic.isSelected())
		{
			
			if (chgTextSerif.isSelected())
			{	
				textArea.setFont(font("Serif",  FontWeight.BOLD,
									FontPosture.ITALIC, 12));
		
			}
			if (chgTextSansSerif.isSelected())
			{
				
				textArea.setFont(font("SansSerif",  FontWeight.BOLD,
									FontPosture.ITALIC, 12));
			}
			if (chgTextMono.isSelected())
			{
				
				textArea.setFont(font("Monospaced", FontWeight.BOLD,
									FontPosture.ITALIC, 12));
									
			}	
		} //if only bold is selected 
		else if(chgTextBold.isSelected())
		{
			
			if (chgTextSerif.isSelected())
			{	
				
				textArea.setFont(font("Serif", FontWeight.BOLD, 12));
				
			}
			if (chgTextSansSerif.isSelected())
			{
				
				textArea.setFont(font("SansSerif", FontWeight.BOLD, 12));
			}
			if (chgTextMono.isSelected())
			{
				
				textArea.setFont(font("Monospaced", FontWeight.BOLD, 12));
				
			}
			
		} //if only italic is selected
		else if (chgTextItalic.isSelected())
		{

			
			if (chgTextSerif.isSelected())
			{	
				
				textArea.setFont(font("Serif", FontPosture.ITALIC, 12));
				
			}
			if (chgTextSansSerif.isSelected())
			{
				
				textArea.setFont(font("SansSerif", FontPosture.ITALIC, 12));
				
				
			}
			if (chgTextMono.isSelected())
			{
				
				textArea.setFont(font("Monospaced", FontPosture.ITALIC, 12));
				
				
			}
		} //else case is if there is only a font family button checked
		else
		{
			if (chgTextSerif.isSelected())
			{	
				//textArea.setFont(font("Serif", 12));
				textArea.setFont(font(java.awt.Font.SERIF, 12));
			}
			if (chgTextSansSerif.isSelected())
			{
				//textArea.setFont(font("SansSerif", 12));
				textArea.setFont(font(java.awt.Font.SANS_SERIF, 12));
			}
			if (chgTextMono.isSelected())
			{
				//textArea.setFont(font("Monospaced", 12));
				//fontName = "Monospaced";
				textArea.setFont(font(java.awt.Font.MONOSPACED, 12));
			}
			
		}
		
    }
	/**
     * The newFile sets clears the text in the textArea. 
	 * The class's filename is also set to null.
     * @param event fires when the newFile listeners sends an event
     */
    @FXML
    void newFileMenuListener(ActionEvent event) 
	{
		textArea.clear();
		fileName = null;
    }
	/**
     * Open file Menu opens a chooser dialog box so you 
	 * can select it and have read into the textArea. It will append it to 
	 * whatever is already in the textArea
     * @param event fires when you choose the openfile button
     */
    @FXML
    void openFileMenu(ActionEvent event) throws IOException
	{
		//open Dialog to let the user choose a file
		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);
		
		
		if(selectedFile != null)
		{
			
			fileName = selectedFile.getPath();
			
			try
			{
				
				File file = new File(fileName);
				Scanner scanFile = new Scanner(file);
				String content = "";
				//read the file and set into the text area
				while(scanFile.hasNext())
				{
					content += scanFile.nextLine();
					content += "\n";
				}
			
				textArea.setText(content);
			}
			catch(Exception e)
			{
				System.out.println("Error");
			}
			
		}
    }
	/**
     *  When you choose to save a file and and the file is new, 
	 *  it will call the SaveFileAsMenu since it performs the same function
	 *  otherwise it will save your file
     * @param event fires you choose to save a file
     */	
    @FXML
    void saveFileMenu(ActionEvent event) throws IOException
	{
		if(fileName == null)
		{
			//would be duplicate code as the saveAs, so we call save as
			//to do the work since the user hasn't given this a filename
			//yet
			saveFileAsMenu(event);

		}
		else
		{
			

			File file = new File(fileName);
			//write to the file
			try
			{
				FileWriter fWriter = new FileWriter(file);
				PrintWriter outputFile = new PrintWriter(fWriter);
				outputFile.println(textArea.getText());
				outputFile.close();
			}
			catch(Exception e)
			{
				System.out.println("Error");
			}
				
		}
	}
	/**
     * Save file as saves a new file and writes the content in the 
	 * text area to the file. The logic if you really want to 
	 * 
     * @param event fires you want to save a file as a specific name
     */
    @FXML
    void saveFileAsMenu(ActionEvent event) throws IOException
	{
		if(fileName == null)
		{
			//open Dialog to let the user choose a file/select
			FileChooser fileChooser = new FileChooser();
			File selectedFile = fileChooser.showSaveDialog(null);
			String content = textArea.getText();
			String fileName = selectedFile.getPath();
			try
			{	//write
				PrintWriter writeTofile = new PrintWriter(fileName);
				writeTofile.println(content);
				writeTofile.close();
			}
			catch(Exception e)
			{
				System.out.println("Error");
			}
			
		}
		else
		{
			//open Dialog to let the user choose a file/select
			FileChooser fileChooser = new FileChooser();
			
			File selectedFile = fileChooser.showSaveDialog(null);
			String saveAs = selectedFile.getPath();
			
			//Need to get the previous fileName and make a new file object
			File previousFile = new File(fileName);
			File saveAsFile = new File(saveAs);
			
			//use the renameTo for the previous file to assign a new path name
			previousFile.renameTo(saveAsFile);
			
			String content = textArea.getText();
			//get the the content from the text area and write to the Save As
			//file
			textArea.setText(content);
			PrintWriter writeTofile = new PrintWriter(saveAsFile);
			writeTofile.println(content);
			writeTofile.close();
		}
		
    }
		
    

   
}
