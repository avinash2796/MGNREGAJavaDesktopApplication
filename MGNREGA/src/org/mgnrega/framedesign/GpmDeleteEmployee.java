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

public class GpmDeleteEmployee extends JFrame
{
	private static final long serialVersionUID = 1L;
    private JButton bsubmit;
	private JLabel l1;
	private JTextField teid;
	private Scanner sc1;
	protected GpmDeleteEmployee(Gpm g)
	{
		super("DELETE PROJECT");
		
		teid=new JTextField(20);
		 teid.addFocusListener( new FocusAdapter() 
         {
            public void focusGained(FocusEvent e)
            {
                    teid.setBackground(Color.WHITE);
            }
         }
       );
		Container c=getContentPane();
		c.setLayout(new GridLayout(2,2));
		c.setBackground(Color.MAGENTA);
		l1=new JLabel();
		Font f1=new Font("Aerial",Font.BOLD,15);
		l1=new JLabel("Enter Employee_Id to be Deleted");
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);
		bsubmit=new JButton("DELETE");
		bsubmit.addActionListener((e) ->
		{
			boolean isdatavalidate=dataValidation();
			   if(isdatavalidate)
			   {
				   String msg=edelDetails(g);
				   if(msg==null)
					   JOptionPane.showMessageDialog(this,"Employee Successfully Deleted");
				   else
					   JOptionPane.showMessageDialog(this,msg);
			   }
		}
	    );
		
		c.add(l1);c.add(teid);
		c.add(new JLabel(" "));c.add(bsubmit);
		setVisible(true);
		setSize(450,100);
		setLocation(450,175);
		setResizable(false);
		
	}
	
	private String edelDetails(Gpm g)
	{
		String emp_id=teid.getText().trim();
		return (g.delEmployee(emp_id));
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
