package client;

import javax.swing.*;

public class KeyUtil {
    public static KeyUtil instance;

    private KeyUtil() {
    }

    public static KeyUtil getInstance() {
        if(instance == null) {
            instance = new KeyUtil();
        }
        return instance;
    }

    public static void disableKey(InputMap im, String[] keystrokeNames) {
        for (int i = 0; i < keystrokeNames.length; i++) {
            im.put(KeyStroke.getKeyStroke(keystrokeNames[i]), "none");
        }
    }

}
