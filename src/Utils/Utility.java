package Utils;

import View.FocusTime.FocusTime;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by AldoBalderrama on 8/3/2016.
 */
public class Utility {
    /**
     * Obtain the image URL
     *
     * @param path        path the image
     * @param description Description the image
     * @return
     */
    public static Image createImage(String path, String description) {
        URL imageURL = FocusTime.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}
