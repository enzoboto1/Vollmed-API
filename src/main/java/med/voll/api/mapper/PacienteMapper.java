package med.voll.api.mapper;

import med.voll.api.dto.DadosCadastroPacienteDTO;
import med.voll.api.dto.DadosEnderecoDTO;
import med.voll.api.dto.DadosListagemPacienteDTO;
import med.voll.api.model.Endereco;
import med.voll.api.model.Paciente;

import java.util.List;
import java.util.stream.Collectors;

public class PacienteMapper {

    public static Paciente toPaciente(DadosCadastroPacienteDTO dto) {
        if (dto == null) {
            return null;
        }

        Paciente paciente = new Paciente();
        paciente.setNome(dto.nome());
        paciente.setEmail(dto.email());
        paciente.setCpf(dto.cpf());
        paciente.setTelefone(dto.telefone());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.endereco().logradouro());
        endereco.setBairro(dto.endereco().bairro());
        endereco.setCep(dto.endereco().cep());
        endereco.setNumero(dto.endereco().numero());
        endereco.setComplemento(dto.endereco().complemento());
        endereco.setCidade(dto.endereco().cidade());
        endereco.setUf(dto.endereco().uf());
        paciente.setEndereco(endereco);

        return paciente;
    }

    public static DadosCadastroPacienteDTO toDTO(Paciente paciente) {
        if (paciente == null) {
            return null;
        }

        DadosEnderecoDTO enderecoDTO = null;
        if (paciente.getEndereco() != null) {
            enderecoDTO = new DadosEnderecoDTO(
                    paciente.getEndereco().getLogradouro(),
                    paciente.getEndereco().getBairro(),
                    paciente.getEndereco().getCep(),
                    paciente.getEndereco().getNumero(),
                    paciente.getEndereco().getComplemento(),
                    paciente.getEndereco().getCidade(),
                    paciente.getEndereco().getUf()
            );
        }

        return new DadosCadastroPacienteDTO(
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getCpf(),
                enderecoDTO
        );
    }

    public static DadosListagemPacienteDTO toDadosListagemPacienteDTO(Paciente paciente) {
        if (paciente == null) {
            return null;
        }
        return new DadosListagemPacienteDTO(paciente);
    }

    public static List<DadosListagemPacienteDTO> toDadosListagemPacienteDTOList(List<Paciente> pacientes) {
        return pacientes.stream()
                .map(PacienteMapper::toDadosListagemPacienteDTO)
                .collect(Collectors.toList());
    }

}
