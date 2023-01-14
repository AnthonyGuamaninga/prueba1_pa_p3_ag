package com.example.demo.banco.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.modelo.Cuenta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaRepoImpl implements ICuentaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuenta);
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuenta);
	}

	@Override
	public Cuenta buscar(String numero) {
		// TODO Auto-generated method stub
		Cuenta cuenta = this.entityManager.find(Cuenta.class, numero);
		System.out.println("Saldo de la cuenta: "+cuenta.getSaldo());
		return cuenta;
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.entityManager.refresh(this.buscar(numero));
	}

}
