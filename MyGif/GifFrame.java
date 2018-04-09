/*
 * Donttai.java
 *
 * Created on __DATE__, __TIME__
 */

package MyGif;

import java.awt.*;
import java.io.File;

import javax.swing.*;
/**
 *
 * @author  __USER__
 */
public class GifFrame extends javax.swing.JFrame 
{

    /** Creates new form Donttai */
    //GEN-BEGIN:variables
    // Variables declaration - do not modify
	private JLabel label_Gif;
    public GifFrame(String path)
    {
       ImageIcon i = new ImageIcon(path);
       this.setTitle("MyGif");
       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       int x = i.getIconWidth();
       int y = i.getIconHeight();
       this.setSize(x,y);
       
       Toolkit kit = Toolkit.getDefaultToolkit();
       Dimension di = kit.getScreenSize();
       double location_x = (di.getWidth() - 800)/2;
       double location_y =  ((di.getHeight() - 600)/2);
       this.setLocation((int)location_x, (int)location_y);
       label_Gif = new JLabel();
       label_Gif.setIcon(i);
       this.getContentPane().add(label_Gif);
       this.setResizable(false);
       this.setVisible(true);
       
    }

    //String path = "E:\\Workspaces\\MyEclipse_9.0\\20120731\\bin\\动态图\\1\\10";
    //Java默认文件路径是项目的根目录，所以要手动加上bin及其以下的路径

/*

    public void paint(Graphics g)
    {
        ImageObserver imageObserver = new ImageObserver()
        {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y,
                    int width, int height)
            {
                // TODO Auto-generated method stub
                return false;
            }
        };
        try
        {
            //g.drawImage(ImageIO.read(new File(Donttai.class.getResource("1.png").toString())), 20, 20, imageObserver);
       
            g.drawImage(ImageIO.read(new File("images//mygif.gif")), 100, 50, 400, 300,
                    imageObserver);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

*/
}