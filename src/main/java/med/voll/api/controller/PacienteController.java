package med.voll.api.controller;

import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.dto.DadosCadastroPacienteDTO;
import med.voll.api.dto.DadosListagemMedicoDTO;
import med.voll.api.dto.DadosListagemPacienteDTO;
import med.voll.api.service.PacienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/cadastrar")
    public void cadastrarPaciente(@RequestBody DadosCadastroPacienteDTO dados) {
        pacienteService.save(dados);
    }

    @GetMapping
    public List<DadosListagemPacienteDTO> listar() {
        return pacienteService.findAll();
    }

}
