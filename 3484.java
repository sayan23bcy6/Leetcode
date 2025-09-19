class Spreadsheet {
    private int rows;
    private int cols = 26;
    private int[][] grid;

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.grid = new int[rows][cols];
    }
    
    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }
    
    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }
    
    public int getValue(String formula) {
        if (formula.charAt(0) != '=') {
            throw new IllegalArgumentException("Formula must start with =");
        }
        String expr = formula.substring(1);
        String[] parts = expr.split("\\+");
        int sum = 0;
        for (String part : parts) {
            sum += evaluatePart(part.trim());
        }
        return sum;
    }
    private int evaluatePart(String token) {
        if (Character.isDigit(token.charAt(0))) {
            return Integer.parseInt(token);
        }
        int[] pos = parseCell(token);
        return grid[pos[0]][pos[1]];
    }
    
    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid cell reference: " + cell);
        }
        return new int[]{row, col};
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
