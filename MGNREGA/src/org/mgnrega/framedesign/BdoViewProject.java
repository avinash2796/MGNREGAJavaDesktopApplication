package org.mgnrega.framedesign;

import org.mgnrega.pojo.Project;
import org.mgnrega.filehandling.StoreAndRetrieveProject;

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


public class BdoViewProject extends JFrame
{
	private static final long serialVersionUID = 1L;

	protected BdoViewProject()
	{
		super("All Projects");
		String heading[]={"Project Name","Project ID","Project Start Date","MaxNoOfDays","MaxNoOfEmployees","GPM_Id"};
		String data[][];
		ArrayList <Project> plist;
		try
		{
			plist = StoreAndRetrieveProject.readFromFile();
			
			data = new String[plist.size()][6];
			
			SimpleDateFormat fom = new SimpleDateFormat("dd/MM/yyyy");
			int r=0;
			for(Project pj : plist)
			{
				data[r][0]=pj.getP_name();
				data[r][1]=pj.getP_id();
				data[r][2]=fom.format(pj.getP_strdt());
				data[r][3]=Integer.toString(pj.getMnd());
				data[r][4]=Integer.toString(pj.getMne());
				data[r][5]=pj.getGpm_id();
				r++;
			}
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Project Details"),BorderLayout.NORTH);
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

