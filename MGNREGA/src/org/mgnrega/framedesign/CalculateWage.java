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

public class CalculateWage extends JFrame
{
	private static final long serialVersionUID = 1L;
	 private JButton bsubmit;
	 private JTextField teid,tnod;
	 private JLabel l1,l2;
	private Scanner sc1;
	public CalculateWage(Gpm g)
	{
		super("CALCULATE WAGE");
		
		setSize(500, 100);
		
		setLocation(450, 175);
		setVisible(true);
		setResizable(false);
		Container c=getContentPane();
		c.setLayout(new GridLayout(3,2));
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
		tnod=new JTextField(20);
		 tnod.addFocusListener( new FocusAdapter() 
         {
            public void focusGained(FocusEvent e)
            {
                    tnod.setBackground(Color.WHITE);
            }
         }
       );
		Font f1=new Font("Aerial",Font.BOLD,15);
		l1=new JLabel("Enter Employee ID");
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);
		l2=new JLabel("Enter Total no. of days Worked by the Employee");
		l2.setFont(f1);
		l2.setForeground(Color.BLACK);
		bsubmit=new JButton("SUBMIT");
		bsubmit.addActionListener((e) ->
		{
			boolean isdatavalidate=dataValidation();
  			   if(isdatavalidate)
  			   {	   
  				   int index=g.searchEmployee(teid.getText().trim());
  				   if(index>=0)
				   {     
					   
  					   JOptionPane.showMessageDialog(this,"Employee Successfully Found.");
					   String msg=g.WageCalculation(teid.getText().trim(),Integer.parseInt(tnod.getText().trim()));
					   if(Integer.parseInt(tnod.getText().trim())==100)
						   JOptionPane.showMessageDialog(this,"Please Delete This Employee "+teid.getText().trim()+ "\n As 100 days have passed.");
					   JOptionPane.showMessageDialog(this, msg);
				   }
				   if(index==-1)
					   JOptionPane.showMessageDialog(this,"Employee not Found.");
				   if(index==-2)
					   JOptionPane.showMessageDialog(this,"Employees.dat file does not exist.");
  			   }
		}
		);	
		
		c.add(l1);c.add(teid);
		c.add(l2);c.add(tnod);
		c.add(new JLabel(" "));c.add(bsubmit);
		
	}
	public boolean dataValidation()
	   {
		   boolean daysvalidation= dayCheck();
		   boolean empvalidation=eidCheck();
		   
		   if (daysvalidation&&empvalidation)
			   return true;
		   
		   return false;
	   }
	 public boolean dayCheck()
	   {
		   boolean dayvalid = true;
		      
		    	try
		    	{
		    			String input=tnod.getText().trim();
		    			int x=Integer.parseInt(input);
		    			System.out.println(x);
		    	}
		    	catch(NumberFormatException e)
		    	{
		    		JOptionPane.showMessageDialog(this, "Enter Integer Input for no. of days");
		    	}
		    		int days=Integer.parseInt(tnod.getText().trim());
		    	
		    		if (days<0 || days>100)
		    		{
		    			JOptionPane.showMessageDialog(this, "Employee can work upto 100 days");
		    			tnod.setText("");
		    			tnod.setBackground(Color.RED);
		    			dayvalid = false;
		    		}
		    		return dayvalid;
		    	
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
