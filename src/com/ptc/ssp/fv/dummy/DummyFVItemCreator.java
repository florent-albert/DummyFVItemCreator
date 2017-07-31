package com.ptc.ssp.fv.dummy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DummyFVItemCreator
{
	public static void main(String[] args) 
	{
		String dbUser = args[0];
		String dbPassword = args[1];
		String dbHost = args[2];
		String dbPort = args[3];
		String dbService = args[4];
		
		Statement stmt = null;
		Connection conn = null;
		
		List<StoredFVItem> storedfvitems = new ArrayList<StoredFVItem>();
	    try {
		    Class.forName("oracle.jdbc.OracleDriver");
	        System.out.println("Oracle JDBC driver loaded ok.");
	        conn=DriverManager.getConnection("jdbc:oracle:thin:"+dbUser+"/"+dbPassword+"@"+dbHost+":"+dbPort+":"+dbService);
		        
		    String query = "select ad.filename as FILE_NAME, ad.filesize as FILE_SIZE, fvm.path as FILE_PATH, to_char(fvi.uniquesequencenumber,'FM0XXXXXXXXXXXXX') as FVITEM_NAME" + 
		    		"from applicationdata ad, fvitem fvi, fvfolder fvf, fvmount fvm " + 
		    		"where ad.ida3a5=fvi.ida2a2 " + 
		    		"and fvi.ida3a4=fvf.ida2a2 " + 
		    		"and fvm.ida3a5=fvf.ida2a2 " + 
		    		"and ida3c4 > 110;";
		    
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) 
	        {
	            String fileName = rs.getString("FILE_NAME");
	            int fileSize = rs.getInt("FILE_SIZE");
	            String filePath = rs.getString("FILE_PATH");
	            String fvItemName = rs.getString("FVITEM_NAME");
	            StoredFVItem storedFVItem = new StoredFVItem(fileName, fileSize, filePath, fvItemName);
	            storedfvitems.add(storedFVItem);
	            
	        }
	    } catch (SQLException sqle ) {
	        sqle.printStackTrace();
	    } catch (ClassNotFoundException e){
			e.printStackTrace();
		} 
		
		for(StoredFVItem storedFVItem:storedfvitems)
		{
			try{
				File item_file = new File(item);
				FileWriter fw = new FileWriter(item_file);
				fw.write("Dummy file replacing original file ");
				fw.close();
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
		

	}

}
