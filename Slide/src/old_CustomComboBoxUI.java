import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

class old_CustomComboBoxUI extends BasicComboBoxUI {
    
    // Override the paintCurrentValue() method to change the selected value color
    @Override
	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
    	if (comboBox.getSelectedIndex() == -1) { // Check if no item is selected
            g.setColor(Color.GRAY); // Set the color to gray
            g.drawString("Select", bounds.x + 3, bounds.y + bounds.height - 3); // Draw the ghost text
        } else {
            super.paintCurrentValue(g, bounds, hasFocus); // Call the original method
        }
    }
    
    // Override the paintCurrentValueBackground() method to change the background color of the selected value
    @Override
	public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        g.setColor(new Color(255, 145, 43)); // Change the color to a custom RGB value
        super.paintCurrentValueBackground(g, bounds, hasFocus);
    }
    
    // Override the paintArrowButton() method to change the color of the dropdown arrow
    @Override
    protected JButton createArrowButton() {
        JButton button = super.createArrowButton();
        button.setBackground(Color.BLACK);// Change the color to a custom RGB value
        //button.setForeground(new Color(255, 145, 43));
        button.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4)); // Add some padding
        return button;
    }
    
}