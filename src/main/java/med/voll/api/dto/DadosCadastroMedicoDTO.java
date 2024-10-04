package med.voll.api.dto;

import med.voll.api.model.EspecialidadeMedico;

public record DadosCadastroMedicoDTO(String nome, String email, String crm, EspecialidadeMedico especialidade,
                                     DadosEnderecoDTO endereco) {
}
