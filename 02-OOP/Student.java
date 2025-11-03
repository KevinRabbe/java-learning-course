class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void stelleDichVor() {
        System.out.println("Ich bin " + name + " und ich bin " + age + " Jahre alt.");
    }
}

class Student extends Person {
    private String studentenID;
    private String studiengang;

    public Student(String name, int age, String studentenID, String studiengang) {
        super(name, age);
        this.studentenID = studentenID;
        this.studiengang = studiengang;
    }

    @Override
    public void stelleDichVor() {
        super.stelleDichVor();
        System.out.println("Ich studiere " + studiengang + " und meine Studenten-ID ist " + studentenID + ".");
    }

    public static void main(String[] args) {
        Student student = new Student("Max Mustermann", 20, "S123456", "Informatik");
        student.stelleDichVor();
    }
}