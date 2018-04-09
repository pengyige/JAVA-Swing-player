package MyPlayer;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class CloseListener extends WindowAdapter{

		public void windowClosing(WindowEvent e) {
		int flag  = JOptionPane.showConfirmDialog(null, "确定退出播放器吗?","326播放器",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
		if(0 == flag)
       {
           Main.frame.player.getMediaPlayer().stop();
           Main.frame.player.getMediaPlayer().release();
           for(SwingWorker worker:Main.frame.getSwingWorker())
           {
        	   if(!worker.isCancelled())
        	   {
        		   System.out.println("关闭线程"+worker.getProgress());
        		   worker.cancel(true);
        	   }
           }
           Main.frame.dispose();
           
           System.exit(0);
       }
    
	   }
}
