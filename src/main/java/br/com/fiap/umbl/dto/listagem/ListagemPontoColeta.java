package br.com.fiap.umbl.dto.listagem;

import br.com.fiap.umbl.domain.PontoColetaEntity;
import br.com.fiap.umbl.dto.cadastro.MaterialAceito;

public record ListagemPontoColeta (

        String nome,
        MaterialAceito materialAceito,
        String email,
        String telefone
){
    public ListagemPontoColeta(PontoColetaEntity pontoColeta){
        this(pontoColeta.getNome(), pontoColeta.getMaterialAceito(), pontoColeta.getEmail(), pontoColeta.getTelefone());
    }
}
