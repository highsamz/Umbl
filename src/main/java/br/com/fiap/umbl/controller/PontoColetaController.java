package br.com.fiap.umbl.controller;

import br.com.fiap.umbl.domain.PontoColetaEntity;
import br.com.fiap.umbl.dto.atualizacao.AtualizarPontoColeta;
import br.com.fiap.umbl.dto.cadastro.CadastroPontoColeta;
import br.com.fiap.umbl.dto.listagem.ListagemPontoColeta;
import br.com.fiap.umbl.service.PontoColetaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class PontoColetaController {

    @Autowired
    private PontoColetaService pontoColetaService;

    @PostMapping("/salvar/coleta")
    @ResponseStatus(HttpStatus.CREATED)
    PontoColetaEntity postColeta (@RequestBody @Valid CadastroPontoColeta cadastroPontoColeta){
        return pontoColetaService.insertPontoColeta(new PontoColetaEntity(cadastroPontoColeta));
    }

    @GetMapping("/listar/coletas")
    @ResponseStatus(HttpStatus.OK)
    Page<ListagemPontoColeta> findAllColeta (@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return pontoColetaService.findAllPontoColeta(pageable).map(ListagemPontoColeta::new);
    }

    @PutMapping("/atualizar/coleta")
            @Transactional
    void putColeta(@RequestBody @Valid AtualizarPontoColeta pontoColeta){
        pontoColetaService.updatePontoColeta(pontoColeta);
    }

    @DeleteMapping("/excluir/coleta/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteColeta (@PathVariable Long id){
        pontoColetaService.deletePontoColeta(id);
    }
}
