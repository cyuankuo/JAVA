package edu.nyu.cs9053.homework7;

public class BarnTransfer {

    public void transfer (Barn<? super Animal> animalBarn1, Barn<? extends Animal> animalBarn2){

        Animal[] barnAnimals2 = (Animal[]) animalBarn2.elementData;

        for (Animal o: barnAnimals2) {
            animalBarn1.add(o);
        }
    }
}

