import java.util.LinkedList;

class AnimalQueue {
    LinkedList<Dog> dogs;
    LinkedList<Cat> cats = new LinkedList<>();
    int val = 0;
    public AnimalQueue() {
        this.dogs = new LinkedList<>();
        this.cats = new LinkedList<>();
    }

    public void enqueue(Animal a) {
        a.setOrder(val);
        val++;
        if(a instanceof Dog) {
            dogs.addLast((Dog) a);
        } else if (a instanceof Cat) {
            cats.addLast((Cat) a);
        }
    }

    public Cat dequeueCats() {
        return cats.poll();
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) return dequeueCats();
        if (cats.size() == 0) return dequeueDogs();
        if(dogs.peek().isOlderThan(cats.peek())) return dequeueDogs();
        else return dequeueCats();

    }

}

public class Shelter {

    public static void main(String[] args) {
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Cat("Callie"));
        animals.enqueue(new Cat("Kiki"));
        animals.enqueue(new Dog("Fido"));
        animals.enqueue(new Dog("Dora"));
        animals.enqueue(new Cat("Kari"));
        animals.enqueue(new Dog("Dexter"));
        animals.enqueue(new Dog("Dobo"));
        animals.enqueue(new Cat("Copa"));

        System.out.println(animals.dequeueAny().name);
        System.out.println(animals.dequeueAny().name);
        System.out.println(animals.dequeueAny().name);

        animals.enqueue(new Dog("Dapa"));
        animals.enqueue(new Cat("Kilo"));

//        while (animals.size() != 0) {
//            System.out.println(animals.dequeueAny().name);
//        }
    }
}
