package homework3.position;

/** A type represents a fix point in Cartesian coordinates*/
public class Position <T>{
    private final int x, y;
    private T obj = null;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public T getObject(){
        return obj;
    }

    public void setObject(T obj){
        this.obj = obj;
    }

    public void clear(){
        this.obj = null;
    }

    public String toString(){
        if(obj == null)
            return "**";
        return obj.toString();
    }
}
