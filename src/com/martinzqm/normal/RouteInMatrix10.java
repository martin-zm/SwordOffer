package com.martinzqm.normal;

/**
 * @Author miao
 * @Description:
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * @Date 2018/8/22 9:11
 */
public class RouteInMatrix10 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        boolean[] isVisited = new boolean[rows * cols];
        int pathLength = 0;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (hasPathCore(matrix, row, col, rows, cols, str, isVisited, pathLength)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPathCore(char[] matrix, int row, int col, int rows, int cols,
                               char[] str, boolean[] isVisited, int pathLength) {
        if (pathLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        if (col >= 0 && col < cols && row >= 0 && row < rows &&
                matrix[row * cols + col] == str[pathLength] && isVisited[row * cols + col] == false) {
            ++pathLength;
            isVisited[row * cols + col] = true;
            hasPath = hasPathCore(matrix, row + 1, col, rows, cols, str, isVisited, pathLength)
                      || hasPathCore(matrix, row - 1, col, rows, cols, str, isVisited, pathLength)
                      || hasPathCore(matrix, row, col + 1, rows, cols, str, isVisited, pathLength)
                      || hasPathCore(matrix, row - 1, col - 1, rows, cols, str, isVisited, pathLength);
            if (hasPath == false) {
                --pathLength;
                isVisited[row * cols + col] = false;
            }

        }
        return hasPath;
    }
}
