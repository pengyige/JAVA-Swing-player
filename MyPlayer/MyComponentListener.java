package MyPlayer;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MyComponentListener extends ComponentAdapter{
	public void componentResized(ComponentEvent e)
	{
		PlayManage.ShowPicture(Main.source_picture);
	//	System.out.println("窗口大小:"+Main.frame.getWidth()+"  "+Main.frame.getHeight());
	//	System.out.println("图片width:"+Main.frame.getLabel_Picture().getWidth()+"图片height"+Main.frame.getLabel_Picture().getHeight());
	}

}
