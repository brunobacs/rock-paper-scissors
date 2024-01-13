package com.bacsstudyingkotlin.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra (View view) {
        // objeto view = propriedades => ex.: tornar invisivel o objeto cliado
        verificarGanhador("pedra");
    }
    public void selecionarPapel (View view) {
        verificarGanhador("papel");
    }
    public void selecionarTesoura (View view) {
        verificarGanhador("tesoura");
    }

    private void verificarGanhador (String escolhaUsuario){
        String escolhaDoApp = gerarEscolhaDoApp();
        TextView textoResultado = findViewById(R.id.resultado);

        if (
                escolhaDoApp.equalsIgnoreCase("pedra") && escolhaUsuario.equalsIgnoreCase("tesoura") ||
                escolhaDoApp.equalsIgnoreCase("papel") && escolhaUsuario.equalsIgnoreCase("pedra") ||
                escolhaDoApp.equalsIgnoreCase("tesoura") && escolhaUsuario.equalsIgnoreCase("papel")
        ){ //App ganha
            textoResultado.setText("App ganhou!");

        } else if (
                escolhaUsuario.equalsIgnoreCase("pedra") && escolhaDoApp.equalsIgnoreCase("tesoura") ||
                        escolhaUsuario.equalsIgnoreCase("papel") && escolhaDoApp.equalsIgnoreCase("pedra") ||
                        escolhaUsuario.equalsIgnoreCase("tesoura") && escolhaDoApp.equalsIgnoreCase("papel") )
        { // user ganha
            textoResultado.setText("User ganhou!");
        }else{ //empate
            textoResultado.setText("Empate!");
        }



    }

    private String gerarEscolhaDoApp() {
        String[] opcoes ={"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);
        String escolhaDoApp = opcoes[numeroAleatorio];

        ImageView imageApp = findViewById(R.id.escolhaAPP);
        switch (escolhaDoApp){
            case "pedra":
                imageApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return escolhaDoApp;
    }
}