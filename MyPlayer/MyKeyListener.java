package MyPlayer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyChar());
		if(e.getKeyCode() == e.VK_ESCAPE)
		{
			PlayManage.ExitScreen();
			
		}
		if(e.getKeyCode() == e.VK_SPACE)
		{
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
		if(e.getKeyCode() == e.VK_DOWN)
		{
			int cur_Volumne = Main.frame.player.getMediaPlayer().getVolume();
			int volume = --cur_Volumne;
			Main.frame.player.getMediaPlayer().setVolume(volume);
			Main.frame.getSlider_volume().setValue(volume);
		}
		if(e.getKeyCode() == e.VK_UP)
		{
			int cur_Volumne = Main.frame.player.getMediaPlayer().getVolume();
			int volume = ++cur_Volumne;
			Main.frame.player.getMediaPlayer().setVolume(volume);
			Main.frame.getSlider_volume().setValue(volume);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

}
