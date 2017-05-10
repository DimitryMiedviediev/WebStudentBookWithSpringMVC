import entity.Person;
import inversionOfControl.Coach;
import inversionOfControl.CricketCoach;
import inversionOfControl.TrackCoach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dimitry on 21.04.17.
 */
public class Start {
    public static void main(String[] args) {


        //Inversion of Control
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/beans/applicationContext.xml");

        CricketCoach theCoach = context.getBean("cricketCoach", inversionOfControl.CricketCoach.class);

        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());

        System.out.println(theCoach.getName());

        System.out.println(theCoach.getEmail());

        context.close();

//        Coach coach = new TrackCoach();
//        System.out.println(coach);

        //Dependencies Injections

    }
}
