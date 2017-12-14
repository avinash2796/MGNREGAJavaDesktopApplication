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

      public class CreateEmployee extends JFrame
      {
    	  private static final long serialVersionUID = 1L;
    	  private JLabel l1,l2,l4,l6,l7,l8,l9;
    	  private JTextField tid,tname,twpd;
    	  private JTextArea tadd;
    	  private JComboBox <String> dy1,mt1,yr1,dy2,mt2,yr2;
    	  private JRadioButton rmale,rfemale;
    	  private JButton bsubmit;
		private Scanner sc1;
    	  public CreateEmployee(Gpm g)
    	  {
    		  super("Employee Registration");
    		  Container c=getContentPane();
    		  c.setLayout(new GridLayout(8,2));
    		  c.setBackground(Color.LIGHT_GRAY);
    		  tid=new JTextField(20);
    		  Random r = new Random();
    		  int x = r.nextInt(10000);
    		  tid.setText("EMP"+x);
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
    		  tadd= new JTextArea(5,20);
    		  twpd =new JTextField(20);
    		  twpd.addFocusListener( new FocusAdapter() 
              {
                 public void focusGained(FocusEvent e)
                 {
                         twpd.setBackground(Color.WHITE);
                 }
              }
            );
    		  JScrollPane tapan=new JScrollPane(tadd);
		  
    		  ButtonGroup rgroup=new ButtonGroup();
    		  rgroup.add(rmale);
    		  rgroup.add(rfemale);
		   
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
			  
			   ButtonGroup rGroup=new ButtonGroup();
			   rGroup.add(rmale);
			   rGroup.add(rfemale);

		       JPanel gpanel=new JPanel();
			   gpanel.add(rmale);
			   gpanel.add(rfemale);
			   
			   String dvalue[]=new String[31];
			   for(int i=0;i<=30;i++)
			   {
					dvalue[i]=String.valueOf(i+1);
			   }
			   dy1=new JComboBox <String> (dvalue);
					
			   String mvalue[]=new String[12];
			   for(int i=0;i<=11;i++)
			   {
					mvalue[i]=String.valueOf(i+1);
			   }
			   mt1=new JComboBox <String> (mvalue);
				
			   String yvalue[]=new String[61];
			   int cnt=0;
			   for(int i=1936;i<=1996;i++)
			   {
					yvalue[cnt]=String.valueOf(i);
					cnt++;	
			   }
					yr1=new JComboBox <String> (yvalue);
					
				    JPanel cpanel=new JPanel();
				    cpanel.add(dy1);
					cpanel.add(mt1);
					cpanel.add(yr1);
					
					String dval[]=new String[31];
					   for(int i=0;i<=30;i++)
					   {
							dval[i]=String.valueOf(i+1);
					   }
					   dy2=new JComboBox <String> (dval);
							
					   String mval[]=new String[12];
					   for(int i=0;i<=11;i++)
					   {
							mval[i]=String.valueOf(i+1);
					   }
					   mt2=new JComboBox <String> (mval);
						
					   String yval[]=new String[11];
					   int cntt=0;
					   for(int i=2017;i<=2026;i++)
					   {
							yval[cntt]=String.valueOf(i);
							cntt++;	
					   }
						yr2=new JComboBox <String> (yval);
							
						    JPanel dpanel=new JPanel();
						    dpanel.add(dy2);
							dpanel.add(mt2);
							dpanel.add(yr2);
							
					
					bsubmit =new JButton("SUBMIT");
					
					bsubmit.addActionListener((e) ->
					{
						 boolean isdatavalidate=dataValidation();
		    			  if(isdatavalidate)
		    			  {
		    				  String msg=takeEmployeeInfo(g);
		    				  if(msg==null)
		    					  JOptionPane.showMessageDialog(this,"Employee Successfully Added.");
		    				  else
		    					  JOptionPane.showMessageDialog(this,msg);
		    				  			resetFrame(g);
		    			  }
					 }
					  );
					
					Font f1=new Font("Aerial",Font.BOLD,14);
					l2=new JLabel("Enter Employee_Id");
					l2.setFont(f1);
					l2.setForeground(Color.RED);
					
				    l1=new JLabel("Enter Name");
					l1.setFont(f1);
					l1.setForeground(Color.RED);
					
					l4=new JLabel("Enter Address");
					l4.setFont(f1);
					l4.setForeground(Color.RED);
					
					l6=new JLabel("Select Gender");
					l6.setFont(f1);
					l6.setForeground(Color.RED);
					
					l7=new JLabel("Select DOB");
					l7.setFont(f1);
					l7.setForeground(Color.RED);
					
					l8=new JLabel("Select Start Date");
					l8.setFont(f1);
					l8.setForeground(Color.RED);
					
					l9=new JLabel("Set Wage Per Day");
					l9.setFont(f1);
					l9.setForeground(Color.RED);
					
					
					c.add(l1);c.add(tname);
					
					c.add(l2);c.add(tid);
					c.add(l4);c.add(tapan);
					c.add(l6);c.add(gpanel);
					c.add(l7);c.add(cpanel);
					c.add(l8);c.add(dpanel);
					c.add(l9);c.add(twpd);
					c.add(new JLabel(" "));c.add(bsubmit);
					
					setSize(350, 400);
					 setLocation(200,200);
					 setResizable(false);
				
					 setVisible(true);	
    	  }

    	    private String takeEmployeeInfo(Gpm obj) 
    		{
    	    	   String gn="";
    			   if(rmale.isSelected())
    				    gn="M";
    			   else if(rfemale.isSelected())
    				    gn="F";
    	    	   String emp_id = tid.getText().trim();
    			   String emp_name=tname.getText().trim();
    			   String emp_address=tadd.getText().trim();
    			   String emp_gender=gn.trim();
    			   String wapady=twpd.getText().trim();
    			   int d1 = Integer.parseInt(((String)dy1.getSelectedItem()).trim());
    			   int m1 = Integer.parseInt(((String)mt1.getSelectedItem()).trim());
    			   int y1 = Integer.parseInt(((String)yr1.getSelectedItem()).trim());
    			   int d2 = Integer.parseInt(((String)dy2.getSelectedItem()).trim());
    			   int m2 = Integer.parseInt(((String)mt2.getSelectedItem()).trim());
    			   int y2 = Integer.parseInt(((String)yr2.getSelectedItem()).trim());
    			   int wpd= Integer.parseInt(wapady);
    			   return (obj.setEmployee(emp_name,emp_gender,emp_address,y1,m1,d1,y2,m2,d2,emp_id,wpd));
    		}
    	    
    	    public boolean dataValidation()
    		{
    			   boolean namevalidation = nameCheck();
    			   boolean gendervalidation = gendercheck();
    			   boolean wagevalidation=wagecheck();
    			   boolean addressvalidation = addresscheck();
    			   
    			   if (namevalidation && gendervalidation&&wagevalidation&&addressvalidation )
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
    		  public boolean wagecheck()
    		  {
    			  boolean wagevalid=true;
    			  try
  		    	{
  		    			String input=twpd.getText().trim();
  		    			int x=Integer.parseInt(input);
  		    			System.out.println(x);
  		    	}
  		    	catch(NumberFormatException e)
  		    	{
  		    		JOptionPane.showMessageDialog(this, "Enter Integer Input for Wage");
  		    	}
  		    		int wages=Integer.parseInt(twpd.getText().trim());
  		    	
  		    		if (wages<167)
  		    		{
  		    			JOptionPane.showMessageDialog(this, "Minimum wage for MGNREGA worker is Rs 167 ");
  		    			twpd.setText("");
  		    			twpd.setBackground(Color.RED);
  		    			wagevalid = false;
  		    		}
  		    		return wagevalid;
    			  
    		  }
    		  public void resetFrame(Gpm g)
    		     {
    		    	 this.dispose();
    	     	     new CreateEmployee(g);
    		     }
      }