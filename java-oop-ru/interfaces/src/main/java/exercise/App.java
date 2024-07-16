package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int numberOfApartments) {
       return apartments.stream()
               .sorted(Home::compareTo)
               .limit(numberOfApartments)
               .map(Home::toString)
               .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result); // =>
// [
//     Квартира площадью 44.0 метров на 10 этаже,
//     Квартира площадью 90.0 метров на 2 этаже,
//     2 этажный коттедж площадью 125.5 метров
// ]
    }
}
// END
