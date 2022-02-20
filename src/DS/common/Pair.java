package common;

public class Pair<A,B>{
    public A v1;
    public B v2;
    public Pair(A v1, B v2){
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public String toString() {
        return "(" + v1 +
                ", " + v2 +
                ')';
    }
}
