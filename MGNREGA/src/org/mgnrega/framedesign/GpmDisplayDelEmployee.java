package org.mgnrega.framedesign;

import org.mgnrega.pojo.Employee;
import org.mgnrega.pojo.Wages;
import org.mgnrega.filehandling.StoreAndRetrieveEmployee;
import org.mgnrega.filehandling.StoreAndRetrieveWages;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Container;
//import java.util.Calendar;
//import java.util.Date;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GpmDisplayDelEmployee extends JFrame
{
	private static final long serialVersionUID = 1L;

	protected GpmDisplayDelEmployee(int index)
	{
		super("Following Employee Deleted As Work Period Exceded");
		String heading[]={"Employee Name","Employee ID","No Of Days Worked","Wage Per Day","Total Wage"};
		String data[][];
		ArrayList <Employee> elist;
		ArrayList <Wages> wlist;
		try
		{
			elist = StoreAndRetrieveEmployee.readFromFile();
			wlist = StoreAndRetrieveWages.readFromFile();
			
			data = new String[1][5];
			
			Employee emp = elist.get(index);
			int r=0;
			
			    data[r][0]=emp.getName();
				data[r][1]=emp.getEmp_id();
			 
		    int s=0;
		    
		        while((emp.getEmp_id()).equalsIgnoreCase(wlist.get(s).getE_id())==false)
			             s++;
		        
		        data[r][2]=String.valueOf(wlist.get(s).getNod());
			    data[r][3]=String.valueOf(wlist.get(s).getWpd());
			    data[r][4]=String.valueOf(wlist.get(s).getTotw());
				
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("Employee Details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			
			setSize(850, 300);
			
			setLocation(200, 200);
			setVisible(true);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
    }
}

