package com.example.demo.banco.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TransferenciaRepoImpl implements ITransferenciaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(transferencia); 
	}

	@Override
	public Transferencia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Transferencia.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}

}
