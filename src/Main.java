import shapes.Circle;
import shapes.GeometryObject;
import shapes.GeometryObjectFactory;
import utils.Colors;
import utils.ShapeNames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //TODO: Make a random color assignment

        List<GeometryObject> listOfGeneratedShapes = new ArrayList<>();

//        GeometryObject abc = GeometryObjectFactory.generateShape(ShapeNames.SQUARE);
//        System.out.println(abc.toString());


        for (int i = 0; i < 10000; i++){
            listOfGeneratedShapes.add(GeometryObjectFactory.generateShape(pickTheShape(), pickColor()));
        }

        for (GeometryObject item : listOfGeneratedShapes){
            System.out.println(item.toString() + "\n");
        }

    }

    private static ShapeNames pickTheShape(){
        List<ShapeNames> listOfShapeNames = new ArrayList<>();
        listOfShapeNames.add(ShapeNames.CIRCLE);
        listOfShapeNames.add(ShapeNames.SQUARE);
        listOfShapeNames.add(ShapeNames.TRAPEZOID);
        listOfShapeNames.add(ShapeNames.TRIANGE);

        //TODO: Enclose it try block after writing custom Error handler
        Random random = new Random();
        int index = random.nextInt(listOfShapeNames.size());
        return listOfShapeNames.get(index);
    }

    private static String pickColor(){
        List<Colors> listOfColors = new ArrayList<>();
        listOfColors.add(Colors.BLACK);
        listOfColors.add(Colors.BLUE);
        listOfColors.add(Colors.BROWN);
        listOfColors.add(Colors.GREEN);
        listOfColors.add(Colors.GREY);
        listOfColors.add(Colors.ORANGE);
        listOfColors.add(Colors.PURPLE);
        listOfColors.add(Colors.RED);
        listOfColors.add(Colors.WHITE);
        listOfColors.add(Colors.YELLOW);

        //TODO: Enclose it try block after writing custom Error handler
        Random random = new Random();
        int index = random.nextInt(listOfColors.size());
        return listOfColors.get(index).toString();
    }

}
