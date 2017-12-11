package deputaty;

public class People {

    private int height;
    private int weight;

    public People(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "People{" +
                "height='" + height + '\'' +
                ", weight=" + weight +
                '}';
    }
}
