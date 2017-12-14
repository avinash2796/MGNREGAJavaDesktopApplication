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

public class BdoSearchGpm extends JFrame
{
	 private static final long serialVersionUID = 1L;
	 private JLabel l1,l2;
	 private JTextField tgid;
	 private JButton submit;
	private Scanner sc1;
	 
	 protected BdoSearchGpm()
	  {
		  super("GPM Search Window For BDO");
	  
		    Container c=getContentPane();
		    c.setLayout(new GridLayout(2,2));
            c.setBackground(Color.GREEN);
		    tgid=new JTextField(20);
		    tgid.addFocusListener( new FocusAdapter() 
	          {
	             public void focusGained(FocusEvent e)
	             {
	                     tgid.setBackground(Color.WHITE);
	             }
	          }
	        );
		    
			   submit=new JButton("Submit");
			   submit.addActionListener((e) ->
				{
					boolean isdatavalidate=dataValidation();
		  			   if(isdatavalidate)
		  			   {	 
		  				   int index=getgSearchIndex();
		  				   if(index>=0)
		  				   {     
		  					   JOptionPane.showMessageDialog(this,"Member Successfully Found.");
		  					   new BdoDisplaySearchedGPM(index);
		  				   }
		  				   if(index==-1)
		  					   JOptionPane.showMessageDialog(this,"Member not Found.");
		  				   if(index==-2)
		  					   JOptionPane.showMessageDialog(this,"GramPanchayatMembers.dat file does not exist.");
		  				   /*else
						   	JOptionPane.showMessageDialog(this,"Unknown ERROR!!");*/
		  			   }
				}
				);	
                Font f1=new Font("Aerial",Font.BOLD,14);
				l1=new JLabel("Enter GPMember_ID");
				l1.setFont(f1);
				l1.setForeground(Color.RED);
				
			    l2=new JLabel("Submit");
				l2.setFont(f1);
				l2.setForeground(Color.RED);
				

				c.add(l1);c.add(tgid);
				
				c.add(l2);c.add(submit);
				    
				
				 setSize(350, 100);
				 setLocation(200,200);
				 setResizable(false);
				 setVisible(true);	
	 }
	 
	 private int getgSearchIndex()
	 {
		   String gpm_id=tgid.getText().trim();
		   return (Bdo.searchGPM(gpm_id));
	 }
	 
	 public boolean dataValidation()
	   {
		   boolean gpidvalidation= gpidCheck();
		   
		   if (gpidvalidation)
			   return true;
		   
		   return false;
	   }
	 public boolean gpidCheck()
	   {
		  boolean gpidvalid = true;
	      String gpidpattern = "^GPM";
	    	
	      sc1 = new Scanner(tgid.getText().trim());
	    	
	      String match = sc1.findInLine(gpidpattern);
	    	
	      if (match == null)
	      {
	    	  JOptionPane.showMessageDialog(this, "Invalid GMP ID..Please Enter Another ID");
	    	  tgid.setText("");
	    	  tgid.setBackground(Color.RED);
	       	  gpidvalid = false;
	      }
	      return gpidvalid;
	   }
}

