package brian.numeric;

/**
 * Created by brian on 4/14/17.
 */
public interface Numeric<N extends Number> {

    default Integer intValue(Number n) {
        return n.intValue();
    }

    default Long longValue(Number n) {
        return n.longValue();
    }

    default Float floatValue(Number n) {
        return n.floatValue();
    }

    default Double doubleValue(Number n) {
        return n.doubleValue();
    }

    default Byte byteValue(Number n) {
        return n.byteValue();
    }

    default Short shortValue(Number n) {
        return n.shortValue();
    }

    default Number parseNum(String str) {
        if (str.matches("\\d+")) return new Integer(str);
        else if (str.matches("\\d+L")) return new Long(str);
        else if (str.matches("\\d*\\.\\d+f")) return new Float(str);
        return new Double(str);
    }
}
