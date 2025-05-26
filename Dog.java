import java.util.ArrayList;

public class Dog {

    private final String name;
    private final String pupAdultOld;
    private final String breed;
    private final int expenses; 
    private final Boolean energetic;
    private final Boolean trained;
    private final Boolean childFriendly;
    private final Boolean dogFriendly;
    private final Boolean catFriendly;

    //constructor for Dog class
    public Dog(String name, String pupAdultOld, String breed, int expenses, Boolean energetic, Boolean trained, Boolean childFriendly, Boolean dogFriendly, Boolean catFriendly) {
        this.name = name;
        this.pupAdultOld = pupAdultOld;
        this.breed = breed;
        this.expenses = expenses;
        this.energetic = energetic;
        this.trained = trained;
        this.childFriendly = childFriendly;
        this.dogFriendly = dogFriendly;
        this.catFriendly = catFriendly;
    }

    //returns the name of the dog
    public String getName(){
        return name;
    }

    //returns the age of the dog
    public String getPupAdultOld(){
        return pupAdultOld;
    }

    //returns the breed of the dog
    public String getBreed(){
        return breed;
    }

    //returns the expenses of the dog
    public int getExpenses(){
        return expenses;
    }   

    //returns if the dog is energetic or not
    public Boolean getEnergetic(){
        return energetic;
    }

    //returns whether the dog is trained
    public Boolean getTrained(){
        return trained;
    }

    //returns the child friendliness of the dog
    public Boolean getChildFriendly(){
        return childFriendly;
    }

    //returns the dog friendliness of the dog
    public Boolean getDogFriendly(){
        return dogFriendly;
    }

    //returns the cat friendliness of the dog
    public Boolean getCatFriendly(){
        return catFriendly;
    }

    //returns the string representation of the dog
    public String toString(){
        return name + " is a " + pupAdultOld + " " + breed + " with an average yearly spending of $" + expenses + ". Energetic: " + energetic + ". Trained: " + trained + ". Child Friendly: " + childFriendly + ". Dog Friendly: " + dogFriendly + ". Cat Friendly: " + catFriendly;
    }

    //returns the best dogs for the user's preferences
    public static ArrayList<Dog> bestDogs(ArrayList<Dog> dogs, ArrayList<String> aspects) {
        // if (dogs.size() <= 1){
        //     return dogs;
        // }
        String aspect = aspects.get(0).toLowerCase();
        Dog dog = dogs.get(0);
        for (int i = 0; i < aspects.size(); i++){
            //loops through the aspects
            aspect = aspects.get(i).toLowerCase();
            // System.out.println(aspect);
            for (int j = 0; j < dogs.size(); j++){
                //loops through the dogs to remove the ones that don't match with the disired aspects
                dog = dogs.get(j);
                // System.out.println(dog.getName());
                if (dogs.size() == 0){
                    System.out.println("No dogs match your preferences.");
                    return dogs;
                }
                else if (aspect.equals("energetic") && dog.getEnergetic() != true ){
                    dogs.remove(j);
                    j--;
                }
                else if (aspect.equals("not energetic") && dog.getEnergetic() != false){
                    dogs.remove(j);
                    j--;
                }
                else if (aspect.equals("adult") && !dog.getPupAdultOld().toLowerCase().equals("adult")){
                    dogs.remove(j);
                    j--;
                }
                else if (aspect.equals("old") && !dog.getPupAdultOld().toLowerCase().equals("old")){
                    dogs.remove(j);
                    j--;
                }
                else if (aspect.equals("puppy") && !dog.getPupAdultOld().toLowerCase().equals("puppy")){
                    dogs.remove(j);
                    j--;
                }
                else if (aspect.equals("trained") && dog.getTrained() != true){
                    dogs.remove(j);
                    j--;
                }
                else if (aspect.equals("child friendly") && dog.getChildFriendly() != true){
                    dogs.remove(j);
                    j--;
                }
                else if (aspect.equals("dog friendly") && dog.getDogFriendly() != true){
                    dogs.remove(j);
                    j--;
                }
                else if (aspect.equals("cat friendly") && dog.getCatFriendly() != true){
                    dogs.remove(j);
                    j--;
                    // System.out.println("hi");
                }
                else{
                    try {
                        int budget = Integer.parseInt(aspect);
                        if (budget < dog.getExpenses()){
                            dogs.remove(j);
                            j--;
                        }
                    } catch (NumberFormatException e) {
                        
                    }
                }
            }
        }
        //returns the dog ArrayList with the remaining dogs
        if (dogs.size() == 0){
            System.out.println();
            System.out.println("No dogs match your preferences.");
        }
        else{
            System.out.println();
            System.out.println("Your results: ");
        }
        return dogs;
    }
}