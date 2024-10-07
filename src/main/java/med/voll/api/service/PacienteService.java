package med.voll.api.service;

import med.voll.api.dto.DadosCadastroPacienteDTO;
import med.voll.api.dto.DadosListagemPacienteDTO;
import med.voll.api.mapper.PacienteMapper;
import med.voll.api.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void save(DadosCadastroPacienteDTO dados) {
        pacienteRepository.save(PacienteMapper.toPaciente(dados));
    }

    public List<DadosListagemPacienteDTO> findAll() {
        return PacienteMapper.toDadosListagemPacienteDTOList(pacienteRepository.findAll());
    }
}
