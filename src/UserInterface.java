import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class UserInterface extends JPanel implements ListSelectionListener {
    private JList<String> list;
    private DefaultListModel<String> listModel;

    private static final String selectString = "Select";

    private JButton selectButton;

    private JLabel selectedShapeLabel;

    private JTextArea infoSelectedTextField;

    UserInterface() {

        super(new BorderLayout());

        listModel = new DefaultListModel<>();
        for (int i = 0; i < Main.listOfGeneratedShapes.size(); i++){
            listModel.addElement(Main.listOfGeneratedShapes.get(i).getmName() + " - " +
                    Main.listOfGeneratedShapes.get(i).getmColor());
        }

        // Create the list and put it in a scroll pane.
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);

        // Select button initialization
        selectButton = new JButton(selectString);
        selectButton.setActionCommand(selectString);
        selectButton.addActionListener(new SelectButtonListener());

        // Select label initialization
        selectedShapeLabel = new JLabel("Test text");

        // Selected Shape description field initialization
        infoSelectedTextField = new JTextArea();

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(selectButton);
        buttonPane.add(Box.createHorizontalStrut(8));
        buttonPane.add(selectedShapeLabel);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel infoAndDrawingPane = new JPanel();
        infoAndDrawingPane.setLayout(new BoxLayout(infoAndDrawingPane, BoxLayout.LINE_AXIS));
        infoAndDrawingPane.add(infoSelectedTextField);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        add(listScrollPane, BorderLayout.LINE_START);
        add(buttonPane, BorderLayout.PAGE_END);
        add(infoAndDrawingPane, BorderLayout.CENTER);

    }

    /** Handles action, when a Select button is pressed
     */
    class SelectButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //This method can be called only if
            //there's a valid selection
            //so go ahead and do whatever's selected.
            int index = list.getSelectedIndex();
            selectedShapeLabel.setText(String.valueOf(index));

            infoSelectedTextField.setText(Main.listOfGeneratedShapes.get(index).toString());
        }

    }

    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {

            if (list.getSelectedIndex() == -1) {
                //No selection, disable fire button.
                selectButton.setEnabled(false);

            } else {
                //Selection, enable the fire button.
                selectButton.setEnabled(true);
            }
        }
    }
}
