package br.ulbra.cadastro;

import android.view.View;
import android.widget.Button;

public class telaprincipal {
    MainActivity act;
    Button btcadastrar_usuario;
    Button bt_listar_usuarios_cadastrados;
    telacadastrousuario tela_cadastro;
    telalistagemusuarios tela_listagem;

    public telaprincipal(MainActivity act) {
        this.act = act;
    }

    public void CarregarTela() {
        act.setContentView(R.layout.telaprincipal);
        btcadastrar_usuario = (Button)
                act.findViewById(R.id.btcadastrar_usuario);
        bt_listar_usuarios_cadastrados = (Button)
                act.findViewById(R.id.bt_listar_usuarios_cadastrados);
        btcadastrar_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela_cadastro.CarregarTela();
            }
        });
        bt_listar_usuarios_cadastrados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela_listagem.CarregarTela();
            }
        });
    }

    public void setTelaCadastro(telacadastrousuario tela_cadastro) {
        this.tela_cadastro = tela_cadastro;
    }

    public void setTelaListagem(telalistagemusuarios tela_listagem) {
        this.tela_listagem = tela_listagem;
    }
}
