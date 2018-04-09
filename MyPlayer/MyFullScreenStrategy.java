package MyPlayer;
import java.awt.Window;
import java.util.Random;

import uk.co.caprica.vlcj.player.embedded.DefaultAdaptiveRuntimeFullScreenStrategy;

public class MyFullScreenStrategy extends DefaultAdaptiveRuntimeFullScreenStrategy{

	public MyFullScreenStrategy(Window window) {
		super(window);
		// TODO Auto-generated constructor stub
	}
	protected void beforeEnterFullScreen() {
		Main.frame.getJMenuBar().setVisible(false);
	    Main.frame.getTabbedPane().setVisible(false);
	    Main.frame.getPanel().setVisible(false);
	    Main.frame.player.getVideoSurface().requestFocusInWindow();
	    /*设置背景*/
	    String source = "images//风景";
	    Random r1 = new Random();
	    int num = r1.nextInt(7)+1;
	    Main.source_picture = source+num+".jpg";
	    PlayManage.ShowPicture(Main.source_picture);
	  
    }
    protected void afterExitFullScreen() {
    	Main.frame.getJMenuBar().setVisible(true);
	    Main.frame.getTabbedPane().setVisible(true);
	    Main.frame.getPanel().setVisible(true);
	    /*设置默认背景*/
	    String source = "images//默认";
	    Random r1 = new Random();
	    int num = r1.nextInt(2)+1;
	    Main.source_picture = source+num+".jpg";
	    PlayManage.ShowPicture(Main.source_picture);
	    
    }
}
