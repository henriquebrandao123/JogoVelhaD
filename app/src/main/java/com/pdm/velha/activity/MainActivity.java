package com.pdm.velha.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.pdm.velha.R;
import com.pdm.velha.model.Jogada;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    private  final int CIRCULO = R.drawable.circulo_velha;
    private  final int XIS = R.drawable.xis_velha;
    private  int[] randomOption = {CIRCULO, XIS};

    Jogada jogada = new Jogada();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instanciarImagens();
        limparTabuleiro();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {

            case R.id.img1:

                img1.setImageResource(jogada.setJogada(0,0,randomOption));
                img1.setEnabled(false);
                break;

            case R.id.img2:

                img2.setImageResource(jogada.setJogada(0,1,randomOption));
                img2.setEnabled(false);

                break;
            case R.id.img3:
                img3.setImageResource(jogada.setJogada(0,2,randomOption));
                img3.setEnabled(false);

                break;
            case R.id.img4:
                img4.setImageResource(jogada.setJogada(1,0,randomOption));
                img4.setEnabled(false);

                break;
            case R.id.img5:
                img5.setImageResource(jogada.setJogada(1,1,randomOption));
                img5.setEnabled(false);

                break;
            case R.id.img6:
                img6.setImageResource(jogada.setJogada(1,2,randomOption));
                img6.setEnabled(false);

                break;
            case R.id.img7:
                img7.setImageResource(jogada.setJogada(2,0,randomOption));
                img7.setEnabled(false);

                break;
            case R.id.img8:
                img8.setImageResource(jogada.setJogada(2,1,randomOption));
                img8.setEnabled(false);

                break;
            case R.id.img9:
                img9.setImageResource(jogada.setJogada(2,2,randomOption));
                img9.setEnabled(false);
                break;
            default:
                break;
        }

        verificarJodas();
    }

    private void verificarJodas()
    {
        if(jogada.verificarGanhador() == 0)
        {
            Toast.makeText(getApplicationContext(),"0 Ganhou",Toast.LENGTH_LONG).show();
            bloquearTabuleiro(false);
            limparTabuleiro();
            jogada.ClearTabuleiro();
            bloquearTabuleiro(true);




        }
        else if(jogada.verificarGanhador() == 1)
        {
            Toast.makeText(getApplicationContext(),"x Ganhou",Toast.LENGTH_LONG).show();
            bloquearTabuleiro(false);
            limparTabuleiro();
            jogada.ClearTabuleiro();
            bloquearTabuleiro(true);


        }
        else if(jogada.verificarGanhador() == 2){

            Toast.makeText(getApplicationContext(),"Deu velha",Toast.LENGTH_LONG).show();

        }
    }

    private void instanciarImagens(){

        img1 = findViewById(R.id.img1);
        img1.setOnClickListener(this);

        img2 = findViewById(R.id.img2);
        img2.setOnClickListener(this);

        img3 = findViewById(R.id.img3);
        img3.setOnClickListener(this);

        img4 = findViewById(R.id.img4);
        img4.setOnClickListener(this);

        img5 = findViewById(R.id.img5);
        img5.setOnClickListener(this);

        img6 = findViewById(R.id.img6);
        img6.setOnClickListener(this);

        img7 = findViewById(R.id.img7);
        img7.setOnClickListener(this);

        img8 = findViewById(R.id.img8);
        img8.setOnClickListener(this);

        img9 = findViewById(R.id.img9);
        img9.setOnClickListener(this);

    }

    private void limparTabuleiro(){

        img1.setImageDrawable(null);
        img2.setImageDrawable(null);
        img3.setImageDrawable(null);
        img4.setImageDrawable(null);
        img5.setImageDrawable(null);
        img6.setImageDrawable(null);
        img7.setImageDrawable(null);
        img8.setImageDrawable(null);
        img9.setImageDrawable(null);

    }

    private void bloquearTabuleiro(boolean trava){

        img1.setEnabled(trava);
        img2.setEnabled(trava);
        img3.setEnabled(trava);
        img4.setEnabled(trava);
        img5.setEnabled(trava);
        img6.setEnabled(trava);
        img7.setEnabled(trava);
        img8.setEnabled(trava);
        img9.setEnabled(trava);
    }



}
