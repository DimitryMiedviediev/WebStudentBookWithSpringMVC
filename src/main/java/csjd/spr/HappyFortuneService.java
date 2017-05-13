package csjd.spr;

import org.springframework.stereotype.Component;

/**
 * Created by Dimitry on 10.05.17.
 */
@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }

}
