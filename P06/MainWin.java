import shelter.Shelter;
import shelter.Animal;
import shelter.Dog;
import shelter.DogBreed;
import shelter.Lizard;
import shelter.LizardBreed;
import shelter.Gender;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
public class MainWin extends JFrame{
	
	private Shelter shelter = new Shelter("AnimalCompanions");
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
		
		
		quit.addActionListener(event -> onQuitClick());
		newdog.addActionListener(event -> onNewDogClick());
		newlizard.addActionListener(event -> onNewLizardClick());
		about.addActionListener(event -> onAboutClick());
		
		
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
		lizardbutton.addActionListener(event->onNewLizardClick());
		
		
		//dailog box
		data = new JLabel();
		add(data,BorderLayout.CENTER);
		
	}
	public void onNewDogClick(){
		int width = 500;  // Default dialog size
		int height = 200;
		boolean canceled;
		JComboBox breeds;   // Breeds of animals
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
        constraints.gridwidth = 1;   
        constraints.gridheight = 1;  
        constraints.weightx = 1;     
        constraints.weighty = 0;    
        constraints.insets = new Insets(2, 5, 2, 5);  
        constraints.fill= GridBagConstraints.BOTH;    
        constraints.anchor = GridBagConstraints.LINE_START;  
            
        
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
        
        String[] gender_text = {"male", "female"};
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
			String breedtype = breeds.getSelectedItem().toString();
			String gendertype = genders.getSelectedItem().toString();
			shelter.addAnimals(new Dog(DogBreed.valueOf(breedtype),names.getText(),Gender.valueOf(gendertype),(int)ages.getValue()));
            updateDisplay();
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
		//pack();
        //setVisible(true);
	}
	
	public void onNewLizardClick(){
		int width = 500;  // Default dialog size
		int height = 200;
		boolean canceled;
		JComboBox breeds;   // Breeds of animals
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
        GridBagConstraints constraints = new GridBagConstraints(); 
        constraints.gridwidth = 1;   
        constraints.gridheight = 1;  
        constraints.weightx = 1;     
        constraints.weighty = 0;     
        constraints.insets = new Insets(2, 5, 2, 5);  
        constraints.fill= GridBagConstraints.BOTH;    
        constraints.anchor = GridBagConstraints.LINE_START;  
           
        
        
        GridBagConstraints constraintsLabel = (GridBagConstraints) constraints.clone();
        constraintsLabel.weightx = 0;  
        
        // ////////////////////////////////////
        // Breed of animal
        JLabel breed = new JLabel("Breed");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 0;
        box.add(breed, constraintsLabel);                         // Add the button to the JFrame

        String[] options = {"Tuatara", "Chuckwalla", "Komodo", "Gecko", "Agamid", "Armadillo"};
        breeds = new JComboBox<String>(options);
        //breeds.setEditable(true); // Allow custom types to be entered as well
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
        
        String[] gender_text = {"male", "female"};
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
			String breedtype = breeds.getSelectedItem().toString();
			String gendertype = genders.getSelectedItem().toString();
			shelter.addAnimals(new Lizard(LizardBreed.valueOf(breedtype),names.getText(),Gender.valueOf(gendertype),(int)ages.getValue()));
            updateDisplay();
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
		//pack();
        //setVisible(true);
	}
	
	void onQuitClick(){
		System.exit(0);
	}
	
	void onAboutClick(){
		JDialog box = new JDialog();
		box.setTitle("Mav's Animal Shelter Software");
		box.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		box.setLayout(new FlowLayout());
		box.setSize(600,600);  
		
			try{
			BufferedImage myPicture = ImageIO.read(new File("doglizard.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
			box.add(logo);
			}catch(IOException e){}
            
		 JLabel text = new JLabel("<html>"
          + "<p>Version 1.0</p>"
          + "<p>Copyright 2022 by Bipin Shrestha</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Logo by xthedoctorx</p>"
          + "<p><font size=-2>https://animals-riding-animals.tumblr.com/post/165220708256/lizard-riding-dog</font></p>"
          + "<p>Dog icon by Openclipart, licensed under Public domain<p><font size=-2> <https://publicdomainvectors.org/en/free-clipart/Cartoon-dog-vector-image/12091.html></font></p>"
		  + "<p>Lizard icon by webalys, licensed under licensed for personal</p>"
		  + "<p>and commercial purposes with attribution<p><font size=-2> <https://publicdomainvectors.org/en/free-clipart/Cartoon-dog-vector-image/12091.html></font></p>"
          + "<p><font size=-2>https://www.iconfinder.com/icons/4888173/lizard_icon</font></p>"
          + "</html>");
        
        box.add(text);
		box.setVisible(true);
		
	}
	
	void updateDisplay(){
		data.setText("<html>"+shelter.toString().replaceAll("<","&lt;").replaceAll(">","&gt;").replaceAll("\n","<br/>")+"</html>");
	}
}