package eu.killmaster;

import java.util.Random;

/**
 * Created by killmaster on 28-03-2014.
 */
public class Mundo {
    private static final int OBSTACULO = 0;
    private static final int INIMIGO = 1;
    private static final int SAIDA = 2;
    private static final int SNAKE = 3;
    private static final int TTL = 10;
    private int side = 0;
    private int obstaculos;
    private int inimigos;
    private Object[][] mundo;
    Random rand = new Random();

    public Mundo(int side,int obstaculos, int inimigos) {
        this.side = side;
        this.obstaculos = obstaculos;
        this.inimigos = inimigos;
        preencherMundo(obstaculos,OBSTACULO);
        preencherMundo(inimigos,INIMIGO);
        preencherMundo(1,SAIDA);
        preencherMundo(1,SNAKE);
    }

    @Override
    public String toString() {
        int i,j;
        String mundo = "";
        for(i = 0; i < this.side; i++){
            for(j = 0; j < this.side; j++){
                if(!this.mundo[i][j].equals(null))
                    mundo += this.mundo[i][j].toString();
                else
                    mundo += ".";
            }
            mundo += "\n";
        }
        return mundo;
    }

    private void preencherMundo(int limite, int tipo){
        int i,x,y;
        for(i = 0; i < limite; i++){
            x = rand.nextInt(this.side);
            y = rand.nextInt(this.side);
            if(!this.mundo[x][y].equals(null)){
                i--;
            }
            else{
                switch (tipo) {
                    case(OBSTACULO):
                        this.mundo[x][y] = new Obstaculo();
                        break;
                    case(INIMIGO):
                        this.mundo[x][y] = new Inimigo();
                        break;
                    case(SAIDA):
                        this.mundo[x][y] = new Saida();
                        break;
                    case(SNAKE):
                        this.mundo[x][y] = new Snake(TTL);
                        break;
                }
            }
        }
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public Object[][] getMundo() {
        return mundo;
    }

    public void setMundo(Object[][] mundo) {
        this.mundo = mundo;
    }

    public int getObstaculos() {
        return obstaculos;
    }

    public void setObstaculos(int obstaculos) {
        this.obstaculos = obstaculos;
    }

    public int getInimigos() {
        return inimigos;
    }

    public void setInimigos(int inimigos) {
        this.inimigos = inimigos;
    }
}
