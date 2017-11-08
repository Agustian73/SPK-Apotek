
package tampilan;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;


public class ClGambarDesktop extends JDesktopPane
{
        @Override
	protected void paintComponent(Graphics graph)
	{
		Graphics2D g2D = (Graphics2D) graph.create();
		
		Image img = new ImageIcon(getClass().getResource("/gambar/bgutama.jpg")).getImage();
		
		g2D.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		g2D.dispose();
	}
}