package com.rest.productos.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.rest.productos.entidades.Producto;
import com.rest.productos.servicio.ProductoServicio;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


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
	public String mostrarFormularioDeRegistrarProducto(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "nuevo_producto";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardarProducto(@ModelAttribute("producto") Producto producto) {
		productoServicio.save(producto);
		return "redirect:/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView mostrarFormularioDeEditarProducto(@PathVariable(name = "id") Long id) {
		ModelAndView modelo = new ModelAndView("editar_producto");
		Producto producto = productoServicio.get(id);
		modelo.addObject("producto", producto);
		return modelo;
	}
}