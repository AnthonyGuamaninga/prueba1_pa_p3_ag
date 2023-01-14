package com.example.demo.banco.service;

import com.example.demo.banco.modelo.Cuenta;

public interface ICuentaService {
	
	public void crear(Cuenta cuenta);
	public void modificar(Cuenta cuenta);
	public Cuenta buscar(String numero);
	public void eliminar(String numero);

}
