package exercise.daytime;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Day implements Daytime {
    private String name = "day";

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    public void init() {
        System.out.println("Day bean has been created.");
    }
    // END
}
