/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:57 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller;

import org.demo.controller.assembler.TintucResourceAssembler;
import org.demo.controller.resource.TintucResource;
import com.tlu.qlsuckhoe.entity.Tintuc;
import com.tlu.qlsuckhoe.service.TintucServiceImpl;
import com.tlu.qlsuckhoe.service.criteria.TintucCriteria;
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
@RequestMapping(value = "/tintuc", produces = "application/hal+json")
public class TintucController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TintucController.class);

	private static final String NOT_FOUND ="Tintuc not found";

	@Autowired
	private TintucServiceImpl tintucService;

	@Autowired
	private PagedResourcesAssembler<Tintuc> pageAssember;

	private TintucResourceAssembler tintucResourceAssembler = new TintucResourceAssembler();

	@GetMapping
	public ResponseEntity<PagedResources<TintucResource>> search(Pageable pageable, TintucCriteria criteria) {
		LOGGER.info("Tintucs search [pageable={}|TintucCriteria={}", pageable, criteria);
		final Page<Tintuc> result = tintucService.search(pageable, criteria);
		LOGGER.info("Found {} tintucs !", result.getSize());
		return new ResponseEntity<>(pageAssember.toResource(result, tintucResourceAssembler), HttpStatus.OK);
	}

	@GetMapping("{idtintuc}")
	public ResponseEntity<TintucResource> get(@PathVariable("idtintuc") Integer idtintuc) {
		LOGGER.info("Tintuc get with id {}", resolveIdForLogger(idtintuc));
		final Tintuc tintuc = tintucService.get(idtintuc);
		if (tintuc == null) {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>((TintucResource) null, HttpStatus.NOT_FOUND);
		}
		LOGGER.info("Tintuc found : {}", tintuc);
		final TintucResource tintucResource = tintucResourceAssembler.toResource(tintuc);
		return new ResponseEntity<>(tintucResource, HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<TintucResource> create(@RequestBody Tintuc tintuc) {
		LOGGER.info("Tintuc creation request : {}", tintuc);
		if (tintucService.exist(tintuc)) {
			LOGGER.info("Tintuc already exist ! : {}", tintuc);
			return new ResponseEntity<>((TintucResource) null, HttpStatus.CONFLICT);
		} else {
			final Tintuc created = tintucService.create(tintuc);
			LOGGER.info("Created tintuc {}", created);
			return new ResponseEntity<>(tintucResourceAssembler.toResource(created), HttpStatus.OK);
		}
	}

	@PutMapping(value = "{idtintuc}", consumes = "application/json")
	public ResponseEntity<Void> update(@PathVariable("idtintuc") Integer idtintuc, @RequestBody Tintuc tintuc) {
		LOGGER.info("Tintuc update request [id={} | tintuc={}}", resolveIdForLogger(idtintuc), tintuc);
		// force the id (use the id provided by the URL)
		tintuc.setIdtintuc(idtintuc);
		if (tintucService.save(tintuc)) {
			LOGGER.info("Tintuc succesfully updated");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{idtintuc}")
	public ResponseEntity<Void> delete(@PathVariable("idtintuc") Integer idtintuc) {
		LOGGER.info("Tintuc deletion request : {}", resolveIdForLogger(idtintuc));
		if (tintucService.delete(idtintuc)) {
			LOGGER.info("Tintuc succesfully deleted");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer idtintuc) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(idtintuc));
		return ids.toString();
	}

}
