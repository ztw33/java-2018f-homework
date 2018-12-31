package Formation;

public class FormationException extends Exception {
    private String name;
    public  FormationException(){
        super();
    }

    public FormationException(String code,String name){
        super(code);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
