package com.example.demo.correccion.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.correccion.modelo.TransferenciaC;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TransferenciaCRepoImpl implements ITransferenciaCRepo{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(TransferenciaC transferenciaC) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferenciaC);
	}

}
