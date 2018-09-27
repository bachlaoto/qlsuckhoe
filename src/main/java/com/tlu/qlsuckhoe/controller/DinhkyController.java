/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:55 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller;

import org.demo.controller.assembler.DinhkyResourceAssembler;
import org.demo.controller.resource.DinhkyResource;
import com.tlu.qlsuckhoe.entity.Dinhky;
import com.tlu.qlsuckhoe.service.DinhkyServiceImpl;
import com.tlu.qlsuckhoe.service.criteria.DinhkyCriteria;
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
@RequestMapping(value = "/dinhky", produces = "application/hal+json")
public class DinhkyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DinhkyController.class);

	private static final String NOT_FOUND ="Dinhky not found";

	@Autowired
	private DinhkyServiceImpl dinhkyService;

	@Autowired
	private PagedResourcesAssembler<Dinhky> pageAssember;

	private DinhkyResourceAssembler dinhkyResourceAssembler = new DinhkyResourceAssembler();

	@GetMapping
	public ResponseEntity<PagedResources<DinhkyResource>> search(Pageable pageable, DinhkyCriteria criteria) {
		LOGGER.info("Dinhkys search [pageable={}|DinhkyCriteria={}", pageable, criteria);
		final Page<Dinhky> result = dinhkyService.search(pageable, criteria);
		LOGGER.info("Found {} dinhkys !", result.getSize());
		return new ResponseEntity<>(pageAssember.toResource(result, dinhkyResourceAssembler), HttpStatus.OK);
	}

	@GetMapping("{idkhamdinhky}")
	public ResponseEntity<DinhkyResource> get(@PathVariable("idkhamdinhky") Integer idkhamdinhky) {
		LOGGER.info("Dinhky get with id {}", resolveIdForLogger(idkhamdinhky));
		final Dinhky dinhky = dinhkyService.get(idkhamdinhky);
		if (dinhky == null) {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>((DinhkyResource) null, HttpStatus.NOT_FOUND);
		}
		LOGGER.info("Dinhky found : {}", dinhky);
		final DinhkyResource dinhkyResource = dinhkyResourceAssembler.toResource(dinhky);
		return new ResponseEntity<>(dinhkyResource, HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<DinhkyResource> create(@RequestBody Dinhky dinhky) {
		LOGGER.info("Dinhky creation request : {}", dinhky);
		if (dinhkyService.exist(dinhky)) {
			LOGGER.info("Dinhky already exist ! : {}", dinhky);
			return new ResponseEntity<>((DinhkyResource) null, HttpStatus.CONFLICT);
		} else {
			final Dinhky created = dinhkyService.create(dinhky);
			LOGGER.info("Created dinhky {}", created);
			return new ResponseEntity<>(dinhkyResourceAssembler.toResource(created), HttpStatus.OK);
		}
	}

	@PutMapping(value = "{idkhamdinhky}", consumes = "application/json")
	public ResponseEntity<Void> update(@PathVariable("idkhamdinhky") Integer idkhamdinhky, @RequestBody Dinhky dinhky) {
		LOGGER.info("Dinhky update request [id={} | dinhky={}}", resolveIdForLogger(idkhamdinhky), dinhky);
		// force the id (use the id provided by the URL)
		dinhky.setIdkhamdinhky(idkhamdinhky);
		if (dinhkyService.save(dinhky)) {
			LOGGER.info("Dinhky succesfully updated");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{idkhamdinhky}")
	public ResponseEntity<Void> delete(@PathVariable("idkhamdinhky") Integer idkhamdinhky) {
		LOGGER.info("Dinhky deletion request : {}", resolveIdForLogger(idkhamdinhky));
		if (dinhkyService.delete(idkhamdinhky)) {
			LOGGER.info("Dinhky succesfully deleted");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer idkhamdinhky) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(idkhamdinhky));
		return ids.toString();
	}

}