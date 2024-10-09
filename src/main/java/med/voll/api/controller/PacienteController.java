package med.voll.api.controller;

import jakarta.transaction.Transactional;
import med.voll.api.dto.DadosCadastroPacienteDTO;
import med.voll.api.dto.DadosListagemPacienteDTO;
import med.voll.api.service.PacienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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
    public Page<DadosListagemPacienteDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return pacienteService.findAll(paginacao);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        pacienteService.delete(id);
    }

}
