import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner input = new Scanner(System.in); //scan in the aspects user prioritizes in adoption
        System.out.println();
        System.out.print("Please list 3 most important ascepts that are important to you in your adoption process seperated by commas (please use the phrases puppy/adult/old, an integer budget, energetic/not energetic, trained/not trained, child friendly, dog friendly, cat friendly): ");
        String[] aspects1 = input.nextLine().split(", ");
        ArrayList<String> aspects = new ArrayList<String>(); //make an ArrayList with the aspects
        input.close();
        for (int i = 0; i < aspects1.length; i++){ //add the elements in the array to the ArrayList for easier use
            aspects.add(aspects1[i]);
        }
        // System.out.println(aspects);
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        
        try {
            Scanner scanner = new Scanner(new File("adoptableDogs.txt")); //scan in the dogs file
            String line = scanner.nextLine();
            while (scanner.hasNext()) { //create dog objects with information from file
                line = scanner.nextLine();
                String[] dogInfo = line.split(", ");
                Dog dog = new Dog(dogInfo[0], dogInfo[1], dogInfo[2], Integer.parseInt(dogInfo[3]), Boolean.parseBoolean(dogInfo[4]), Boolean.parseBoolean(dogInfo[5]), Boolean.parseBoolean(dogInfo[6]), Boolean.parseBoolean(dogInfo[7]), Boolean.parseBoolean(dogInfo[8]));
                dogs.add(dog);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
        
        ArrayList<Dog> theBest = Dog.bestDogs(dogs, aspects); //find the best dogs for the user's preferences
        //System.out.println();
        // System.out.println("Your results: "); //display the best dogs
        for (int i = 0; i < theBest.size(); i++) {
            System.out.println(i+1 + ") " + theBest.get(i).toString());
        }
        System.out.println();
    }
}