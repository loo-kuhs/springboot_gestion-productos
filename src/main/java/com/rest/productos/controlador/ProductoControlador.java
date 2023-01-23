package com.rest.productos.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.rest.productos.entidades.Producto;
import com.rest.productos.servicio.ProductoServicio;


@Controller
public class ProductoControlador {
	
	@Autowired
	private ProductoServicio productoServicio;
	
	@RequestMapping("/")
	public String verPaginaDeInicio(Model model) {
		List<Producto> listaProductos = productoServicio.listAll();
		model.addAttribute("listaProductos", listaProductos);
		return "index";
	}
	
	@RequestMapping("/nuevo")
	public String verPaginaDeNuevoProducto(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "nuevo_producto";
	}
}
