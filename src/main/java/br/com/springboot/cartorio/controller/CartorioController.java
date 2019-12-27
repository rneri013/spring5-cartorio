package br.com.springboot.cartorio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.springboot.cartorio.model.Cartorio;
import br.com.springboot.cartorio.service.CartorioService;

@Controller
public class CartorioController {

    private CartorioService cartorioService;

    @Autowired
    public CartorioController(CartorioService cartorioService) {
        this.cartorioService = cartorioService;
    }

    @GetMapping
    public String listaCartorios(Model model) {
        model.addAttribute("cartorios", cartorioService.findAll());
        return "cartorios";
    }
    
    
    @RequestMapping(value = "/cartoriosApi", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Cartorio> cartoriosAPI(){
    	return cartorioService.findAll();
    }

    @GetMapping("/novo-cartorio")
    public String criarFormCartorio(Model model) {
        model.addAttribute("cartorio", new Cartorio());
        return "novo-cartorio";
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String novoCartorio(@Valid @ModelAttribute Cartorio cartorio, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "novo-cartorio";
        }
        cartorioService.save(cartorio);
        model.addAttribute("cartorios", cartorioService.findAll());
        return "cartorios";
    }

    @GetMapping("/edit/{id}")
    public String listaEditCartorioId(@PathVariable Long id, Model model) {
        Cartorio cartorio = cartorioService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de Cartório inválido:" + id));
        model.addAttribute("cartorio", cartorio);
        return "editar-cartorio";
    }
    
    @GetMapping("/{id}")
    public String listaCartorioId(@PathVariable Long id, Model model) {
        Cartorio cartorio = cartorioService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de Cartório inválido:" + id));
        model.addAttribute("cartorio", cartorio);
        return "visualizar";
    }

    @PostMapping("/edit/{id}/update")
    public String atualizaCartorio(@PathVariable Long id, @Valid @ModelAttribute Cartorio cartorio, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editar-cartorio";
        }
        cartorioService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de Cartório inválido:" + id));
        cartorioService.save(cartorio);
        model.addAttribute("cartorios", cartorioService.findAll());
        return "cartorios";
    }

    @PostMapping("/{id}/delete")
    public String deleteCartorio(@PathVariable Long id, Model model) {
        cartorioService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de Cartório inválido:" + id));
        cartorioService.deleteById(id);
        model.addAttribute("cartorios", cartorioService.findAll());
        return "cartorios";
    }
}
