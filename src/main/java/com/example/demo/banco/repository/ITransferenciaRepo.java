package com.example.demo.banco.repository;

import com.example.demo.banco.modelo.Transferencia;

public interface ITransferenciaRepo {
	
	public void insertar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public Transferencia buscar(Integer id);
	public void eliminar( Integer id);

}
