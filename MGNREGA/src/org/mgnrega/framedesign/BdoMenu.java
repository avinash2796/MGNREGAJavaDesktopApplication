package org.mgnrega.framedesign;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BdoMenu extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JButton B1,B2,B3,B4,B5,B6,B7,B8,B9,B10;
	public BdoMenu() 
	{
		super("B.D.O. MENU");
		setSize(400, 300);
		setLocation(450, 175);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new GridLayout(10,2));
		c.setBackground(Color.LIGHT_GRAY);
		B1=new JButton("CREATE PROJECT");
		B1.addActionListener((e) ->
		{
		   new CreateProject();
		  
		}
		);
		B2=new JButton("VIEW PROJECT LIST");
		B2.addActionListener((e) ->
		{
			new BdoViewProject();
          		
		}
		);
		B3=new JButton("CREATE GP MEMBER");
		B3.addActionListener((e) ->
		{
		   new CreateGpm();
		   
		}
		);
		B4=new JButton("VIEW GPM LIST");
		B4.addActionListener((e) ->
		{
			new BdoViewGrmPhctMem();
			
		}
		);
		B5=new JButton("ALLOCATE PROJECT");
		B5.addActionListener((e) ->
		{
			new AllocateProjToGPM();
			
		}
	    );
		B6=new JButton("VIEW EMPLOYEE LIST");
		B6.addActionListener((e) ->
		{
		        Bdo b=new Bdo();
		        b.viewEmployee();
		}
		);
		B7=new JButton("SEARCH PROJECT");
		B7.addActionListener((e) ->
		{
		     new BdoSearchProject();
		     
		}
		);
		B8=new JButton("SEARCH GP MEMBER");
		B8.addActionListener((e) ->
		{
		     new BdoSearchGpm();
		    
		}
		);
		B9=new JButton("DELETE PROJECT");
		B9.addActionListener((e) ->
		{
		     new BdoDeleteProject();
		    
		}
		);
		B10=new JButton("DELETE GP MEMEBER");
		B10.addActionListener((e) ->
		{
		     new BdoDeleteGpm();
		   
		}
		);
		c.add(B1);c.add(B2);
		c.add(new JLabel(" "));c.add(new JLabel(" "));
		c.add(B3);c.add(B4);
		c.add(new JLabel(" "));c.add(new JLabel(" "));
		c.add(B5);c.add(B6);
		c.add(new JLabel(" "));c.add(new JLabel(" "));
		c.add(B7);c.add(B8);
		c.add(new JLabel(" "));c.add(new JLabel(" "));
		c.add(B9);c.add(B10);
    }
}
