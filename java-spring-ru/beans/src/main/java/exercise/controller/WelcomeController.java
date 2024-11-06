package exercise.controller;


import exercise.daytime.Day;
import exercise.daytime.Daytime;
import exercise.daytime.Night;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.LocalTime;

// BEGIN
@RestController
public class WelcomeController {

    private final Daytime daytime;
    private final Daytime night;

    @Autowired
    public WelcomeController(Day daytimeBean, Night nightBean) {
        this.daytime = daytimeBean;
        this.night = nightBean;
    }

    @GetMapping("/welcome")
    public String welcome() {
        LocalDateTime time = LocalDateTime.now();
        int hour = time.getHour();
        if(hour >= 6 && hour < 22) {
            return new Day().getName();
        } else return new Night().getName();
    }



}
// END
