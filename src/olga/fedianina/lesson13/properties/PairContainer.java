package olga.fedianina.lesson13.properties;

public class PairContainer <T,K> {
    private T key;
    private K value;

    public PairContainer(T key, K value){
        this.key = key;
        this.value = value;
    }



    public T getKey() {
        return key;
    }

    public K getValue() {
        return value;
    }
}
