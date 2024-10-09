package med.voll.api.service;

import med.voll.api.dto.DadosCadastroPacienteDTO;
import med.voll.api.dto.DadosListagemPacienteDTO;
import med.voll.api.mapper.PacienteMapper;
import med.voll.api.repository.PacienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void save(DadosCadastroPacienteDTO dados) {
        pacienteRepository.save(PacienteMapper.toPaciente(dados));
    }

    public Page<DadosListagemPacienteDTO> findAll(Pageable paginacao) {
        return pacienteRepository.findAll(paginacao).map(PacienteMapper::toDadosListagemPacienteDTO);
    }

    public void delete(Long id) {
        pacienteRepository.deleteById(id);
    }

}
