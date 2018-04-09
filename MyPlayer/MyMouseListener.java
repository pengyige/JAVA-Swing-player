package MyPlayer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

public class MyMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(Main.frame.player.getMediaPlayer().isPlaying())
		{
			PlayManage.pause();
			Main.frame.get_btnplay().setText("播放");
		}
		else
		{
		PlayManage.play();
		Main.frame.get_btnplay().setText("暂停");
		}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

		Main.frame.player.requestFocusInWindow();
		Main.frame.getPanel_pro().setVisible(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Timer t = new Timer();
		MyDelay tt = new MyDelay();
		t.schedule(tt, 5000);
	}

}
