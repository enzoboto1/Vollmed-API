package med.voll.api.service;

import med.voll.api.dto.DadosAtualizacaoPacienteDTO;
import med.voll.api.dto.DadosCadastroPacienteDTO;
import med.voll.api.dto.DadosEnderecoDTO;
import med.voll.api.dto.DadosListagemPacienteDTO;
import med.voll.api.mapper.EnderecoMapper;
import med.voll.api.mapper.PacienteMapper;
import med.voll.api.model.Paciente;
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

    public void update(DadosAtualizacaoPacienteDTO dados) {
        Paciente paciente = pacienteRepository.getReferenceById(dados.id());
        verificaDadosPacienteDTO(dados, paciente);
        verificaDadosEnderecoDTO(dados, paciente);
        pacienteRepository.save(paciente);
    }

    private void verificaDadosPacienteDTO(DadosAtualizacaoPacienteDTO dados, Paciente paciente) {
        if (dados.nome() != null) {
            paciente.setNome(dados.nome());
        }
        if (dados.telefone() != null) {
            paciente.setTelefone(dados.telefone());
        }
        if (dados.endereco() != null) {
            paciente.setEndereco(EnderecoMapper.toEndereco(dados.endereco()));
        }
    }

    private void verificaDadosEnderecoDTO(DadosAtualizacaoPacienteDTO dados, Paciente paciente) {
        if (dados.endereco() != null) {
            DadosEnderecoDTO endereco = dados.endereco();

            if (endereco.logradouro() != null) {
                paciente.getEndereco().setLogradouro(endereco.logradouro());
            }
            if (endereco.bairro() != null) {
                paciente.getEndereco().setBairro(endereco.bairro());
            }
            if (endereco.cep() != null) {
                paciente.getEndereco().setCep(endereco.cep());
            }
            if (endereco.uf() != null) {
                paciente.getEndereco().setUf(endereco.uf());
            }
            if (endereco.cidade() != null) {
                paciente.getEndereco().setCidade(endereco.cidade());
            }
            if (endereco.numero() != null) {
                paciente.getEndereco().setNumero(endereco.numero());
            }
            if (endereco.complemento() != null) {
                paciente.getEndereco().setComplemento(endereco.complemento());
            }
        }
    }

    public void delete(Long id) {
        pacienteRepository.deleteById(id);
    }

    public void deleteLogica(Long id) {
        Paciente paciente = pacienteRepository.getReferenceById(id);
        paciente.setAtivo(false);
        pacienteRepository.save(paciente);
    }

}
