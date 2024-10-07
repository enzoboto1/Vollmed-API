package med.voll.api.service;

import med.voll.api.dto.DadosAtualizacaoMedicoDTO;
import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.dto.DadosEnderecoDTO;
import med.voll.api.dto.DadosListagemMedicoDTO;
import med.voll.api.mapper.EnderecoMapper;
import med.voll.api.mapper.MedicoMapper;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<DadosListagemMedicoDTO> findAll(Pageable paginacao) {
        return medicoRepository.findAll(paginacao)
                .map(MedicoMapper::toDadosListagemMedicoDTO);
    }

    public void update(DadosAtualizacaoMedicoDTO dados) {
        Medico medico = medicoRepository.getReferenceById(dados.id());
        verificaDadosMedicoDTO(dados, medico);
        verificaDadosEnderecoDTO(dados, medico);
        medicoRepository.save(medico);
    }

    private void verificaDadosMedicoDTO(DadosAtualizacaoMedicoDTO dados, Medico medico) {
        if (dados.nome() != null) {
            medico.setNome(dados.nome());
        }
        if (dados.telefone() != null) {
            medico.setTelefone(dados.telefone());
        }
        if (dados.endereco() != null) {
            medico.setEndereco(EnderecoMapper.toEndereco(dados.endereco()));
        }
    }

    private void verificaDadosEnderecoDTO(DadosAtualizacaoMedicoDTO dados, Medico medico) {
        if (dados.endereco() != null) {
            DadosEnderecoDTO endereco = dados.endereco();

            if (endereco.logradouro() != null) {
                medico.getEndereco().setLogradouro(endereco.logradouro());
            }
            if (endereco.bairro() != null) {
                medico.getEndereco().setBairro(endereco.bairro());
            }
            if (endereco.cep() != null) {
                medico.getEndereco().setCep(endereco.cep());
            }
            if (endereco.uf() != null) {
                medico.getEndereco().setUf(endereco.uf());
            }
            if (endereco.cidade() != null) {
                medico.getEndereco().setCidade(endereco.cidade());
            }
            if (endereco.numero() != null) {
                medico.getEndereco().setNumero(endereco.numero());
            }
            if (endereco.complemento() != null) {
                medico.getEndereco().setComplemento(endereco.complemento());
            }
        }
    }

}
