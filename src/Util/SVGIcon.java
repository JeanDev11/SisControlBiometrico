package Util;

import com.kitfox.svg.SVGDiagram;
import com.kitfox.svg.SVGException;
import com.kitfox.svg.SVGUniverse;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class SVGIcon implements Icon {
    private final SVGDiagram diagram;

    public SVGIcon(String svgPath) {
        SVGUniverse svgUniverse = new SVGUniverse();
        URI uri = svgUniverse.loadSVG(getClass().getResource(svgPath));
        diagram = svgUniverse.getDiagram(uri);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (diagram != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.translate(x, y);
            try {
                diagram.render(g2d);
            } catch (SVGException e) {
                e.printStackTrace();
            }
            g2d.dispose();
        }
    }

    @Override
    public int getIconWidth() {
        return diagram != null ? (int) diagram.getWidth() : 0;
    }

    @Override
    public int getIconHeight() {
        return diagram != null ? (int) diagram.getHeight() : 0;
    }
}
