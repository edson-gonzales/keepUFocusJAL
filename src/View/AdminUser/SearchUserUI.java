package View.AdminUser;

import Utils.Constants;
import View.Events.UserEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.util.ResourceBundle;

/**
 * UI to list users and make search into it
 *
 * @author Lourdes Villca on 18/07/2016.
 */
public class SearchUserUI extends JPanel {
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton newUserButton;
    private JPanel searchPanel;
    private UserEvent userEvent;
    private AddUserUI addUserUI;
    private ResourceBundle resource;

    /**
     * Init the components and define the layout for panels
     */
    public SearchUserUI() {
        resource = resource.getBundle(Constants.APLICATION_RESOURCES);
        searchPanel = buildSearchPanel();
        TableUser tablePane = new TableUser();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(searchPanel);
        this.add(tablePane);

    }

    /**
     * Method to build the search panel
     *
     * @return a panel with search section
     */
    public JPanel buildSearchPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        InitComponent.initLabel(searchLabel, resource.getString("admin.label.name"), panel);
        searchField = InitComponent.initTextBox(searchField, new Dimension(150, 25), panel);

        searchButton = InitComponent.initButton(searchButton, resource.getString("common.label.searchButton"), panel);
        newUserButton = InitComponent.initButton(newUserButton, resource.getString("common.label.newUser"), panel);

        searchButton.setActionCommand("1");
        newUserButton.setActionCommand("2");

        addUserUI = new AddUserUI();
        userEvent = new UserEvent(addUserUI);

        searchButton.addActionListener(userEvent);
        newUserButton.addActionListener(userEvent);

        InitComponent.setSizeComponent(panel, new Dimension(640, 50));
        return panel;
    }

}
