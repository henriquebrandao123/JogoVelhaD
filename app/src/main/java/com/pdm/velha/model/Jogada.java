package com.pdm.velha.model;

public class Jogada {

    private  int[][] tabuleiro = new int[][]{ {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };;
    private int vez;
    private int jogador;
    public Jogada (){

        jogador = 0;
        vez = 0;

    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public int setJogada (int linha, int coluna, int[] value)
    {
        vez++;

        if(vez % 2 == 0)
            jogador = 0;
        else
            jogador = 1;

        tabuleiro[linha][coluna] = value[jogador];

        return value[jogador];
    }

    public int verificarGanhador()
    {
        boolean ganhador = false;

        for(int i = 0; i < 3;i++)
        {
            if((tabuleiro[i][0] == tabuleiro[i][1]) & (tabuleiro[i][1] == tabuleiro[i][2] ))
            {
                ganhador = true;
            }
        }

        for(int i = 0; i < 3;i++)
        {
            if(tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i])
            {
                ganhador = true;
            }
        }

        if(tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2])
        {
            ganhador = true;
        }

        if(tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0])
        {
            ganhador = true;
        }

        if(ganhador)
        {
            return jogador;
        }
        if(vez == 9 )
        {
            return 2;
        }

        return 3;

    }

    public void ClearTabuleiro()
    {
        int a = 0;
        for(int i = 0; i < 3;i++)
        {
            for(int j = 0; j < 3;j++)
            {
                tabuleiro[i][j] = a++;
            }
        }
        a = 0;
        jogador = 0;
        vez = 0;
    }
}

