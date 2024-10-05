package med.voll.api.dto;

import med.voll.api.model.EspecialidadeMedico;

public record DadosListagemMedicoDTO(String nome, String email, String crm, EspecialidadeMedico especialidade) {
}