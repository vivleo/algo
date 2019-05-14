import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Main extends JFrame {
    private int WIDTH = 600;
    private int HEIGHT = 600;
    private static Main m = new Main();
    private static Pane p = new Pane();

    public Main(){
        setSize(WIDTH,HEIGHT);
        setName("Game of life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    public static int [][] algo1(){
        int [][] copy = new int[800][800];
        for (int i=1;i<p.getGame().length-1;i++){
            for (int j = 1; j<p.getGame()[0].length-1;j++){
                //System.out.println("AlgoGame "+i+" "+j);
                int cmptr = p.compteur(i,j);
                if (cmptr<2){
                    copy[i][j]=0;
                }
                else if (p.getGame()[i][j]==1 && (cmptr==2 || cmptr==3)){
                    copy[i][j]=p.getGame()[i][j];
                }
                else if (p.getGame()[i][j]==1 && cmptr>3){
                    copy[i][j]=0;
                }
                else if (p.getGame()[i][j]==0 && cmptr==3){
                    copy[i][j]=1;
                }
            }
        }
        return copy;
    }

    public static int [][] algo3(){
        int [][] copy = new int[800][800];
        for (int i=1;i<p.getGame().length-1;i++){
            for (int j = 1; j<p.getGame()[0].length-1;j++) {

                int cmptr = p.compteur(i,j);

                if (p.getGame()[i][j]==0 && cmptr==0){
                    copy[i][j]=0;
                }
                else if (p.getGame()[i][j]==1 && cmptr==1){
                    copy[i][j]=1;
                }
                else if (p.getGame()[i][j]==1 && cmptr==2){
                    p.setGameind(i,j,0);
                }
                else if (p.getGame()[i][j]==1 && cmptr==3){
                    copy[i][j]=3;
                }
                else if (p.getGame()[i][j]==1 && cmptr==4){
                    copy[i][j]=0;
                }
                else if (p.getGame()[i][j]==1 && cmptr==5){
                    copy[i][j]=5;
                }
                else if (p.getGame()[i][j]==1 && cmptr==6){
                    copy[i][j]=0;
                }
                else if (p.getGame()[i][j]==1 && cmptr==7){
                    copy[i][j]=7;
                }
                else if (p.getGame()[i][j]==1 && cmptr==8){
                    copy[i][j]=0;
                }
            }
        }
        return copy;
    }

    public static int [][] sandpile(){
        int [][] copy = new int[600][600];
        int [][]tmp=p.getGame();
        for (int i =1;i<p.getGame().length-1;i++){
            for (int j = 1;j<p.getGame()[0].length-1;j++){
                if (p.getGame()[i][j]>=4){
                    copy[i][j-1]=tmp[i][j-1]+1;
                    copy[i+1][j]=tmp[i+1][j]+1;
                    copy[i-1][j]=tmp[i-1][j]+1;
                    copy[i][j+1]=tmp[i][j+1]+1;
                    p.setGameind(300,300,p.getValueGame(300,300)-4);
                }
            }
        }
        return copy;
    }

    public static void algo2(){

        for (int i = 1; i < p.getGame().length;i++){
            for (int j = 1;j<p.getGame()[0].length;j++){
                if (p.getGame()[i][j]==1 && p.getGame()[i+1][j]==1 && p.getGame()[i][j+1]==1){
                    continue;
                }
                else if (p.getGame()[i][j]==1 && p.getGame()[i][j+1]==1 && p.getGame()[i+1][j]==0){
                    p.setGameind(i,j,0);
                }
                else if (p.getGame()[i][j]==1 && p.getGame()[i+1][j]==1 && p.getGame()[i][j+1]==0){
                    p.setGameind(i,j,0);
                }
            }
        }
    }


    public static int [][] algo6(){
        int [][] copy = new int[800][800];
        int [][]current = p.getGame();
        for (int i=1;i<p.getGame().length-1;i++){
            for (int j = 1; j< p.getGame()[0].length-1;j++) {
                int cmptr = p.compteur(i, j);
                if (cmptr == 1 || cmptr==2 ){
                    copy[i][j]=1;
                }

                else if (cmptr == 3 || cmptr == 4 || cmptr==5 || cmptr == 6 || cmptr == 7 || cmptr == 8){
                    copy[i][j]=0;
                }
            }
        }
        return copy;
    }


    public static int [][] algo7(){
        int [][] copy = new int[600][600];
        int [][]current = p.getGame();
        for (int i=1;i<p.getGame().length-1;i++){
            for (int j = 1; j< p.getGame()[0].length-1;j++) {
                int cmptr = p.compteur(i, j);
                if (cmptr == 2 && p.getGame()[i][j]==0){
                    copy[i][j]=1;
                }
                else if (cmptr==3 || cmptr==4 || cmptr == 5 || cmptr==6 || cmptr==7){
                    copy[i][j]=0;
                }
            }
        }
        return copy;
    }

    public static int [][] algo8(){
        int [][] copy = new int[600][600];
        int [][]current = p.getGame();
        for (int i=1;i<p.getGame().length-1;i++){
            for (int j = 1; j< p.getGame()[0].length-1;j++) {
                int cmptr = p.compteur(i, j);
                if (p.getGame()[i][j]==0 && (cmptr==3 || cmptr==6 || cmptr==7 || cmptr == 8)){
                    copy[i][j]=1;
                }
                else if (p.getGame()[i][j]==1 && (cmptr==3 || cmptr==4 || cmptr==6 || cmptr==7 || cmptr == 8)){
                    copy[i][j]=1;
                }
            }
        }
        return copy;
    }

    public static int [][] algo9(){
        int [][] copy = new int[1000][600];
        int [][]current = p.getGame();
        for (int i=1;i<p.getGame().length-1;i++){
            for (int j = 1; j< p.getGame()[0].length-1;j++) {
                int cmptr = p.compteur(i, j);
                if (current[i][j]==0 && cmptr==3){
                    copy[i][j]=1;
                }
                else if (current[i][j]==1){
                    copy[i][j]=1;
                }
            }
        }
        return copy;
    }

    public static int [][] algo5(){
        int [][] copy = new int[800][800];
        int [][]current = p.getGame();
        for (int i=1;i<p.getGame().length-1;i++){
            for (int j = 1; j< p.getGame()[0].length-1;j++){
                int cmptr=p.compteur(i,j);
                if (current[i][j]==1 && cmptr==8){
                    copy[i][j]=0;
                }
                else if (current[i][j]==1 && cmptr==4){
                    copy[i][j]=0;
                }
                else if (current[i][j]==0 && cmptr==8){
                    copy[i][j]=0;
                }
                else if (current[i][j]==0 && cmptr==4){
                    copy[i][j]=1;
                }
                else if (current[i][j]==1 && cmptr==0){
                    copy[i][j]=1;
                }
                else if (current[i][j]==0 && cmptr==0){
                    copy[i][j]=0;
                }
            }
        }
        return copy;
    }

    public static int [][] algo4(){
        int [][] copy = new int[800][800];
        for (int i = 1; i < p.getGame().length-1;i++){
            for (int j = 1;j<p.getGame()[0].length-1;j++) {
                int cmptr = p.compteur(i,j);
                if (cmptr==3){
                    copy[i][j]=1;
                }
                else if (cmptr>=1 && cmptr<=5){
                    copy[i][j]=p.getGame()[i][j];
                }
                else {
                    copy[i][j]=0;
                }
            }
        }
        return copy;
    }


    public static void main(String[] args) throws Exception{

        m.setContentPane(p);
        m.setVisible(true);
        int cm=0;
        while(true){
            //p.setGame(algo1());
            //algo2();
            //p.setGame(algo3());
            //p.setGame(algo4());
            //p.setGame(algo5());
            //p.setGame(algo6());
            p.setGame(algo7());
            //p.setGame(algo8());
            //p.setGame(algo9());
            //p.setGame(sandpile());
            cm++;
            System.out.println(cm);
            System.out.println("repaint");
            m.repaint();
        }



    }
}
