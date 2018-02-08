import shapes.GeometryObject;
import utils.Colors;
import utils.ShapeNames;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

public class UserInterface extends JPanel implements ListSelectionListener {

    private JList<String> list;
    private DefaultListModel<String> listModel;

    private static final String selectString = "Select";

    private JButton selectButton;
    private JLabel selectedShapeLabel;
    private JTextArea infoSelectedTextField;
    private JPanel drawingAreaJPanel;

    UserInterface() {

        super(new BorderLayout());

        listModel = new DefaultListModel<>();
        for (int i = 0; i < Main.listOfGeneratedShapes.size(); i++) {
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

        // Setting up drawing area
        drawingAreaJPanel = new JPanel();

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(selectButton);
        buttonPane.add(Box.createHorizontalStrut(8));
        buttonPane.add(selectedShapeLabel);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel infoAndDrawingPane = new JPanel();
        infoAndDrawingPane.setLayout(new BoxLayout(infoAndDrawingPane, BoxLayout.Y_AXIS));
        infoAndDrawingPane.add(infoSelectedTextField);
        infoAndDrawingPane.add(Box.createHorizontalStrut(8));
        infoAndDrawingPane.add(drawingAreaJPanel);
        infoAndDrawingPane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        add(listScrollPane, BorderLayout.LINE_START);
        add(buttonPane, BorderLayout.PAGE_END);
        add(infoAndDrawingPane, BorderLayout.CENTER);

    }

    /**
     * Handles action, when a Select button is pressed
     */


    class SelectButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            int index = list.getSelectedIndex();
            selectedShapeLabel.setText(String.valueOf(index));

            infoSelectedTextField.setText(Main.listOfGeneratedShapes.get(index).toString());

            drawingAreaJPanel.removeAll();
            drawingAreaJPanel.add(new Bubble(Main.listOfGeneratedShapes.get(index)));

        }

    }

    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
    }

    public class Bubble extends JPanel {

        private int mAxis = 100;
        private GeometryObject mGeometryObject;

        public Bubble(GeometryObject geometryObject) {

            mGeometryObject = geometryObject;
            setOpaque(false);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setPaint(getColorFromGeometryObject(mGeometryObject));

            switch (mGeometryObject.getmName()) {
                case CIRCLE:
                    g2d.fill(new Ellipse2D.Double((getWidth() - mGeometryObject.getSidesOfTheShape().get(0)) / 2,
                            (getHeight() - mGeometryObject.getSidesOfTheShape().get(0)) / 2,
                            mGeometryObject.getSidesOfTheShape().get(0),
                            mGeometryObject.getSidesOfTheShape().get(0)));
                    break;
                case SQUARE:
                    g2d.fill(new Rectangle2D.Double((getWidth() - mGeometryObject.getSidesOfTheShape().get(0)) / 2,
                            (getHeight() - mGeometryObject.getSidesOfTheShape().get(0)) / 2,
                            mGeometryObject.getSidesOfTheShape().get(0),
                            mGeometryObject.getSidesOfTheShape().get(0)));
                    break;
                case TRAPEZOID:
                    double bigBase = mGeometryObject.getSidesOfTheShape().get(0);
                    double smallBase = mGeometryObject.getSidesOfTheShape().get(1);
                    double leftSide = mGeometryObject.getSidesOfTheShape().get(2);
                    double rightSide = mGeometryObject.getSidesOfTheShape().get(3);
                    double height = Math.sqrt(((bigBase + leftSide - smallBase + rightSide) *
                            (-bigBase + leftSide + smallBase + rightSide) *
                            (bigBase - leftSide - smallBase + rightSide) *
                            (bigBase + leftSide - smallBase - rightSide)) /
                            (4 * Math.pow((bigBase - smallBase), 2)));

                    double leftSubBase = Math.sqrt(Math.pow(leftSide, 2) - Math.pow(height, 2));
                    double middleSubBase = leftSubBase + smallBase;
                    double diagonal = Math.sqrt(Math.pow(middleSubBase, 2) + Math.pow(height, 2));

                    double a_1 = bigBase;
                    double b_1 = diagonal;
                    double c_1 = rightSide;
                    double x_1 = (b_1 * b_1 + a_1 * a_1 - c_1 * c_1) / (2 * a_1);
                    double y_1 = Math.abs(Math.sqrt(Math.pow(b_1, 2) - Math.pow(x_1, 2)));

                    double a_2 = leftSubBase;
                    double b_2 = leftSide;
                    double c_2 = height;
                    double x_2 = (b_2 * b_2 + a_2 * a_2 - c_2 * c_2) / (2 * a_2);
                    double y_2 = Math.abs(Math.sqrt(Math.pow(b_2, 2) - Math.pow(x_2, 2)));

                    double widthTrap = (getWidth() + bigBase) / 2;
                    double heightTrap = (getHeight() + bigBase) / 2;

                    double x1Points[] = {widthTrap + 0, widthTrap - a_1, widthTrap - x_1, widthTrap - x_2};
                    double y1Points[] = {heightTrap + 0, heightTrap + 0, heightTrap - y_1, heightTrap - y_2};

                    GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points.length);
                    polygon.moveTo(x1Points[0], y1Points[0]);
                    polygon.lineTo(x1Points[1], y1Points[1]);
                    polygon.lineTo(x1Points[2], y1Points[2]);
                    polygon.lineTo(x1Points[3], y1Points[3]);

                    polygon.closePath();
                    g2d.fill(polygon);

                    break;

                case TRIANGE:
                    double a = mGeometryObject.getSidesOfTheShape().get(0);
                    double b = mGeometryObject.getSidesOfTheShape().get(1);
                    double c = mGeometryObject.getSidesOfTheShape().get(2);

                    double xT = (b * b + a * a - c * c) / (2 * a);
                    double yT = Math.abs(Math.sqrt(Math.pow(b, 2) - Math.pow(xT, 2)));

                    double o_x = (0 + a + xT) / 3;
                    double o_y = (0 + 0 + yT) / 3;

                    double widthTri = (getWidth() - o_x - 20) / 2;
                    double heightTri = (getHeight() - o_y - 20) / 2;

                    double x1Points1[] = {widthTri + 0, widthTri + a, widthTri + xT};
                    double y1Points1[] = {heightTri + 0, heightTri + 0, heightTri + yT};

                    GeneralPath polygon1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points1.length);
                    polygon1.moveTo(x1Points1[0] , y1Points1[0] );

                    for (int index = 1; index < x1Points1.length; index++) {
                        polygon1.lineTo(x1Points1[index], y1Points1[index]);
                    }

                    polygon1.closePath();
                    g2d.fill(polygon1);

                    break;

                default:
                    throw new IllegalArgumentException("There is an error in the reading class name when drawing a shape");
            }
        }
    }

    private Color getColorFromGeometryObject(GeometryObject geometryObject) {

        switch (geometryObject.getmColor()) {
            case BLACK:
                return Color.BLACK;
            case GREEN:
                return Color.GREEN;
            case BLUE:
                return Color.BLUE;
            case YELLOW:
                return Color.YELLOW;
            case GREY:
                return Color.GRAY;
            case WHITE:
                return Color.WHITE;
            case RED:
                return Color.RED;
            case ORANGE:
                return Color.ORANGE;
        }

        return null;
    }

}
