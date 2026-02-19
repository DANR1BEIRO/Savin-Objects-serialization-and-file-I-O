package serialized_object_to_a_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DogSaverTest {

    public static void main(String[] args) {
        ArrayList<Dog> dogs = getDogs();

        serializeObj(dogs, "lista_dogs");
        deserializeObj();


    }

    private static ArrayList<Dog> getDogs() {
        ArrayList<Dog> dogs = new ArrayList<>(
                List.of(Dog.DogBuilder.builder()
                                .breed("Rotweiller")
                                .gender("Male")
                                .weight(30.0)
                                .name("Costela")
                                .build(),
                        Dog.DogBuilder.builder()
                                .breed("Maltes")
                                .gender("Female")
                                .weight(15.0)
                                .name("lolo").build()));
        return dogs;
    }

    private static void serializeObj(Serializable object, String fileName) {
        String fullFIleName = fileName + ".ser";
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fullFIleName))) {
            os.writeObject(object);
            System.out.printf("Object serialized successful to %s%n", fullFIleName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializeObj() {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("lista_dogs.ser"))) {
            List<Dog> recoveredDogs = (ArrayList<Dog>) is.readObject();
            System.out.printf("Object deserialized successful to ", recoveredDogs.getClass().getName());
            recoveredDogs.stream()
                    .forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
