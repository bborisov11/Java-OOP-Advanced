package onehitdungeon.io;

import onehitdungeon.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements InputReader {
    private BufferedReader bf;

    public ConsoleReader(){
        this.bf = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine(){
        try {
            return bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
