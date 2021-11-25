package org.academiadecodigo.speedTyper.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    /*
    O que falta:
    - Servidor ir comparando palavra a palavra o que está a receber.
    - Servidor faz a contagem?
    - Servidor prints nomes jogadores + tempos de cada um (+ translate carros)
     */

    private int portnumber;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private Map<String,ClientConnections> threadsMap;

    public Server(int portnumber) {
        this.portnumber = portnumber;
        threadsMap=new HashMap<>();
    }

    public void start() {
        try {
            while(true){
                clientSocket= serverSocket.accept();
                ClientConnections clientConnection=new ClientConnections(clientSocket);
                ExecutorService myExecutor= Executors.newCachedThreadPool();
                myExecutor.submit(clientConnection);
                if(!threadsMap.containsKey(clientConnection.getName())){
                    threadsMap.put(clientConnection.getName(),clientConnection);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private class ClientConnections implements Runnable{

        private Socket clientSocket;
        private BufferedReader in;
        private String name;

        public ClientConnections(Socket clientSocket){
            this.clientSocket=clientSocket;
            try {
                in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                name=askName();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while(true){
                read();
            }
        }

        private String askName() {
            System.out.println("Enter your super-hero-alter-ego name: ");
            String nameHere = "";

            try {
                nameHere=in.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            return nameHere;
        }

        public String getName() {
            return name;
        }

        public Thread getThisThread(){
            return Thread.currentThread();
        }

        public void read(){
            String line="";
            String result="";

            try{
                while((line=in.readLine())!=null){
                    result+=line+"\n";
                }
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }

    }

}
