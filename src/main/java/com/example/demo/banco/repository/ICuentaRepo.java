package com.example.demo.banco.repository;

import com.example.demo.banco.modelo.Cuenta;

public interface ICuentaRepo {
	
	public void insertar(Cuenta cuenta);
	public void actualizar(Cuenta cuenta);
	public Cuenta buscar(String numero);
	public void eliminar(String numero);

}
