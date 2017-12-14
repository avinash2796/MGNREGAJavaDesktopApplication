package org.mgnrega.framedesign;

import java.awt.Color;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GpmMenu extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JButton B1,B2,B3,B4,B5,B6,B7,B8;
	public GpmMenu(Gpm g) 
	{
		super("GRAM PANCHAYAT MEMBER MENU");
		setSize(500, 250);
		setLocation(450, 175);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new GridLayout(7,2));
		c.setBackground(Color.GRAY);
		B1=new JButton("CREATE  EMPLOYEE");
		B1.addActionListener((e) ->
		{
		   new CreateEmployee(g);
		  
		}
		);
		B2=new JButton("VIEW EMPLOYEE DETAILS");
		B2.addActionListener((e) ->
		{
			g.viewEmployee();
			
		}
		);
		B3=new JButton ("SEARCH EMPLOYEE");
		B3.addActionListener((e) ->
		{
			new GpmSearchEmployee(g);
		
		}
		);
		B4=new JButton ("DELETE EMPLOYEE");
		B4.addActionListener((e) ->
		{
		    new GpmDeleteEmployee(g);
		   
		}
		);
		B5=new JButton("VIEW PROJECTS");
		B5.addActionListener((e) ->
		{
		    g.viewGpmProject();
		   
		}
	    );
		B6=new JButton("ALLOCATE PROJECT TO EMPLOYEE");
		B6.addActionListener((e) ->
		{
			new AllocateProjToEmployee(g);
	
		}
		);
		B7=new JButton("VIEW EMPLOYEE WAGES");
		B7.addActionListener((e) -> 
		{
			g.viewWages();
		}
	    );
		B8=new JButton("CALCULATE EMPLOYEE WAGE");
		B8.addActionListener((e) -> 
		{
			new CalculateWage(g);
		}
	    );
		c.add(B1);c.add(B2);
		c.add(new JLabel(" "));c.add(new JLabel(" "));
		c.add(B3);c.add(B4);
		c.add(new JLabel(" "));c.add(new JLabel(" "));
		c.add(B5);c.add(B6);
		c.add(new JLabel(" "));c.add(new JLabel(" "));
		c.add(B7);c.add(B8);
	}
}
