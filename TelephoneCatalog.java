package GeekBrains;

import java.util.ArrayList;
import java.util.HashMap;


public class TelephoneCatalog {
    HashMap<String, ArrayList<String>> catalogue;

    public TelephoneCatalog() {
        this.catalogue = new HashMap<String, ArrayList<String>>();
    }


    public void add(String name, String number) {
        if (catalogue.containsKey(name)) {
            if (!catalogue.containsValue(number)) {
                ArrayList<String> numbers = catalogue.get(name);
                numbers.add(number);
                catalogue.put(name, numbers);
            }
        } else {
            ArrayList<String> numbers = new ArrayList<String>();
            numbers.add(number);
            catalogue.put(name, numbers);
        }
    }
    public void get(String name){
        if (catalogue.containsKey(name)){
            ArrayList<String> numbers = catalogue.get(name);
            System.out.println(String.format("%s numbers:",name) + numbers);
        } else {
            System.out.println(String.format("There is no such name as %s in catalogue", name));
        }
    }


}
