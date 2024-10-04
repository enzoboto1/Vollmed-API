package med.voll.api.controller;

import med.voll.api.dto.DadosCadastroMedicoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @PostMapping("/cadastrar")
    public void cadastrarMedico(@RequestBody DadosCadastroMedicoDTO dados) {
        System.out.println(dados);
    }

}
