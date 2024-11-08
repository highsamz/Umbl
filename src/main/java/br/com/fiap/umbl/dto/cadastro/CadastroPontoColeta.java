package br.com.fiap.umbl.dto.cadastro;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroPontoColeta(
        @NotBlank
        String nome,
        @NotBlank
        String capacidade,
        @NotNull
        MaterialAceito materialAceito,
        @Email
                @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotNull
        CadastroEnderecoPontoColeta enderecoPontoColeta
) {
}
