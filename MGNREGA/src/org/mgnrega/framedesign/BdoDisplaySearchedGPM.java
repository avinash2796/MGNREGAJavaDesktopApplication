package org.mgnrega.framedesign;

import org.mgnrega.pojo.GrmPhctMem;
import org.mgnrega.filehandling.StoreAndRetrieveGrmPhctMem;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
//import java.awt.Color;
import java.awt.Container;
//import java.util.Calendar;
//import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BdoDisplaySearchedGPM extends JFrame
{
	private static final long serialVersionUID = 1L;

	public BdoDisplaySearchedGPM(int index)
	{
		super("Details of Searched GramPanchayatMember");
		String heading[]={"Member Name","Member Gender","Member Address","D.O.B","Member id","Password","Email id","Project id"};
		String data[][];
		ArrayList <GrmPhctMem> glist;
		try
		{
			glist = StoreAndRetrieveGrmPhctMem.readFromFile();
			
			data = new String[1][8];
			
			GrmPhctMem gpm = glist.get(index);
			SimpleDateFormat fom = new SimpleDateFormat("dd/MM/yyyy");
			int r=0;
			
			    data[r][0]=gpm.getGpm_name();
				data[r][1]=gpm.getGpm_gender();
				data[r][2]=gpm.getGpm_address();
				data[r][3]=fom.format(gpm.getGDOB());
				data[r][4]=gpm.getGpm_id();
				data[r][5]=gpm.getPassword();
				data[r][6]=gpm.getEmail_id();
				for(int i=0;i<(gpm.getPrjid()).size();i++)
				{
					 if(i==0)
						 data[r][7]=(gpm.getPrjid()).get(i);
					 else
						 data[r][7]=","+(gpm.getPrjid()).get(i);
			    }
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Member Details"),BorderLayout.NORTH);
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
