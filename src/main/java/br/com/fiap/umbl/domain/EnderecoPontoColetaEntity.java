package br.com.fiap.umbl.domain;

import br.com.fiap.umbl.dto.atualizacao.AtualizarEnderecoPontoColeta;
import br.com.fiap.umbl.dto.cadastro.CadastroEnderecoPontoColeta;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoPontoColetaEntity {

    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private String bairro;
    private String estado;

    public EnderecoPontoColetaEntity(CadastroEnderecoPontoColeta dadosEndereco){
        this.logradouro = dadosEndereco.logradouro();
        this.cep = dadosEndereco.cep();
        this.numero = dadosEndereco.numero();
        this.cidade = dadosEndereco.cidade();
        this.bairro = dadosEndereco.bairro();
        this.estado = dadosEndereco.estado();
    }

    public EnderecoPontoColetaEntity(AtualizarEnderecoPontoColeta endereco){
    executarComCaptura(() -> {
        if (endereco.logradouro() != null) {
            this.logradouro = endereco.logradouro();
        }
        if (endereco.cep() != null) {
            this.cep = endereco.cep();
        }
        if (endereco.numero() != null) {
            this.numero = endereco.numero();
        }
        if (endereco.cidade() != null) {
            this.cidade = endereco.cidade();
        }
        if (endereco.bairro() != null) {
            this.bairro = endereco.bairro();
        }
        if (endereco.estado() != null) {
            this.estado = endereco.estado();
        }
    }
    );
    }
    private void executarComCaptura(Runnable task) {
        try {
            task.run();
        } catch (Exception assertionError) {
            StackTraceElement[] stackTrace = assertionError.getStackTrace();
            if (stackTrace.length > 0) {
                StackTraceElement element = stackTrace[0];
                System.err.println("Ocorreu erro: " + element.getClassName());
            } else {
                System.err.println("Stack trace está vazia.");
            }
        }
    }
}
