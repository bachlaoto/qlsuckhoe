/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:54 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller;

import org.demo.controller.assembler.DanhmucResourceAssembler;
import org.demo.controller.resource.DanhmucResource;
import com.tlu.qlsuckhoe.entity.Danhmuc;
import com.tlu.qlsuckhoe.service.DanhmucServiceImpl;
import com.tlu.qlsuckhoe.service.criteria.DanhmucCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller which produce Hal+json content (including hateoas metadata).
 * @author Telosys (http://www.telosys.org/) version 3.0.0
 */
@RestController
@RequestMapping(value = "/danhmuc", produces = "application/hal+json")
public class DanhmucController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DanhmucController.class);

	private static final String NOT_FOUND ="Danhmuc not found";

	@Autowired
	private DanhmucServiceImpl danhmucService;

	@Autowired
	private PagedResourcesAssembler<Danhmuc> pageAssember;

	private DanhmucResourceAssembler danhmucResourceAssembler = new DanhmucResourceAssembler();

	@GetMapping
	public ResponseEntity<PagedResources<DanhmucResource>> search(Pageable pageable, DanhmucCriteria criteria) {
		LOGGER.info("Danhmucs search [pageable={}|DanhmucCriteria={}", pageable, criteria);
		final Page<Danhmuc> result = danhmucService.search(pageable, criteria);
		LOGGER.info("Found {} danhmucs !", result.getSize());
		return new ResponseEntity<>(pageAssember.toResource(result, danhmucResourceAssembler), HttpStatus.OK);
	}

	@GetMapping("{iddanhmuc}")
	public ResponseEntity<DanhmucResource> get(@PathVariable("iddanhmuc") Integer iddanhmuc) {
		LOGGER.info("Danhmuc get with id {}", resolveIdForLogger(iddanhmuc));
		final Danhmuc danhmuc = danhmucService.get(iddanhmuc);
		if (danhmuc == null) {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>((DanhmucResource) null, HttpStatus.NOT_FOUND);
		}
		LOGGER.info("Danhmuc found : {}", danhmuc);
		final DanhmucResource danhmucResource = danhmucResourceAssembler.toResource(danhmuc);
		return new ResponseEntity<>(danhmucResource, HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<DanhmucResource> create(@RequestBody Danhmuc danhmuc) {
		LOGGER.info("Danhmuc creation request : {}", danhmuc);
		if (danhmucService.exist(danhmuc)) {
			LOGGER.info("Danhmuc already exist ! : {}", danhmuc);
			return new ResponseEntity<>((DanhmucResource) null, HttpStatus.CONFLICT);
		} else {
			final Danhmuc created = danhmucService.create(danhmuc);
			LOGGER.info("Created danhmuc {}", created);
			return new ResponseEntity<>(danhmucResourceAssembler.toResource(created), HttpStatus.OK);
		}
	}

	@PutMapping(value = "{iddanhmuc}", consumes = "application/json")
	public ResponseEntity<Void> update(@PathVariable("iddanhmuc") Integer iddanhmuc, @RequestBody Danhmuc danhmuc) {
		LOGGER.info("Danhmuc update request [id={} | danhmuc={}}", resolveIdForLogger(iddanhmuc), danhmuc);
		// force the id (use the id provided by the URL)
		danhmuc.setIddanhmuc(iddanhmuc);
		if (danhmucService.save(danhmuc)) {
			LOGGER.info("Danhmuc succesfully updated");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{iddanhmuc}")
	public ResponseEntity<Void> delete(@PathVariable("iddanhmuc") Integer iddanhmuc) {
		LOGGER.info("Danhmuc deletion request : {}", resolveIdForLogger(iddanhmuc));
		if (danhmucService.delete(iddanhmuc)) {
			LOGGER.info("Danhmuc succesfully deleted");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer iddanhmuc) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(iddanhmuc));
		return ids.toString();
	}

}
