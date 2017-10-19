    // 529. Minesweeper

    public char[][] updateBoard(char[][] board, int[] click) {
        LinkedList<int[]> queue = new LinkedList();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] cur = queue.removeFirst();
            if (board[cur[0]][cur[1]] == 'M') board[cur[0]][cur[1]] = 'X';
            else if (board[cur[0]][cur[1]] == 'E') {
                int count = 0;
                for (int i = -1; i < 2; i++) 
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int x = cur[0] + i;
                        int y = cur[1] + j;
                        if (x < 0 || y < 0 || x == board.length || y == board[0].length) continue;
                        if (board[x][y] == 'X' || board[x][y] == 'M') count ++;
                    }
                if (count == 0) {
                    board[cur[0]][cur[1]] = 'B';
                    for (int i = -1; i < 2; i++) 
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) continue;
                            int x = cur[0] + i;
                            int y = cur[1] + j;
                            if (x < 0 || y < 0 || x == board.length || y == board[0].length) continue;
                            if (board[x][y] == 'E') queue.add(new int[]{x, y});
                        }
                } else 
                    board[cur[0]][cur[1]] = (char)('0' + count);
            }
        }
        return board;
    }