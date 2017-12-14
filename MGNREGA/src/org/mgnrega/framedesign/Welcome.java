package org.mgnrega.framedesign;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Welcome extends JFrame 
{
	  private static final long serialVersionUID = 1L;
	    private JButton bdologin,gpmlogin;
		private JLabel l1,l2;
		public  Welcome()
		{

			super("MGNREGA");
			setVisible(true);
			setSize(400,200);
			setLocation(450,175);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			Container c=getContentPane();
			c.setLayout(new GridLayout(5,2));
			c.setBackground(Color.ORANGE);
			Font f1=new Font("Aerial",Font.BOLD,20);
			l1=new JLabel("WELCOME !! USER ");
			l1.setFont(f1);
			l1.setForeground(Color.BLACK);
			Font f2=new Font("Aerial",Font.BOLD,15);
			l2=new JLabel("Select User Type");
			l2.setFont(f2);
			l2.setForeground(Color.BLACK);
			bdologin=new JButton("B.D.O. Login");
			bdologin.setBackground(Color.WHITE);
			bdologin.addActionListener((e) ->
			{
			   new BdoLogin();
			  setVisible(false);
			}
		  );
			gpmlogin=new JButton("G.P.M. Login");
			gpmlogin.setBackground(Color.CYAN);
			gpmlogin.addActionListener((e) ->
			{
			   new GpmLogin();
			   setVisible(false);
			}
		  );
			c.add(l1);c.add(new JLabel(" "));
			c.add(l2);c.add(new JLabel(" "));
			c.add(new JLabel(" "));c.add(bdologin);
			c.add(new JLabel(" "));c.add(gpmlogin);
		
	}

	public static void main(String[] args) 
	{
		new Welcome();
	}

}
