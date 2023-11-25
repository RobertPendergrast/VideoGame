public class hitbox{
    public int L;
    public int R;
    public int U;
    public int D;

    public hitbox(int x, int y, int size){
        L = x;
        R = x+size;
        D = y;
        U = y+size;
    }
    public void update(int x, int y, int size){
        L = x;
        R = x+size;
        D = y+size;
        U = y;
    }
    public boolean checkCollisionLeft(hitbox other) {
        //left side of object is over right side of other
        if (((D > other.getU()) && D < other.getD()) || ((U < other.getD()) && (U > other.getU()))) {
            if ((L < other.getR()) && (R > other.getR())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCollisionRight(hitbox other){
        //right side of object is over left side of other
       if(((D>other.getU())&&D<other.getD())||((U<other.getD())&&(U>other.getU()))) {
            if ((R > other.getL()) && (L < other.getL())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCollisionUp(hitbox other){
        return false;
    }

    public boolean checkCollisionDown(hitbox other){
        if(( (L<other.getR()) && (L>other.getL()) )||( (R<other.getL()) && (R<other.getR()) )){
            if(D>other.getU()){
                return true;
            }
        }
        return false;
    }


    public int getL(){
        return L;
    }
    public int getR(){
        return R;
    }
    public int getU(){
        return U;
    }
    public int getD(){
        return D;
    }

}