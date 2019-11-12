/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.edu.model.MecanicoModel;

/**
 *
 * @author neon
 */
@Controller
@RequestMapping("mecanico")
public class MecanicoController {
    
    MecanicoModel mecModel = new MecanicoModel();
    
    @RequestMapping("list")
    public String listarCliente(Model model) {

        model.addAttribute("listarMecanico", mecModel.listarMecanicos());

        return "mecanico/listar";
    }
    
}
