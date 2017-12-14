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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GpmLogin extends JFrame
{
	private static final long serialVersionUID = 1L;
	 private String gpm_id,password;
	 private JTextField gpmid;
	 private JPasswordField gpmpassword;
	 private JLabel l1,l2,l3;
	 private JButton gpmsubmit;
	private Scanner sc1;
	public GpmLogin()
	{
		super("G.P.M.Login");
		
		setSize(400, 200);
		
		setLocation(450, 175);
		setVisible(true);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new GridLayout(5,2));
		c.setBackground(Color.GREEN);
		l1=new JLabel();
		Font f1=new Font("Aerial",Font.BOLD,20);
		l1=new JLabel("Enter your Details");
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);
		l2=new JLabel();
		Font f2=new Font("Aerial",Font.BOLD,15);
		l2=new JLabel("Enter UserId");
		l2.setFont(f2);
		l2.setForeground(Color.BLACK);
		l3=new JLabel();
		Font f3=new Font("Aerial",Font.BOLD,15);
		l3=new JLabel("Enter Password");
		l3.setFont(f3);
		l3.setForeground(Color.BLACK);
		gpmid=new JTextField(20);
		 gpmid.addFocusListener( new FocusAdapter() 
         {
            public void focusGained(FocusEvent e)
            {
                    gpmid.setBackground(Color.WHITE);
            }
         }
       );
		gpmpassword=new JPasswordField(20);
		gpmsubmit=new JButton("SUBMIT");
		gpmsubmit.addActionListener((e) ->
		{
			boolean isdatavalidate=dataValidation();
			   if(isdatavalidate)
			   {
				   gpm_id=gpmid.getText().trim();
				   char ch[]=gpmpassword.getPassword();
				   password=new String(ch);
				   password=password.trim();
				   if(gmem.check(gpm_id,password))
						{
				        	final Gpm g=new Gpm(gpm_id);
				        	new GpmMenu(g);
				        	setVisible(false);
						}
				   else
					   JOptionPane.showMessageDialog(this, "Invalid ID/Password..Please Enter Correct Details");
				   gpmid.setText("");
				   gpmpassword.setText("");
			   }
		 
		}
	  );
		c.add(l1);c.add(new JLabel(" "));
		c.add(l2);c.add(gpmid);
		c.add(l3);c.add(gpmpassword);
		c.add(new JLabel(" "));c.add(gpmsubmit);
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
	    	
	      sc1 = new Scanner(gpmid.getText().trim());
	    	
	      String match = sc1.findInLine(gpidpattern);
	    	
	      if (match == null)
	      {
	    	  JOptionPane.showMessageDialog(this, "Invalid GMP ID..Please Enter Another ID");
	    	  gpmid.setText("");
	    	  gpmid.setBackground(Color.RED);
	       	  gpidvalid = false;
	      }
	      return gpidvalid;
	   }
	
}
