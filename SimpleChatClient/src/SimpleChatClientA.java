import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClientA {
    PrintWriter writer;
    BufferedReader reader;
    JTextField outgoing;
    JTextArea incoming;

    public void go(){
        JFrame frame = new JFrame();
        JButton sendButton = new JButton("Send");
        incoming = new JTextArea(15,30);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing = new JTextField(20);
        JPanel mainPanel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        sendButton.addActionListener(new SendButtonListener());
        setUpNetworking();

        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.setSize(400,400);
        frame.setVisible(true);
        outgoing.requestFocus();
       // new SendButtonListener().getData(writer,outgoing);
    }

    public void setUpNetworking(){
        try {
            Socket socket = new Socket("localhost",6000);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Connection Established to " + socket.getInetAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev){
            try {
                writer.println(outgoing.getText());
                writer.flush();
            }catch (Exception ex){
                ex.printStackTrace();
            }
            outgoing.setText(" ");
            outgoing.requestFocus();
        }
    }
    public class IncomingReader implements Runnable{
        String message;
        public void run(){
            try {
                while ((message = reader.readLine()) != null){
                    System.out.println("read " + message);
                    incoming.append(message + "\n");
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
            System.out.println("IsThreadAlive " +  Thread.currentThread().isAlive());
        }
    }

    public static void main(String args[]){
        Duration threadA = new Duration();
        threadA.start();
        //new SimpleChatClientA().go();
    }
}