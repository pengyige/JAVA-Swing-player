package MyPlayer;
import MyGif.GifFrame;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import uk.co.caprica.vlcj.filter.VideoFileFilter;
import uk.co.caprica.vlcj.filter.swing.SwingFileFilter;
import uk.co.caprica.vlcj.filter.swing.SwingFileFilterFactory;
import uk.co.caprica.vlcj.mrl.HttpMrl;
import uk.co.caprica.vlcj.player.embedded.DefaultAdaptiveRuntimeFullScreenStrategy;
public class PlayManage {
	static Properties prop = new Properties();
	public static void openFile()
	{
		
		JFileChooser chooser = new JFileChooser();
		 chooser.setApproveButtonText("播放");
		// chooser.addChoosableFileFilter(SwingFileFilterFactory.newAudioFileFilter());
		// chooser.addChoosableFileFilter(SwingFileFilterFactory.newPlayListFileFilter());
		// chooser.addChoosableFileFilter(SwingFileFilterFactory.newMediaFileFilter());
		// chooser.addChoosableFileFilter(SwingFileFilterFactory.newSubtitleFileFilter());
		int v = chooser.showOpenDialog(null);
		if(v==JFileChooser.APPROVE_OPTION)
		{
			File file = chooser.getSelectedFile();
			PlayManage.mediaplayAbsolute(file.getAbsolutePath());
			//setPlayRecord(file.getAbsolutePath());
		//	Main.frame.getHMode().addElement(file.getAbsolutePath());
			
		}

		
	}//打开文件
	/*打开文件和拖曳播放情况*/ //播放本地视频时的情况
	public static void mediaplayAbsolute(String resource)
	{
		//绝对路径播放
		if(resource.endsWith(".mp3"))
		{
			Main.frame.getCardLayout().show(Main.frame.getCardPane(),"picture");
			Main.frame.player.getMediaPlayer().playMedia(resource);
			PlayManage.ShowPicture(Main.source_picture);
			Main.frame.getHMode().addElement(resource);
			return;
		}
		
		if(resource.endsWith(".gif"))
		{
			
		GifFrame gif =	new GifFrame(resource);
		Main.frame.getHMode().addElement(resource);
			return ;
			
		}
		Main.frame.player.getMediaPlayer().playMedia(resource);
		Main.frame.getCardLayout().show(Main.frame.getCardPane(), "media");
		Main.frame.getHMode().addElement(resource);
		
	}
	/*双击列表时候播放情况*/ //可能有本地也可能有网路
	public static void mediaplay(String resource)
	{	
		
	
		//若在历史记录播放
		if(1 == Main.frame.gettabbedPane_list().getSelectedIndex())
		{
			if(':' !=resource.charAt(1))
			{
				/*
			Main.frame.player.getMediaPlayer().playMedia("TestVideo//"+resource);
			*/
				Main.frame.getCardLayout().show(Main.frame.getCardPane(), "media");
				String path = Resource.media_Resource.get(resource);
				Main.frame.player.getMediaPlayer().playMedia(path);	
			}
			else
			{
				//绝对路径调用绝对路径
				PlayManage.mediaplayAbsolute(resource);
				Main.frame.getHMode().removeElement(resource);//播放时会添加一个记录故先删除这个记录
			}
			return ;
		}
		//若在播放列表播放
		if(0 == Main.frame.gettabbedPane_list().getSelectedIndex())
		{
			/*播放播放列表的文件
			if(':' !=resource.charAt(1))
			{
			Main.frame.player.getMediaPlayer().playMedia("TestVideo//"+resource);
		
			}
			else
			{
				Main.frame.player.getMediaPlayer().playMedia(resource);
			}
			*/
			//播放服务器的视频地址
			PlayManage.button_play(resource);
			return ;
		}
		
	
		
	}//播放媒体
	/*按钮播放情况*/ //播放网络视频时的情况
	public static void button_play(String resource)
	{
		Main.frame.getCardLayout().show(Main.frame.getCardPane(), "media");
		String path = Resource.media_Resource.get(resource);
		Main.frame.player.getMediaPlayer().playMedia(path);
		Main.frame.getHMode().addElement(resource);
		Main.Index = Main.frame.getMode().indexOf(resource);
	}
	public static void play()
	{
		Main.frame.player.getMediaPlayer().play();
	}//播放
	public static void stop()
	{
		Main.frame.player.getMediaPlayer().stop();
	}//停止
	public static void pause()
	{
		Main.frame.player.getMediaPlayer().pause();
	}//暂停
	public static void next()
	{
		int index = (++Main.Index)% (Main.frame.getMode().size());
		String resource = (String)Main.frame.getMode().getElementAt(index);
		
		PlayManage.button_play(resource);
	}//下一个
	public static void last()
	{
		
		int index = (--Main.Index)% (Main.frame.getMode().size());
		if(index == -1)
		{
			index =	Main.frame.getMode().size()-1;
		}
		String resource = (String)Main.frame.getMode().getElementAt(index);
		PlayManage.button_play(resource);
	}//上一个
	public static void setVol(int value)
	{
		Main.frame.player.getMediaPlayer().setVolume(value);
	}//设置音量大小
	public static void jumpTo(float length)
	{
		Main.frame.player.getMediaPlayer().setTime((long)(length*Myframe.player.getMediaPlayer().getLength()));;
	}//跳转
	public static String getTitle()
	{	
	//	String title = Main.frame.player.getMediaPlayer().getMediaMeta().getTitle();
		
		return Main.frame.player.getMediaPlayer().getMediaMeta().getTitle();
	}//得到标题
	public static void setPlayRecord(String videoname)
	{
		
		//Main.frame.getMode().addElement(videoname);
		Main.frame.getHMode().addElement(videoname);

		Main.frame.getList().setModel(Main.frame.getMode());
		Main.frame.getHlist().setModel(Main.frame.getHMode());
		
	}//设置播放记录
	public static int setRate(float rate)
	{
		return Main.frame.player.getMediaPlayer().setRate(rate);
	}//设置速率
	
	public static void setAspectRatio(String ratio)
	{
		Main.frame.player.getMediaPlayer().setAspectRatio(ratio);
	}//设置比例
	public static void fullScreen()
	{
		
		Main.frame.player.getMediaPlayer().setFullScreenStrategy(new MyFullScreenStrategy(Main.frame));
		Main.frame.player.getMediaPlayer().setFullScreen(true);
		
	}//全屏
	public static void ExitScreen()
	{
		Main.frame.player.getMediaPlayer().setFullScreen(false);
	}//退出全屏
	public static void NoVolume()
	{
		Main.frame.player.getMediaPlayer().mute();
	}//静音
	public static void ShowPicture(String source)
	{
		ImageIcon img = new ImageIcon(source);
		int width  = Main.frame.getLabel_Picture().getWidth();
		int height = Main.frame.getLabel_Picture().getHeight();
		Image image = img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		
		img.setImage(image);
		Main.frame.getLabel_Picture().setIcon(img);
		
		
	}
	public static void Connection()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Resource.media_Resource = new TreeMap<String,String>();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@112.74.184.232:6666:myorcl","scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select 媒体名,媒体路径 from media_table");
			while(rs.next())
			{
				String media_name = rs.getString(1);
				String media_path = rs.getString(2);
				Resource.media_Resource.put(media_name,media_path);
				Main.frame.getMode().addElement(media_name);
			}
			
		}catch(ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"连接服务器失败,请检查网络!");
			e.printStackTrace();
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"连接服务器失败,请检查网络!");
			e.printStackTrace();
		}finally{
			try
			{
				if( rs != null)
				{
					rs.close();
				}
				
				if( stmt != null)
				{
					stmt.close();
				}
				
				if(conn != null)
				{
					conn.close();
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
