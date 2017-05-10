package dependenciesInjection;

/**
 * Created by Dimitry on 30.04.17.
 */
public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is your lucky Day!";
    }
}
