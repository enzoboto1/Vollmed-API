package med.voll.api.controller;

import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.dto.DadosCadastroPacienteDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @PostMapping("/cadastrar")
    public void cadastrarPaciente(@RequestBody DadosCadastroPacienteDTO dados) {
        System.out.println("dados recebido: " + dados);
    }

}
