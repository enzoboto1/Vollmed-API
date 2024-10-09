package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.DadosAtualizacaoMedicoDTO;
import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.dto.DadosListagemMedicoDTO;
import med.voll.api.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrarMedico(@RequestBody DadosCadastroMedicoDTO medicoDTO) {
        medicoService.save(medicoDTO);
    }

    @GetMapping
    public Page<DadosListagemMedicoDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return medicoService.findAll(paginacao);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicoDTO dados) {
        medicoService.update(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        medicoService.delete(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirLogico(@PathVariable Long id){
        medicoService.deleteLogica(id);
    }

}
