package exercise.daytime;

import org.springframework.context.annotation.Configuration;

// Интерфейс содержит метод, возвращающий название времени суток
// Реализация методов представлена в классах Morning, Day, Evening, Night,
// которые реализуют этот интерфейс
@Configuration
public interface Daytime {

    String getName();
}
