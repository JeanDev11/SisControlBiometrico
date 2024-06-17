package Util;

import com.kitfox.svg.SVGDiagram;
import com.kitfox.svg.SVGException;
import com.kitfox.svg.SVGUniverse;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URI;
import javax.swing.JPanel;

public class SVGExample extends JPanel{

    private final SVGDiagram diagram;

    public SVGExample(String svgPath) {
        SVGUniverse svgUniverse = new SVGUniverse();
        URI uri = svgUniverse.loadSVG(getClass().getResource(svgPath));
        diagram = svgUniverse.getDiagram(uri);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (diagram != null) {
            try {
                diagram.render(g2d);
            } catch (SVGException e) {
                e.printStackTrace();
            }
        }
    }

    
}
