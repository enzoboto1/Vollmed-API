package med.voll.api.dto;

import med.voll.api.model.EspecialidadeMedico;
import med.voll.api.model.Medico;

public record DadosListagemMedicoDTO(Long id, String nome, String email, String crm,
                                     EspecialidadeMedico especialidade) {

    public DadosListagemMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}