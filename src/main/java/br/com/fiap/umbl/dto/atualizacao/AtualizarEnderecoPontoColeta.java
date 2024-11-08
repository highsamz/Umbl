package br.com.fiap.umbl.dto.atualizacao;

public record AtualizarEnderecoPontoColeta(
        String logradouro,
        String cep,
        String numero,
        String cidade,
        String bairro,
        String estado
) {
}
