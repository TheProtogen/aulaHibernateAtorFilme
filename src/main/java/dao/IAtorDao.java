package dao;

import java.util.List;

import model.Ator;

public interface IAtorDao {
	public Ator pesquisar(String ator) ;
	public void inserir(Ator ator) ;
	public void remover (long id) ;
	public List<Ator> lista(); 
	public List<Ator> apenasUmAtor (String ator);

}
