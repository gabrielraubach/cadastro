package br.ulbra.cadastro;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class telalistagemusuarios {
    MainActivity act;
    EditText txtnome, txtendereco, txttelefone;
    Button btanterior, btproximo, btfechar;
    TextView txtstatus;
    telaprincipal tela_principal;
    int index;

    public telalistagemusuarios(
            MainActivity act, telaprincipal tela_principal) {
        this.act = act;
        this.tela_principal = tela_principal;
        index = 0;
    }

    public void CarregarTela() {
//Antes de carregar a tela, verifica se existe registros
        //inseridos
        if (act.getRegistros().size() == 0) {
            (new AlertDialog.Builder(act)).setTitle("Aviso")
                    .setMessage("Não existe nenhum registro cadastrado.")
                    .setNeutralButton("OK", null).show();
            return;
        }
        act.setContentView(R.layout.listagem_usuarios_cadastrados);
        btanterior = (Button) act.findViewById(R.id.btAnt);
        btproximo = (Button) act.findViewById(R.id.btProx);
        btfechar = (Button) act.findViewById(R.id.btFechar);
        txtnome = act.findViewById(R.id.edtNome);
        txtendereco = act.findViewById(R.id.edtend);
        txttelefone = act.findViewById(R.id.edtTel);
        txtstatus = (TextView) act.findViewById(R.id.txtStat);
        PreencheCampos(index);
        AtualizaStatus(index);

        btanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0) {
                    index--;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });

        btproximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < act.getRegistros().size() - 1) {
                    index++;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });
        btfechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela_principal.CarregarTela();
            }
        });
    }


    private void PreencheCampos(int idx)  {
        txtnome.setText(act.getRegistros().get(idx).getNome());
        txttelefone.setText(act.getRegistros().get(idx).getTelefone());
        txtendereco.setText(act.getRegistros().get(idx).getEndereco());
    }

    private void AtualizaStatus(int idx) {
        int total = act.getRegistros().size();
        txtstatus.setText("Registros : " + (idx+1) + "/" + total);
    }

}

