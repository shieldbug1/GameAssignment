package game.build.graphic;

import static game.build.util.Reference.GAME_DIMENSION;
import static java.awt.Font.PLAIN;
import game.build.util.Logger;
import game.build.util.Resources;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class NormalWon extends MenuPane
{
	private static final Font TITLE_FONT = Resources.getCustomFont().deriveFont(PLAIN, 110);
	private static final Font TIME_FONT = Resources.getCustomFont().deriveFont(PLAIN, 80);
	
	private final String songTitle;
	
	public NormalWon(String songName)
	{
		super("normalWon");
		Logger.info("Normal mode won! Beat: " + songName);
		this.songTitle = songName;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.GREEN);
		g2d.setFont(TITLE_FONT);
		g2d.drawString("Congratulations!", (GAME_DIMENSION.width - 1000)/2, GAME_DIMENSION.height*180/720);
		g2d.setFont(TIME_FONT);
		g2d.drawString("You beat: " + this.songTitle, centreTextOffset(this.songTitle.length() + 10), GAME_DIMENSION.height*320/720);
		g2d.dispose();
	}
	
	private static int centreTextOffset(int l)
	{
		switch(l)
		{
		case 10: return (GAME_DIMENSION.width - 424)/2;
		case 11: return (GAME_DIMENSION.width-492)/2;
		case 18: return (GAME_DIMENSION.width-710)/2;
		case 19: return (GAME_DIMENSION.width -790)/2;
		default:
			return (int) Math.round((GAME_DIMENSION.width-37.0769D*l-66.3846D)/2); // linear interpolation (who survives for 10+ minutes anyway?)
		}
	}
}
