package org.academiadecodigo.speedTyper.Server;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.speedTyper.View.Cars.Cars;
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
    - Comparação entre palavra escrita e frase
    - Contagem de tempo e comparação entre tempos
    - Print dos nomes dos jogadores + translate das imagens consoante tempo
     */

    private int portnumber;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private Map<String,ClientConnections> threadsMap;
    private ExecutorService myExecutor;

    private View currentView;

    private boolean gameStarted;

    public Server(int portnumber) {
        try {
            this.portnumber = portnumber;
            serverSocket=new ServerSocket(portnumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

        threadsMap=new HashMap<>();
        gameStarted=false;

        introduceGame();
    }

    public Map<String, ClientConnections> getThreadsMap() {
        return threadsMap;
    }

    public boolean isGameStarted() {
        return gameStarted;
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
        setCurrentView(new RegisterView(this));
        start();
        show();
        instructGame();
    }

    public void start() {
        try {
            while(true){
                clientSocket= serverSocket.accept();
                ClientConnections clientConnection=new ClientConnections(clientSocket);
                myExecutor= Executors.newCachedThreadPool();
                myExecutor.submit(clientConnection);
                if(!threadsMap.containsKey(clientConnection.getName())){
                    threadsMap.put(clientConnection.getName(),clientConnection);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean checkPlayersState(){
        boolean allSet=true;
        for (ClientConnections client: threadsMap.values()){
            if(!client.isReadyToPlay()){
                allSet=false;
            }
        }
        return allSet;
    }

    private void instructGame(){
        setCurrentView(new InstructionsView());
        show();
        typeGame();
    }

    private void typeGame(){
        setCurrentView(new GameView(getCars()));
        gameStarted=true;
        show();
        endGame();
    }

    public String[] getCars(){
        ClientConnections[] clientsArr= (ClientConnections[]) threadsMap.values().toArray();
        String[] cars= new String[threadsMap.size()];

        for (int i=0; i< cars.length; i++){
            cars[i]=clientsArr[i].getCar();
        }
        return cars;
    }

    private void endGame(){
        setCurrentView(new EndView());
        show();
        close();
    }

    private void close(){
        for(ClientConnections client: threadsMap.values()){
            client.close();
        }
        myExecutor.shutdown();
        try {
            clientSocket.close();
            serverSocket.close();
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
        private String car;
        private boolean readyToPlay;

        public ClientConnections(Socket clientSocket){
            try {
                this.clientSocket=clientSocket;
                in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out=new PrintWriter(clientSocket.getOutputStream(), true);
                readyToPlay=false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        public String getCar() {
            return car;
        }

        public boolean isReadyToPlay(){
            return readyToPlay;
        }

        @Override
        public void run() {
            name=askName();
            number=askNumber();
            car= loadCar(number);
            readyToPlay=true;
            while(true){
                if(isGameStarted()){
                    read(); //-------------------ACRESCENTAR AQUI OS MÉTODOS DE COMPARAÇÃO E CONTAGEM
                }
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

        public String loadCar(int numberChosen){
            String src = null;
            for (Cars car: Cars.values()){
                if(numberChosen==car.getNumber()){
                    src=car.getCarSrc();
                }
            }
            return src;
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

        public void close(){
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

