package serialized_object_to_a_file;

import java.io.Serializable;

public class Dog implements Serializable {
    private String breed;
    private String gender;
    private Double weight;
    private String name;


    public static final class DogBuilder {
        private String breed;
        private String gender;
        private Double weight;
        private String name;

        private DogBuilder() {
        }

        public static DogBuilder builder() {
            return new DogBuilder();
        }

        public DogBuilder breed(String breed) {
            this.breed = breed;
            return this;
        }

        public DogBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public DogBuilder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public DogBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Dog build() {
            Dog dog = new Dog();
            dog.gender = this.gender;
            dog.breed = this.breed;
            dog.weight = this.weight;
            dog.name = this.name;
            return dog;
        }
    }
}
