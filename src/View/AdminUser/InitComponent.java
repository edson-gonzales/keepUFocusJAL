package View.AdminUser;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Component;

/**
 * Class to help us to add components like JLabel, JTextBox, JComboBox
 *
 * @author Lourdes Villca
 */
public class InitComponent {
    /**
     * Method to initialize a JLabel
     *
     * @param jlabel component to be created
     * @param text   Text of the Jlabel
     * @param panel  Panel where the component will be added
     */
    public static void initLabel(JLabel jlabel, String text, JPanel panel) {
        jlabel = new JLabel(text);
        panel.add(jlabel);
    }

    /**
     * Method to initialize a JLabel
     *
     * @param textField  component to be created
     * @param txtSize    dimension of the TextBox
     * @param rightPanel Panel where the component will be added
     */
    public static void initTextBox(JTextField textField, Dimension txtSize, JPanel rightPanel) {
        textField = new JTextField(20);
        setSizeComponent(textField, txtSize);
        rightPanel.add(textField);
    }

    /**
     * Method to initialize a JLabel
     *
     * @param comboBox   component to be created
     * @param cboxSize   dimension of the ComboBox
     * @param rightPanel Panel where the component will be added
     */
    public static void initComboBox(JComboBox comboBox, Dimension cboxSize, JPanel rightPanel) {
        comboBox = new JComboBox();
        setSizeComponent(comboBox, cboxSize);
        rightPanel.add(comboBox);
    }

    /**
     * Method to define the Component size
     *
     * @param comp component to be resized
     * @param componentSize dimension of the component
     */
    public static void setSizeComponent(Component comp, Dimension componentSize) {
        comp.setMaximumSize(componentSize);
        comp.setPreferredSize(componentSize);
        comp.setMinimumSize(componentSize);
    }
}
