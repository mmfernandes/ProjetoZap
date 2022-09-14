package com.example.trabalhozap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity
{

    //definição das variaveis
    private TextInputLayout num_Telefone;
    private TextInputLayout _mensagem;

    private TextInputEditText textInput_Telefone;
    private TextInputEditText getTextInput_Mensagem;


    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnviar = findViewById(R.id.buttonEnviar);
        textInput_Telefone = findViewById(R.id.textInput_Telefone);
        getTextInput_Mensagem = findViewById(R.id.textInput_Mensagem);

        buttonEnviar.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        String telefone = textInput_Telefone.getText().toString(); //convertendo para string
                        String mensagem = getTextInput_Mensagem.getText().toString();
                        telefone  = Space(telefone);

                        String zap = LinkZap(telefone,mensagem);
                        openWebPage(zap);

                        

                    }

                }
                );

    }
    public String LinkZap(String telefone, String mensagem)
    {
        mensagem = mensagem.replace(" ", "%20"); //recebendo a mensagem e substituindo os espaços por %20
        return ("https://wa.me/" + telefone + "?text=" + mensagem);

    }
    public String Space(String telefone)
    {
        telefone = telefone.replace(" ", ""); // string para substituir o espaço e evitar erro ao enviar mensagem
        return telefone ;

    }
    public void openWebPage(String zap)
    {
        Uri webpage = Uri.parse(zap);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        startActivity(intent);

    }

}