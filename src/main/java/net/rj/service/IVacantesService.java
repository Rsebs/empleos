package net.rj.service;

import java.util.List;

import net.rj.model.Vacante;

public interface IVacantesService {
	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer id);
	void guardar(Vacante vacante);
}
