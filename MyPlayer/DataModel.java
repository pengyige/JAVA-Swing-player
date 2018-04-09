package MyPlayer;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.TreeMap;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class DataModel extends DefaultListModel{
	
	public DataModel()
	{
		
		/*连接视频服务器*/
	
		/*获取文件夹视频
		File f = new File("TestVideo");
		String[] fileNames = f.list();
		for(String fileName : fileNames)
		{
			this.addElement(fileName);
		}
		*/
		
	}
	public DataModel(int flag)
	{
		
	}
}
