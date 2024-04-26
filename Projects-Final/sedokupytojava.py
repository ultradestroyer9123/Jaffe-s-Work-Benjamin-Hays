import random

grid = [
    "#########",
    "#########",
    "#########",
    "#########",
    "#########",
    "#########",
    "#########",
    "#########",
    "#########",
]

def is_valid(grid, row, col, num):
    # Check if the number already exists in the current row or column
    for i in range(9):
        if grid[row][i] == num or grid[i][col] == num:
            return False

    # Check if the number already exists in the current 3x3 subgrid
    start_row, start_col = 3 * (row // 3), 3 * (col // 3)
    for i in range(3):
        for j in range(3):
            if grid[start_row + i][start_col + j] == num:
                return False

    return True

def solve_sudoku(grid):
    empty_cell = find_empty_cell(grid)
    if not empty_cell:
        return True  # Puzzle solved successfully

    row, col = empty_cell

    for num in "123456789":
        if is_valid(grid, row, col, num):
            grid[row] = grid[row][:col] + num + grid[row][col + 1:]
            if solve_sudoku(grid):
                return True  # If the recursion is successful, return True

            grid[row] = grid[row][:col] + "#" + grid[row][col + 1:]  # Backtrack

    return False

def find_empty_cell(grid):
    for i in range(9):
        for j in range(9):
            if grid[i][j] == "#":
                return (i, j)
    return None  # If there are no empty cells, return None

def print_grid(grid):
    for row in grid:
        print(row)

# Solve the Sudoku puzzle
solve_sudoku(grid)

# Print the solved Sudoku grid
print_grid(grid)
