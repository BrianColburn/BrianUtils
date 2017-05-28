package brian.functional;

import java.util.function.UnaryOperator;

public class Box<Type> {
    public Type item;
    public Box(){}
    public Box(Type i) {
        item = i;
    }
    public void modify(UnaryOperator<Type> func) {
        item = func.apply(item);
    }
}
