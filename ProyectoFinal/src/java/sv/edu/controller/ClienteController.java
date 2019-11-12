/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.edu.model.ClienteModel;

/**
 *
 * @author neon
 */
@Controller
@RequestMapping("clientes")
public class ClienteController {

    ClienteModel clienteModel = new ClienteModel();

    @RequestMapping("list")
    public String listarCliente(Model model) {

        model.addAttribute("listarCliente", clienteModel.listarClientes());

        return "clientes/listar";
    }

}
