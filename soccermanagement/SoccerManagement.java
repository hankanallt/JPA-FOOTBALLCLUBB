package soccermanagement;

import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpafinal.domain.Address;
import jpafinal.domain.FootballClubb;
import jpafinal.domain.SoccerPlayer;

public class SoccerManagement {

    public static Scanner sc = new Scanner(System.in);
    public static boolean loop = true;

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public static void main(String[] args) {

        mainMenu();

    }

    public static void mainMenu() {

        System.out.println("\n+--------------------------------------------+");
        System.out.println("+-----------Football Clubb Menu--------------+");
        System.out.println("+--------------------------------------------+");

        System.out.println("1.  Add New Soccer Player");
        System.out.println("2.  Add New Football Clubb");
        System.out.println("3.  Remove Soccer PLayer");
        System.out.println("4.  Remove Football Clubb");
        System.out.println("5.  Update Soccer Player");
        System.out.println("6.  Update Soccer Clubb");
        System.out.println("7.  Add Existing Player To Existing FooballClubb");
        System.out.println("8.  Add New Player To Existing FooballClubb;");
        System.out.println("9.  Add Address To Player");
        System.out.println("10. Remove Address From Player;");
        System.out.println("11. Show All By Name");
        System.out.println("12. Show All Football Clubbs");

        System.out.println("0. Back to main menu\n");

        System.out.println("\n+--------------------------------------------+");
        System.out.println("+-----------Football Clubb Menu--------------+");
        System.out.println("+--------------------------------------------+");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 0:
                loop = false;
                break;
            case 1:
                addNewSoccerPlayer();
                break;
            case 2:
                addNewFootballClubb();
                break;
            case 3:
                removeSoccerPlayer();
                break;
            case 4:
                removeFootballClubb();
                break;
            case 5:
                updateSoccerPlayer();
                break;
            case 6:
                updateFootballClubb();
                break;
            case 7:
                addExistingPlayerToExistingFooballClubb();
                break;
            case 8:
                addNewPlayerToExistingFooballClubb();
                break;
            case 9:
                addAddresstoPlayer();
                break;
            case 10:
                removeAddressFromPlayer();
            case 11:
                showAllByName();
            case 12:
                showAllFootballCLubb();

                loop = true;
                while (loop) {
                    mainMenu();
                }
                break;
            default:
                System.out.println("No such option");
                break;

        }
    }
//    public SoccerPlayer(String Firstname, String Lastname, int Age, float ShoeSize, 
    //int JerseyNumber, Double salary, String position, Address address) {
//OK

    public static void addNewSoccerPlayer() {
        EntityManager em = emf.createEntityManager();
        System.out.print("what is the First Name of the player? ");
        String Firstname = sc.nextLine();

        System.out.print("what is the First Name of the player? ");
        String LastName = sc.nextLine();

        System.out.println("What is the Age?");
        int Age = sc.nextInt();
        sc.nextLine();

        System.out.println("What is the ShoeSize?");
        float ShoeSize = sc.nextFloat();
        sc.nextLine();

        System.out.println("What is the Jersey number?");
        int JerseyNumber = sc.nextInt();
        sc.nextLine();

        System.out.println("How much Salary does he have?");
        double Salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("what is the Playing Position of the player? ");
        String Position = sc.nextLine();

        SoccerPlayer s = new SoccerPlayer(Firstname, LastName, Age, ShoeSize, JerseyNumber, Salary, Position);

        em.getTransaction().begin();
        s.setFirstname(Firstname);
        s.setLastname(LastName);
        s.setAge(Age);
        s.setShoeSize(ShoeSize);
        s.setJerseyNumber(JerseyNumber);
        s.setSalary(Salary);
        s.setPosition(Position);

        em.persist(s);
        em.getTransaction().commit();

        em.close();

    }
//OK

    public static void addNewFootballClubb() {

        EntityManager em = emf.createEntityManager();
        System.out.print("what is the Name of the Football Clubb? ");
        String FootballClubb = sc.nextLine();

        FootballClubb f = new FootballClubb();

        em.getTransaction().begin();
        f.setName(FootballClubb);
        em.persist(f);
        em.getTransaction().commit();

        em.close();

    }
//OK

    public static void removeSoccerPlayer() {

        EntityManager em = emf.createEntityManager();

        System.out.print("What is the id of the Soccerplayer? : ");
        Long id = sc.nextLong();
        sc.nextLine();

        SoccerPlayer s = em.find(SoccerPlayer.class, id);

        em.getTransaction().begin();

        s.getId();

        em.persist(s);
        em.remove(s);
        System.out.println("Soccer player is now Removed from the List");

        em.getTransaction().commit();

        em.close();

    }
//OK

    public static void removeFootballClubb() {
        EntityManager em = emf.createEntityManager();

        System.out.print("What is the name of the FootballClubb? : ");
        String name = sc.nextLine();

        FootballClubb F = em.find(FootballClubb.class, name);
        em.getTransaction().begin();
        F.getName();

        em.remove(F);
        System.out.println("Football Clubb is now Removed from the List");
        em.getTransaction().commit();

        em.close();

    }
//OK

    public static void updateSoccerPlayer() {
        EntityManager em = emf.createEntityManager();

        System.out.println("What is the Id of the Player you want to uppdate");
        Long id = sc.nextLong();
        sc.nextLine();

        System.out.print("what is the New First Name of the player? ");
        String Firstname = sc.nextLine();

        System.out.print("what is the New Last Name of the player? ");
        String LastName = sc.nextLine();

        System.out.println("What is the New Age?");
        int Age = sc.nextInt();
        sc.nextLine();

        System.out.println("What is the New ShoeSize?");
        float ShoeSize = sc.nextFloat();
        sc.nextLine();

        System.out.println("What is the New Jersey number?");
        int JerseyNumber = sc.nextInt();
        sc.nextLine();

        System.out.println("What is the New Salary?");
        double Salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("what is the New Playing Position of the player? ");
        String Position = sc.nextLine();

        SoccerPlayer s = em.find(SoccerPlayer.class, id);

        //    public SoccerPlayer(String Firstname, String Lastname, int Age, float ShoeSize, int JerseyNumber, 
        // Double salary, String position) {
        em.getTransaction().begin();
        s.setFirstname(Firstname);
        s.setLastname(LastName);
        s.setAge(Age);
        s.setShoeSize(ShoeSize);
        s.setJerseyNumber(JerseyNumber);
        s.setSalary(Salary);
        s.setPosition(Position);

        em.persist(s);
        em.getTransaction().commit();
        System.out.println("Player is now Updated");
        em.close();

    }
//OK

    public static void updateFootballClubb() {
        EntityManager em = emf.createEntityManager();

        System.out.println("What is the Old name of the FootballClubb you want to uppdate");
        String oldName = sc.nextLine();

        System.out.print("what is the New Name of the Football Clubb? ");
        String newName = sc.nextLine();

        FootballClubb f = em.find(FootballClubb.class, oldName);

        em.getTransaction().begin();
        f.setName(newName);

        em.persist(f);
        em.getTransaction().commit();
        System.out.println("Player is now Updated");
        em.close();

    }
// GÅr ej PGA Name är PrimaryKey. Går ej att uppdatera PrimaryKey

    public static void addExistingPlayerToExistingFooballClubb() {
        EntityManager em = emf.createEntityManager();

        System.out.println("What is the Id of the Player");
        Long id = sc.nextLong();
        sc.nextLine();

        System.out.println("What is the name of the Football Clubb? ");
        String name = sc.nextLine();

        SoccerPlayer s = em.find(SoccerPlayer.class, id);
        FootballClubb f = em.find(FootballClubb.class, name);

        em.getTransaction().begin();

        f.addSoccerPlayer(s);

        System.out.println("Player is now added to the FootballClubb");
        em.getTransaction().commit();

        em.close();

    }
//OK

    public static void addNewPlayerToExistingFooballClubb() {
        EntityManager em = emf.createEntityManager();
        System.out.print("what is the First Name of the player? ");
        String Firstname = sc.nextLine();

        System.out.print("what is the First Name of the player? ");
        String LastName = sc.nextLine();

        System.out.println("What is the Age?");
        int Age = sc.nextInt();
        sc.nextLine();

        System.out.println("What is the ShoeSize?");
        float ShoeSize = sc.nextFloat();
        sc.nextLine();

        System.out.println("What is the Jersey number?");
        int JerseyNumber = sc.nextInt();
        sc.nextLine();

        System.out.println("How much Salary does he have?");
        double Salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("what is the Playing Position of the player? ");
        String Position = sc.nextLine();

        SoccerPlayer s = new SoccerPlayer(Firstname, LastName, Age, ShoeSize, JerseyNumber, Salary, Position);

        System.out.println("What is the name of the Football Clubb? ");
        String name = sc.nextLine();

        FootballClubb f = em.find(FootballClubb.class, name);

        em.getTransaction().begin();

        f.addSoccerPlayer(s);
        em.persist(f);

        System.out.println("Player is now added to the FootballClubb");
        em.getTransaction().commit();

        em.close();

    }
//OK

    public static void addAddresstoPlayer() {

        EntityManager em = emf.createEntityManager();

        System.out.println("What is the id of the player? ");
        Long id = sc.nextLong();
        sc.nextLine();

        System.out.println("What is the name of the Street? ");
        String Street = sc.nextLine();

        System.out.println("What is the name of the City? ");
        String City = sc.nextLine();

        System.out.println("What is the name of the Country? ");
        String Country = sc.nextLine();

        Address a = new Address(Street, City, Country);

        em.getTransaction().begin();
        a.setStreet(Street);
        a.setCity(City);
        a.setCountry(Country);

        em.persist(a);

        System.out.println("The address is added to the id");
        em.getTransaction().commit();

        em.close();

    }
//OK

    public static void removeAddressFromPlayer() {
        EntityManager em = emf.createEntityManager();

        System.out.println("What is the Address id?");
        Long id = sc.nextLong();
        sc.nextLine();

        em.getTransaction().begin();
        Address a = em.find(Address.class, id);
        a.getId();

        em.remove(a);
        System.out.println("Player Address is now Removed from the List");

        em.getTransaction().commit();

        em.close();
    }
//OK 

    public static void showAllByName() {
        EntityManager em = emf.createEntityManager();

        List<SoccerPlayer> soccerPlayers = (List<SoccerPlayer>) em.createNativeQuery("SELECT * FROM soccerplayer",
                SoccerPlayer.class).getResultList();
        for (SoccerPlayer soccerPlayer : soccerPlayers) {
            System.out.println(soccerPlayer.getFirstname() + "" + soccerPlayer.getLastname());

//            List<FootballClubb> footballClubbs = (List<FootballClubb>) em.createNativeQuery("SELECT * FROM footballClubb",
//                    FootballClubb.class).getResultList();
//            for (FootballClubb footballClubb : footballClubbs) {
//                System.out.println(footballClubb.getName()+ "" + soccerPlayer.getFirstname());
        }
        em.getTransaction().begin();

        em.getTransaction().commit();

        em.close();
    }
//OK
    public static void showAllFootballCLubb() {
        EntityManager em = emf.createEntityManager();

        List<FootballClubb> footballClubbs = (List<FootballClubb>) em.createNativeQuery("SELECT * FROM footballClubb",
                FootballClubb.class).getResultList();
        for (FootballClubb footballClubb : footballClubbs) {
            System.out.println(footballClubb.getName() + "" + footballClubb.getSoccerPlayers());

        }
        em.getTransaction().begin();

        em.getTransaction().commit();

        em.close();
    }
//OK
}
