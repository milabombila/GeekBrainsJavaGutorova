package GeekBrains;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        ArrayList<String> dogs = new ArrayList<>();

        dogs.add("shiba");
        dogs.add("corgi");
        dogs.add("malamute");
        dogs.add("terrier");
        dogs.add("beagle");
        dogs.add("mastiff");
        dogs.add("husky");
        dogs.add("akita");
        dogs.add("shiba");
        dogs.add("corgi");
        dogs.add("malamute");

        HashMap<String,Integer> checkDogs = new HashMap<String,Integer>();
        for (String name:dogs) {
            if(checkDogs.containsKey(name)){
                int counter = checkDogs.get(name);
                counter +=1;
                checkDogs.put(name, counter);
            } else {
                checkDogs.put(name, 1);
            }
        }
        System.out.println(checkDogs.keySet());
        for (Map.Entry<String, Integer> dog: checkDogs.entrySet()) {
            System.out.println(String.format("Dogs breed: %s, counter: %s", dog.getKey(), dog.getValue()));
        }
        TelephoneCatalog catalog = new TelephoneCatalog();
        catalog.add("Stan", "+3722341245");
        catalog.add("Mila", "+7925324549");
        catalog.add("Tim", "+79267334134");
        catalog.add("Stan", "+7915455313");
        catalog.add("Mila", "+7903124583");
        catalog.get("Stan");
        catalog.get("Mila");
        catalog.get("Tim");
        catalog.get("Wolf");
    }
}
