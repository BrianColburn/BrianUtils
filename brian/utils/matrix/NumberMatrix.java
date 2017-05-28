package brian.utils.matrix;

public interface NumberMatrix<MT extends NumberMatrix<MT, LT, T>, LT extends brian.utils.list.NumberList, T extends Number> {

    /**
     * Return a new matrix with no pointers to the internal matrix
     * @return a copy of the matrix
     */
    MT getMatrix();

    /**
     * <p>Transposes a matrix</p>
     * <p>Basically it turns rows into columns and vice versa</p>
     * @return Transposition of said matrix
     */
    MT transpose();

    /**
     * <p>Flattens a matrix</p>
     * <p>It takes a 2D matrix and squishes (a technical term) it onto a 1D List</p>
     * @return Result of the flattening of said matrix
     */
    LT flatten();

    LT topDownDiagonal();

    LT bottomUpDiagonal();

    /**
     * Sum every row in The Matrix
     * @return The sum of every row in The Matrix
     */
    LT sumRows();


    /**
     * Sum every column in The Matrix
     * @return The sum of every column in The Matrix
     */
    LT sumColumns();

    /**
     * Sum the top down diagonal in a matrix
     * @return The sum of the top down diagonal
     */
    T sumTopDownDiagonal();

    T sumBottomUpDiagonal();

    LT sumDiagonals();

    /**
     * Sum every element in The Matrix
     * @return The sum of every element in the matrix
     */
    T sumMatrix();
}
