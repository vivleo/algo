import javax.swing.*;
import java.awt.*;

public class Pane extends JPanel {
    private int[][] game = new int[800][600];

    public Pane() {
        super();
        init();
    }

    public void setGameind(int i, int j, int value) {
        game[i][j] = value;
    }

    public void setGame(int[][] a) {
        this.game = a;
    }

    public int[][] getGame() {
        return this.game;
    }

    @Override
    public void paintComponent(Graphics g) {
        //coloring(g);
        //algorithm1coloring(g);
        simpleColoring(g);
        //coloringAlgo3(g);
        //coloringSandpile(g);
    }

    public int getValueGame(int i, int j) {
        return game[i][j];
    }

    public void coloringSandpile(Graphics g) {
        for (int i = 1; i < game.length - 1; i++) {
            for (int j = 1; j < game[0].length - 1; j++) {
                if (game[i][j] == 1) {
                    g.setColor(Color.MAGENTA);
                    g.fillRect(i, j, 1, 1);
                } else if (game[i][j] == 2) {
                    g.setColor(Color.BLUE);
                    g.fillRect(i, j, 1, 1);
                } else if (game[i][j] == 3) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i, j, 1, 1);
                } else if (game[i][j] == 4) {
                    g.setColor(Color.green);
                    g.fillRect(i, j, 1, 1);
                }
            }
        }
    }

    public void initSandpile() {
        for (int i = 1; i < game.length - 1; i++) {
            for (int j = 1; j < game[0].length - 1; j++) {
                if (i == 300 && j == 300) {
                    game[300][300] = 100000;
                }
                game[i][j] = 0;
            }
        }
    }

    public void coloringAlgo3(Graphics g) {
        for (int i = 1; i < game.length - 1; i++) {
            for (int j = 1; j < game[0].length - 1; j++) {
                if (game[i][j] == 0) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i, j, 1, 1);
                } else if (game[i][j] == 1) {
                    g.setColor(Color.darkGray);
                    g.fillRect(i, j, 1, 1);
                } else if (game[i][j] == 2) {
                    g.setColor(Color.WHITE);
                    g.fillRect(i, j, 1, 1);
                } else if (game[i][j] == 3) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(i, j, 1, 1);
                } else if (game[i][j] == 4) {
                    g.setColor(Color.RED);
                    g.fillRect(i, j, 1, 1);
                } else if (game[i][j] == 5) {
                    g.setColor(Color.BLUE);
                    g.fillRect(i, j, 1, 1);
                } else if (game[i][j] == 6) {
                    g.setColor(Color.magenta);
                    g.fillRect(i, j, 1, 1);
                } else if (game[i][j] == 7) {
                    g.setColor(Color.pink);
                    g.fillRect(i, j, 1, 1);
                } else if (game[i][j] == 8) {
                    g.setColor(Color.green);
                    g.fillRect(i, j, 1, 1);
                }
            }
        }
    }

    public void coloring(Graphics g) {
        int ite = 0;
        int[] col = {1, 2, 3, 4};
        for (int i = 1; i < game.length - 1; i++) {
            for (int j = 1; j < game[0].length - 1; j++) {
                if (game[i][j] == 1) {
                    g.setColor(Color.WHITE);
                    g.fillRect(i, j, 1, 1);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(i, j, 1, 1);
                }
            }
        }
    }

    public void algorithm1coloring(Graphics g) {
        for (int i = 1; i < game.length - 1; i++) {
            for (int j = 1; j < game[0].length - 1; j++) {
                if (game[i][j] == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(i, j, 4, 4);
                } else if (game[i][j] == 1) {
                    g.setColor(Color.BLUE);
                    g.fillRect(i, j, 4, 4);
                } else if (game[i][j] == 2) {
                    g.setColor(Color.red);
                    g.fillRect(i, j, 4, 4);
                }
            }
        }
    }

    public void simpleColoring(Graphics g) {
        for (int i = 1; i < game.length - 1; i++) {
            for (int j = 1; j < game[0].length - 1; j++) {
                if (game[i][j] == 0) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i, j, 1, 1);
                } else if (game[i][j] == 1) {
                    g.setColor(Color.WHITE);
                    g.fillRect(i, j, 1, 1);
                }

            }
        }
    }


    public void init() {
        for (int i = 1; i < game.length - 1; i++) {
            for (int j = 1; j < game[0].length - 1; j++) {
                game[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    public void init2() {
        for (int i = 200; i < 550; i++) {
            for (int j = 200; j < 500; j++) {
                game[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    public void init8() {
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                game[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    public void algoGame() {

    }

    /*
        public int[][] extraitMatrice(int [][] mat, int i ,int j){
            int [][] resu = new int [3][3];
            for (int a=0;a<mat.length;a++){
                for (int b = 0;b<mat[0].length;b++){
                    if (a==i-1 && b==j-1){
                        resu[0][0] = mat[a][b];
                    }
                    else if (a==i-1 && b==j){
                        resu[0][1] = mat[a][b];
                    }
                    else if (a==i-1 && b==j+1){
                        resu [0][2] = mat[a][b];
                    }
                    else if (a==i && b==j-1){
                        resu[1][0] = mat[a][b];
                    }
                    else if (a==i && b==j){
                        continue;
                    }
                    else if (a==i && b==j+1){
                        resu[1][2] = mat[a][b];
                    }
                    else if (a==i+1 && b==j-1){
                        resu[2][0] = mat[a][b];
                    }
                    else if (a==i+1 && b==j){
                        resu[2][1] = mat[a][b];
                    }
                    else if (a==i+1 && b==j+1){
                        resu[2][2] = mat[a][b];
                    }
                }
            }
            return resu;
        }
    */
    public int compteurVoisinDir(int i, int j) {
        int cmptr = 0;
        if (game[i - 1][j] == 1)
            cmptr++;
        if (game[i][j - 1] == 1)
            cmptr++;
        if (game[i][j + 1] == 1)
            cmptr++;
        if (game[i + 1][j] == 1)
            cmptr++;
        return cmptr;
    }

    public int compteurVoisinDirHor(int i, int j) {
        int cmptr = 0;
        if (game[i - 1][j] == 1)
            cmptr++;
        if (game[i + 1][j] == 1)
            cmptr++;
        return cmptr;
    }

    public int compteur(int i, int j) {
        int cmptr = 0;
        if (game[i - 1][j - 1] == 1)
            cmptr++;
        if (game[i - 1][j] == 1)
            cmptr++;
        if (game[i - 1][j + 1] == 1)
            cmptr++;
        if (game[i][j - 1] == 1)
            cmptr++;
        if (game[i][j + 1] == 1)
            cmptr++;
        if (game[i + 1][j - 1] == 1)
            cmptr++;
        if (game[i + 1][j] == 1)
            cmptr++;
        if (game[i + 1][j + 1] == 1)
            cmptr++;
        return cmptr;
    }

    public int compteurDiag(int i, int j) {
        int cmptr = 0;
        if (game[i - 1][j - 1] == 1)
            cmptr++;
        if (game[i - 1][j + 1] == 1)
            cmptr++;
        if (game[i + 1][j - 1] == 1)
            cmptr++;
        if (game[i + 1][j + 1] == 1)
            cmptr++;
        return cmptr;
    }


}
