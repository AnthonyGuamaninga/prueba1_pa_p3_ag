package com.example.demo.correccion.repository;

import com.example.demo.correccion.modelo.CuentaC;

public interface ICuentaCRepository {

	public void insertar(CuentaC cuenta);
	public void actualizar(CuentaC cuenta);
	public CuentaC buscar(String numero);
	public void eliminar(String numero);
	
}
