public class ZeroMatrix {
//    Hints:#17, #74, #702
    // #17: If you just cleared the rows and columns as you found Os, you'd likely wind up clearing
    //the whole matrix. Try finding the cells with zeros first before making any changes to the
    //matrix.

//    Can you use O(N) additional space instead of O(N2)? What information do you really
//    need from the list of cells that are zero?

//    Part 2: Try a sum of squares of the values.

    public static int[][] zeroRowCol(int[][] mat) {
        int N = mat.length;
        boolean[] mem1 = new boolean[N];
        boolean[] mem2 = new boolean[N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(mat[i][j] == 0) {
                    mem1[i] = true;
                    mem2[j] = true;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            if(mem1[i]) {
                mat[i] = new int[N];
            }

            if(mem2[i]) {
                System.out.println(i);
                for (int j = 0; j < N; j++) {
                    mat[j][i] = 0;
                }
            }
        }

        return mat;
    }

    // Reduce space to O(1) by using the first row as a replacement for the row array and the first column as a replacement for the column array.
    public static int[][] zeroRowCol_reduced_space(int[][] mat) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        // check if first  row has a zero
        for (int j = 0; j < mat[0].length; j++) {
            if(mat[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }
        // check if first column has a zero
        for (int j = 0; j < mat[0].length; j++) {
            if(mat[0][j] == 0) {
                colHasZero = true;
                break;
            }
        }

        // Check for zeros in the rest of the array
        for(int i = 1; i < mat.length; i++) {
            for(int j = 1; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // Nullify rows based on values in first column
        for (int i= 1; i < mat.length; i++) {
            if (mat[i][0] == 0) {
                nullifyRow(mat, i);
            }
        }
        // Nullify columns based on values in first row
        for (int j = 1; j < mat[0].length; j++) {
            if (mat[0][j] == 0) {
                nullifyColumn(mat, j);
            }
        }
        // Nullify first row
        if (rowHasZero) {
            nullifyRow(mat, 0);
        }
        // Nullify first column
        if (colHasZero) {
            nullifyColumn(mat, 0);
        }

        return mat;
    }

    public static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void nullifyColumn(int[][] matrix, int col) {
        for (int i= 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // CHECK BIT VECTOR option

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  0,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 0, 12},
                {13, 14, 15, 16}
        };
        zeroRowCol(matrix);
        printMatrix(matrix);

    }
}
