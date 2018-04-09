package MyPlayer;
import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowListener;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Rectangle;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.*;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.button.StandardButtonShaper;
import org.jvnet.substance.painter.SpecularGradientPainter;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.*;
import org.jvnet.substance.theme.*;
import org.jvnet.substance.title.*;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;
import org.jvnet.substance.watermark.SubstanceStripeWatermark;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.Equalizer;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import javax.swing.JScrollPane;
import com.sun.awt.AWTUtilities;
import com.sun.jna.platform.unix.X11.Cursor;

import javax.swing.ImageIcon;
import org.jvnet.substance.*;
public class Myframe extends JFrame {

	private static final int UTF = 0;
	private JPanel contentPane;//主面板
	private JTabbedPane tabbedPane_list;//播放列表面板
	private JScrollPane scrollPane_list;
	private JScrollPane scrollPane_hlist;
	 private JList list ;
	 private JList hlist ;
	 DefaultListModel mode ;
	 DefaultListModel hmode ;
	private JMenuBar JMenuBar_MenuBar;//菜单栏
	private JMenu Menu_File;
	private JMenuItem MenuItem_Open;
	private JMenu menu_filelist;
	private JMenuItem MenuItem_OpenList;
	private JMenuItem MenuItem_CloseList;

	
	private JPanel panel_play;
	private JPanel panel_media_pro;//媒体和进度条面板
	private JPanel panel_Card_media_picture;//卡片容器
	private CardLayout card;
	private JLabel label_picture;//显示图片
	private JPanel panel_pro;	//进度条面板
	private JPanel panel_control;
	private JButton btn_play;
	private JButton btn_last;
	private JButton btn_stop;
	private JButton btn_next;
	private JButton btn_volume;
	private JSlider slider_volume;
	private JButton btn_full;
	private JPanel panel_list;
	private JPanel panel_hlist;
	static  EmbeddedMediaPlayerComponent player;
	private Canvas videoSurface;
	private JMenu Menu_Ctl;
	private JMenu Menu_Rate;
	private JRadioButtonMenuItem radioButtonMenuItem_low;
	private JRadioButtonMenuItem radioButtonMenuItem_normal;
	private JRadioButtonMenuItem radioButtonMenuItem_1_fast;
	private JRadioButtonMenuItem radioButtonMenuItem_2_two;
	private JMenu Menu_MediaScale;
	private JRadioButtonMenuItem radioButtonMenuItem_fifty;
	private JRadioButtonMenuItem radioButtonMenuItem_qishiwu;
	private JRadioButtonMenuItem radioButtonMenuItem_hundred;
	private JMenuBar menuBar_1;
	private JMenu Menu_FrameStyle;
	private JMenuItem mntmWindows;
	private JMenuItem mntmJava;
	private JMenuItem mntmNimbus;
	private JMenuItem mntmGood;
	private JMenu Menu_BianMa;
	private JMenuItem mntmCurrent;
	private JMenuItem mntmUTF8;
	private JMenu Menu_bg;
	private JMenuItem mntmBg;
	private MyOverlayFrame overlay;
	private JLabel label_time;
	private JProgressBar progressBar;
	private JLabel label_alltime;
	private SwingWorker t;
	private ArrayList<SwingWorker> array_SwingWorker;
	public Myframe() {
		setMinimumSize(new Dimension(1192,853));
		//setPreferredSize(new Dimension(1192, 853));
		setTitle("326视频播放器");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension di = kit.getScreenSize();
		double x = (di.getWidth() - 1192)/2;
		double y =  ((di.getHeight() - 853)/2);
		this.setLocation((int)x, (int)y);
		
		ImageIcon im = new ImageIcon("images//应用Logo.png");
		this.setIconImage(im.getImage());
		
		//设置鼠标图标


		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		/*******************菜单栏创建***************/
		 JMenuBar_MenuBar = new JMenuBar();
		setJMenuBar(JMenuBar_MenuBar);
		
		 Menu_File = new JMenu("文件");
		JMenuBar_MenuBar.add(Menu_File);
		
		 MenuItem_Open = new JMenuItem("打开本地文件");
		 MenuItem_Open.addActionListener(new ActionListener()
				 {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						PlayManage.openFile();
					}
			 			
				 });
		 
		Menu_File.add(MenuItem_Open);
		
		 menu_filelist = new JMenu("播放列表");
		JMenuBar_MenuBar.add(menu_filelist);
		
		MenuItem_OpenList = new JMenuItem("显示列表");
		MenuItem_OpenList.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						tabbedPane_list.setVisible(true);
					}
						
				});
		menu_filelist.add(MenuItem_OpenList);
		

		//菜单列表操作//
	    MenuItem_CloseList = new JMenuItem("隐藏列表");
	    MenuItem_CloseList.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						tabbedPane_list.setVisible(false);
					}
					
				});
		menu_filelist.add(MenuItem_CloseList);
		
		Menu_Ctl = new JMenu("媒体控制");
		JMenuBar_MenuBar.add(Menu_Ctl);
		
		Menu_Rate = new JMenu("播放速率");
		Menu_Ctl.add(Menu_Rate);
		
		
		/*播放速率菜单*/
		MyMenuItemListener MyMIL = new MyMenuItemListener();
		ButtonGroup bg = new ButtonGroup();
		radioButtonMenuItem_low = new JRadioButtonMenuItem("0.5");
		radioButtonMenuItem_low.setActionCommand("0.5");
		radioButtonMenuItem_low.addActionListener(MyMIL);
		Menu_Rate.add(radioButtonMenuItem_low);
		
		radioButtonMenuItem_normal = new JRadioButtonMenuItem("1");
		radioButtonMenuItem_normal.setActionCommand("1");
		radioButtonMenuItem_normal.addActionListener(MyMIL);
		Menu_Rate.add(radioButtonMenuItem_normal);
		
		radioButtonMenuItem_1_fast = new JRadioButtonMenuItem("1.5");
		radioButtonMenuItem_1_fast.setActionCommand("1.5");
		radioButtonMenuItem_1_fast.addActionListener(MyMIL);
		Menu_Rate.add(radioButtonMenuItem_1_fast);
		
		radioButtonMenuItem_2_two = new JRadioButtonMenuItem("2");
		radioButtonMenuItem_2_two.setActionCommand("2");
		radioButtonMenuItem_2_two.addActionListener(MyMIL);
		Menu_Rate.add(radioButtonMenuItem_2_two);
		
		bg.add(radioButtonMenuItem_low);
		bg.add(radioButtonMenuItem_normal);
		bg.add(radioButtonMenuItem_1_fast);
		bg.add(radioButtonMenuItem_2_two);
		
		
		/*视频比例菜单*/
		Menu_MediaScale = new JMenu("视频比例");
		Menu_Ctl.add(Menu_MediaScale);
		
		ButtonGroup bg_ratio = new ButtonGroup();
		radioButtonMenuItem_fifty = new JRadioButtonMenuItem("50%");
		radioButtonMenuItem_fifty.setActionCommand("50%");
		radioButtonMenuItem_fifty.addActionListener(MyMIL);
		Menu_MediaScale.add(radioButtonMenuItem_fifty);
		
		radioButtonMenuItem_qishiwu = new JRadioButtonMenuItem("75%");
		radioButtonMenuItem_qishiwu.setActionCommand("75%");
		radioButtonMenuItem_qishiwu.addActionListener(MyMIL);
		Menu_MediaScale.add(radioButtonMenuItem_qishiwu);
		
		radioButtonMenuItem_hundred = new JRadioButtonMenuItem("100%");
		radioButtonMenuItem_hundred.setActionCommand("100%");
		radioButtonMenuItem_hundred.addActionListener(MyMIL);
		Menu_MediaScale.add(radioButtonMenuItem_hundred);
		
		bg_ratio.add(radioButtonMenuItem_fifty);
		bg_ratio.add(radioButtonMenuItem_qishiwu);
		bg_ratio.add(radioButtonMenuItem_hundred);
		
		
		/*界面风格菜单*/
		Menu_FrameStyle = new JMenu("界面设置");
		JMenuBar_MenuBar.add(Menu_FrameStyle);
		
		mntmWindows = new JMenuItem("风格1");
		mntmWindows.setActionCommand("风格1");
		mntmWindows.addActionListener(MyMIL);
		Menu_FrameStyle.add(mntmWindows);
		
		mntmJava = new JMenuItem("风格2");
		mntmJava.setActionCommand("风格2");
		mntmJava.addActionListener(MyMIL);
		Menu_FrameStyle.add(mntmJava);
		
		mntmGood = new JMenuItem("最佳");
		mntmGood.setActionCommand("最佳");
		mntmGood.addActionListener(MyMIL);
		Menu_FrameStyle.add(mntmGood);
		
		mntmNimbus = new JMenuItem("默认");
		mntmNimbus.setActionCommand("默认");
		mntmNimbus.addActionListener(MyMIL);
		Menu_FrameStyle.add(mntmNimbus);
		

		/*编码设置*/
		Menu_BianMa = new JMenu("编码设置");
		JMenuBar_MenuBar.add(Menu_BianMa);
		
		mntmCurrent = new JMenuItem("当前解码");
		mntmCurrent.setActionCommand("当前解码");
		mntmCurrent.addActionListener(MyMIL);
		Menu_BianMa.add(mntmCurrent);
		
		mntmUTF8 = new JMenuItem("UTF8");
		mntmUTF8.setActionCommand("UTF8");
		mntmUTF8.addActionListener(MyMIL);
		Menu_BianMa.add(mntmUTF8);
		
		
		/*音乐背景*/
		Menu_bg = new JMenu("音乐设置");
		JMenuBar_MenuBar.add(Menu_bg);
		
		mntmBg  = new JMenuItem("背景图片");
		mntmBg.setActionCommand("背景图片");
		mntmBg.addActionListener(MyMIL);
		Menu_bg.add(mntmBg);

		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		
	
		
	
		
		/******************播放面板****************************/
		panel_play = new JPanel();
		panel_play.setBackground(Color.LIGHT_GRAY);
		
		
		/*添加播放面板到正个容器的中间*/
		contentPane.add(panel_play, BorderLayout.CENTER);
		panel_play.setLayout(new BorderLayout(0, 0));
	
		player = new EmbeddedMediaPlayerComponent();	
		player.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter()
				{
						public void playing(MediaPlayer mediaPlayer)
						{
							/*SwingUtilities.invokeLater(new Runnable()
									{

										@Override
										public void run() {*/
											// TODO Auto-generated method stub
											setTitle();
											Main.frame.setMediaLoGo();
											Main.frame.setMarquee();
											setalltime();
											/*关闭之前的线程*/
											  for(SwingWorker worker:Main.frame.getSwingWorker())
									           {
									        	   if(!worker.isCancelled())
									        	   {
									        		   System.out.println("关闭线程");
									        		   worker.cancel(true);
									        	   }
									           }
											updateProgress();
							
										//}
										
									//});
						}
						public void finished(MediaPlayer mediaPlayer)
						{
							SwingUtilities.invokeLater(new Runnable()
									{

										@Override
										public void run() {
											// TODO Auto-generated method stub
										Main.Index++;
										int index =	Main.Index % (Main.frame.getMode().size());
										String resource = (String)Main.frame.getMode().getElementAt(index);
										PlayManage.mediaplay(resource);
										}
								
									});
						}
						public void err(MediaPlayer mediaPlayer)
						{
							SwingUtilities.invokeLater(new Runnable()
									{

										@Override
										public void run() {
											// TODO Auto-generated method stub
											JOptionPane.showMessageDialog(null, "alter","alter",JOptionPane.ERROR_MESSAGE);
										}
								
									});
						}
				});
		videoSurface = player.getVideoSurface();
		videoSurface.addMouseListener(new MyMouseListener());
		videoSurface.addMouseMotionListener(new MouseMotionListener()
				{

					@Override
					public void mouseDragged(MouseEvent e) {
						// TODO Auto-generated method stub
				
					}

					@Override
					public void mouseMoved(MouseEvent e) {
						// TODO Auto-generated method stub
						Main.frame.getPanel_pro().setVisible(true);
					}
			
				});
		videoSurface.addKeyListener(new MyKeyListener());

		
		
		/*
		
		MediaPlayerFactory factory = player.getMediaPlayerFactory();
		Equalizer equalizer = factory.newEqualizer();
		java.util.List<String> presetNames =  factory.getEqualizerPresetNames();
		player.getMediaPlayer().setEqualizer(equalizer);
		for(String str : presetNames)
		{
			System.out.println(str);
		}
		*/
		
		/*媒体_进度条面板*/
		panel_media_pro = new JPanel();
		panel_media_pro.setLayout(new BorderLayout(0,0));
		
		
		//添加到左边的面板的中间
		panel_play.add(panel_media_pro, BorderLayout.CENTER);
		
		
		/*卡片面板：用来放媒体控件和JLabel*/
		card =new CardLayout();
		panel_Card_media_picture = new JPanel(card);
		panel_Card_media_picture.add(player,"media");
		label_picture = new JLabel();
		label_picture.addMouseListener(new MyMouseListener());
		label_picture.setFocusTraversalKeysEnabled(true);
		label_picture.setFocusable(true);
		label_picture.addKeyListener(new MyKeyListener());
		panel_Card_media_picture.add(label_picture,"picture");
		
	//	panel_Card_media_picture.setPreferredSize(new Dimension(650,530));
		//让他先显示图片面板
		card.show(panel_Card_media_picture,"picture");
		
		/*进度条面板*/
		panel_pro = new JPanel();
		panel_pro.setVisible(false);
		panel_pro.setPreferredSize(new Dimension(10, 18));

		panel_media_pro.add(panel_Card_media_picture, BorderLayout.CENTER);

		panel_media_pro.add(panel_pro,BorderLayout.SOUTH);
		panel_pro.setLayout(new BoxLayout(panel_pro, BoxLayout.X_AXIS));
		
		label_time = new JLabel("时间");
		panel_pro.add(label_time);
		
		JButton btn_full = new JButton("全");
		btn_full.setPreferredSize(new Dimension(20, 23));
		btn_full.setMinimumSize(new Dimension(0, 0));
		btn_full.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(Main.frame.player.getMediaPlayer().isFullScreen())
						{
							PlayManage.ExitScreen();
						}
						else
						{
							PlayManage.fullScreen();
						}
					}
					
				});
		progressBar = new JProgressBar();
		progressBar.setMaximum(1000);
		progressBar.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				int x = e.getX();
				PlayManage.jumpTo((float)x/progressBar.getWidth());
			}
		});//进度条跳转
		panel_pro.add(progressBar);
		
		label_alltime = new JLabel("时间");
		panel_pro.add(label_alltime);
		//panel_pro.add(Box.createHorizontalStrut(40));
		panel_pro.add(btn_full);
		
		
		
		
		/*媒体控制面板*/
		panel_control = new JPanel();
		panel_control.setPreferredSize(new Dimension(10, 30));
		panel_control.setBackground(Color.WHITE);
		panel_play.add(panel_control, BorderLayout.SOUTH);
		panel_control.setLayout(new BoxLayout(panel_control, BoxLayout.X_AXIS));
		
		btn_play = new JButton("播放");
		btn_play.setMinimumSize(new Dimension(0, 0));
		btn_play.setPreferredSize(new Dimension(5,5));
		btn_play.setMaximumSize(new Dimension(10, 30));
		btn_play.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(player.getMediaPlayer().isPlaying())
					{
						PlayManage.pause();
						btn_play.setText("播放");
					}
					else
					{
					PlayManage.play();
					btn_play.setText("暂停");
					}
				}
			
			});
		btn_play.setPreferredSize(new Dimension(60, 60));
		panel_control.add(btn_play);
		panel_control.add(Box.createVerticalStrut(15));
		
		btn_last = new JButton("上一个");
		btn_last.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						PlayManage.last();
					}
					
				});
		panel_control.add(btn_last);
		
		btn_stop = new JButton("停止");
		btn_stop.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						PlayManage.stop();
					}
					
				});
		panel_control.add(btn_stop);
		
		btn_next = new JButton("下一个");
		btn_next.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						PlayManage.next();
					}
			
				});
		panel_control.add(btn_next);
		panel_control.add(Box.createVerticalStrut(10));
		
		btn_volume = new JButton("静音");
		btn_volume.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						PlayManage.NoVolume();
					}
					
				});
		btn_volume.setPreferredSize(new Dimension(60, 30));
		btn_volume.setMinimumSize(new Dimension(20, 20));
		panel_control.add(btn_volume);
		
		slider_volume = new JSlider(0,300);
		slider_volume.setPreferredSize(new Dimension(100, 23));
		//slider_volume.setSize(new Dimension(10, 0));
		slider_volume.setMaximumSize(new Dimension(100, 23));
		slider_volume.setMinimumSize(new Dimension(100, 23));
		slider_volume.addChangeListener(new ChangeListener()
				{

					@Override
					public void stateChanged(ChangeEvent e) {
						// TODO Auto-generated method stub
						JSlider source =(JSlider) e.getSource();
						PlayManage.setVol(source.getValue());
					}
					
				});


		panel_control.add(slider_volume);
		panel_control.add(Box.createHorizontalStrut(40));
		
		btn_full = new JButton("全屏");
		btn_full.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						PlayManage.fullScreen();
					}
					
				});
		btn_full.setPreferredSize(new Dimension(60, 20));
		btn_full.setMinimumSize(new Dimension(10, 10));
		panel_control.add(btn_full);
		
		/*播放列表面板*/
		tabbedPane_list = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_list.setPreferredSize(new Dimension(160, 5));
		contentPane.add(tabbedPane_list, BorderLayout.EAST);
		
		/*播放记录*/
		panel_list = new JPanel();
		mode = new  DataModel();
		panel_list.setLayout(new BorderLayout(0, 0));
		list = new JList(mode);
		list.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				
				if(e.getClickCount() == 2)
				{
					
					PlayManage.mediaplay((String)list.getSelectedValue());
				}
			}
		});
		scrollPane_list = new JScrollPane(list);
		panel_list.add(scrollPane_list);
		panel_list.setBackground(Color.black);
		tabbedPane_list.addTab("播放列表", null, panel_list, null);
	

		/*历史记录*/
		panel_hlist = new JPanel();
		panel_hlist.setLayout(new BorderLayout(0, 0));
		hmode = new DataModel(1);
		hlist = new JList(hmode);
		hlist.addMouseListener(new MouseAdapter(){							
		public void mouseClicked(MouseEvent e)
			{
				
				if(e.getClickCount() == 2)
				{
					
					PlayManage.mediaplay((String)hlist.getSelectedValue());
				}
			}
		});
		scrollPane_hlist = new JScrollPane(hlist);
		panel_hlist.add(scrollPane_hlist);
		panel_hlist.setBackground(Color.BLUE);
		tabbedPane_list.addTab("历史记录", null, panel_hlist, null);
		
		
		/*线程管理*/
		array_SwingWorker = new ArrayList<SwingWorker>();
		
		
		/*边框设置*/
		//this.contentPane.setBorder(BorderFactory.createLineBorder(Color.red,1));
		//this.setUndecorated(true);
		/*拖动实现*/
		this.Mydrag();
	}
	private Point Point(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	public JSlider getSlider_volume() {
		return slider_volume;
	}
	public void setTitle()
	{
		String title = PlayManage.getTitle();
		if(title.substring(0,4).equals("http"))
			this.setTitle("326视频播放器-网络电视");	
		else
			this.setTitle("326视频播放器-"+title);
	}//设置标题
	public JList getList() {
		return list;
	}

	public JList getHlist() {
		return hlist;
	}
	public JTabbedPane getTabbedPane()
	{
		return this.tabbedPane_list;
	}
	public JPanel getPanel()
	{
		return panel_control;
	}
	public DefaultListModel getMode() {
		return mode;
	}//返回记录中模式

	public DefaultListModel getHMode() {
		return hmode;
	}//返回历史中模式
	public void setMediaLoGo()
	{
			
		 player.getMediaPlayer().setLogoFile("images//logo.psd");
		 player.getMediaPlayer().setLogoOpacity(60);
		 player.getMediaPlayer().setLogoLocation(0, 0);
		 player.getMediaPlayer().enableLogo(true);
	}//设置LOGO
	public void setMarquee()
	{
	
		player.getMediaPlayer().setMarqueeText("326 player");
		 player.getMediaPlayer().setMarqueeSize(60);
		 player.getMediaPlayer().setMarqueeOpacity(60);
		 player.getMediaPlayer().setMarqueeColour(Color.BLUE);
		 player.getMediaPlayer().setMarqueeTimeout(3000);
		 int x =player.getWidth();
		 int y = player.getHeight();
		 player.getMediaPlayer().setMarqueeLocation(x/2,y);
		 player.getMediaPlayer().enableMarquee(true);
	}//设置字幕
	//设置字幕
	public void setalltime()
	{
		long alltime = this.player.getMediaPlayer().getLength();
		int miao = (int) (alltime / 1000);
		int hours = (int)miao / 3600;
		int minutes = (miao - hours*3600)/60;
		int seconds = (miao - hours*3600 - minutes*60);
		String str_alltime = String.format("%02d:%02d:%02d",hours,minutes,seconds);
		this.label_alltime.setText(str_alltime);
	}//设置总时间
	public void setcurtime()
	{
		long curr = Main.frame.player.getMediaPlayer().getTime();
		int miao = (int) (curr / 1000);
		int hours = (int)miao / 3600;
		int minutes = (miao - hours*3600)/60;
		int seconds = (miao - hours*3600 - minutes*60);
		String str_curtime = String.format("%02d:%02d:%02d",hours,minutes,seconds);
		this.label_time.setText(str_curtime);
	}//设置当前时间
	public void updateProgress()
	{
		  SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	 t = new SwingWorker<String,Integer>(){
						protected String doInBackground() throws Exception
						{
							while(true)
							{	
							setcurtime();
							float jindu = Main.frame.player.getMediaPlayer().getPosition();		
							publish((int)(jindu*1000));
							
							Thread.sleep(100);
							}
							
						}
						protected void process(java.util.List<Integer> chunks)
						{
							for(int v:chunks)
							{
								Main.frame.progressBar.setValue(v);
							

							}
						}
					};
					t.execute();
					array_SwingWorker.add(t);
	            }
		  });
	}
	//更新进度条
	public JPanel getPanel_pro()
	{
		return panel_pro;
	}
	public JButton get_btnplay()
	{
			return btn_play;
	}
	public ArrayList<SwingWorker> getSwingWorker()
	{
		return this.array_SwingWorker;
	}
	public JTabbedPane  gettabbedPane_list()
	{
		return tabbedPane_list;
	}
	public static void setskin() 
	//设置皮肤
	{
		
		

			//@Override
			
				// TODO Auto-generated method stub
		
		     
		    	/*
		        try {
		            JFrame.setDefaultLookAndFeelDecorated(true);
		          //  UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		        	UIManager.setLookAndFeel( new  SubstanceOfficeBlue2007LookAndFeel());
		            UIManager.setLookAndFeel( " org.jvnet.substance.skin.SubstanceRavenGraphiteLookAndFeel " );  
		        } catch (Exception e) {
		            //e.printStackTrace();
		        }
		        */
		
				try {
							UIManager.setLookAndFeel(new SubstanceGreenMagicLookAndFeel());
				} catch (UnsupportedLookAndFeelException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
					}
	
		          //设置主题   
		       SubstanceLookAndFeel.setCurrentTheme(new SubstanceBottleGreenTheme());  
		         //设置皮肤
		       SubstanceLookAndFeel.setSkin(new GreenMagicSkin());
		       SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper()); //设置水印  
		       SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());  
		          //设置边框  
		       SubstanceLookAndFeel.setCurrentBorderPainter(new ClassicBorderPainter());  
		          //设置渐变渲染  
		        SubstanceLookAndFeel.setCurrentGradientPainter(new SpecularGradientPainter());  
		          //设置标题  
		        SubstanceLookAndFeel.setCurrentTitlePainter(new Glass3DTitlePainter());
		        
			   	JDialog.setDefaultLookAndFeelDecorated(true);
			    JFrame.setDefaultLookAndFeelDecorated(true);  
		
	}
			
		
    
	
	
	public void Mydrag()
	{
		 new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, new DropTargetAdapter()
				 {

					@Override
					public void drop(DropTargetDropEvent dtde) {
						// TODO Auto-generated method stub
						try
						{
							if(dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor))//文件格式若支持
							{
								 dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
								 Object resource =  (dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor));
								 int length  = resource.toString().length();
								 String res = resource.toString().substring(1,length - 1 );
								 PlayManage.mediaplayAbsolute(res);
							}
							else
							{
								dtde.rejectDrop();
								JOptionPane.showMessageDialog(null, "不支持的格式");
							}
						}catch(Exception e)
						{
							e.printStackTrace();
						}
					}
			 
				 });
	}
	public JLabel getLabel_Picture()
	{
		return this.label_picture;
	}
	public CardLayout getCardLayout()
	{
		return this.card;
	}
	public JPanel getCardPane()
	{
		return this.panel_Card_media_picture;
	}
}