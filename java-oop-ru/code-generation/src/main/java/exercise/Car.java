package exercise;

import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    @SneakyThrows
    public static String serialize(Car car) {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(car);
    }
    @SneakyThrows
    public static Car unserialize(String carJson) {
        ObjectMapper objectMapper = new ObjectMapper();
       return objectMapper.readValue(carJson,Car.class);
    }
    // END
}
