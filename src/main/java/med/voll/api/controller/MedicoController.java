package med.voll.api.controller;

import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.service.MedicoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping("/cadastrar")
    public void cadastrarMedico(@RequestBody DadosCadastroMedicoDTO medicoDTO) {
        medicoService.save(medicoDTO);
    }

}
