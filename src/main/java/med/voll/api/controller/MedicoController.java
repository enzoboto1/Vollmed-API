package med.voll.api.controller;

import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.dto.DadosListagemMedicoDTO;
import med.voll.api.service.MedicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<DadosListagemMedicoDTO> listar() {
        return medicoService.findAll();
    }

}
