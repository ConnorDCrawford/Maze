/*
 * Maze
 * Created by Connor Crawford
 */

package maze;

import java.util.LinkedList;

public class PathFinder {

    Maze maze;

    public PathFinder(Maze iMaze) {
        maze = iMaze;
    }

    private boolean traverseMaze (int row, int col, char dir, LinkedList<Coordinate> path) {
        boolean isDone = false;
        if (maze.isExit(row, col)) {
            return (true);
        } else {
            if (dir != 'N' && !maze.hasNorthWall(row, col))
                isDone = traverseMaze(row - 1, col, 'S', path);
            if (dir != 'S' && !maze.hasSouthWall(row, col) && !isDone)
                isDone = traverseMaze(row + 1, col, 'N', path);
            if (dir != 'E' && !maze.hasEastWall(row, col) && !isDone)
                isDone = traverseMaze(row, col + 1, 'W', path);
            if (dir != 'W' && !maze.hasWestWall(row, col) && !isDone)
                isDone = traverseMaze(row, col - 1, 'E', path);
            if (isDone)
                path.add(new Coordinate(row, col));
            return (isDone);
        }
    }
    
    public LinkedList<Coordinate> findPath(int startRow, int startColumn) {
        LinkedList<Coordinate> myPath = new LinkedList<Coordinate>();
        traverseMaze(startRow, startColumn, ' ', myPath); 
        return (myPath);
    }
}
