package brian.utils.matrix;

import brian.numeric.Complex;
import brian.utils.list.ComplexList;

/**
 * Created by Colburn2013 on 3/12/2017.
 */
public class ComplexMatrix implements NumberMatrix<ComplexMatrix, ComplexList, Complex> {
    @Override
    public ComplexMatrix getMatrix() {
        return new ComplexMatrix();
    }

    /**
     * <p>Transposes a matrix</p>
     * <p>Basically it turns rows into columns and vice versa</p>
     *
     * @return Transposition of said matrix
     */
    @Override
    public ComplexMatrix transpose() {
        return null;
    }

    /**
     * <p>Flattens a matrix</p>
     * <p>It takes a 2D matrix and squishes (a technical term) it onto a 1D List</p>
     *
     * @return Result of the flattening of said matrix
     */
    @Override
    public ComplexList flatten() {
        return null;
    }

    @Override
    public ComplexList topDownDiagonal() {
        return null;
    }

    @Override
    public ComplexList bottomUpDiagonal() {
        return null;
    }

    /**
     * Sum every row in The Matrix
     *
     * @return The sum of every row in The Matrix
     */
    @Override
    public ComplexList sumRows() {
        return null;
    }

    /**
     * Sum every column in The Matrix
     *
     * @return The sum of every column in The Matrix
     */
    @Override
    public ComplexList sumColumns() {
        return null;
    }

    /**
     * Sum the top down diagonal in a matrix
     *
     * @return The sum of the top down diagonal
     */
    @Override
    public Complex sumTopDownDiagonal() {
        return null;
    }

    @Override
    public Complex sumBottomUpDiagonal() {
        return null;
    }

    @Override
    public ComplexList sumDiagonals() {
        return null;
    }

    /**
     * Sum every element in The Matrix
     *
     * @return The sum of every element in the matrix
     */
    @Override
    public Complex sumMatrix() {
        return null;
    }
}
