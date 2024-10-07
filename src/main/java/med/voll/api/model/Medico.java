package med.voll.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private EspecialidadeMedico especialidade;

    @Embedded
    private Endereco endereco;

}
