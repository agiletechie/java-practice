import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class MyMainChatServer{
    ArrayList clientOutputStreams;

    public class ClientHandler implements Runnable{
        Socket sock;
        BufferedReader reader;

        public void run(){
            String message;
            try {
                while ((message = reader.readLine()) != null){
                    System.out.println(message);
                    tellEveryOne(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public ClientHandler(Socket clientSocket){
            sock = clientSocket;
            try {
                InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamReader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void go(){
        clientOutputStreams = new ArrayList();
        try {
            ServerSocket serverSock = new ServerSocket(6000);
            while (true){
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                clientOutputStreams.add(writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tellEveryOne(String message){
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext()){
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                writer.flush();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new MyMainChatServer().go();
    }
}
