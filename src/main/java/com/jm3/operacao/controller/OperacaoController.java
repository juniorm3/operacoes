package com.jm3.operacao.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jm3.operacao.model.Operacao;
import com.jm3.operacao.model.TipoMercadoria;
import com.jm3.operacao.model.TipoNegocio;
import com.jm3.operacao.repository.Operacoes;
import com.jm3.operacao.service.CadastroOperacaoService;

@Controller
@RequestMapping("/operacao")
public class OperacaoController {

	private static final String CADASTRO_VIEW = "CadastroOperacao";

	@Autowired
	private Operacoes operacoes;

	@Autowired
	private CadastroOperacaoService cadastroOperacaoService;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Operacao());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Operacao operacao, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}

		try {
			cadastroOperacaoService.salvar(operacao);
			attributes.addFlashAttribute("mensagem", "Operacao salva com sucesso!");
			return "redirect:/operacao";
		} catch (IllegalArgumentException e) {
			errors.rejectValue("dataNegociacao", null, e.getMessage());
			return CADASTRO_VIEW;
		}
	}

	@RequestMapping
	public ModelAndView pesquisar() {
		List<Operacao> todasAsOperacoes = operacoes.findAll();
		ModelAndView mv = new ModelAndView("PesquisaOperacoes");
		mv.addObject("operacoes", todasAsOperacoes);
		return mv;
	}

	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Operacao operacao) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(operacao);
		return mv;
	}

	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		cadastroOperacaoService.exluir(codigo);

		attributes.addFlashAttribute("mensagem", "Operação excluida com sucesso!");
		return "redirect:/operacao";
	}

	@ModelAttribute("todosTiposMercadorias")
	public List<TipoMercadoria> todosTiposMercadoria() {
		return Arrays.asList(TipoMercadoria.values());
	}

	@ModelAttribute("todosTiposNegociacao")
	public List<TipoNegocio> todosTiposNegocio() {
		return Arrays.asList(TipoNegocio.values());
	}

}
