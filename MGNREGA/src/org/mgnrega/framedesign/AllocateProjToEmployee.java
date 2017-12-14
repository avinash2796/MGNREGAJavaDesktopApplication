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

public class AllocateProjToEmployee extends JFrame
{
	 private static final long serialVersionUID = 1L;
	 private JLabel l1,l2,l3;
	 private JTextField tpid;
	 private JTextField teid;
	 private JButton submit;
	private Scanner sc1;
	private Scanner sc12;
	 
	 public AllocateProjToEmployee(Gpm g)
	  {
		  super("ALLOCATE PROJECT TO EMPLOYEE UNDER GPM");
	  
		    Container c=getContentPane();
		    c.setLayout(new GridLayout(3,2));
            c.setBackground(Color.GREEN);
		    tpid=new JTextField(20);
		    tpid.addFocusListener( new FocusAdapter() 
	          {
	             public void focusGained(FocusEvent e)
	             {
	                     tpid.setBackground(Color.WHITE);
	             }
	          }
	        );
		    teid=new JTextField(20);
		    teid.addFocusListener( new FocusAdapter() 
	          {
	             public void focusGained(FocusEvent e)
	             {
	                     teid.setBackground(Color.WHITE);
	             }
	          }
	        );
		    
			   submit=new JButton("Submit");
			   submit.addActionListener((e) ->
				{
					boolean isdatavalidate=dataValidation();
		  			   if(isdatavalidate)
		  			   {	   
		  				   String msg=allocatePTE(g);
		  				   if(msg==null)
		  					   JOptionPane.showMessageDialog(this,"Project Successfully Allocated To Employee.");
		  				   else
		  					   JOptionPane.showMessageDialog(this,msg);
		  			   }
				}
				);	
                Font f1=new Font("Aerial",Font.BOLD,14);
				l1=new JLabel("Enter Project_ID");
				l1.setFont(f1);
				l1.setForeground(Color.RED);
				
				l2=new JLabel("Enter Employee_ID");
				l2.setFont(f1);
				l2.setForeground(Color.RED);
				
			    l3=new JLabel("Submit");
				l3.setFont(f1);
				l3.setForeground(Color.RED);
				

				c.add(l1);c.add(tpid);
				
				c.add(l2);c.add(teid);
				c.add(l3);c.add(submit);
				    
				
				 setSize(350, 100);
				 setLocation(200,200);
				 setResizable(false);
				 setVisible(true);	
	 }
	 
	 private String allocatePTE(Gpm g)
	 {
		   String prj_id=tpid.getText().trim();
		   String emp_id=teid.getText().trim();
		   return(g.allocProjectToEmp(prj_id, emp_id));
	 }
	 
	 public boolean dataValidation()
	   {
		   boolean pidvalidation = pidCheck();
		   boolean eidvalidation= eidCheck();
		   
		   if (pidvalidation&&eidvalidation)
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
	   public boolean eidCheck()
	   {
		  boolean eidvalid = true;
	      String eidpattern = "^EMP";
	    	
	      sc1 = new Scanner(teid.getText().trim());
	    	
	      String match = sc1.findInLine(eidpattern);
	    	
	      if (match == null)
	      {
	    	  JOptionPane.showMessageDialog(this, "Invalid Employee ID..Please Enter Another ID");
	    	  teid.setText("");
	    	  teid.setBackground(Color.RED);
	       	  eidvalid = false;
	      }
	      return eidvalid;
	   }
	 
	 
}