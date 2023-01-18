package com.example.demo.correccion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.correccion.modelo.CuentaC;
import com.example.demo.correccion.repository.ICuentaCRepository;

@Service
public class CuentaCServiceImpl implements ICuentaCService {

	@Autowired
	private ICuentaCRepository cuentaRepo;

	@Override
	public void crear(CuentaC cuenta) {
		// TODO Auto-generated method stub
		this.cuentaRepo.insertar(cuenta);
	}

	@Override
	public void modificar(CuentaC cuenta) {
		// TODO Auto-generated method stub
		this.cuentaRepo.actualizar(cuenta);
	}

	@Override
	public CuentaC buscar(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaRepo.buscar(numero);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.cuentaRepo.eliminar(numero);
	}

	

	

}
