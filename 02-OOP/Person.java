public class Person {
    // Attributes
    private String name;
    private int age;
    private String city;

    // Constructor with parameters
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.city = "Unknown";
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Instance methods
    public void stelleDichVor() {
        System.out.println("Hallo, ich heiße " + name + ", ich bin " + age + " Jahre alt und komme aus " + city + ".");
    }

    public boolean istErwachsen() {
        return age >= 18;
    }

    public void wirdAelter() {
        age++;
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Person person1 = new Person("Max", 25, "Berlin");
        person1.stelleDichVor();
        System.out.println("Ist erwachsen: " + person1.istErwachsen());
        person1.wirdAelter();
        System.out.println("Nach einem Jahr: " + person1.getAge() + " Jahre alt.");

        Person person2 = new Person();
        person2.setName("Anna");
        person2.setAge(16);
        person2.setCity("München");
        person2.stelleDichVor();
        System.out.println("Ist erwachsen: " + person2.istErwachsen());
    }
}