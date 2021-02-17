package com.app.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private TextInputEditText email;
    private TextView tv;

    Button btnNext;

    //checkbox - capturando selecoes
    private CheckBox checkVermelho;
    private CheckBox checkAzul;
    private CheckBox checkBranco;

    //referencias para o radiobutton
    private RadioButton sexoMasculino, sexoFeminino;
    private RadioGroup opcaoSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //capturando inputs
        nome = findViewById(R.id.nome);
        email = findViewById(R.id.email);
        tv = findViewById(R.id.txtResultado);

        //checkbox capturando o que usuario marcou
        checkAzul = findViewById(R.id.checkBlue);
        checkBranco = findViewById(R.id.checkWhite);
        checkVermelho = findViewById(R.id.checkRed);

        //capturando os sexos informado na view
        sexoMasculino = findViewById(R.id.radioM);
        sexoFeminino = findViewById(R.id.radioF);

        opcaoSexo = findViewById(R.id.RadioGroupSexo);
        sexos();
        //botão clicavel para ir para outra tela
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent outraTela = new Intent(getApplicationContext(), ActivityTwo.class);
                startActivity(outraTela);
            }
        });
    }

    public void checkbox(){
     String texto = "";
     if( checkVermelho.isChecked() ){
         texto = "Vermelho Selecionado - ";
     }

        if( checkBranco.isChecked() ){
            texto = texto + "Branco Selecionado - ";
        }

        if( checkAzul.isChecked() ){
            texto = texto + "Azul Selecionado - ";
        }
      tv.setText(texto);
    }
    public void sexos(){

        opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioM){
                    tv.setText("masculino");
                }else if(checkedId == R.id.radioF){
                    tv.setText("feminino");
                }
            }
        });

        /*

        if(sexoMasculino.isChecked()){
            tv.setText("masculino");
        }else{
            tv.setText("feminino");
        }

         */



    }


    // metodo para recuperar dados da caixa de texto
    public void enviar(View view) {
        sexos();
       // checkbox();
       /*
        //pegando o campo nome
        String recuperaNome = nome.getText().toString();

        //pegando o campo email
        String recuperaEmail = email.getText().toString();

        //recuperar o texto resultado da interface
        tv.setText("Nome digitado:" + recuperaNome + " e o Email digitado é: " + recuperaEmail);
*/

    }

        public void limpar(View view) {
            nome.setText("");
            email.setText("");
        }

}
