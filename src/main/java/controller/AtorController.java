package controller;

import java.util.List;

import dao.AtorDao;
import model.Ator;

public class AtorController {

	private AtorDao atordao = new AtorDao();
	
	public void inserir(Ator ator) {
		atordao.inserir(ator);
	}
	public void apagar(long id) {
		atordao.remover(id);
	}
	public void atualizar(Ator ator) { 
		atordao.atualizar(ator);
	}
	public List<Ator> listarUm(String ator) {
		return atordao.apenasUmAtor(ator);
	}
	public List<Ator> listarTodos() {
		return atordao.lista();
	}
	
}
