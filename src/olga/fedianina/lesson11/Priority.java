package olga.fedianina.lesson11;

public enum Priority {
    HIGH  (10), MIDDLE(5), LOW(1);


    private int code;

    Priority (int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "code=" + code +
                '}';
    }
}
