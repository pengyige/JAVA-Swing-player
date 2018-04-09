package MyPlayer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.RenderingHints;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

import com.sun.jna.platform.WindowUtils;

import uk.co.caprica.vlcj.component.overlay.AbstractJWindowOverlayComponent;

public class MyOverlayFrame extends	Window{
	private static final long serialVersionUID = 1L;
	public MyOverlayFrame(Window owner) {
		super(owner, WindowUtils.getAlphaCompatibleGraphicsConfiguration());
		this.setSize(100,200);
        this.add(new JLabel("背景"));
		setBackground(new Color(100, 200, 100));
		
	}
	





}
