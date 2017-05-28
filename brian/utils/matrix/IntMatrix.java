package brian.utils.matrix;

import brian.Function;
import brian.utils.list.IntList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by brian on 3/11/17.
 */
public class IntMatrix implements NumberMatrix<IntMatrix, IntList, Integer>{
    private List<IntList> matrix = new ArrayList<>();

    public IntMatrix(Collection<IntList> matrix) {
        for (IntList row : matrix) this.matrix.add(new IntList(row));
    }

    public IntMatrix(IntList nums) {
        this(nums.partition((int)Math.sqrt(nums.size())));
    }

//    public IntMatrix(int... nums) {
//        this(new IntList(nums));
//    }

    public IntMatrix(int[]... nums) {
        this(new IntList(nums));
    }

    @Override
    public IntMatrix getMatrix() {
        return new IntMatrix(matrix);
    }

    /**
     * <p>Transposes a matrix</p>
     * <p>Basically it turns rows into columns and vice versa</p>
     * @return Transposition of said matrix
     */
    public IntMatrix transpose() {
        List<IntList> trMatrix = new ArrayList<>();

        for (int i = 0; i < matrix.get(0).size(); i++) {
            trMatrix.add(new IntList());
            for (int j = 0; j < matrix.size(); j++)
                trMatrix.get(i).add(matrix.get(j).get(i));
        }

        return new IntMatrix(trMatrix);
    }

    /**
     * <p>Flattens a matrix</p>
     * <p>It takes a 2D matrix and squishes (a technical term) it onto a 1D List</p>
     * @return Result of the flattening of said matrix
     */
    public IntList flatten() {
        IntList lists = new IntList();
        for (IntList list : matrix) lists.addAll(list);
        return lists;
    }

    public IntMatrix overlay(IntMatrix m, int offset) {
        //IntMatrix rtnMatrix = this; // Mutable
        IntMatrix rtnMatrix = new IntMatrix(this.matrix); // Immutable
        List<IntList> rows = m.flatten().partition(m.sumRows().size());
        for (int i = 0; i < m.sumRows().size(); i++) {
            IntList matrixRow = rtnMatrix.matrix.get(offset + i);
            for (int k = 0; k < rows.size(); k++) {
                matrixRow.set(k + offset, rows.get(i).get(k));
            }
        }
        return rtnMatrix;
    }

    public IntList topDownDiagonal() {
        return new IntList(IntStream.range(0, matrix.size())
                .map(n -> matrix.get(n).get(n)));
    }

    public IntList bottomUpDiagonal() {
        return new IntList(IntStream.range(0, matrix.size())
                .map(n -> matrix.get(matrix.size()-(n + 1)).get(n)));
    }

    /**
     * Sum every row in The Matrix
     * @return The sum of every row in The Matrix
     */
    public IntList sumRows() {
        return new IntList(matrix.stream().mapToInt(IntList::sum));
    }


    /**
     * Sum every column in The Matrix
     * @return The sum of every column in The Matrix
     */
    public IntList sumColumns() {
        return transpose().sumRows();
    }

    /**
     * Sum the top down diagonal in a matrix
     * @return The sum of the top down diagonal
     */
    public Integer sumTopDownDiagonal() {
        return topDownDiagonal().sum();
    }

    public Integer sumBottomUpDiagonal() {
        return bottomUpDiagonal().sum();
    }

    public IntList sumDiagonals() {
        return new IntList(new int[] {sumTopDownDiagonal(), sumBottomUpDiagonal()});
    }

    /**
     * Sum every element in The Matrix
     * @return The sum of every element in the matrix
     */
    public Integer sumMatrix() {
        return flatten().sum();
    }

    public Boolean magicSquareQ() {
        return new IntList(sumRows(), sumColumns(), sumDiagonals()).stream().noneMatch(n -> n != (int)(Function.magicConstant(matrix.size())));
    }

    /**
     * Pretty Print a matrix
     * @return  Pretty Printed matrix
     */
    public String toString() {
        StringBuilder result = new StringBuilder();

        Integer maxDigits;
        if (flatten().intStream(n -> n.toString().length()).max().isPresent()) // check for the largest number
            maxDigits = flatten().intStream(n -> n.toString().length())  // Get the largest amount of digits
                .max()
                .getAsInt();
        else maxDigits = flatten().get(0).toString().length();

        for (IntList row : matrix) {  // Build up our "pretty printed" matrix string
            for (Integer element : row)
                result.append(String.format("%" + (maxDigits + 1) + "d", element));
            result.append('\n');
        }

        return result.substring(0, result.length() - 1);  // Get rid of the extra newline
    }

    public IntMatrix map(UnaryOperator<Integer> f) {
        return new IntMatrix(matrix.stream().map(list -> list.map(f)).collect(Collectors.toList()));
    }
}
