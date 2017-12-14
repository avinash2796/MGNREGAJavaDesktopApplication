package org.mgnrega.framedesign;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateGpm extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	private JTextField tid,tname,temailid,tpass;
	private JRadioButton rmale,rfemale;
	private JTextArea tadd;
	private JComboBox <String> day,month,year;
	private JButton badd;
	private Scanner sc1;
	private Scanner sc2;
	private Scanner sc12;
	
	public CreateGpm()
	 {
		 super("GPM REGISTRATION");
		  
		  Container c=getContentPane();
		  c.setLayout(new GridLayout(8,2));
		c.setBackground(Color.LIGHT_GRAY);	
		  tid=new JTextField(20);
		  Random r = new Random();
		  int x = r.nextInt(10000);
		  tid.setText("GPM"+x);
		  tid.setEditable(false);
		  tpass=new JTextField(20);
		  tpass.addFocusListener( new FocusAdapter() 
          {
             public void focusGained(FocusEvent e)
             {
                     tpass.setBackground(Color.WHITE);
             }
          }
        );
		  tname = new JTextField(20);
		  tname.addFocusListener( new FocusAdapter() 
          {
             public void focusGained(FocusEvent e)
             {
                     tname.setBackground(Color.WHITE);
             }
          }
        );
		  temailid = new JTextField(20);
		  temailid.addFocusListener( new FocusAdapter() 
          {
             public void focusGained(FocusEvent e)
             {
                     temailid.setBackground(Color.WHITE);
             }
          }
        );
		  tadd=new JTextArea(5,20);
		  tadd.addFocusListener( new FocusAdapter() 
          {
             public void focusGained(FocusEvent e)
             {
                     tadd.setBackground(Color.WHITE);
             }
          }
        );
		  
		  JScrollPane tapan=new JScrollPane(tadd);
		  rmale=new JRadioButton("Male");
		  rmale.addFocusListener( new FocusAdapter() 
          {
             public void focusGained(FocusEvent e)
             {
                     rmale.setBackground(Color.WHITE);
             }
          }
        );
		  rfemale=new JRadioButton("Female");
		  rfemale.addFocusListener( new FocusAdapter() 
          {
             public void focusGained(FocusEvent e)
             {
                     rfemale.setBackground(Color.WHITE);
             }
          }
        );
		  
		  ButtonGroup rgroup=new ButtonGroup();
		   rgroup.add(rmale);
		   rgroup.add(rfemale);
		   
		   JPanel gpanel=new JPanel();
		   gpanel.add(rmale);
		   gpanel.add(rfemale);
		   
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
				
		   String yvalue[]=new String[61];
		   int cnt=0;
		   for(int i=1936;i<=1996;i++)
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
				boolean isdatavalidate=dataValidation();
	  			   if(isdatavalidate)
	  			{
	  				  
				   String msg=takeGPMInfo();
				   if(msg==null)
				        JOptionPane.showMessageDialog(this,"Member Successfully Added.");
				   else
					   JOptionPane.showMessageDialog(this,msg);
				   		resetFrame();
	  			   }
			 }
			  );
			Font f=new Font("Aerial",Font.BOLD,14);
			l1=new JLabel("Enter GPM Name");
			l1.setFont(f);
			l1.setForeground(Color.RED);
				
			Font f1=new Font("Aerial",Font.BOLD,14);
			l2=new JLabel("Set Gpm Id");
			l2.setFont(f1);
			l2.setForeground(Color.RED);
				
			l3=new JLabel("Set Gpm Pasword");
			l3.setFont(f1);
			l3.setForeground(Color.RED);
			
			l4=new JLabel("Enter Address");
			l4.setFont(f1);
			l4.setForeground(Color.RED);
			
			l5=new JLabel("Set Project ID");
			l5.setFont(f1);
			l5.setForeground(Color.RED);
				
			l6=new JLabel("Select Gender");
			l6.setFont(f1);
			l6.setForeground(Color.RED);
				
			l7=new JLabel("Select DOB");
			l7.setFont(f1);
			l7.setForeground(Color.RED);
				
			l8=new JLabel("Enter Email ID");
			l8.setFont(f1);
			l8.setForeground(Color.RED);
			
			c.add(l1);c.add(tname);
			c.add(l2);c.add(tid);
			c.add(l3);c.add(tpass);
			c.add(l4);c.add(tapan);
			c.add(l6);c.add(gpanel);
			c.add(l7);c.add(cpanel);
			c.add(l8);c.add(temailid);
			c.add(new JLabel(" "));c.add(badd);
			
			
			setSize(350, 400);
			setLocation(450,175);
			setResizable(false);
			
			setVisible(true);
	 }
     
	 private String takeGPMInfo()
	 {
		   String gn="";
		   if(rmale.isSelected())
			    gn="M";
		   else if(rfemale.isSelected())
			    gn="F";
		   String gpm_id = tid.getText().trim();
		   String gpm_name=tname.getText().trim();
		   String gpm_gender=gn.trim();
		   String gpm_address=tadd.getText().trim();
		   String password=tpass.getText().trim();
		   String email_id=temailid.getText().trim();
		   int d = Integer.parseInt(((String)day.getSelectedItem()).trim());
		   int m = Integer.parseInt(((String)month.getSelectedItem()).trim());
		   int y = Integer.parseInt(((String)year.getSelectedItem()).trim());
		   return(Bdo.setGpm(gpm_name, gpm_gender, gpm_address, y, m, d, gpm_id, password, email_id));
	 }
	 
	 public boolean dataValidation()
	   {
		   boolean namevalidation = nameCheck();
		   boolean emailvalidation = emilcheck();
		   boolean gendervalidation = gendercheck();
		   boolean passwordvalidation = passwordcheck();
		   boolean addressvalidation = addresscheck();
		   
		   if (namevalidation && emailvalidation && gendervalidation && passwordvalidation && addressvalidation)
			   return true;
		   
		   return false;
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
	   public boolean emilcheck()
	    {
		    boolean emailvalid = true;
	    	String emailpattern = "^(\\w)+@(\\w+\\.)(\\w+\\.)?[A-Za-z]+$";
	    	
	    	sc2 = new Scanner(temailid.getText().trim());
	    	
	    	String match1 = sc2.findInLine(emailpattern);
	    	
	    	if (match1 == null)
	    	{
	    	   JOptionPane.showMessageDialog(this, "Invalid EmailId..Please Enter Another Email");
		       temailid.setText("");
		      temailid.setBackground(Color.RED);
		       emailvalid = false;
	    	}
	    	
	    	return emailvalid;
	    }
	   public boolean gendercheck()
		  {
			  	boolean gendervalid=true;
				  if(rmale.isSelected()==false&&rfemale.isSelected()==false)
				  {
					  JOptionPane.showMessageDialog(this, "You must select male or female");
		    	  rfemale.setBackground(Color.RED);
		    	  rmale.setBackground(Color.RED);
		       	  gendervalid = false; 
				  }
				     return gendervalid;
		  }
	   
	   public boolean passwordcheck()
	   {
		  boolean passwordvalid = true;
	      String passwordpattern = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
	    	
	      sc12 = new Scanner(tpass.getText().trim());
	    	
	      String match = sc12.findInLine(passwordpattern);
	    	
	      if (match == null)
	      {
	    	  JOptionPane.showMessageDialog(this, "Invalid Password..Must be atleast 8 characters long\n with special character and numbers");
	    	  tpass.setText("");
	    	  tpass.setBackground(Color.RED);
	       	  passwordvalid = false;
	      }
	        return passwordvalid;
	   }
	     
	   public boolean addresscheck()
	   {
		  boolean addressvalid = true;
	     
	    	String addcheck=tadd.getText().trim();
	    	
	      if (addcheck.length()<=2)
	      {
	    	  JOptionPane.showMessageDialog(this, "Invalid Address..Please Select Address Field");
	    	  tadd.setText("");
	    	  tadd.setBackground(Color.RED);
	       	  addressvalid = false;
	      }
	      return addressvalid;
	   }
	   public void resetFrame()
	     {
	    	 this.dispose();
   	         new CreateGpm();
	     }

}
