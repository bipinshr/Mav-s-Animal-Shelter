import shelter.Shelter;
import shelter.Animal;
import shelter.Dog;
import shelter.DogBreed;
import shelter.Lizard;
import shelter.LizardBreed;
import shelter.Gender;
import java.awt.*;
import javax.swing.*;

public class MainWin extends JFrame{
	
	private Shelter shelter;
	private JLabel data;
	
	public MainWin(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,200);
		
		//------------ This is for menubar ----------- 
		
		JMenuBar menubar = new JMenuBar();
		
		JMenu File = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit");
		
		JMenu Animalmenu = new JMenu("Animal");
		JMenuItem newdog = new JMenuItem("New Dog");
		JMenuItem newlizard = new JMenuItem("New Lizard");
		
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		
		/*
		quit.addActionListener(event -> onQuitClick());
		newdog.addActionListener(event -> onNewDogClick());
		newlizard.addActionListener(event -> onNewLizardClick());
		about.addActionListener(event -> onAboutClick());
		*/
		
		File.add(quit);
		Animalmenu.add(newdog);
		Animalmenu.add(newlizard);
		help.add(about);
		
		menubar.add(File);
		menubar.add(Animalmenu);
		menubar.add(help);
		setJMenuBar(menubar);
		
		//-------- This is for toolbar -----------
		JToolBar toolbar = new JToolBar("Create Animal");
		JButton dogbutton = new JButton(new ImageIcon("dog.png"));
		dogbutton.setActionCommand("Create a new dog");
		dogbutton.setToolTipText("Create a new dog");
		toolbar.add(dogbutton);
		dogbutton.addActionListener(event->onNewDogClick());
		
		JButton lizardbutton = new JButton(new ImageIcon("lizard.png"));
		dogbutton.setActionCommand("Create a new lizard");
		dogbutton.setToolTipText("Create a new lizard");
		toolbar.add(lizardbutton);
		getContentPane().add(toolbar,BorderLayout.PAGE_START);
		//lizardbutton.addActionListener(event->onNewLizardClick());
		
		/*
		dailog box
		textbox = new JLabel();
		add(textbox,BorderLayout.CENTER);
		*/
	}
	public void onNewDogClick(){
		int width = 500;  // Default dialog size
		int height = 200;
		boolean canceled;
		JComboBox breeds;   // Types of animals
        JTextField names;  // Name of new animal
		JComboBox genders; // Gender of new animal
		JSpinner ages;
		canceled = true;
		
		// Create a dialog box
		JDialog box = new JDialog();
		box.setTitle("New Dog");
		box.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		box.setSize(width,height);  
		
		box.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints(); // Specify cell for widgets
        constraints.gridwidth = 1;   // 1 cell wide
        constraints.gridheight = 1;  // 1 cell high
        constraints.weightx = 1;     // Resize data controls in width as window resizes
        constraints.weighty = 0;     // Do NOT resize in height as window resizes
        constraints.insets = new Insets(2, 5, 2, 5);  // Pixel spacing above, left, below, and right
        constraints.fill= GridBagConstraints.BOTH;    // Resize widget to fill the cell - options:
            // NONE (the default), HORIZONTAL (width only), VERTICAL (height only), or BOTH
        constraints.anchor = GridBagConstraints.LINE_START;  // Position widget center left in cell - options:
            // FIRST_LINE_START   PAGE_START   FIRST_LINE_END
            // LINE_START           CENTER	         LINE_END
            // LAST_LINE_START     PAGE_END     LAST_LINE_END
        
        // Configure GridBagLayout constraints for the left (labels) column
        GridBagConstraints constraintsLabel = (GridBagConstraints) constraints.clone(); // Duplicate constraints
        constraintsLabel.weightx = 0;  // Do NOT resize the label column in width as window resizes
        
        // ////////////////////////////////////
        // Breed of animal
        JLabel breed = new JLabel("Breed");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 0;
        box.add(breed, constraintsLabel);                         // Add the button to the JFrame

        String[] options = {"Beagle", "Poodle", "Dobermann", "Bulldog", "Boxer", "Labrador", "Mastiff"};
        breeds = new JComboBox<String>(options);
        breeds.setEditable(true); // Allow custom types to be entered as well
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weighty = 0;
        box.add(breeds, constraints);
		box.setVisible(true);
		
		// Name of animal
        JLabel name = new JLabel("Name");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 1;
        box.add(name, constraintsLabel);
        
        names = new JTextField(20); 
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weighty = 0;    
        box.add(names, constraints);
		
		 // Gender of animal
        JLabel gender = new JLabel("Gender");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 2;
        box.add(gender, constraintsLabel);
        
        String[] gender_text = {"Male", "Female"};
        genders = new JComboBox<String>(gender_text);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weighty = 0;
        box.add(genders, constraints);
		
		// age of animal
		JLabel age = new JLabel("Age");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 3;
        box.add(age, constraintsLabel);
        
        SpinnerModel range = new SpinnerNumberModel(0, 0, 25, 1);
        ages = new JSpinner(range);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weighty = 0;
        box.add(ages, constraints);
		
		 
		
		
		
		// Add OK and Cancel buttons
        JPanel panel = new JPanel();
        
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> {
            //canceled = false;   // This accepts the data below
            box.setVisible(false);  // Hide dialog but keep it to get the entered data!
        });
        panel.add(ok);
        
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(event -> {
            //canceled = true;    // Ignore the data below - the user clicked Cancel
            box.setVisible(false);
        });
        panel.add(cancel);
        
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;   // The buttons on the panel span the entire dialog
        constraints.anchor = GridBagConstraints.CENTER;    // Center the buttons
        box.add(panel, constraints);
		
        
     
	}
}