package org.mgnrega.framedesign;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BdoSearchProject extends JFrame
{
	 private static final long serialVersionUID = 1L;
	 private JLabel l1,l2;
	 private JTextField tpid;
	 private JButton submit;
	private Scanner sc12;
	 
	 protected BdoSearchProject()
	  {
		  super("Project Search Window For BDO");
	  
		    Container c=getContentPane();
		    c.setLayout(new GridLayout(2,2));
            c.setBackground(Color.LIGHT_GRAY);
		    tpid=new JTextField(20);
		    tpid.addFocusListener( new FocusAdapter() 
	          {
	             public void focusGained(FocusEvent e)
	             {
	                     tpid.setBackground(Color.WHITE);
	             }
	          }
	        );
		    
		    
			   submit=new JButton("Submit");
			   submit.addActionListener((e) ->
				{
					boolean isdatavalidate=dataValidation();
		  			   if(isdatavalidate)
		  			   {	
		  				   int index=getSearchIndex();
		  				   if(index>=0)
		  				   {     
		  					   JOptionPane.showMessageDialog(this,"Project Successfully Found.");
		  					   new BdoDisplaySearchedProject(index);
		  				   }
		  				   if(index==-1)
		  					   JOptionPane.showMessageDialog(this,"Project not Found.");
		  				   if(index==-2)
		  					   JOptionPane.showMessageDialog(this,"Projects.dat file does not exist.");
		  				   /* else
						   	JOptionPane.showMessageDialog(this,"Unknown ERROR!!");*/
		  			   }
				}
				);	
                Font f1=new Font("Aerial",Font.BOLD,14);
				l1=new JLabel("Enter Project_ID");
				l1.setFont(f1);
				l1.setForeground(Color.RED);
				
			    l2=new JLabel("Submit");
				l2.setFont(f1);
				l2.setForeground(Color.RED);
				

				c.add(l1);c.add(tpid);
				
				c.add(l2);c.add(submit);
				    
				
				 setSize(350, 100);
				 setLocation(200,200);
				 setResizable(false);
				 setVisible(true);	
	 }
	 
	 private int getSearchIndex()
	 {
		   String pid=tpid.getText().trim();
		   return (Bdo.searchProject(pid));
	 }
	 
	 public boolean dataValidation()
	   {
		   boolean pidvalidation = pidCheck();
		   
		   if (pidvalidation)
			   return true;
		   
		   return false;
	   }
	 
	 public boolean pidCheck()
	   {
		  boolean pidvalid = true;
	      String pidpattern = "^PRJ";
	    	
	      sc12 = new Scanner(tpid.getText().trim());
	    	
	      String match = sc12.findInLine(pidpattern);
	    	
	      if (match == null)
	      {
	    	  JOptionPane.showMessageDialog(this, "Invalid Project ID..Please Enter Another ID");
	    	  tpid.setText("");
	    	  tpid.setBackground(Color.RED);
	       	  pidvalid = false;
	      }
	      return pidvalid;
	   }
}
