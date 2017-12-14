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

public class AllocateProjToGPM extends JFrame
{
	 private static final long serialVersionUID = 1L;
	 private JLabel l1,l2,l3;
	 private JTextField tpid;
	 private JTextField tgid;
	 private JButton submit;
	private Scanner sc12;
	private Scanner sc1;
	 
	 public AllocateProjToGPM()
	  {
		  super("ALLOCATE PROJECT TO GRAM PANCHAYAT MEMBER");
	  
		    Container c=getContentPane();
		    c.setLayout(new GridLayout(3,2));
		    c.setBackground(Color.RED);
            
		    tpid=new JTextField(20);
		    tpid.addFocusListener( new FocusAdapter() 
	          {
	             public void focusGained(FocusEvent e)
	             {
	                     tpid.setBackground(Color.WHITE);
	             }
	          }
	        );
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
		  				   String msg=allocate();
		  				   if(msg==null)
		  					   JOptionPane.showMessageDialog(this,"Project Successfully Allocated.");
		  				   else
		  					   JOptionPane.showMessageDialog(this,msg);
		  			   }
				}
				);	
                Font f1=new Font("Aerial",Font.BOLD,14);
				l1=new JLabel("Enter Project_ID");
				l1.setFont(f1);
				l1.setForeground(Color.WHITE);
				
				l2=new JLabel("Enter GPM_ID");
				l2.setFont(f1);
				l2.setForeground(Color.WHITE);
				
			    l3=new JLabel("Submit");
				l3.setFont(f1);
				l3.setForeground(Color.RED);
				

				c.add(l1);c.add(tpid);
				
				c.add(l2);c.add(tgid);
				c.add(l3);c.add(submit);
				    
				
				 setSize(350, 100);
				 setLocation(200,200);
				 setResizable(false);
				
				 setVisible(true);	
	 }
	 
	 private String allocate()
	 {
		   String pid=tpid.getText().trim();
		   String gpm_id=tgid.getText().trim();
		   return(Bdo.allocPrjid(pid, gpm_id));
	 }
	 public boolean dataValidation()
	   {
		   boolean pidvalidation = pidCheck();
		   boolean gpidvalidation= gpidCheck();
		   
		   if (pidvalidation&&gpidvalidation)
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

