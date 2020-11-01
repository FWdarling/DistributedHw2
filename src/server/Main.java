package server;

public class Main {
    public static void main(String[] args){
        try {
            DataReceive server = new DataReceive();
            String path = "src/dataServer/File";
            server.load(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
