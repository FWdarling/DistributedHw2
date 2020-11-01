package client;

import java.io.*;
import java.net.Socket;

public class SearchClient {

    public String search(String ip, int port, String name, String id) throws IOException {
        Socket socket = new Socket(ip, port);
        //System.out.println("Successfully connected to the server" + id);
        //System.out.println("ip: " + ip + "and port: " + port);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        out.write((id + ':' + name).getBytes());

        byte[] bytes = new byte[1024];
        int len = in.read(bytes);
        String str = new String(bytes, 0, len);
        System.out.println(str);
        String ans = new String(bytes, 17, len - 17);
        return ans;
    }

    public static void main(String[] args)  {
        System.out.println("Please input author name you want to search: ");
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String name = "";
        try{
            name = br.readLine();
            System.out.println("Please wait for server response...");
            String ans = "";
            int sum = 0;

            SearchClient searchClient = new SearchClient();
            ans = searchClient.search("127.0.0.1", 9999, name, "00");
            sum += Integer.parseInt(ans);
            ans = searchClient.search("127.0.0.1", 9999, name, "01");
            sum += Integer.parseInt(ans);
            ans = searchClient.search("127.0.0.1", 9999, name, "02");
            sum += Integer.parseInt(ans);
            System.out.println("The total number of occurrences of the author is " + sum);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

}
