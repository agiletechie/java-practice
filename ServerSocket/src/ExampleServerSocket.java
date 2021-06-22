import java.io.*;
import java.net.*;
public class ExampleServerSocket {
    String adviceList[] = {"Take Smaller bites","Go for the tight jeans","Oneword : inappropriate",
                            "Just for today,behonest","My dog name is Tony"};

    public void go(){
        try{
            ServerSocket serverSock = new ServerSocket(4242);

            while (true){
                Socket sock = serverSock.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);

                writer.close();
                System.out.println(advice);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public String getAdvice() {
        String advice;

        int num = (int) (Math.random() * adviceList.length);
        advice = adviceList[num];
        return advice;
    }

    public static void main(String args[]){
        ExampleServerSocket server = new ExampleServerSocket();
        server.go();
    }
}
