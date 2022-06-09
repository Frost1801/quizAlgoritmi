package View.Frame;

import View.GUI;

import javax.swing.*;
import java.awt.*;

public class GUIElementsFactory {

    public static final int VERY_LARGE_TEXT_SIZE = 45;
    public static final int LARGE_TEXT_SIZE = 35;
    public static final int MEDIUM_TEXT_SIZE = 18;
    public static final int SMALL_TEXT_SIZE = 12;


    //creates a text label
    public static JLabel createStandardLabel(String text, Color color, int size,boolean centerAligned,boolean addHTML){
        JLabel toReturn = new JLabel();
        if (addHTML) {
            toReturn.setText(addHTML(text));
        }
        else {
            toReturn.setText(text);
        }

        toReturn.setFont(new Font (GUI.GENERAL_FONT,Font.BOLD,size));
        toReturn.setForeground(color);
        if (centerAligned)
            toReturn.setHorizontalAlignment(JLabel.CENTER);
        return toReturn;
    }
    //creates a button with an image
    public static JButton createJButtonWithImage (String path, Color backgroundColor, double ratio){
        JButton toReturn = new JButton();
        toReturn.setIcon(GUI.getFixedDimensionImage(path, ratio));
        toReturn.setBackground(backgroundColor);
        toReturn.setFocusable(false);
        return toReturn;
    }
    public static JButton createJButtonWithText (String description, Color backgroundColor, Color foregroundColor){
        JButton toReturn = new JButton(description);
        toReturn.setBackground(backgroundColor);
        toReturn.setForeground(foregroundColor);
        toReturn.setFocusable(false);
        return toReturn;
    }

    public static GridBagConstraints createGridBagConstraint (int x, int y, int topSpacing, int leftSpacing, int bottomSpacing, int rightSpacing){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(topSpacing,leftSpacing,bottomSpacing,rightSpacing);
        return gbc;
    }



    public static String addHTML (String toReturn){
        return  "<html><body style='text-align: center'><p style=\"width:600px\">" + toReturn + "</p></html>";
    }


}
