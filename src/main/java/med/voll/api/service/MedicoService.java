package med.voll.api.service;

import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.mapper.MedicoMapper;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico save(DadosCadastroMedicoDTO medicoDTO) {
        return medicoRepository.save(MedicoMapper.toMedico(medicoDTO));
    }

}
