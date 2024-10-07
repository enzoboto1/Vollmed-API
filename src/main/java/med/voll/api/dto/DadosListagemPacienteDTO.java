package med.voll.api.dto;

import med.voll.api.model.Paciente;

public record DadosListagemPacienteDTO(String nome, String email, String cpf) {
    public DadosListagemPacienteDTO(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}