package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Ator;
import model.Filme;

public class AtorDao implements IAtorDao {
	
	EntityManagerFactory mf = Persistence.createEntityManagerFactory ("root");

	@Override
	public Ator pesquisar(String ator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Ator ator) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.persist(ator);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public void remover(long id) {
		// TODO Auto-generated method stub
		EntityManager em = mf.createEntityManager();
		Ator ator = em.find(Ator.class, id);
		if (ator != null) { em.remove(ator); }
		em.getTransaction().commit();
		em.close();	
	}

	
	//Usar para outros casos.
	@Override
	public List<Ator> lista() {
		EntityManager em = mf.createEntityManager();
		List<Ator> ator = em.createQuery("SELECT a FROM Ator a", Ator.class).getResultList();
		em.close();
		return ator;
	}

	@Override
	public List<Ator> apenasUmAtor(String nome) {
		EntityManager em = mf.createEntityManager();
		List<Ator> at = em.createQuery("SELECT a FROM Ator a WHERE a.nome LIKE :nome ", Ator.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
		em.close();
		return at;
	}

	public void atualizar(Ator ator) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.merge(ator);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
