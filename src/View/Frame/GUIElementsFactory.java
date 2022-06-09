package View.Frame;

import View.GUI;

import javax.swing.*;
import java.awt.*;

public class GUIElementsFactory {
    public static final int TITLE_SIZE = 35;
    public static final int MEDIUM_TEXT_SIZE = 18;
    public static final int SMALL_TEXT_SIZE = 12;


    //creates a text label
    public static JLabel createStandardLabel(String text, Color color, int size,boolean centerAligned){
        JLabel toReturn = new JLabel(addHTML(text));
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
    public static JButton createJButtonWithText (String description, Color backgroundColor){
        JButton toReturn = new JButton(description);
        toReturn.setBackground(backgroundColor);
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
        return  "<html><body style='text-align: center'><p>" + toReturn + "</p></html>";
    }


}
