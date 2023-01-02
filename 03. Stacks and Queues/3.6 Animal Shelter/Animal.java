public class Animal {
    int order;
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int val) {
        this.order = val;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.order;
    }

}
