package inversionOfControl;

import dependenciesInjection.FortuneService;
import inversionOfControl.Coach;

/**
 * Created by Dimitry on 28.04.17.
 */
public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Hard running 5k!";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it!: " + fortuneService.getFortune();
    }

}
