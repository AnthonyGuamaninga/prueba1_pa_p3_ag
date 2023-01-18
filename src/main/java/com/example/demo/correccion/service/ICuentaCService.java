package com.example.demo.correccion.service;

import com.example.demo.correccion.modelo.CuentaC;

public interface ICuentaCService {

	public void crear(CuentaC cuenta);
	public void modificar(CuentaC cuenta);
	public CuentaC buscar(String numero);
	public void eliminar(String numero);
}
