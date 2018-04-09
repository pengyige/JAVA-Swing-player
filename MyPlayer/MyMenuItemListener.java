package MyPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.skin.AutumnSkin;
import org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.jvnet.substance.skin.SubstanceChallengerDeepLookAndFeel;

public class MyMenuItemListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("0.5"))
		{
			if(1 == PlayManage.setRate(0.5f))
			{
				JOptionPane.showMessageDialog(null, "该视频不支持，设置失败！");
			}
		}
		
		if(e.getActionCommand().equals("1"))
		{
			if(1 == PlayManage.setRate(1.0f))
			{
				JOptionPane.showMessageDialog(null, "该视频不支持，设置失败！");
			}
		}
		
		if(e.getActionCommand().equals("1.5"))
		{
			if(1 == PlayManage.setRate(1.5f))
			{
				JOptionPane.showMessageDialog(null, "该视频不支持，设置失败！");
			}
		}
		if(e.getActionCommand().equals("2"))
		{
			if(1 == PlayManage.setRate(2.0f))
			{
				JOptionPane.showMessageDialog(null, "该视频不支持，设置失败！");
			}
		}
		
		
		
		/*视频比例*/
		if(e.getActionCommand().equals("50%"))
		{
			PlayManage.setAspectRatio("1:2");
		}
		if(e.getActionCommand().equals("75%"))
		{
			PlayManage.setAspectRatio("4:3");
		}
		if(e.getActionCommand().equals("100%"))
		{
			Main.frame.player.getMediaPlayer().setScale(0);;
		}
		
		/*界面风格*/
		if(e.getActionCommand().equals("风格1"))
		{
			  try {
				UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		            
		if(e.getActionCommand().equals("风格2"))
		{
			
			   try {
				try {
					UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   
		}
		
		if(e.getActionCommand().equals("最佳"))
		{ 
			try {
				UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceAutumnLookAndFeel");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getActionCommand().equals("默认"))
		{
			
			Myframe.setskin();
		}
		
		if(e.getActionCommand().equals("当前解码"))
		{
			
			JOptionPane.showMessageDialog(null,"当前解码格式为："+Charset.defaultCharset());
			
		}
		
		if(e.getActionCommand().equals("UTF8"))
		{
			/*
			try {
				Runtime.getRuntime().exec("设置环境变量.bat");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		//	System.out.println(System.getenv("JAVA_TOOL_OPTIONS"));
		//	System.setProperty("JAVA_TOOL_OPTIONS", "-Dfile.encoding=UTF-8");
			JOptionPane.showMessageDialog(null, "JAVA_TOOL_OPTIONS，-Dfile.encoding=UTF-8");
		}
		
		if(e.getActionCommand().equals("背景图片"))
		{
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("Images//"));
			chooser.setDialogTitle("请选择背景图片");
			chooser.setApproveButtonText("确定");
			int v = chooser.showOpenDialog(null);
			if(v==JFileChooser.APPROVE_OPTION)
			{
				File file = chooser.getSelectedFile();
				Main.source_picture = file.getAbsolutePath();
				PlayManage.ShowPicture(file.getAbsolutePath());
				
			}
		}
		
	}

}
