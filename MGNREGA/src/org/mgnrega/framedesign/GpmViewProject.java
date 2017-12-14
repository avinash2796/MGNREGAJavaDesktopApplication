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

public class GpmViewProject extends JFrame
{
	private static final long serialVersionUID = 1L;

	public GpmViewProject(String gpm_id)
	{
		super("All Projects Under The GPMember "+gpm_id);
		String heading[]={"Project Name","Project_Id","Project Start Date","Max No Of Days","Max No Of Employee"};
		String data[][];
		ArrayList <Project> plist;
		//System.out.println(gpm_id);
		try
		{
			plist = StoreAndRetrieveProject.readFromFile();
			
			data = new String[plist.size()][5];
			
			SimpleDateFormat fom = new SimpleDateFormat("dd/MM/yyyy");
			int r=0;
			for(Project prj : plist)
			{
				
				if((gpm_id).equalsIgnoreCase(prj.getGpm_id())==true)
				{
					 data[r][0]=prj.getP_name();
				     data[r][1]=prj.getP_id();
				     data[r][2]=fom.format(prj.getP_strdt());
				     data[r][3]=Integer.toString(prj.getMnd());
				     data[r][4]=Integer.toString(prj.getMne());
				}    
				     r++;
				
			}
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Gpm Project Details"),BorderLayout.NORTH);
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
