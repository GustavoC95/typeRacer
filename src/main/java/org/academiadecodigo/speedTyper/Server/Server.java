package org.academiadecodigo.speedTyper.Server;

import org.academiadecodigo.speedTyper.View.Impl.*;
import org.academiadecodigo.speedTyper.View.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    /*
    O que falta:
    - Encadear tudo (wiring)
    - Fazer match entre seleção dos carros e os carros que aparecem no jogo
    - Comparação entre palavra escrita e frase
    - Contagem de tempo e comparação entre tempos
    - Print dos nomes dos jogadores + translate das imagens consoante tempo
    - Indicar o port no início do jogo ou ter algures uma indicação?!
     */

    private int portnumber;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private Map<String,ClientConnections> threadsMap;

    private View currentView;

    public Server(int portnumber) {
        this.portnumber = portnumber;
        try {
            serverSocket=new ServerSocket(portnumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        threadsMap=new HashMap<>();

        introduceGame();
    }

    public Map<String, ClientConnections> getThreadsMap() {
        return threadsMap;
    }

    public View getCurrentView() {
        return currentView;
    }

    public void setCurrentView(View currentView) {
        this.currentView = currentView;
    }

    private void show(){
        while(!currentView.getMoveNext()){
            currentView.show();
        }
    }

    private void introduceGame(){
        setCurrentView(new IntroductionView());
        show();
        initializeGame();
    }

    private void initializeGame(){
        setCurrentView(new PresentationView());
        show();
        register();
    }

    private void register(){
        setCurrentView(new RegisterView());
        show();
        instructGame();
    }

    private void instructGame(){
        setCurrentView(new InstructionsView());
        show();
        typeGame();
    }

    private void typeGame(){
        setCurrentView(new GameView());
        show();
        endGame();
    }

    private void endGame(){
        setCurrentView(new EndView());
        show();
        //close everything
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
        private PrintWriter out;

        private String name;
        private int number;

        public ClientConnections(Socket clientSocket){
            this.clientSocket=clientSocket;
            try {
                in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out=new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Thread getThisThread(){
            return Thread.currentThread();
        }

        public String getName() {
            return name;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public void run() {
            name=askName();
            number=askNumber();
            while(true){
                read();
            }
        }

        private String askName() {
            out.write("Enter your racer name: \n");
            out.flush();

            String nameHere = "";

            try {
                nameHere=in.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            return nameHere;
        }

        private int askNumber(){
            out.write("Choose your car: ");
            out.flush();

            int numberHere = 0;

            try {
                numberHere=Integer.valueOf(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return numberHere;
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

