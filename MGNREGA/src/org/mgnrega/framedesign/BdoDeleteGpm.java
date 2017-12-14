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

public class BdoDeleteGpm extends JFrame
{
	private static final long serialVersionUID = 1L;
    private JButton bsubmit;
	private JLabel l1;
	private JTextField tgpmid;
	private Scanner sc1;
	public BdoDeleteGpm()
	{
		super("DELETE GPMEMBER");
		
		tgpmid=new JTextField(20);
		 tgpmid.addFocusListener( new FocusAdapter() 
         {
            public void focusGained(FocusEvent e)
            {
                    tgpmid.setBackground(Color.WHITE);
            }
         }
       );
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(2,2));
		c.setBackground(Color.CYAN);
		l1=new JLabel();
		Font f1=new Font("Aerial",Font.BOLD,15);
		l1=new JLabel("Enter GPM_Id to be Deleted");
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);
		bsubmit=new JButton("DELETE");
		bsubmit.addActionListener((e) ->
		{
			boolean isdatavalidate=dataValidation();
			   if(isdatavalidate)
			   {	   
				   String msg=gdelDetails();
				   if(msg==null)
					   JOptionPane.showMessageDialog(this,"GPMember Successfully Deleted");
				   else
					   JOptionPane.showMessageDialog(this,msg);
			   }
		}
	    );
		
		c.add(l1);c.add(tgpmid);
		c.add(new JLabel(" "));c.add(bsubmit);
		setVisible(true);
		setSize(450,100);
		setLocation(450,175);
		
		setResizable(false);
		
	}
	
	private String gdelDetails()
	{
		String gpm_id=tgpmid.getText().trim();
		return (Bdo.delGPM(gpm_id));
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
	    	
	      sc1 = new Scanner(tgpmid.getText().trim());
	    	
	      String match = sc1.findInLine(gpidpattern);
	    	
	      if (match == null)
	      {
	    	  JOptionPane.showMessageDialog(this, "Invalid GMP ID..Please Enter Another ID");
	    	  tgpmid.setText("");
	    	  tgpmid.setBackground(Color.RED);
	       	  gpidvalid = false;
	      }
	      return gpidvalid;
	   }
	 

}
