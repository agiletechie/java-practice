public class Duration extends Thread{
    int count = 0;
    public synchronized void run(){
        while (true){
            if(count <= 2){
                new SimpleChatClientA().go();
                count++;
            }else break;
            try {
                sleep(5000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
