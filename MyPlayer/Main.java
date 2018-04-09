package MyPlayer;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.StandardButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;
import org.jvnet.substance.theme.SubstanceBottleGreenTheme;
import org.jvnet.substance.title.MatteHeaderPainter;
import org.jvnet.substance.watermark.SubstanceStripeWatermark;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.platform.unix.X11.Cursor;

import MyGif.FlashScreen;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import com.sun.awt.AWTUtilities;

public class Main {
	static Myframe frame ;
	static int Index;
	public static FlashScreen indexa;
	public static SwingWorker t;
	private static MyOverlayFrame overlay;
	 private static final String NATIVE_LIBRARY_SEARCH_PATH = ".";
	 static String source_picture = "images//默认1.jpg";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			  NativeLibrary.addSearchPath(  
		               RuntimeUtil.getLibVlcLibraryName(),NATIVE_LIBRARY_SEARCH_PATH );  
		        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class); 
		        System.out.println(LibVlc.INSTANCE.libvlc_get_version()); 
		        Main.FlashScreen();
		        //让主线程等待一段时间后再去显示窗体
		       try {
					Thread.currentThread().sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        SwingUtilities.invokeLater(new Runnable() {
		            @SuppressWarnings("deprecation")
					public void run() {
		            		Myframe.setskin();
			                frame = new Myframe();
			             //   setoverlay();
			              /*光标设置*/
			                /*
			        		Toolkit kit = Toolkit.getDefaultToolkit();
			        		Image img = kit.getImage("images//指针.ico");
			        		Point p = new Point(16,16);
			        		Dimension di = kit.getBestCursorSize(10,10);
			        		System.out.println(di.getHeight()+"   "+di.getWidth());
			        		java.awt.Cursor cu = kit.createCustomCursor(img, p,"stick");
			        		frame.setCursor(cu);*/
			                
			 
			                CloseListener cl = new CloseListener();
			                frame.addWindowListener(cl);
			                frame.addKeyListener(new MyKeyListener());		                
			               frame.addComponentListener(new MyComponentListener());
			                frame.setVisible(true);
			               if(indexa != null)
			                {
			              //  	System.out.println("关闭闪屏窗口");
			                	indexa.dispose();
			                }
			                if(!t.isCancelled())
			                {
			            //	  System.out.print("关闭假线程");
			            	   t.cancel(true);
			                }
			                PlayManage.Connection();
		            }
		        	});
		     }

	public static void setoverlay()
	{
		/*
		overlay = new MyOverlayFrame(Main.frame);
		overlay.setVisible(true);
		Main.frame.player.getMediaPlayer().setOverlay(overlay);
		Main.frame.player.getMediaPlayer().enableOverlay(true);
		/*
	
		JButton btn = new JButton("确定");
		*/
	//	new OverlayLayout(frame.player);
		
		
		//frame.player.getMediaPlayer().setOverlay(overlay);;
	//	overlay.setLocation((int)p.getX(),(int)p.getY());
		
		//System.out.println(p.getX()+"   "+p.getY());
		
	}
	public static void FlashScreen()
	{
		// TODO Auto-generated method stub
		 SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				indexa=new FlashScreen();
				indexa.setVisible(true);
				indexa.updateProgress();
			}
	
		 });
		
	}
	

		        
	
}


