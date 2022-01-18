package LAB2;

public class Candy {
    private String name;
    private int sweetness;
    private boolean isChocolate;

    public Candy(String name, int sweetness, boolean isChocolate) {
        this.name = name;
        this.sweetness = sweetness;
        this.isChocolate = isChocolate;
    }

    public String getName() {
        return name;
    }

    public int getSweetness() {
        return sweetness;
    }

    public boolean isChocolate() {
        return isChocolate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSweetness(int sweetness) {
        this.sweetness = sweetness;
    }

    public void setChocolate(boolean chocolate) {
        isChocolate = chocolate;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", sweetness=" + sweetness +
                ", isChocolate=" + isChocolate +
                '}';
    }
}
