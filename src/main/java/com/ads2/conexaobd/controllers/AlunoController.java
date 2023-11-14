package com.ads2.conexaobd.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ads2.conexaobd.model.Aluno;
import com.ads2.conexaobd.repository.AlunoRepository;

@Controller
public class AlunoController {

    @Autowired
    AlunoRepository repository;

    @GetMapping("/aluno/cadastro")
    public String cadastroAluno() {
        return "cadastroAluno";
    }

    @PostMapping("/aluno")
    public String novoAluno(Aluno aluno) {
        repository.inserir(aluno);
        return "redirect:/aluno/lista";
    }

    @GetMapping("/aluno/lista")
    public ModelAndView lista() throws SQLException {
        ModelAndView mv = new ModelAndView("listaAlunos");
        List<Aluno> alunos = new ArrayList<>();
        alunos = repository.buscar();
        return mv.addObject("alunos", alunos);

    }

    @GetMapping("aluno/excluir/{id}")
    public String excluirAluno(@PathVariable("id") int id) throws SQLException{
        repository.excluir(id);
        return "redirect:/aluno/lista";


    }

}
