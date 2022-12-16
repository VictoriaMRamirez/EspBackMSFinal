package com.dh.catalog.controller;

import com.dh.catalog.model.dto.CatalogDTO;
import com.dh.catalog.service.ICatalogService;
import net.datafaker.Cat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/catalogs")
public class CatalogController {

	private ICatalogService catalogService;

	public CatalogController(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping
	ResponseEntity<CatalogDTO> getAll() {
		return ResponseEntity.ok(catalogService.getAll());
	}

	@GetMapping("online/{genre}")
	ResponseEntity<CatalogDTO> getCatalogOnline(@PathVariable String genre) throws Exception {
		return ResponseEntity.ok(catalogService.getCatalogOnline(genre));
	}

	@GetMapping("offline/{genre}")
	ResponseEntity<CatalogDTO> getCatalogOffline(@PathVariable String genre) {
		return ResponseEntity.ok(catalogService.getCatalogOffline(genre));
	}
}
