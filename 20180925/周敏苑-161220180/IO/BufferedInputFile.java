package IO;

import java.io.*;

public class BufferedInputFile {
    DataInputStream in;
    String name;
    public BufferedInputFile(String x){
        name = x;
    }
    public BufferedInputFile(){}

    public String read() throws IOException{
        BufferedReader in1 = new BufferedReader(new FileReader(name));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in1.readLine()) != null){
            sb.append(s + '\n');
        }
        in1.close();
        return sb.toString();
    }

    public void setIn() throws IOException{
        in = new DataInputStream(new ByteArrayInputStream(read().getBytes()));
    }

    public char charFromInput() throws IOException{
        while(in.available() != 0)
            return (char)in.readByte();
        return '!';
    }
}
