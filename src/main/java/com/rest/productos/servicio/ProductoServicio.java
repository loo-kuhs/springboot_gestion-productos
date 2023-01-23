package com.rest.productos.servicio;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.rest.productos.entidades.Producto;
import com.rest.productos.repositorio.ProductoRepositorio;


@Service
public class ProductoServicio {
	
	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	public List<Producto> listAll() {
		return productoRepositorio.findAll();
	}
	
	public void save(Producto producto) {
		productoRepositorio.save(producto);
	}
	
	public Producto get(Long id) {
		return productoRepositorio.findById(id).get();
	}
	
	public void delete(Long id) {
		productoRepositorio.deleteById(id);
	}
}
