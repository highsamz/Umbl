package br.com.fiap.umbl.dto.cadastro;

import jakarta.validation.constraints.NotBlank;

public record CadastroEnderecoPontoColeta(

        @NotBlank
        String logradouro,
        @NotBlank
        String cep,
        @NotBlank
        String numero,
        @NotBlank
        String cidade,
        @NotBlank
        String bairro,
        @NotBlank
        String estado
) {
}
