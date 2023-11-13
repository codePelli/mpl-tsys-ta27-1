package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proveedor;
import com.example.demo.service.*;

import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorService IProveedorService;
	
    @PostMapping("/add")
    public Proveedor insertProveedor(@RequestBody Proveedor proveedor) {
    	
    	return IProveedorService.saveProveedor(proveedor);
    }
    
    @GetMapping("/list")
    public List <Proveedor> listPiezas() {
    	
    	return IProveedorService.listProv();
    }
    
    @GetMapping("/{id}")
    public Proveedor proveedorPorId(@PathVariable(name = "id") String id) {
    	
    	Proveedor provPorId = IProveedorService.proveedorPorCod(id);
    	System.out.println("Proveedor por ID" + provPorId);
    	
    	return provPorId;
    }
    
    @PutMapping("{id}")
	public Proveedor updateProveedor(@PathVariable(name = "id") String id, @RequestBody Proveedor proveedor) {
    	
    	Proveedor provSeleccionado = IProveedorService.proveedorPorCod(id);
    	
    	if(provSeleccionado != null) {
    		
    		provSeleccionado.setNombre(proveedor.getNombre());
    		Proveedor provUpd = IProveedorService.updateProveedor(provSeleccionado);
    		
    		return provUpd;
    		
    	} else {
    		
    		System.out.println("ERROR updating Proveedor");

    		return null;
    	}
    }
    
    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable(name = "id")String id) {
    	
    	IProveedorService.deleteProveedor(id);
    }
}
