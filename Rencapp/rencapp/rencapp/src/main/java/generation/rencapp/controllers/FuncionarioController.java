package generation.rencapp.controllers;

import generation.rencapp.models.Funcionario;
import generation.rencapp.models.Usuario;
import generation.rencapp.services.FuncionarioServiceImpl;
import generation.rencapp.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//CONTROLADORES VAN A CONTROLAR LAS VISTAS

@Controller

    @RequestMapping("api/funcionario")
    public class FuncionarioController {

    @Autowired
    private FuncionarioServiceImpl funcionarioServiceImpl;

    @Autowired
    private UsuarioService usuarioService;

    //Método GET para mostrar una vista llamada indexdoctores al ingresar a la ruta "localhost:8080/doctor/index"
    @GetMapping("/lista")
    public String indexFuncionario(Model model) {
        List<Funcionario> funcionarios = funcionarioServiceImpl.findAll();
        model.addAttribute("funcionario", funcionarios);
        return "lista-funcionarios.html";
    }


    @GetMapping("/crear")
    public String mostrarFormulario(Model model, @RequestParam Long usuarioId){  // el @RequestParam sirve para traer un valor dinámico desde la ruta anterior
        // creamos una variable usuario y la inicializamos con el usuario según su id
        Usuario usuario = usuarioService.findById(usuarioId);
        // creamos una instancia de doctor vacía
        Funcionario funcionario = new Funcionario();

        // a nuestra instancia de Funcionario le seteamos el usuario

        funcionario.setUsuario(usuario);

        // a la vista (model) le pasamos la instancia de tipo doctor llamado "doctor"

        model.addAttribute("funcionario", funcionario);

        // retornamos el nombre de la vista, el archivo html
        return "registro-funcionario";
    }

    @PostMapping("/crear")
    public String guardarFuncionarioCreado(@ModelAttribute Funcionario funcionario){  // al recibir atributos se usa el @ModelAttribute
        funcionarioServiceImpl.saveFuncionario(funcionario);
        return "redirect:/funcionario/lista";
    }

}
