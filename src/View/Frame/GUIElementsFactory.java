package View.Frame;

import View.GUI;

import javax.swing.*;
import java.awt.*;

public class GUIElementsFactory {
    public static final int TITLE_SIZE = 26;
    public static final int MEDIUM_TEXT_SIZE = 18;
    public static final int SMALL_TEXT_SIZE = 12;



    public static JLabel createStandardLabel(String text, Color color, int size){
        JLabel toReturn = new JLabel(addHTML(text));
        toReturn.setFont(new Font (GUI.GENERAL_FONT,Font.BOLD,size));
        toReturn.setForeground(color);
        return toReturn;
    }

    public static GridBagConstraints createGridBagConstraint (int x, int y, int topSpacing, int leftSpacing, int bottomSpacing, int rightSpacing){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(topSpacing,leftSpacing,bottomSpacing,rightSpacing);
        return gbc;
    }




    public static String addHTML (String toReturn){
        return  "<html><body style='text-align: center'><p>" + toReturn + "</p></html>";
    }


}
