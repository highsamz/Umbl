package br.com.fiap.umbl.dto.atualizacao;

import br.com.fiap.umbl.dto.cadastro.MaterialAceito;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record AtualizarPontoColeta(
        @NotNull
        Long id,
        String nome,
        String capacidade,
        MaterialAceito materialAceito,
        @Email
        String email,
        String telefone,
        AtualizarEnderecoPontoColeta enderecoPontoColeta
) {
}
