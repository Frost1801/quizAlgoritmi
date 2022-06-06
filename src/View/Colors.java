package View;

import java.awt.*;

public enum Colors {
    BACKGROUND (new Color(255,255,255)),
    FOREGROUND (new Color(0,65,128)),
    BUTTON (new Color (160,0,9)),
    ACCENT (new Color(102,139,177)),
    TITLE (new Color(0,0,0)),
    TEXT (new Color(255,255,255)),
    BORDER (new Color(0,0,0));

    Colors(Color thisColor) {
        itemColor = thisColor;
    }
    public Color getColor (){
        return itemColor;
    }
    private final Color itemColor;
}
