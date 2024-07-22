package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;


// BEGIN
public class App {

    public static void save(Path path, Car car) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCar = null;
        try {
            jsonCar = objectMapper.writeValueAsString(car);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            Files.writeString(path,jsonCar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path path) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(String.valueOf(path));
        try {
            return objectMapper.readValue(file, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
// END
