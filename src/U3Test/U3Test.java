// Reece Yang
//
// This driver class has an applet that uses the Postage class to
// determine the cost to mail an item.

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class U3Test extends JApplet {

  double cost;

	public void init() {

      String input = JOptionPane.showInputDialog(
        "Enter Postage Type & ounces, separated by a space:");

      String type = input.substring(0, 1);
      double weight = Double.parseDouble(input.substring(2));

      Postage p = new Postage(type, weight);

      cost = p.calculate();

      setBackground(Color.yellow);
	}

	public void paint(Graphics g) {

		g.setColor(Color.darkGray);

		Font f = new Font("Monospaced", Font.BOLD, 16);
		g.setFont(f);

		String output = String.format("$%5.2f", cost);

		g.drawString("Cost to mail this item =", 10, 20);
		g.drawString(output, 42, 36);
	}
}
