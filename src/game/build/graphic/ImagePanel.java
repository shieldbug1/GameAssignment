package game.build.graphic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JComponent;

public class ImagePanel extends JComponent
{
	protected Image image;
	private int xOffset, yOffset;
	
	public ImagePanel(Image image, int x, int y)
	{
		this.image = image;
		this.xOffset = x;
		this.yOffset = y;
		this.setPreferredSize(new Dimension(image.getWidth(this),image.getHeight(this)));
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawImage(image, xOffset, yOffset, this);
		g2d.dispose();
	}
	
}