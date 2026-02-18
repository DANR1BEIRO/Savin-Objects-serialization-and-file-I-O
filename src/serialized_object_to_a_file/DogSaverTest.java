package serialized_object_to_a_file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DogSaverTest {

    public static void main(String[] args) {
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

        serializeObj(dogs, "lista_dogs");


    }

    private static void serializeObj(Serializable object, String fileName) {
        String fullFIleName = fileName + ".ser";
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fullFIleName))) {
            os.writeObject(object);
            System.out.printf("Object serialized successful to %s", fullFIleName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
