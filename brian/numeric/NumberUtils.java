package brian.numeric;

/**
 * Created by Colburn2013 on 4/18/2017.
 */
public class NumberUtils {
    // This is the closest I can get to a '+' function for parametrically polymorphic "Number" types...
    public static Number add(Number n1, Number n2) {
        if (n1 instanceof Integer) {
            Integer num = (Integer) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num + ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num + nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num + nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num + nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num + nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num + nd;
            }
        }
        else if (n1 instanceof Long) {
            Long num = (Long) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num + ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num + nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num + nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num + nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num + nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num + nd;
            }
        }
        else if (n1 instanceof Double) {
            Double num = (Double) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num + ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num + nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num + nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num + nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num + nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num + nd;
            }
        }
        else if (n1 instanceof Float) {
            Float num = (Float) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num + ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num + nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num + nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num + nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num + nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num + nd;
            }
        }
        else if (n1 instanceof Byte) {
            Byte num = (Byte) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num + ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num + nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num + nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num + nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num + nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num + nd;
            }
        }
        else if (n1 instanceof Short) {
            Short num = (Short) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num + ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num + nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num + nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num + nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num + nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num + nd;
            }
        }
        throw new IllegalArgumentException("Arguments must be one of the following classes: 'Integer', 'Long', 'Double', 'Float', 'Byte', or 'Short'.");
    }

    public static Number sub(Number n1, Number n2) {
        return add(n1, mul(-1, n2));
    }

    public static Number mul(Number n1, Number n2) {
        if (n1 instanceof Integer) {
            Integer num = (Integer) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num * ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num * nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num * nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num * nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num * nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num * nd;
            }
        }
        else if (n1 instanceof Long) {
            Long num = (Long) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num * ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num * nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num * nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num * nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num * nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num * nd;
            }
        }
        else if (n1 instanceof Double) {
            Double num = (Double) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num * ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num * nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num * nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num * nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num * nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num * nd;
            }
        }
        else if (n1 instanceof Float) {
            Float num = (Float) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num * ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num * nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num * nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num * nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num * nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num * nd;
            }
        }
        else if (n1 instanceof Byte) {
            Byte num = (Byte) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num * ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num * nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num * nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num * nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num * nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num * nd;
            }
        }
        else if (n1 instanceof Short) {
            Short num = (Short) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num * ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num * nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num * nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num * nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num * nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num * nd;
            }
        }
        return n1.doubleValue()*n2.doubleValue();
    }

    public static Number div(Number n1, Number n2) {
        if (n1 instanceof Integer) {
            Integer num = (Integer) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num / ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num / nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num / nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num / nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num / nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num / nd;
            }
        }
        else if (n1 instanceof Long) {
            Long num = (Long) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num / ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num / nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num / nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num / nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num / nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num / nd;
            }
        }
        else if (n1 instanceof Double) {
            Double num = (Double) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num / ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num / nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num / nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num / nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num / nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num / nd;
            }
        }
        else if (n1 instanceof Float) {
            Float num = (Float) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num / ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num / nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num / nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num / nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num / nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num / nd;
            }
        }
        else if (n1 instanceof Byte) {
            Byte num = (Byte) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num / ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num / nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num / nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num / nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num / nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num / nd;
            }
        }
        else if (n1 instanceof Short) {
            Short num = (Short) n1;
            if (n2 instanceof Integer) {
                Integer ni = (Integer) n2;
                return num / ni;
            }
            else if (n2 instanceof Long) {
                Long nd = (Long) n2;
                return num / nd;
            }
            else if (n2 instanceof Double) {
                Double nd = (Double) n2;
                return num / nd;
            }
            else if (n2 instanceof Float) {
                Float nd = (Float) n2;
                return num / nd;
            }
            else if (n2 instanceof Byte) {
                Byte nd = (Byte) n2;
                return num / nd;
            }
            else if (n2 instanceof Short) {
                Short nd = (Short) n2;
                return num / nd;
            }
        }
        return n1.doubleValue()/n2.doubleValue();
    }

    public Number parseNum(String str) {
        if (str.matches("\\d+")) return new Integer(str);
        else if (str.matches("\\d+L")) return new Long(str);
        else if (str.matches("\\d*\\.\\d+f")) return new Float(str);
        return new Double(str);
    }
}
