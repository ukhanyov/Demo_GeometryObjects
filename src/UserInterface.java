import shapes.GeometryObject;
import utils.Colors;
import utils.ShapeNames;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
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

        // Setting up drawing area
        drawingAreaJPanel = new JPanel();
        drawingAreaJPanel.setLayout(new BoxLayout(drawingAreaJPanel, BoxLayout.PAGE_AXIS));

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

    /** Handles action, when a Select button is pressed
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
    public void valueChanged(ListSelectionEvent e) {    }

    public class Bubble extends JPanel {

        private int mAxis = 100;
        private GeometryObject mGeometryObject;

        public Bubble(GeometryObject geometryObject) {

            mGeometryObject = geometryObject;
            setBackground(darken(getColorFromGeometryObject(mGeometryObject), 0.0000001f));
            setOpaque(false);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(150, 150);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            // Getting the color
            Color startColor = brighten(getBackground(), 0.0000001f);
            Color endColor = getBackground();

            // Painting into the color
            int x = (getWidth() - 150) / 2;
            int y = (getHeight() - 150) / 2;

            LinearGradientPaint lgp = new LinearGradientPaint(
                    new Point(x, y),
                    new Point(x, y + 150),
                    new float[]{0f, 1f},
                    new Color[]{startColor, endColor});
            g2d.setPaint(lgp);



            switch (mGeometryObject.getmName()){
                case CIRCLE:
                    g2d.fill(new Ellipse2D.Double(0, 0, mGeometryObject.getSidesOfTheShape().get(0),
                                                            mGeometryObject.getSidesOfTheShape().get(0)));
                    break;
                case SQUARE:
                    g2d.fill(new Rectangle2D.Double(0, 0, mGeometryObject.getSidesOfTheShape().get(0),
                                                                    mGeometryObject.getSidesOfTheShape().get(0)));
                    break;
                case TRAPEZOID:

//                    int x1Points[] = {0, 100, 70, 30};
//                    int y1Points[] = {0, 0, 70, 70};
//                    GeneralPath polygon =
//                            new GeneralPath(GeneralPath.WIND_EVEN_ODD,
//                                    x1Points.length);
//                    polygon.moveTo(x1Points[0], y1Points[0]);
//
//                    for (int index = 1; index < x1Points.length; index++) {
//                        polygon.lineTo(x1Points[index], y1Points[index]);
//                    }
//
//                    polygon.closePath();
//                    g2d.fill(polygon);

                    break;
                case TRIANGE:
                    double a = mGeometryObject.getSidesOfTheShape().get(0);
                    double b = mGeometryObject.getSidesOfTheShape().get(1);
                    double c = mGeometryObject.getSidesOfTheShape().get(2);


                    double xT = (b*b + a*a - c*c)/(2*a);
                    double yT = Math.abs(Math.sqrt(Math.pow(b, 2) - Math.pow(xT, 2)));

                    double x1Points1[] = {0, a, xT};
                    double y1Points1[] = {0, 0, yT};

                    GeneralPath polygon1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points1.length);
                    polygon1.moveTo(x1Points1[0], y1Points1[0]);

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

    public static Color brighten(Color color, double fraction) {
        int red = (int) Math.round(Math.min(255, color.getRed() + 255 * fraction));
        int green = (int) Math.round(Math.min(255, color.getGreen() + 255 * fraction));
        int blue = (int) Math.round(Math.min(255, color.getBlue() + 255 * fraction));
        int alpha = color.getAlpha();
        return new Color(red, green, blue, alpha);
    }

    public static Color darken(Color color, double fraction) {
        int red = (int) Math.round(Math.max(0, color.getRed() - 255 * fraction));
        int green = (int) Math.round(Math.max(0, color.getGreen() - 255 * fraction));
        int blue = (int) Math.round(Math.max(0, color.getBlue() - 255 * fraction));
        int alpha = color.getAlpha();
        return new Color(red, green, blue, alpha);
    }

    private Color getColorFromGeometryObject(GeometryObject geometryObject){

        switch (geometryObject.getmColor()){
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
