package med.voll.api.mapper;

import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.dto.DadosEnderecoDTO;
import med.voll.api.dto.DadosListagemMedicoDTO;
import med.voll.api.model.Endereco;
import med.voll.api.model.Medico;

public class MedicoMapper {

    public static Medico toMedico(DadosCadastroMedicoDTO dados) {
        if (dados == null) {
            return null;
        }

        Medico medico = new Medico();
        medico.setNome(dados.nome());
        medico.setEmail(dados.email());
        medico.setCrm(dados.crm());
        medico.setEspecialidade(dados.especialidade());

        if (dados.endereco() != null) {
            Endereco endereco = new Endereco();
            endereco.setLogradouro(dados.endereco().logradouro());
            endereco.setBairro(dados.endereco().bairro());
            endereco.setCep(dados.endereco().cep());
            endereco.setCidade(dados.endereco().cidade());
            endereco.setUf(dados.endereco().uf());
            endereco.setNumero(dados.endereco().numero());
            endereco.setComplemento(dados.endereco().complemento());
            medico.setEndereco(endereco);
        }

        return medico;
    }

    public static DadosCadastroMedicoDTO toDadosCadastroMedicoDTO(Medico medico) {
        if (medico == null) {
            return null;
        }

        return new DadosCadastroMedicoDTO(
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade(),
                new DadosEnderecoDTO(
                        medico.getEndereco().getLogradouro(),
                        medico.getEndereco().getBairro(),
                        medico.getEndereco().getCep(),
                        medico.getEndereco().getCidade(),
                        medico.getEndereco().getUf(),
                        medico.getEndereco().getNumero(),
                        medico.getEndereco().getComplemento()
                )
        );
    }

    public static DadosListagemMedicoDTO toDadosListagemMedicoDTO(Medico medico) {
        if (medico == null) {
            return null;
        }

        return new DadosListagemMedicoDTO(
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade()
        );
    }
}
