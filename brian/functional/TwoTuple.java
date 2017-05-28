package brian.functional;

public class TwoTuple<R,L> {
    private final R right;
    private final L left;
    public TwoTuple(R right, L left) {
        this.right = right;
        this.left  = left;
    }

    public R getRight() {
        return right;
    }

    public L getLeft() {
        return left;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)",left,right);
    }
}
