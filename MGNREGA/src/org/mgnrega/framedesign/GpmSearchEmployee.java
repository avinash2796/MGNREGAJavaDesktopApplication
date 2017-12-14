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

public class GpmSearchEmployee extends JFrame
{
	 private static final long serialVersionUID = 1L;
	 private JLabel l1,l2;
	 private JTextField teid;
	 
	 private JButton submit;
	private Scanner sc1;
	 
	 protected GpmSearchEmployee(Gpm g)
	  {
		  super("Employee Search Window For GPM");
	  
		    Container c=getContentPane();
		    c.setLayout(new GridLayout(2,2));
            c.setBackground(Color.CYAN);
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
						   int index=getSearchEIndex(g);
						   if(index>=0)
						   {     
							   JOptionPane.showMessageDialog(this,"Employee Successfully Found.");
							   new GpmDisplaySearchedEmployee(index);
						   }
						   if(index==-1)
							   JOptionPane.showMessageDialog(this,"Employee not Found.");
						   if(index==-2)
							   JOptionPane.showMessageDialog(this,"Employees.dat file does not exist.");
						   /* else
						   	JOptionPane.showMessageDialog(this,"Unknown ERROR!!");*/
					   }
				}
				);	
                Font f1=new Font("Aerial",Font.BOLD,14);
				l1=new JLabel("Enter Employee_id");
				l1.setFont(f1);
				l1.setForeground(Color.RED);
				
			    l2=new JLabel("Submit");
				l2.setFont(f1);
				l2.setForeground(Color.RED);
				

				c.add(l1);c.add(teid);
				
				c.add(l2);c.add(submit);
				    
				
				 setSize(350, 100);
				 setLocation(200,200);
				 setResizable(false);
	
				 setVisible(true);	
	 }
	 
	 private int getSearchEIndex(Gpm g)
	 {
		   String emp_id=teid.getText().trim();
		   return (g.searchEmployee(emp_id));
	 }
	 public boolean dataValidation()
	   {
		   boolean eidvalidation= eidCheck();
		   
		   if (eidvalidation)
			   return true;
		   
		   return false;
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
