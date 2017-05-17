package uni.db.project;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import uni.db.project.entity.*;
import uni.db.project.entity.Group;
import uni.db.project.entity.EducationForm;
import uni.db.project.entity.GroupStatus;
import uni.db.project.entity.QualificationLevel;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by Dimitry on 14.05.17.
 */
public class Start {
    public static void main(String[] args) {

//        createUniversity();
//        createFaculty();
//        createSpeciality();
//        createDepartment();
//        createEducationForm();
//        createQualificationLevel();
//        createGroupStatus();

//        createGroup(
//                getFaculty(1),
//                12,
//                getSpeciality(1),
//                getDepartment(1),
//                getEducationForm(1),
//                getQualificationLevel(1),
//                2,
//                getGroupStatus(1));





//        createUser("User", "user@gmail.com", "20101995_user");
//        createUser("admin", "admin");

//        giveAuthority(1, 1);
//        giveAuthority(2, 2);

//        createAuthority("ROLE_ADMIN");
//        createAuthority("ROLE_USER");

    }

    public static void createUser(String username, String email, String password) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            User user = new User(username, email, password);

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

    public static boolean validateEmail(String email) {
        boolean isValid = false;
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
            isValid = true;
        } catch (AddressException e) {
            System.out.println("Email is not valid: " + email);
        }
        return isValid;
    }

    public static void validatePassword(String password) {
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        System.out.println(password.matches(pattern));
    }

    /*
    Default injection some values in TABLE university
     */
    public static void createUniversity() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            University university = new University(
                    "Київський Національний торговельно-економічний університет",
                    "Наука важка, але плідна",
                    "1964",
                    "Державний",
                    new Person(
                            "Анатолій",
                            "Мазеракі",
                            "Анатолійович",
                            null,
                            null,
                            null),
                    new Address(
                            "19",
                            "Кіото",
                            "Київ",
                            "Київська",
                            "02156",
                            "Україна"
                    ),
                    "www.knteu.kiev.ua");

            session.save(university);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    public static University getUniversity(int id) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        University university = new University();
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            university = session.get(University.class, id);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
        return university;
    }

    /*
    Default injection some values in TABLE faculty
     */
    public static void createFaculty() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        University university = getUniversity(1);
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Faculty faculty1 = new Faculty(
                    university,
                    "Факультет економіки, менеджменту і психології",
                    new Person(
                            "Наталія",
                            "Гуляєва",
                            "Миколаївна",
                            null,
                            null,
                            null));

            Faculty faculty2 = new Faculty(
                    university,
                    "Факультет обліку, аудиту та інформаційних систем",
                    new Person(
                            "Олександр",
                            "Харченко",
                            "Анатолійович",
                            null,
                            null,
                            null));

            Faculty faculty3 = new Faculty(
                    university,
                    "Ресторанно-готельного та туристичного бізнесу",
                    new Person(
                            "Надія",
                            "Ведмідь",
                            "Іванівна",
                            null,
                            null,
                            null));

            Faculty faculty4 = new Faculty(
                    university,
                    "Факультет торгівлі та маркетингу",
                    new Person(
                            "Віктор",
                            "Осика",
                            "Анатолійович",
                            null,
                            null,
                            null));

            Faculty faculty5 = new Faculty(
                    university,
                    "Факультет фінансів та банківської справи",
                    new Person(
                            "Тетяна",
                            "Канєва",
                            "Володимирівна",
                            null,
                            null,
                            null));

            Faculty faculty6 = new Faculty(
                    university,
                    "Факультет міжнародної торгівлі та права ",
                    new Person(
                            "Катерина",
                            "Ладиченко",
                            "Іллівна",
                            null,
                            null,
                            null));

            session.save(faculty1);
            session.save(faculty2);
            session.save(faculty3);
            session.save(faculty4);
            session.save(faculty5);
            session.save(faculty6);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    public static Faculty getFaculty(int id) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        Faculty faculty = new Faculty();
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            faculty = session.get(Faculty.class, id);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
        return faculty;
    }

    /*
    Default injection some values in TABLE speciality
     */
    public static void createSpeciality() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.save(new Speciality("Інженерія програмного забезпечення"));
            session.save(new Speciality("Харчові технології"));
            session.save(new Speciality("Фінанси, банківська справа та страхування"));
            session.save(new Speciality("Філологія"));
            session.save(new Speciality("Туризм"));
            session.save(new Speciality("Підприємництво, торгівля та біржова діяльність"));
            session.save(new Speciality("Публічне управління та адміністрування"));
            session.save(new Speciality("Психологія"));
            session.save(new Speciality("Право"));
            session.save(new Speciality("Облік і оподаткування"));
            session.save(new Speciality("Міжнародні економічні відносини"));
            session.save(new Speciality("Міжнародне право"));
            session.save(new Speciality("Менеджмент"));
            session.save(new Speciality("Маркетинг"));
            session.save(new Speciality("Комп’ютерні науки та інформаційні технології"));
            session.save(new Speciality("Журналістика"));
            session.save(new Speciality("Економіка"));
            session.save(new Speciality("Готельно-ресторанна справа"));
            session.save(new Speciality("Харчові технології та інженерія"));
            session.save(new Speciality("Фінанси і кредит"));
            session.save(new Speciality("Товарознавство і торговельне підприємництво"));
            session.save(new Speciality("Реклама і зв’язки з громадськістю"));
            session.save(new Speciality("Правознавство"));
            session.save(new Speciality("Облік і аудит"));
            session.save(new Speciality("Міжнародний бізнес"));
            session.save(new Speciality("Міжнародна економіка"));
            session.save(new Speciality("Комп’ютерні науки"));
            session.save(new Speciality("Економічна кібернетика"));

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    public static Speciality getSpeciality(int id) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        Speciality speciality = new Speciality();
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            speciality = session.get(Speciality.class, id);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
        return speciality;
    }

    /*
    Default injection some values in TABLE department
     */
    public static void createDepartment() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        Faculty fEMP = getFaculty(1);
        Faculty fOAIS = getFaculty(2);
        Faculty fRHTB = getFaculty(3);
        Faculty fTM = getFaculty(4);
        Faculty fFBS = getFaculty(5);
        Faculty fMTP = getFaculty(6);
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.save(new Department(fEMP, "Кафедра економічної теорії та конкурентної політики"));
            session.save(new Department(fEMP, "Кафедра психології"));
            session.save(new Department(fEMP, "Кефедра менеджменту"));
            session.save(new Department(fEMP, "Кафедра економіки та фінансів підприємства"));
            session.save(new Department(fOAIS, "Кафедра обліку та оподаткування"));
            session.save(new Department(fOAIS, "Кафедра економічної кібернетики"));
            session.save(new Department(fOAIS, "Кафедра програмної інженерії та інформаційних систем"));
            session.save(new Department(fOAIS, "Кафедра філософських та соціальних наук"));
            session.save(new Department(fOAIS, "Кафедра фінансового аудиту"));
            session.save(new Department(fRHTB, "Кафедра технології і організації ресторанного господарства"));
            session.save(new Department(fRHTB, "Кафедра фізичної культури"));
            session.save(new Department(fRHTB, "Кафедра інженерно-технічних дисциплін"));
            session.save(new Department(fRHTB, "Кафедра готельно-ресторанного бізнесу"));
            session.save(new Department(fRHTB, "Кафедра туризму та рекреації"));
            session.save(new Department(fTM, "Кафедра маркетингу та реклами"));
            session.save(new Department(fTM, "Кафедра іноземної філології та перекладу"));
            session.save(new Department(fTM, "Кафедра торговельного підприємства та логістики"));
            session.save(new Department(fTM, "Кафедра товарознавства, управління безпечністю та якістю"));
            session.save(new Department(fTM, "Кафедра товарознавства та митної справи"));
            session.save(new Department(fFBS, "Кафедра банківської справи"));
            session.save(new Department(fFBS, "Кафедра вищої та прикладної математики"));
            session.save(new Department(fFBS, "Кафедра статистики та економетрії"));
            session.save(new Department(fFBS, "Кафедра фінансів"));
            session.save(new Department(fMTP, "Кафедра міжнародних економічних відносин"));
            session.save(new Department(fMTP, "Кафедра міжнародного приватного, комерційного та цивільного права"));
            session.save(new Department(fMTP, "Кафедра інформаційних технологій у міжнародній торгівлі"));
            session.save(new Department(fMTP, "Кафедра міжнародного публічного права"));
            session.save(new Department(fMTP, "Кафедра адміністративного, фінансового та інформаційного права"));
            session.save(new Department(fMTP, "Кафедра сучасних європейських мов"));
            session.save(new Department(fMTP, "Кафедра загальноправових дисциплін"));

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    public static Department getDepartment(int id) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        Department department = new Department();
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            department = session.get(Department.class, id);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
        return department;
    }

    /*
    Default injection some values in TABLE educationForm
     */
    public static void createEducationForm() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;

        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.save(new EducationForm("Денна"));
            session.save(new EducationForm("Заочна"));
            session.save(new EducationForm("Вечірня"));
            session.save(new EducationForm("Дистанційна"));

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    public static EducationForm getEducationForm(int id) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        EducationForm educationForm = new EducationForm();
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            educationForm = session.get(EducationForm.class, id);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
        return educationForm;
    }

    /*
    Default injection some values in TABLE qualificationLevel
     */
    public static void createQualificationLevel() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;

        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.save(new QualificationLevel("Спеціаліст"));
            session.save(new QualificationLevel("Бакалавр"));
            session.save(new QualificationLevel("Магістр"));
            session.save(new QualificationLevel("Аспірант"));

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    public static QualificationLevel getQualificationLevel(int id) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        QualificationLevel qualificationLevel = new QualificationLevel();
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            qualificationLevel = session.get(QualificationLevel.class, id);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
        return qualificationLevel;
    }

    /*
    Default injection some values in TABLE groupStatus
     */
    public static void createGroupStatus() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;

        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.save(new GroupStatus("Активна"));
            session.save(new GroupStatus("Неактивна"));

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    public static GroupStatus getGroupStatus(int id) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        GroupStatus groupStatus = new GroupStatus();
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            groupStatus = session.get(GroupStatus.class, id);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
        return groupStatus;
    }

    /*
    Default injection some values in TABLE group
     */
    public static void createGroup(
            Faculty faculty,
            int number,
            Speciality speciality,
            Department department,
            EducationForm educationForm,
            QualificationLevel qualificationLevel,
            int course,
            GroupStatus groupStatus) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;

        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.save(new Group(faculty, number, speciality, department, educationForm, qualificationLevel, course, groupStatus));

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    public static Group getGroup(int id) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        Group group = new Group();
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            group = session.get(Group.class, id);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
        return group;
    }

}
