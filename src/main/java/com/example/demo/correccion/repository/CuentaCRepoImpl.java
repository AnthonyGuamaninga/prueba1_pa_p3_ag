package com.example.demo.correccion.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.modelo.Cuenta;
import com.example.demo.correccion.modelo.CuentaC;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaCRepoImpl implements ICuentaCRepository {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(CuentaC cuenta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuenta);
	}

	@Override
	public void actualizar(CuentaC cuenta) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuenta);
	}

	@Override
	public CuentaC buscar(String numero) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CuentaC.class, numero);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(numero));
	}

	
	
	

}
