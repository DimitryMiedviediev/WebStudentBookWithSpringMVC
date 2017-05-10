package inversionOfControl;

import dependenciesInjection.FortuneService;

/**
 * Created by Dimitry on 30.04.17.
 */
public class CricketCoach implements Coach {

    private FortuneService fortuneService;
    private String name;
    private String email;

    public CricketCoach() {
    }

    public CricketCoach(FortuneService fortuneService, String name, String email) {
        this.fortuneService = fortuneService;
        this.name = name;
        this.email = email;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling 15 minutes a day!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
