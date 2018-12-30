package record;


import java.io.File;

public class Record {

    private File recordFile = new File("CalabashWorld");

    public Record() {
        //文件的覆盖
        if(recordFile.exists()) {
            recordFile.delete();
        }
    }

    public void beginRecord(){

    }

    public void stopRecord(){

    }

}
