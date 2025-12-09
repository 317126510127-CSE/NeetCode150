//Approach1: Traditional Approach
// Time & Space Complexity
// Time complexity: O(n*2)
// Space complexity: O(n)

class Solution {
    public boolean isValidSudoku(char[][] board) {

        //validate rows
        for (int r = 0; r < 9; r++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.')
                    continue;
                int value = board[r][c] - '0';
                if (rowSet.contains(value)) {
                    return false;
                }
                rowSet.add(value);
            }
        }

        //validate columns
        for (int c = 0; c < 9; c++) {
            HashSet<Integer> columnSet = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                if (board[r][c] == '.')
                    continue;
                int value = board[r][c] - '0';
                if (columnSet.contains(value)) {
                    return false;
                }
                columnSet.add(value);
            }
        }

        //validate squares
        for (int square = 0; square < 9; square++) {
            Set<Integer> squareSet = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.')
                        continue;
                    int value = board[row][col] - '0';
                    if (squareSet.contains(value)) {
                        return false;
                    }
                    squareSet.add(value);
                }
            }
        }
        return true;
    }
}




//Approach2: Using HashSet (One Pass)
// Time & Space Complexity
// Time complexity: O(n*2)
// Space complexity: O(n*2)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rows=new HashMap<>();
        Map<Integer,Set<Character>> cols=new HashMap<>();
        Map<String,Set<Character>> squares=new HashMap<>();


        for(int r=0;r<9;r++)
        {
            for(int c=0;c<9;c++)
            {
                char value=board[r][c];
                if(value=='.')
                {
                    continue;
                }
                String squareKey=r/3 +","+c/3;

                // Initialize sets if missing
                rows.putIfAbsent(r, new HashSet<>());
                cols.putIfAbsent(c, new HashSet<>());
                squares.putIfAbsent(squareKey, new HashSet<>());

                //check duplicates
                if(rows.get(r).contains(value) || cols.get(c).contains(value) || squares.get(squareKey).contains(value))
                {
                    return false;
                }

                //add current value in map
                rows.get(r).add(value);
                cols.get(c).add(value);
                squares.get(squareKey).add(value);

            }
        }
        return true;
    }
}


//Approach3:  Easy Approach
// Time & Space Complexity
// Time complexity: O(n*2)
// Space complexity: O(n)

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                Character value = board[r][c];
                String row=value+"at row "+r;
                String column=value+"at col"+c;
                String square=value+"at box"+(r/3)+"-"+(c/3);
                
                if(value=='.')
                {
                    continue;
                }
                if(seen.contains(row) || seen.contains(column) || seen.contains(square))
                {
                    return false;
                }
                seen.add(row);
                seen.add(column);
                seen.add(square);
            }
        }

        return true;
    }
}