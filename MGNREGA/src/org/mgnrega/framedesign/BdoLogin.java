package org.mgnrega.framedesign;

import  org.mgnrega.framedesign.Bdo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
//import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BdoLogin extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	private String usrid;
	private String usrpassword;
	private JTextField bdoid;
	private JPasswordField bdopassword;
	private JLabel l1,l2,l3;
	private JButton bdosubmit;
	public BdoLogin()
	{
		super("B.D.O.Login Page");		
		setSize(400, 200);
		setLocation(450, 175);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new GridLayout(5,2));
		c.setBackground(Color.CYAN);
		l1=new JLabel();
		Font f1=new Font("Aerial",Font.BOLD,20);
		l1=new JLabel("Enter your Details");
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);
		l2=new JLabel();
		Font f2=new Font("Aerial",Font.BOLD,15);
		l2=new JLabel("Enter User_Id");
		l2.setFont(f2);
		l2.setForeground(Color.BLACK);
		l3=new JLabel();
		Font f3=new Font("Aerial",Font.BOLD,15);
		l3=new JLabel("Enter Password");
		l3.setFont(f3);
		l3.setForeground(Color.BLACK);
		bdoid=new JTextField(20);
		bdopassword=new JPasswordField(20);
		bdosubmit=new JButton("SUBMIT");
		bdosubmit.addActionListener((e) ->
		{
			usrid=bdoid.getText().trim();
			char ch[]=bdopassword.getPassword();
			usrpassword=new String(ch);
			usrpassword=usrpassword.trim();
			if(Bdo.check(usrid,usrpassword))
					{
						new BdoMenu();
					    setVisible(false);
					}
			else
				JOptionPane.showMessageDialog(this, "Invalid ID/Password..Please Enter Correct Details");
	            bdoid.setText("");
	            bdopassword.setText("");
		}
	  );
		c.add(l1);c.add(new JLabel(" "));
		c.add(l2);c.add(bdoid);
		c.add(l3);c.add(bdopassword);
		c.add(new JLabel(" "));c.add(bdosubmit);
	}

}
