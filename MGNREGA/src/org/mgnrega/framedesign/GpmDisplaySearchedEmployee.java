package org.mgnrega.framedesign;

import org.mgnrega.pojo.Employee;
import org.mgnrega.filehandling.StoreAndRetrieveEmployee;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Container;
//import java.util.Calendar;
//import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GpmDisplaySearchedEmployee extends JFrame
{
	private static final long serialVersionUID = 1L;

	protected GpmDisplaySearchedEmployee(int index)
	{
		  super("Searched Employee Details");
		  String heading[]={"Employee Name","Employee Gender","Employee Address","D.O.B","Working Start Date","Employee_Id","Project_Id","Owner GPM_Id"};
			String data[][];
			ArrayList <Employee> elist;
			try
			{
				elist = StoreAndRetrieveEmployee.readFromFile();
				
				data = new String[1][8];
				
				Employee emp = elist.get(index);
				
				SimpleDateFormat fom = new SimpleDateFormat("dd/MM/yyyy");
				int r=0;
					
				    data[r][0]=emp.getName();
					data[r][1]=emp.getGender();
					data[r][2]=emp.getAddress();
					data[r][3]=fom.format(emp.getEDOB());
					data[r][4]=fom.format(emp.getEstrdt());
					data[r][5]=emp.getEmp_id();
					data[r][6]=emp.getPrj_id();
					data[r][7]=emp.getGpm_id();
				
				Container con=getContentPane();
				con.setLayout(new BorderLayout());
				
				JTable datatable=new JTable(data, heading);
				JScrollPane jsp=new JScrollPane(datatable);
				
				con.add(new JLabel("All Employee Details"),BorderLayout.NORTH);
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
