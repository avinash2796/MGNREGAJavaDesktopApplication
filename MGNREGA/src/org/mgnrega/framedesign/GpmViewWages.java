package org.mgnrega.framedesign;

import org.mgnrega.pojo.Wages;
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

public class GpmViewWages extends JFrame
{
	private static final long serialVersionUID = 1L;

	protected GpmViewWages(String gpm_id)
	{
		super("All Wages and Their Details Under GPM"+gpm_id+" Upto Present Date");
		String heading[]={"Employee Id","Wage Per Day","Number Of Days","Total Wage"};
		String data[][];
		ArrayList <Wages> wlist;
		try
		{
			wlist = StoreAndRetrieveWages.readFromFile();
			
			data = new String[wlist.size()][4];
			
			int r=0;
			for(Wages wg : wlist)
			{
				if(((gpm_id).equalsIgnoreCase(wg.getGpm_id())==true))
				{
					 data[r][0]=wg.getE_id();
				     data[r][1]=String.valueOf(wg.getWpd());
				     data[r][2]=String.valueOf(wg.getNod());
				     data[r][3]=String.valueOf(wg.getTotw());
				}
				r++;
			}
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Wage Details"),BorderLayout.NORTH);
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
