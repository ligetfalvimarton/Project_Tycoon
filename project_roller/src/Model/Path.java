package Model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Path {
    private char[][] matrix;
    
    /**
     * Konstruktor
     * @param board 
     */
    public Path(Unit[][] board){
        matrix = new char[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j].getType() == "path"){
                    matrix[i][j] = '1';
                } else {
                    matrix[i][j] = '0';
                }
            }
        }
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
    
    /**
     * Út megtalálása adott pozícióból.
     * @param destination
     * @param position
     * @param sizex
     * @param sizey
     * @return 
     */
    public List<Point> findPath(Point destination, Point position,int sizex,int sizey){
        List<Point> destinations = new ArrayList<>();
        //finding the sorrounding roads for the object and setting them as destination
        
        //special case with size zero -> setting the given sourcePoint as destination
        if(sizex == sizey && sizex == 0){
            matrix[destination.x][destination.y] = 'D';
            destinations.add(destination);
        }
        for(int i=destination.x;i<destination.x+sizex && i<matrix.length; i++){
            for(int j=destination.y;j<destination.y+sizey && j<matrix[0].length;j++){
                if((i-1 > 0 && (i-1) < matrix.length)){
                    if(matrix[i-1][j] == '1'){
                    matrix[i-1][j] = 'D';
                    destinations.add(new Point(i-1,j));
                    }
                }
                if((i+1 > 0 && i+1 < matrix.length)){
                    if(matrix[i+1][j] == '1'){
                    matrix[i+1][j] = 'D';
                    destinations.add(new Point(i+1,j));
                    }
                }
                if((j-1 > 0 && j-1 < matrix[0].length)){
                    if(matrix[i][j-1] == '1'){
                    matrix[i][j-1] = 'D';
                    destinations.add(new Point(i,j-1));
                    }
                }
                if((j+1 > 0 && j+1 < matrix[0].length)){
                    if(matrix[i][j+1] == '1'){
                    matrix[i][j+1] = 'D';
                    destinations.add(new Point(i,j+1));
                    }
                }
            }
        }
        
        if(matrix[position.x][position.y] != 0){
            if((position.x-1 > 0 && (position.x-1) < matrix.length)){
                if(matrix[position.x-1][position.y] == '1'){
                    position.x = position.x-1;
                }
            }
            if((position.x+1 > 0 && (position.x+1) < matrix.length)){
                if(matrix[position.x+1][position.y] == '1'){
                    position.x = position.x+1;
                }
            }
            if((position.y-1 > 0 && (position.y-1) < matrix[0].length)){
                if(matrix[position.x][position.y-1] == '1'){
                    position.y = position.y-1;
                }
            }
            if((position.y+1 > 0 && (position.y+1) < matrix[0].length)){
                if(matrix[position.x][position.y+1] == '1'){
                    position.y = position.y+1;
                }
            }
        }
        
        List<Point> path = new ArrayList<>();
        List<Leaf> leaves = new ArrayList<>();
        Leaf source = new Leaf(null, position);
        leaves.add(source);
        boolean destinationReached = false;
        int id=0;
        while(!destinationReached && id<leaves.size()){
            Leaf curr = leaves.get(id);
            curr.addNeighbours(matrix,leaves);
            for(Point p : curr.getFrees()){
                boolean used = false;
                for(Leaf l : leaves){

                    if(p.equals(l.pos)){
                        used = true;
                    }
                }
                if(!used){
                    leaves.add(new Leaf(leaves.get(id),p));

                }
                if(matrix[p.x][p.y]=='D'){
                    destinationReached=true;
                }
            }
            id+=1;


        }
        if(destinationReached){
            int i=1;
            Leaf curr = leaves.get(leaves.size()-i++);
            while(matrix[curr.pos.x][curr.pos.y] != 'D' && i<=leaves.size()){curr = leaves.get(leaves.size()-i++);}
            path.add(new Point(curr.getPos()));
            while(curr.getParent() != null){
                curr = curr.getParent();
                path.add(new Point(curr.getPos()));
            }
            for(Point p : destinations){
                matrix[p.x][p.y] = '1';
            }
            destinations.clear();
            return path;
        }
        for(Point p : destinations){
                matrix[p.x][p.y] = '1';
        }
        destinations.clear();
        return null;
    }
}

class Leaf{
    private List<Point> frees;
    Point pos;
    private Leaf parent;

    /**
     * Konstruktor.
     * @param parent
     * @param pos 
     */
    public Leaf(Leaf parent, Point pos){
        frees = new ArrayList<>();
        this.pos = pos;
        this.parent = parent;
    }

    public void addPoint(Point p){
        frees.add(p);
    }

    public List<Point> getFrees(){
        return frees;
    }

    public Leaf getParent(){
        return parent;
    }

    public Point getPos(){
        return pos;
    }

    /**
     * Szomszédok felvétele az út eléréséhez.
     * @param matrix
     * @param leaves 
     */
    public void addNeighbours(char[][] matrix, List<Leaf> leaves){
        if((pos.x-1 >= 0 && pos.x-1 < matrix.length) && matrix[pos.x-1][pos.y] != '0') {
            frees.add(new Point(pos.x-1,pos.y));
        }
        if((pos.x+1 >= 0 && pos.x+1 < matrix.length) && matrix[pos.x+1][pos.y] != '0') {
                frees.add(new Point(pos.x+1,pos.y));
        }
        if((pos.y-1 >= 0 && pos.y-1 < matrix[0].length) && matrix[pos.x][pos.y-1] != '0') {
                frees.add(new Point(pos.x,pos.y-1));
        }
        if((pos.y+1 >= 0 && pos.y+1 < matrix[0].length) && matrix[pos.x][pos.y+1] != '0') {
                frees.add(new Point(pos.x,pos.y+1));
        }	
    }
}