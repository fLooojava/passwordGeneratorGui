//mf

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
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


public class GUIGen extends JFrame 
{
	private JTextArea textarea = new JTextArea(5,25);
	//private JLabel jlblStatus = new JLabel();
	private int length;
	public GUIGen ()
	   {
		   JFrame frame = new JFrame("password generator");
	       frame.setSize(600,200);
	      
	       frame.setLocation(300,300);
	       frame.setResizable(false);
	       FlowLayout flowlayout = new FlowLayout();
	       frame.setLayout(flowlayout);
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	       JPanel panel = new JPanel();
	       JLabel lblpw = new JLabel("length of your password : ");
	       JLabel lblcountpw = new JLabel ("passwords to create : ");
	       JPanel panel1 = new JPanel();
	       
	       
	        final JTextField tfieldlength = new JTextField();
	        tfieldlength.setColumns(2);
	        JTextField tfieldcount = new JTextField();
	        tfieldcount.setColumns(2);
	       // private JTextArea textarea = new JTextArea(5,25);
	        JScrollPane sp = new JScrollPane(textarea);
	        textarea.setBackground(Color.LIGHT_GRAY);
	        textarea.setEditable(false);
	        
	        textarea.setLineWrap(true);
	        textarea.setWrapStyleWord(true);
	        
	        final JTextArea textareaedit = new JTextArea(5,25);
	        JScrollPane spe = new JScrollPane(textareaedit);

	        textareaedit.setEditable(true);
	        textarea.setLineWrap(true);
	        textarea.setWrapStyleWord(true);
	        

	       final JButton btngenpw = new JButton("generate pw");
	       
	       // ComboBox
	       String comboBoxlist[] = {"1","2","3",
	    		   					"4","5","6",
	    		   					"7","8","9",
	       							"10"};
	       final JComboBox dropdownlist = new JComboBox(comboBoxlist);
	       
	      
	       
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
	        
	 
	       
	       panel.add(lblcountpw);
	       panel.add(dropdownlist);
	       panel.add(lblpw);
	       panel.add(tfieldlength);
	       
	       panel.add(btngenpw);

	       
	       frame.add(panel);
	       frame.add(panel1);

	       frame.add(sp);
	       frame.add(spe);
	     //  frame.add(jlblStatus);
	  
	       frame.setVisible(true);
	       
	       quit.addActionListener ( new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
	    		  System.exit(0);
	    	  }
	    	   
	       });
	       
	       save.addActionListener(new ActionListener(){
	    	   
	       
	    	   public void actionPerformed(ActionEvent e){
	    		   save();
	    	   
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
  					// System.out.println(e);
  					//System.out.println(dropdownlist.getSelectedIndex());
  					
  					int count = dropdownlist.getSelectedIndex()+1;
  		            String input = tfieldlength.getText();
  		 	        int length = Integer.parseInt(input);
  		 	      
  		 	        
  		 	        
  		 	       CreatePassword createpw= new CreatePassword();
  		 	       int i=1;
  		 	       
  		 	       textarea.setText("");
  		 	       textareaedit.setText("");
  		 	       do{
  		 	       textareaedit.append("password "+i+" is for: \n");
  		 	       textareaedit.setCaretPosition(0);
  		 		   textarea.append("Your new password:\n"+createpw.generateRandomCode(length)+"\n"+"----------------------------------\n"+"Created from: "+ System.getProperty("user.name")+"\n"+"Operating System: "+ System.getProperty("os.name")+"\n\n");
  		 		   textarea.setCaretPosition(0);
  		 		   i++;
  		 	       //System.out.println("laufende variable"+i);
  		 	       //System.out.println("dropdown ausgewählt: " +count);
  		 	       }while(i<=count);
  		 		
  		 	       }
  			
  			
  		 });
	       
	   }
	  private JFileChooser jFileChooser = new JFileChooser();
	  private void save(){
	    if (jFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
	      save(jFileChooser.getSelectedFile());
	    }
	  }
	 
	  private void save(File file){
	    try{
	      BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
	      byte []  b = (textarea.getText()).getBytes();
	      
	      out.write(b, 0, b.length);
	      out.close();
	 
	      //jlblStatus.setText(file.getName() + " saved ");
	    }
	 
	    catch (IOException ex){
	      //jlblStatus.setText("Error saving " + file.getName());
	    }
	       
	       
	  }
	      
	    
	  
	}
