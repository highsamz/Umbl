package br.com.fiap.umbl.domain;

import br.com.fiap.umbl.dto.atualizacao.AtualizarPontoColeta;
import br.com.fiap.umbl.dto.cadastro.CadastroPontoColeta;
import br.com.fiap.umbl.dto.cadastro.MaterialAceito;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PONTO_COLETA")
@EqualsAndHashCode(of = "id")
public class PontoColetaEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_PONTO_COLETA"
    )
    @SequenceGenerator(name = "SEQ_PONTO_COLETA",
            sequenceName = "SEQ_PONTO_COLETA",
            allocationSize = 1
    )
    private Long id;
    private String capacidade;
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(name = "material_aceito")
    private MaterialAceito materialAceito;
    private String email;
    private String telefone;
    @Embedded
    private EnderecoPontoColetaEntity enderecoPontoColeta;

    public PontoColetaEntity(CadastroPontoColeta dados){
        this.nome = dados.nome();
        this.capacidade = dados.capacidade();
        this.materialAceito = dados.materialAceito();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.enderecoPontoColeta = new EnderecoPontoColetaEntity(dados.enderecoPontoColeta());
    }

    public void atualizarPontoColeta(AtualizarPontoColeta pontoColeta){
        if (pontoColeta.nome() != null){
            this.nome = pontoColeta.nome();
        }
        if (pontoColeta.capacidade() != null){
            this.capacidade = pontoColeta.capacidade();
        }
        if (pontoColeta.materialAceito() != null){
            this.materialAceito = pontoColeta.materialAceito();
        }
        if (pontoColeta.email() != null){
            this.email = pontoColeta.email();
        }
        if (pontoColeta.telefone() != null){
            this.telefone = pontoColeta.telefone();
        }
        this.enderecoPontoColeta = new EnderecoPontoColetaEntity(pontoColeta.enderecoPontoColeta());

    }
}
