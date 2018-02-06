import utils.Colors;

public class Main {

    public static void main(String[] args) {

        Square square = new Square(2, Colors.COLOR_GREEN.toString());
        square.makeCalculations();
        System.out.println(square.getmSide() + "\n" +
                            square.getmColor() + "\n" +
                            square.getmDiagonal() + "\n" +
                            square.getmPerimeter() + "\n" +
                            square.getmArea());
    }

}
