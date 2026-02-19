package serialized_object_to_a_file;


import java.io.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 2L;
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class SerialVersionTest {
    public static void main(String[] args) {
        Employee employee = new Employee("Goku", 22);
        // writeObject(employee);
        Employee newEmployee = readObject();
        System.out.println(newEmployee);

    }

    private static void writeObject(Serializable object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.obj"))) {
            oos.writeObject(object);
            System.out.printf("Object was successfully serialized%n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T extends Serializable> T readObject() {
        T employee = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.obj"))) {
            employee = (T) ois.readObject();
            System.out.printf("Object was successfully deserialized%n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
