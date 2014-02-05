

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;


public class GUIGen extends JFrame 
{

	private int length;
	public GUIGen ()
	   {
		   JFrame frame = new JFrame("password generator");
	       frame.setSize(500,200);
	       frame.setLocation(300,300);
	       frame.setResizable(false);
	       FlowLayout flowlayout = new FlowLayout();
	       frame.setLayout(flowlayout);
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	       JPanel panel = new JPanel();
	       JLabel lblpw = new JLabel("length of your password : ");
	       JPanel panel1 = new JPanel();

           
	        final JTextField tfieldlength = new JTextField(5);
	        tfieldlength.setColumns(2);
	        final JTextArea textarea = new JTextArea(5,25);
	        JScrollPane sp = new JScrollPane(textarea);
	        textarea.setBackground(Color.LIGHT_GRAY);
	        textarea.setEditable(false);
	        textarea.setLineWrap(true);
	        textarea.setWrapStyleWord(true);
	        

	       JButton btngenpw = new JButton("generate pw");
	       
	       // menubar
	       
	       	JMenuBar menubar = new JMenuBar();
	       	menubar.setBackground(Color.getHSBColor(60,60, 60));
	        JMenu file = new JMenu ("File");
	        
	        JMenu help = new JMenu ("Help");
	        menubar.add(file);
	        menubar.add(help);
	        
	        JMenuItem save = new JMenuItem("Save");
	        save.setBackground(Color.getHSBColor(60,60, 60));
	        JMenuItem print = new JMenuItem("Print");
	        print.setBackground(Color.getHSBColor(60,60, 60));
	        JMenuItem quit = new JMenuItem("Quit");
	        quit.setBackground(Color.getHSBColor(60,60, 60));
	        JMenuItem about = new JMenuItem("About");
	        about.setBackground(Color.getHSBColor(60,60, 60));
	        
	        file.add(save);
	        file.add(print);
	        file.add(quit);
	        help.add(about);
	        
	        frame.setJMenuBar(menubar);
	       //
	       
	       
	       panel.add(lblpw);
	       panel.add(tfieldlength);
	       
	       panel.add(btngenpw);
	       
	       frame.add(panel);
	       frame.add(panel1);
	       frame.add(sp);
	  
	       frame.setVisible(true);
	       
	       quit.addActionListener ( new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
	    		  System.exit(0);
	    	  }
	    	   
	       });
	       

	       about.addActionListener ( new ActionListener(){
	    	   
	    	   public void actionPerformed(ActionEvent e){
	    		   JFrame frame = new JFrame("About");
	    		  
	    		   JOptionPane aboutmsg = new JOptionPane();
	    		   aboutmsg.showMessageDialog(frame,"V0.1 \n It's possibly to create a random password. \n +implemented a menubar \n \n proposed updates:\n" +
	    		   		"-add some variable informations next to the password (for different accounts)\n" +
	    		   		"-more than one password with one click\n" +
	    		   		"-implement a save function\n" +
	    		   		"-implement a print function");	    
	    		  
	    	   }
	       });
	       
	       btngenpw.addActionListener (new ActionListener() {
	       
	    
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 textarea.copy();
		            String input = tfieldlength.getText();
		 	        int length = Integer.parseInt(input);
		 	        
		 	        // hier muss das code generieren erfolgen
		 	       CreatePassword createpw= new CreatePassword();
		 		   textarea.setText("Your new password:\n"+ createpw.generateRandomCode(length)+"\n"+"----------------------------------\n"+"Created from: "+ System.getProperty("user.name")+"\n"+"Operating System: "+ System.getProperty("os.name"));
		 		  textarea.copy();
		 		
				}
			
			
		 });

	       
	       
	   		
	      
	      
	   }
	}
