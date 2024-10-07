package med.voll.api.mapper;

import med.voll.api.dto.DadosEnderecoDTO;
import med.voll.api.model.Endereco;

public class EnderecoMapper {


    public static Endereco toEndereco(DadosEnderecoDTO dadosEnderecoDTO) {
        if (dadosEnderecoDTO == null) {
            return null;
        }

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dadosEnderecoDTO.logradouro());
        endereco.setBairro(dadosEnderecoDTO.bairro());
        endereco.setCep(dadosEnderecoDTO.cep());
        endereco.setNumero(dadosEnderecoDTO.numero());
        endereco.setComplemento(dadosEnderecoDTO.complemento());
        endereco.setCidade(dadosEnderecoDTO.cidade());
        endereco.setUf(dadosEnderecoDTO.uf());

        return endereco;
    }

    public static DadosEnderecoDTO toDadosEnderecoDTO(Endereco endereco) {
        if (endereco == null) {
            return null;
        }

        return new DadosEnderecoDTO(
                endereco.getLogradouro(),
                endereco.getBairro(),
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getUf(),
                endereco.getNumero(),
                endereco.getComplemento()
        );
    }

}
