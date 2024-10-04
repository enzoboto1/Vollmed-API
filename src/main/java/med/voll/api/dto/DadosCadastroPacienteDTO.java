package med.voll.api.dto;

public record DadosCadastroPacienteDTO(String nome, String email, String telefone, String cpf,
                                       DadosEnderecoDTO endereco) {
}
