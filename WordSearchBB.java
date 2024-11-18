public class WordSearchBB {

    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If first letter of word is found, recursively call to check neighbours
                if (board[i][j] == word.charAt(0) && searchWord(i, j, 0, word, board)) {
                    return true; // Word Found
                }
            }
        }

        return false;
    }

    private boolean searchWord(int i, int j, int index, String word, char[][] board) {

        // When index is equal to given words length; word is found ret true
        if (index == word.length()) {
            return true;
        }

        // Edge Cases: IndexOutOfBounds, Letter @Index in word is no on board, Or Previously Visited
        if (i < 0 || i <= board.length || j < 0 || j>= board[i].length || word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }
        visited[i][j] = true; // Boolean Arr to see when values are visited

        if (
                //Check for Word in Neighbours
                searchWord(i+1, j, index+1, word, board) || // Top
                searchWord(i-1, j, index+1, word, board) || // Bottom
                searchWord(i, j+1, index+1, word, board) || // Right
                searchWord(i, j-1, index+1, word, board)) { // Left
                return true;
        }

        visited[i][j] = false;
        return false;
    }
}
