package org.mgnrega.framedesign;

import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CreateProject extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JLabel l1,l2,l3,l4,l5;
	private JTextField tid,tname,tnod,tmne;
	private JComboBox <String> day,month,year;
	private JButton badd;
	private Scanner sc1;
	 public CreateProject()
	 {
		 super("CREATE PROJECT FORM ");
		  
		  Container c=getContentPane();
		  c.setLayout(new GridLayout(6,2));
		  c.setBackground(Color.CYAN);
		  tid=new JTextField(20);
		  Random r = new Random();
		  int x = r.nextInt(10000);
		  tid.setText("PRJ"+x);
		  tid.setEditable(false);
		  tname = new JTextField(20);
		  tname.addFocusListener( new FocusAdapter() 
          {
             public void focusGained(FocusEvent e)
             {
                     tname.setBackground(Color.WHITE);
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
		  tmne=new JTextField(20);
		  tmne.addFocusListener( new FocusAdapter() 
          {
             public void focusGained(FocusEvent e)
             {
                     tmne.setBackground(Color.WHITE);
             }
          }
        );
		   
		   String dvalue[]=new String[31];
		   for(int i=0;i<=30;i++)
		   {
				dvalue[i]=String.valueOf(i+1);
		   }
		   day=new JComboBox <String> (dvalue);
				
		   String mvalue[]=new String[12];
		   for(int i=0;i<=11;i++)
		   {
				mvalue[i]=String.valueOf(i+1);
		   }
		   month=new JComboBox <String> (mvalue);
				
		   String yvalue[]=new String[11];
		   int cnt=0;
		   for(int i=2017;i<=2026;i++)
		   {
				yvalue[cnt]=String.valueOf(i);
				cnt++;	
		   }
		   year=new JComboBox <String> (yvalue);
		   
		   JPanel cpanel=new JPanel();
		    cpanel.add(day);
			cpanel.add(month);
			cpanel.add(year);
			
			badd=new JButton("SUBMIT");
			
			badd.addActionListener((e) ->
			{
				addInformation();
			}	
			);
			
			Font f=new Font("Aerial",Font.BOLD,14);
			l1=new JLabel("Enter Project Name");
			l1.setFont(f);
			l1.setForeground(Color.RED);
				
			Font f1=new Font("Aerial",Font.BOLD,14);
			l2=new JLabel("Set Project Id");
			l2.setFont(f1);
			l2.setForeground(Color.RED);
				
			l3=new JLabel("Set Project Start Date");
			l3.setFont(f1);
			l3.setForeground(Color.RED);
			
			l4=new JLabel("Enter Max.No. of Days");
			l4.setFont(f1);
			l4.setForeground(Color.RED);
			
			l5=new JLabel("Enter Max. No. of Employee");
			l5.setFont(f1);
			l5.setForeground(Color.RED);
			
			c.add(l1);c.add(tname);
			c.add(l2);c.add(tid);
			c.add(l3);c.add(cpanel);
			c.add(l4);c.add(tnod);
			c.add(l5);c.add(tmne);
			c.add(new JLabel(" "));c.add(badd);
			
			
			setSize(400, 400);
			setLocation(450,175);
			setResizable(false);
			setVisible(true);
	 }
	private String takeProjectInfo() 
	{
		   String p_id = tid.getText().trim();
		   String p_name=tname.getText().trim();
		   int mnd = Integer.parseInt(tnod.getText().trim());
		   int mne = Integer.parseInt(tmne.getText().trim());
		   int dys = Integer.parseInt(((String)day.getSelectedItem()).trim());
		   int mts = Integer.parseInt(((String)month.getSelectedItem()).trim());
		   int ys = Integer.parseInt(((String)year.getSelectedItem()).trim());
		   return(Bdo.setProject(p_name, p_id, ys, dys, mts, mnd, mne)); 	
	}
	
	public boolean dataValidation()
	   {
		   boolean namevalidation = nameCheck();
		   boolean daysvalidation= dayCheck();
		   boolean empvalidation=empCheck();
		   
		   if (namevalidation&&daysvalidation&&empvalidation)
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
		    	
		    		if (days<=0||days>365)
		    		{
		    			JOptionPane.showMessageDialog(this, "Invalid No. of Days entered");
		    			tnod.setText("");
		    			tnod.setBackground(Color.RED);
		    			dayvalid = false;
		    		}
		    		return dayvalid;
		    	
	   }
	   public boolean empCheck()
	   {
		   boolean empvalid = true;
		   try
	    	{
	    			String input=tmne.getText().trim();
	    			int x=Integer.parseInt(input);
	    			System.out.println(x);
	    	}
	    	catch(NumberFormatException e)
	    	{
	    		JOptionPane.showMessageDialog(this, "Enter Integer Input for no. of Max. Employees");
	    	}
	    	
		      int emps=Integer.parseInt(tmne.getText().trim());
		    	
		      if (emps<=0)
		      {
		    	  JOptionPane.showMessageDialog(this, "Invalid No. of Employees entered");
		    	  tmne.setText("");
		    	  tmne.setBackground(Color.RED);
		       	  empvalid = false;
		      }
		      return empvalid;
	   }
	   public boolean nameCheck()
	   {
		  boolean namevalid = true;
	      String namepattern = "^[a-zA-Z]{3,15}$";
	    	
	      sc1 = new Scanner(tname.getText().trim());
	    	
	      String match = sc1.findInLine(namepattern);
	    	
	      if (match == null)
	      {
	    	  JOptionPane.showMessageDialog(this, "Invalid Name..Please Enter Another Name");
	    	  tname.setText("");
	    	  tname.setBackground(Color.RED);
	       	  namevalid = false;
	      }
	      return namevalid;
	   }
	   public void addInformation()
	   {
		   boolean isdatavalidate = dataValidation(); 
        	if(isdatavalidate)
        	{
	    	   createproj();
        	}
		   
	   }
	  public void createproj()
	  {
		  String msg=takeProjectInfo();
  		if(msg==null)
  			JOptionPane.showMessageDialog(this,"Project Successfully Added.");
  		else
  			JOptionPane.showMessageDialog(this,msg);
  			resetFrame();
	  }
	  public void resetFrame()
	     {
	    	 this.dispose();
     	     new CreateProject();
	     }
	   
	  

}
