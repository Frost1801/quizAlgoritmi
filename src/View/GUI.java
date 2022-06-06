package View;

import View.Frame.MainFrame;

import java.awt.*;

public class GUI {

    public static String GENERAL_FONT = "Dialog";



    public GUI (){
        mainFrame = new MainFrame();


        mainFrame.setVisible(true);


    }



    MainFrame mainFrame;

}
