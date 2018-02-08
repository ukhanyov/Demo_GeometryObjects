import shapes.GeometryObject;
import shapes.GeometryObjectFactory;
import utils.Colors;
import utils.ShapeNames;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    //private static UI mUserInterface;

    static List<GeometryObject> listOfGeneratedShapes = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++){
            listOfGeneratedShapes.add(GeometryObjectFactory.generateShape(pickTheShape(), pickColor()));
        }

        for (GeometryObject item : listOfGeneratedShapes){
            System.out.println(item.toString() + "\n");
        }

        //mUserInterface = new UI();

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    /**
     * Create the GUI and show it.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Generate Random Shapes");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new UserInterface();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        //frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    private static ShapeNames pickTheShape(){
        List<ShapeNames> listOfShapeNames = new ArrayList<>();
        listOfShapeNames.add(ShapeNames.CIRCLE);
        listOfShapeNames.add(ShapeNames.SQUARE);
        listOfShapeNames.add(ShapeNames.TRAPEZOID);
        listOfShapeNames.add(ShapeNames.TRIANGE);

        try {
            Random random = new Random();
            int index = random.nextInt(listOfShapeNames.size());
            return listOfShapeNames.get(index);
        }catch (Exception e){
            throw new IndexOutOfBoundsException("Error in Main while picking the random shape from the list of shapes. "
             + "Cause: " + e.toString());
        }
    }

    private static Colors pickColor(){
        List<Colors> listOfColors = new ArrayList<>();
        listOfColors.add(Colors.BLACK);
        listOfColors.add(Colors.BLUE);
        listOfColors.add(Colors.GREEN);
        listOfColors.add(Colors.GREY);
        listOfColors.add(Colors.ORANGE);
        listOfColors.add(Colors.RED);
        listOfColors.add(Colors.WHITE);
        listOfColors.add(Colors.YELLOW);

        try {
            Random random = new Random();
            int index = random.nextInt(listOfColors.size());
            return listOfColors.get(index);
        }catch (Exception e){
            throw new IndexOutOfBoundsException("Error in Main while picking the random color from the list of Colors. "
                    + "Cause: " + e.toString());
        }
    }

}
