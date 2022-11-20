public class RotateMatrix {
//    Hints: #51, #100
//    #51: Try thinking about it layer by layer. Can you rotate a specific layer?
//    #100: Rotating a specific layer would just mean swapping the values in four arrays. If you were
//    asked to swap the values in two arrays, could you do this? Can you then extend it to four arrays?
    public static int[][] rotateMatrix(int[][] mat) {
        if (mat.length == 0 || mat.length != mat[0].length) return mat;

        int N = mat.length-1;
        for(int i = 0; i < N/2; i++) {
            for(int j = i; j < N-i; j++) {
                int p1 = mat[i][j];
                int p2 = mat[j][N-i];
                int p3 = mat[N-i][N-j];
                int p4 = mat[N-j][i];

                mat[j][N-i] = p1;
                mat[N-i][N-j] = p2;
                mat[N-j][i] = p3;
                mat[i][j] = p4;
            }
        }
        return mat;
    }

    // This algorithm is O(N^2), which is the best we can do since any algorithm must touch all N^2 elements.

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };
        printMatrix(matrix);

        rotateMatrix(matrix);
        System.out.println();

        printMatrix(matrix);
    }
}
