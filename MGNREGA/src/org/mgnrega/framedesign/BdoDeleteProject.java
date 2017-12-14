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

public class BdoDeleteProject extends JFrame
{
	private static final long serialVersionUID = 1L;
    private JButton bsubmit;
	private JLabel l1;
	private JTextField tpid;
	private Scanner sc12;
	public BdoDeleteProject()
	{
		super("DELETE PROJECT");
		
		tpid=new JTextField(20);
		 tpid.addFocusListener( new FocusAdapter() 
         {
            public void focusGained(FocusEvent e)
            {
                    tpid.setBackground(Color.WHITE);
            }
         }
       );
		Container c=getContentPane();
		c.setLayout(new GridLayout(2,2));
		c.setBackground(Color.ORANGE);
		l1=new JLabel();
		Font f1=new Font("Aerial",Font.BOLD,15);
		l1=new JLabel("Enter Project_Id to be Deleted");
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);
		bsubmit=new JButton("DELETE");
		bsubmit.addActionListener((e) ->
		{
			boolean isdatavalidate=dataValidation();
			 if(isdatavalidate)
			   {	
				 String msg=pdelDetails();
				 if(msg==null)
					 JOptionPane.showMessageDialog(this,"Project Successfully Deleted");
				 else
					 JOptionPane.showMessageDialog(this,msg);
			   }
		}
	    );
		
		c.add(l1);c.add(tpid);
		c.add(new JLabel(" "));c.add(bsubmit);
		setVisible(true);
		setSize(450,100);
		setLocation(450,175);
		
		setResizable(false);
		
	}
	
	private String pdelDetails()
	{
		String pid=tpid.getText().trim();
		return (Bdo.delProject(pid));
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

