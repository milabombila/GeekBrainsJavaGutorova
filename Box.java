package com.company;

import java.util.ArrayList;

public class Box<T extends Fruktiki > {
    ArrayList BigBox = new ArrayList();
    float weight;
    int fruitAmount;
    String FruitType;

    public Box(String fruitType) {
        FruitType = fruitType;
    }

    public String getFruitType() {
        return FruitType;
    }

    public void SortFruits() {

    }
    public float getWeight(T a) {
        weight = a.getFruitWeight() * fruitAmount;
        return weight;
    }
    public boolean compareBoxes(Box BigBigBox, T a) {
        if (BigBigBox.getWeight(a) == weight ) {
            return true;
        } else {
            return false;
        }
    }
    public void putIn(T a) {
        BigBox.add(a);
        fruitAmount++;
    }

   public void repackingFruits(Box BigBigBox) {
        if (BigBigBox.getFruitType().equals(FruitType) {
           while (fruitAmount != 0){
               BigBigBox.putIn(new Oranges());
               fruitAmount--;
           }
       for (int i = fruitAmount-1 ; i == 0 ; i--) {
           BigBox.remove(i);
       }
       weight = 0;
       System.out.println("Transfer completed");

       } else {
        System.out.println("Can't put different fruits in one box");
    }
   }
}
