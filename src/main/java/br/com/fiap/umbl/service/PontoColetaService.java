package br.com.fiap.umbl.service;

import br.com.fiap.umbl.domain.PontoColetaEntity;
import br.com.fiap.umbl.dto.atualizacao.AtualizarPontoColeta;
import br.com.fiap.umbl.repository.PontoColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PontoColetaService {

    @Autowired
    private PontoColetaRepository pontoColetaRepository;

    public PontoColetaEntity insertPontoColeta (PontoColetaEntity pontoColeta){
        return pontoColetaRepository.save(pontoColeta);
    }

    public Page<PontoColetaEntity> findAllPontoColeta (Pageable pageable){
        return pontoColetaRepository.findAll(pageable);
    }

    public void updatePontoColeta (AtualizarPontoColeta pontoColeta){
        var atualizar = pontoColetaRepository.getReferenceById(pontoColeta.id());
        atualizar.atualizarPontoColeta(pontoColeta);
    }

    public void deletePontoColeta (Long id){
        Optional<PontoColetaEntity> pontoColetaOptional = pontoColetaRepository.findById(id);
        if (pontoColetaOptional.isPresent()){
            pontoColetaRepository.delete(pontoColetaOptional.get());
        }else {
            throw new RuntimeException ("Não foi possível encontrar o Ponto de Coleta");
        }
    }

}
