package com.chillyfacts.com;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class Create_CSV 
{

	public static void main(String[] args) 
	{
		try
		{
			PrintWriter pw=new PrintWriter(new File("https://www.walmart.com/browse/electronics/dell-gaming-laptops/3944_3951_7052607_1849032_4519159 \r\n" + 
					"\r\n" + 
					""));
			StringBuilder sb=new StringBuilder();
			
			Connection con=null;
			Create_CSV obj_DB_Connection=new Create_CSV();
			Object con1 = obj_DB_Connection.getConnection();
			ResultSet rs=null;
			
			String query="select * from dell-gaming-laptops";
			PreparedStatement ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				sb.append(rs.getString("product name"));
				sb.append(",");
				sb.append(rs.getString(" Product Price "));
				sb.append(",");
				sb.append(rs.getString("Item Number/ SKU/ Product Code "));
				sb.append(",");
				sb.append(rs.getString("Model Number"));
				sb.append(",");
				sb.append(rs.getString("Product Category"));
				sb.append(",");
				sb.append(rs.getString("Product Description"));
				sb.append(",");	
			}
			
			pw.write(sb.toString());
			pw.close();
			System.out.println("finished");
		}
		catch(Exception e)
		{
			
		}
	}

	private Object getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}



