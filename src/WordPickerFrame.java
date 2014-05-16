/**
 * French Conjugation Project
 *
 * WordPickerFrame.java
 *
 * This class is the interface for the WordPicker
 * class. It will allow for a person to generate
 * a new word pair on screen and generate each
 * word individually. The user can also type an
 * answer and check if it is correct.
 *
 * @author Steve O'Keefe
 */

// Import classes
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JComboBox;

public class WordPickerFrame extends JFrame{

	// Variables
	static WordPickerFrame wordPicker;
	private JLabel word1 = new JLabel("");
	private JLabel word2 = new JLabel("");
	private JLabel status = new JLabel("");
	private JTextField answer;// = new JTextField("");
	private JButton gen, genX, genY, check, show;
	private JPanel mainPan = new JPanel();
	private JComboBox drop;
	private Dimension size;
	private Border border = BorderFactory.createLoweredBevelBorder();
	private WordPicker pair;
	private String[] lists = {"Irregular", "Regular"};
	
	// Constructor
	public WordPickerFrame(){
		super("French Conjugation Generator");
		size = new Dimension(600, 300);
		setSize(size);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addComponents();
		add(mainPan);
		pair = new WordPicker();
	}
	
	/**
	 * This will piece together the different
	 * elements to create the interface.
	 */
	public void addComponents(){
		// Set layout
		mainPan.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (true){
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		
		// Add drop down list
		createDropList();
		c.fill = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		mainPan.add(drop, c);
		
		// Add "Generate Phrase" button
		createGenButton();
		gen.setPreferredSize(new Dimension(500, 40));
		c.fill = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.insets = new Insets(10, 0, 0, 0);
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		mainPan.add(gen, c);
		
		// Add word1 label
		word1.setOpaque(true);
		word1.setBackground(Color.white);
		word1.setBorder(border);
		word1.setPreferredSize(new Dimension(100, 40));
		c.fill = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		mainPan.add(word1, c);
		
		// Add word2 label
		word2.setOpaque(true);
		word2.setBackground(Color.white);
		word2.setBorder(border);
		word2.setPreferredSize(new Dimension(100, 40));
		c.gridx = 1;
		mainPan.add(word2, c);
		
		// Add answer textfield
		createEnterAction();
		answer.setColumns(20);
		c.gridx = 2;
		mainPan.add(answer, c);
		
		// Add generate word1 button
		createGenXButton();
		c.gridx = 0;
		c.gridy = 3;
		mainPan.add(genX, c);
		
		// Add generate word2 button
		createGenYButton();
		c.gridx = 1;
		mainPan.add(genY, c);
		
		// Add check answer button
		createCheckButton();
		c.gridx = 2;
		mainPan.add(check, c);
		
		// Add status label
		status.setOpaque(true);
		status.setBackground(Color.white);
		status.setBorder(border);
		status.setPreferredSize(new Dimension(50, 40));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 4;
		mainPan.add(status, c);
		
		// Add show answer button
		createShowButton();
		c.gridx = 0;
		c.gridy = 5;
		mainPan.add(show, c);
	}
	
	/**
	 * Creates and returns the Generate Phrase
	 * button and associated action listener
	 * while resetting the status jlabel and
	 * answer jtextfield.
	 */
	public JButton createGenButton(){
		gen = new JButton("Generate Phrase");
		class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				status.setText("");
				answer.setText("");
				String[] words = (pair.wordPair()).split("-");
				word1.setText(words[0]);
				word2.setText(words[1]);
			}
		}
		ActionListener listener = new ButtonListener();
		gen.addActionListener(listener);
		return gen;
	}
	
	/**
	 * Creates and returns the Generate word1
	 * button and associated action listener
	 * while resetting the status jlabel and
	 * answer jtextfield.
	 */
	public JButton createGenXButton(){
		genX = new JButton("Generate");
		class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				status.setText("");
				answer.setText("");
				String wordX = pair.wordX();
				word1.setText(wordX);
			}
		}
		ActionListener listener = new ButtonListener();
		genX.addActionListener(listener);
		return genX;
	}
	
	/**
	 * Creates and returns the Generate word2
	 * button and associated action listener
	 * while resetting the status jlabel and
	 * answer jtextfield.
	 */
	public JButton createGenYButton(){
		genY = new JButton("Generate");
		class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				status.setText("");
				answer.setText("");
				String wordY = pair.wordY();
				word2.setText(wordY);
			}
		}
		ActionListener listener = new ButtonListener();
		genY.addActionListener(listener);
		return genY;
	}
	
	/**
	 * Creates and returns the check answer
	 * button and associated action listener.
	 */
	public JButton createCheckButton(){
		check = new JButton("Check");
		class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				String an = answer.getText();
				if (an.equalsIgnoreCase(pair.getAnswer())){
					status.setText("Correct");
				}
				else {
					status.setText("Incorrect");
				}
			}
		}
		ActionListener listener = new ButtonListener();
		check.addActionListener(listener);
		return check;
	}
	
	/**
	 * Creates and returns the show answer
	 * button and associated action listener.
	 */
	public JButton createShowButton(){
		show = new JButton("Show Answer");
		class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				status.setText(pair.getAnswer());
			}
		}
		ActionListener listener = new ButtonListener();
		show.addActionListener(listener);
		return show;
	}

	public JTextField createEnterAction(){
		answer = new JTextField("");
		class KeyListener implements ActionListener{
			public void actionPerformed(ActionEvent ae){
					String an = answer.getText();
					if (an.equalsIgnoreCase(pair.getAnswer())){
						status.setText("Correct");
					}
					else {
						status.setText("Incorrect");
					}
			}
		}
		ActionListener listener = new KeyListener();
		answer.addActionListener(listener);
		return answer;
	}
	
	public JComboBox createDropList(){
		drop = new JComboBox(lists);
		class DropListener implements ActionListener{
			public void actionPerformed(ActionEvent ae){
				JComboBox cb = (JComboBox)ae.getSource();
				String selected = (String)cb.getSelectedItem();
				if (selected.equalsIgnoreCase(drop.getItemAt(0).toString())){
					word1.setText("");
					word2.setText("");
					answer.setText("");
					status.setText("Loaded Irregular List");
					pair.loadWords("irr");
				}
				else if (selected.equalsIgnoreCase(drop.getItemAt(1).toString())){
					word1.setText("");
					word2.setText("");
					answer.setText("");
					status.setText("Loaded Regular List");
					pair.loadWords("reg");
				}
			}
		}
		ActionListener listener = new DropListener();
		drop.addActionListener(listener);
		return drop;
	}
	
	// Main Class that runs the interface
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){wordPicker = new WordPickerFrame();}
		});
	}
}
