
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Cell extends JLabel {
	ImageIcon deadIcon;
	public boolean willBeAliveNextGen;
	public boolean alive;
	ImageIcon wasAliveIcon;
	boolean down;
	boolean wasAlive;
	ImageIcon aliveIcon;
	public boolean paused=false;
	public ArrayList<Cell> neighbors = new ArrayList<Cell>();
	//false is dead
	public Cell() {
		BufferedImage deadBufferedImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
		Graphics g = deadBufferedImage.getGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 10, 10);
		g.setColor(Color.white);
		g.fillRect(1, 1, 8, 8);
		g.finalize();
		deadIcon = new ImageIcon(deadBufferedImage);
		BufferedImage aliveBufferedImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
		g= aliveBufferedImage.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, 10, 10);
		g.finalize();
		aliveIcon = new ImageIcon(aliveBufferedImage);
		BufferedImage wasAliveBufferedImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
		g=wasAliveBufferedImage.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, 10, 10);
		g.setColor(new Color(128,128,128));
		g.fillRect(1, 1, 8, 8);
		g.finalize();
		wasAliveIcon = new ImageIcon(wasAliveBufferedImage);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(paused) {
					if(alive) {
						dead();
					}
					else {
						alive();
					}
				}
			}
			
			
		});
	}
	public void wasAlive() {
		setIcon(wasAliveIcon);
		alive=false;
		wasAlive=true;
		willBeAliveNextGen=false;
	}
	public int getAliveCount() {
		int count=0;
		for(int i =0; i < neighbors.size();i++) {
			if(neighbors.get(i).alive) {
				count++;
			}
		}
		return count;
	}
	public void dead() {
		setIcon(deadIcon);
		alive=false;
		wasAlive=false;
		willBeAliveNextGen=false;
	}
	public void alive() {
		setIcon(aliveIcon);
		alive=true;
		willBeAliveNextGen=true;
	}
}
