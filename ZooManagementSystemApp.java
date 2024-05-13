package Studentsystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Animal {
    protected String name;
    protected String species;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public void displayInfo() {
        System.out.println("Animal: " + name + " | Species: " + species);
    }
}

class Mammal extends Animal {
    private boolean isWild;

    public Mammal(String name, String species, boolean isWild) {
        super(name, species);
        this.isWild = isWild;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Mammal | Wild: " + isWild);
    }
}

class Bird extends Animal {
    private String featherColor;

    public Bird(String name, String species, String featherColor) {
        super(name, species);
        this.featherColor = featherColor;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Bird | Feather Color: " + featherColor);
    }
}

class Reptile extends Animal {
    private boolean isVenomous;

    public Reptile(String name, String species, boolean isVenomous) {
        super(name, species);
        this.isVenomous = isVenomous;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Reptile | Venomous: " + isVenomous);
    }
}

class ZooManagementSystem {
    private List<Animal> animals;

    public ZooManagementSystem() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("Animal added to the zoo: " + animal.name);
    }

    public void displayAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in the zoo.");
        } else {
            System.out.println("Animals in the zoo:");
            for (Animal animal : animals) {
                animal.displayInfo();
            }
        }
    }
}

public class ZooManagementSystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZooManagementSystem zoo = new ZooManagementSystem();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Mammal");
            System.out.println("2. Add Bird");
            System.out.println("3. Add Reptile");
            System.out.println("4. Display Animals");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Mammal Name: ");
                    scanner.nextLine(); // Consume the newline character
                    String mammalName = scanner.nextLine();
                    System.out.print("Enter Mammal Species: ");
                    String mammalSpecies = scanner.nextLine();
                    System.out.print("Is the Mammal Wild? (true/false): ");
                    boolean isWild = scanner.nextBoolean();

                    Mammal newMammal = new Mammal(mammalName, mammalSpecies, isWild);
                    zoo.addAnimal(newMammal);
                    break;

                case 2:
                    System.out.print("Enter Bird Name: ");
                    scanner.nextLine(); // Consume the newline character
                    String birdName = scanner.nextLine();
                    System.out.print("Enter Bird Species: ");
                    String birdSpecies = scanner.nextLine();
                    System.out.print("Enter Feather Color: ");
                    String featherColor = scanner.nextLine();

                    Bird newBird = new Bird(birdName, birdSpecies, featherColor);
                    zoo.addAnimal(newBird);
                    break;

                case 3:
                    System.out.print("Enter Reptile Name: ");
                    scanner.nextLine(); // Consume the newline character
                    String reptileName = scanner.nextLine();
                    System.out.print("Enter Reptile Species: ");
                    String reptileSpecies = scanner.nextLine();
                    System.out.print("Is the Reptile Venomous? (true/false): ");
                    boolean isVenomous = scanner.nextBoolean();

                    Reptile newReptile = new Reptile(reptileName, reptileSpecies, isVenomous);
                    zoo.addAnimal(newReptile);
                    break;

                case 4:
                    zoo.displayAnimals();
                    break;

                case 5:
                    System.out.println("Exiting the Zoo Management System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
