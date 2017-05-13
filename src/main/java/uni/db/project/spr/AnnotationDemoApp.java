package uni.db.project.spr;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dimitry on 10.05.17.
 */
public class AnnotationDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        context.close();
    }

}
