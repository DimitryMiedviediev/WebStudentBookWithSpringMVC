package inversionOfControl;

import dependenciesInjection.FortuneService;

/**
 * Created by Dimitry on 28.04.17.
 */
public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach() {
    }

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practices!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
