package MyGif;

import java.awt.*;
import java.util.logging.Logger;

import javax.swing.*;
import MyPlayer.Main;
public class FlashScreen extends JWindow {
//�������������ص����
JProgressBar jpb;//���������
JLabel jl1;//�����ڴ���ı�����һ��ͼƬ���ϲ��ǽ�����
int width,height;//���ڻ�ȡ��ʾ���ֱ��ʴ�С

//���캯��
public FlashScreen()
{ 
//������ǩ,���ڱ�ǩ�Ϸ���һ��ͼƬ
	System.out.print("开始创建闪屏");
	this.setSize(400,263);
	width=Toolkit.getDefaultToolkit().getScreenSize().width;
	height=Toolkit.getDefaultToolkit().getScreenSize().height;
	this.setLocation(width/2-200,height/2-150);
jl1=new JLabel();
jl1.setSize(300,200);
//����������
jpb=new JProgressBar();
//���ý���������
jpb.setStringPainted(true);//��ʾ��ǰ����ֵ��Ϣ
jpb.setIndeterminate(false);//ȷ��������ִ����ɺ����ع���
jpb.setBorderPainted(false);//���ý������߿���ʾ
jpb.setBackground(Color.darkGray);//���ý������ı���ɫ

//������
this.add(jl1,BorderLayout.NORTH);
this.add(jpb,BorderLayout.SOUTH);

ImageIcon img = new ImageIcon("images//FlashScreen.jpg");
int width = jl1.getWidth();
int height = jl1.getHeight();
Image image = img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
img.setImage(image);
jl1.setIcon(img);
}

public JProgressBar getProgress()

{
	return this.jpb;
}

public void updateProgress() {
	SwingUtilities.invokeLater(new Runnable() {

	//��������ɺ�ִ����Ӧ�Ĳ��������л��������Ĵ��ڣ�ͬʱ�رս��������ڵ�
	//new Login();
	//�رս���������
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Main.t = new SwingWorker<String,Integer>(){

			@Override
				protected String doInBackground() throws Exception {
				// TODO Auto-generated method stub
					int []progressValue={0,1,5,8,14,17,26,35,38,43,49,56,65,71,75,78,86,94,98,99,100};
				
					for(int i=0;i<progressValue.length;i++)
					{

					Thread.sleep(1000);
				//	System.out.println("开始线程等待"+i);
				//	System.out.println("开始更新");
					Main.indexa.getProgress().setValue(progressValue[i]);;
				//publish((int)(progressValue[i]) );
					
					}
					Main.indexa.dispose();
					return null;
				}
				/*protected void process(java.util.List<Integer> chunks)
				{
					for(int v:chunks)
					{
					
					}
				}*/
	
			};
			Main.t.execute();
	
	};

	});

}
}
