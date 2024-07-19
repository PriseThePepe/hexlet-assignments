package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            // Мы пытаемся получить площадь и округлить её
            System.out.println((int) Math.round(circle.getSquare()));
        } catch (NegativeRadiusException e) {
            // Обработка исключения, если радиус отрицательный
            System.out.println(e.getMessage());
        } finally {
            // Сообщение о завершении вычислений
            System.out.println("Вычисление окончено");
        }
    }

    public static void main(String[] args) throws NegativeRadiusException {
        Point point = new Point(5, 7);
        Circle circle = new Circle(point, 4);
         App.printSquare(circle);
// => "50"
// => "Вычисление окончено"

        Circle circle1 = new Circle(point, -2);
        App.printSquare(circle1);
// => "Не удалось посчитать площадь"
// => "Вычисление окончено"

        Circle circle2 = new Circle(new Point(1, 2), 10);
        int radius = circle2.getRadius();
        System.out.println(radius);

        double square = circle2.getSquare();
        System.out.println(square);

        Circle circle3 = new Circle(new Point(1, 2), 0);
        double square3 = circle3.getSquare();
        System.out.println(square3);
    }
}
// END
