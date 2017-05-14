package uni.db.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import uni.db.project.entity.Authority;
import uni.db.project.entity.User;

/**
 * Created by Dimitry on 14.05.17.
 */
public class Start {
    public static void main(String[] args) {
//        createUser("dimitrymiedviediev@gmail.com", "20101995");
//        createUser("admin", "admin");

//        giveAuthority(1, 1);
//        giveAuthority(2, 2);

//        createAuthority("ROLE_ADMIN");
//        createAuthority("ROLE_USER");
    }

    public static void createUser(String username, String password) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            User user = new User(username, password);

            session.save(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    public static void createAuthority(String role) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Authority authority = new Authority(role);

            session.save(authority);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    public static void giveAuthority(int userID, int authorityID) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            User user = session.get(User.class, userID);
            Authority authority = session.get(Authority.class, authorityID);

            user.getAuthorities().add(authority);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

}
