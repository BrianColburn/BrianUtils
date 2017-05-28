package brian.numeric;

import brian.numeric.group.*;

/**
 * Created by Colburn2013 on 4/18/2017.
 */
public class IntegerRing extends Number implements Ring<IntegerRing, Integer> {
    private Integer num;
    public IntegerRing(Number num) {
        this.num = num.intValue();
    }

    @Override
    public Integer add(Integer a, Integer b) {
        return a+b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return a*b;
    }

    @Override
    public Integer multiplicativeIdentity() {
        return 1;
    }

    @Override
    public Integer inverse() {
        return -num;
    }

    @Override
    public Integer closedOperation(Integer a, Integer b) {
        return add(a,b);
    }

    @Override
    public Integer identity() {
        return 0;
    }

    @Override
    public Object associativeOperation() {
        return null;
    }

    @Override
    public int intValue() {
        return num;
    }

    @Override
    public long longValue() {
        return num.longValue();
    }

    @Override
    public float floatValue() {
        return num.floatValue();
    }

    @Override
    public double doubleValue() {
        return num.doubleValue();
    }
}
