package med.voll.api.service;

import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.dto.DadosListagemMedicoDTO;
import med.voll.api.mapper.MedicoMapper;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico save(DadosCadastroMedicoDTO medicoDTO) {
        return medicoRepository.save(MedicoMapper.toMedico(medicoDTO));
    }

    public List<DadosListagemMedicoDTO> findAll(){
        return medicoRepository.findAll().stream()
                .map(MedicoMapper::toDadosListagemMedicoDTO)
                .collect(Collectors.toList());
    }

}
