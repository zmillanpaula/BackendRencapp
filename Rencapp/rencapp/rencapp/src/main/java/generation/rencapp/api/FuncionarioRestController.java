package generation.rencapp.api;


import generation.rencapp.models.Funcionario;
import generation.rencapp.services.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/funcionarios")

public class FuncionarioRestController {

    @Autowired
    private FuncionarioServiceImpl funcionarioServiceImpl;

    @GetMapping("/funcionario")
    public Funcionario findDoctorById(@RequestParam Long id) {
        Funcionario funcionarioSeleccionado = funcionarioServiceImpl.findById(id);
        System.out.println(funcionarioSeleccionado.getDepartamento());
        return funcionarioSeleccionado;
    }
//faltaria conectar esa funcion con el enum cierto? hablo por aca porque mi hija esta llorando jajaja

}