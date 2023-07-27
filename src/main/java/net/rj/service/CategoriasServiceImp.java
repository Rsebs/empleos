package net.rj.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.rj.model.Categoria;

@Service
public class CategoriasServiceImp implements ICategoriasService {

	private List<Categoria> lista = null;
	
	public CategoriasServiceImp() {
		lista = new LinkedList<>();
		
		// Creamos algunas Categorias para poblar las lista...
		
		// Categoria 1
		Categoria categoria1 = new Categoria();
		categoria1.setId(1);
		categoria1.setNombre("Contabilidad");
		categoria1.setDescripcion("Descripcion de la categoria Contabilidad");
		
		// Categoria 2
		Categoria categoria2 = new Categoria();
		categoria2.setId(2);
		categoria2.setNombre("Ventas");
		categoria2.setDescripcion("Trabajos relacionados con Ventas");
		
		// Categoria 3
		Categoria categoria3 = new Categoria();
		categoria3.setId(3);
		categoria3.setNombre("Comunicaciones");
		categoria3.setDescripcion("Trabajos relacionados con Comunicaciones");
		
		// Categoria 4
		Categoria categoria4 = new Categoria();
		categoria4.setId(4);
		categoria4.setNombre("Arquitectura");
		categoria4.setDescripcion("Trabajos de Arquitectura");
		
		// Categoria 5
		Categoria categoria5 = new Categoria();
		categoria5.setId(5);
		categoria5.setNombre("Educacion");
		categoria5.setDescripcion("Maestros, tutores, etc");
		
		// Categoria 6
		Categoria categoria6 = new Categoria();
		categoria6.setId(6);
		categoria6.setNombre("Desarrollo de Software");
		categoria6.setDescripcion("Trabajo para programadores");
		
		/*
		 * Agregamos los 5 objetos de tipo Categoria a la lista...
		 */
		
		lista.add(categoria1);
		lista.add(categoria2);
		lista.add(categoria3);
		lista.add(categoria4);
		lista.add(categoria5);
		lista.add(categoria6);
	}
	
	public void guardar(Categoria categoria) {
		lista.add(categoria);
	}

	public List<Categoria> buscarTodas() {
		return lista;
	}

	public Categoria buscarPorId(Integer idCategoria) {
		
		for (Categoria c : lista) {
			if (c.getId() == idCategoria) {
				return c;
			}
		}
		
		return null;
	}

}
