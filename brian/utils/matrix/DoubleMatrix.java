package brian.utils.matrix;

import brian.utils.list.DoubleList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by brian on 3/11/17.
 */
public class DoubleMatrix implements NumberMatrix<DoubleMatrix, DoubleList, Double>{
    List<DoubleList> matrix = new ArrayList<>();

    public DoubleMatrix(List<DoubleList> matrix) {
        for (DoubleList row : matrix) this.matrix.add(new DoubleList(row));
    }

    public DoubleMatrix(DoubleList nums) {
        this(nums.partition((int)Math.sqrt(nums.size())));
    }

    public DoubleMatrix(double... nums) {
        this(new DoubleList(nums));
    }

    @Override
    public DoubleMatrix getMatrix() {
        return new DoubleMatrix(matrix);
    }

    /**
     * <p>Transposes a matrix</p>
     * <p>Basically it turns rows into columns and vice versa</p>
     * @return Transposition of said matrix
     */
    public DoubleMatrix transpose() {
        List<DoubleList> trMatrix = new ArrayList<>();

        for (List<Double> row : matrix) {
            trMatrix.add(new DoubleList());
            for (int j = 0; j < row.size(); j++)
                trMatrix.get(j).add(row.get(j));
        }

        return new DoubleMatrix(trMatrix);
    }

    /**
     * <p>Flattens a matrix</p>
     * <p>It takes a 2D matrix and squishes (a technical term) it onto a 1D List</p>
     * @return Result of the flattening of said matrix
     */
    public DoubleList flatten() {
        DoubleList lists = new DoubleList();
        for (DoubleList list : matrix) lists.addAll(list);
        return lists;
    }

    public DoubleList topDownDiagonal() {
        return new DoubleList(IntStream.range(0,matrix.size())
                .mapToDouble(n -> matrix.get(n).get(n)));
    }

    public DoubleList bottomUpDiagonal() {
        return new DoubleList(IntStream.range(0, matrix.size())
                .mapToDouble(n -> matrix.get(matrix.size()-(n + 1)).get(n)));
    }

    /**
     * Sum every row in The Matrix
     * @return The sum of every row in The Matrix
     */
    public DoubleList sumRows() {
        return new DoubleList(matrix.stream().mapToDouble(DoubleList::sum));
    }


    /**
     * Sum every column in The Matrix
     * @return The sum of every column in The Matrix
     */
    public DoubleList sumColumns() {
        return transpose().sumRows();
    }

    /**
     * Sum the top down diagonal in a matrix
     * @return The sum of the top down diagonal
     */
    public Double sumTopDownDiagonal() {
        return topDownDiagonal().sum();
    }

    public Double sumBottomUpDiagonal() {
        return bottomUpDiagonal().sum();
    }

    public DoubleList sumDiagonals() {
        return new DoubleList(sumTopDownDiagonal(), sumBottomUpDiagonal());
    }

    /**
     * Sum every element in The Matrix
     * @return The sum of every element in the matrix
     */
    public Double sumMatrix() {
        return flatten().sum();
    }

    /**
     * Pretty Print a matrix
     * @return  Pretty Printed matrix
     */
    public String toString() {
        StringBuilder result = new StringBuilder();

        Integer maxDigits = flatten().stream()  // Get the largest amount of digits
                .mapToInt(n -> n.toString().length())
                .max()
                .getAsInt();

        for (List<Double> row : matrix) {  // Build up our "pretty printed" matrix string
            for (Double element : row)
                result.append(String.format("%" + (maxDigits + 1) + "s", element));
            result.append('\n');
        }

        return result.substring(0, result.length() - 1);  // Get rid of the extra newline
    }
}
