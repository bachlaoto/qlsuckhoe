/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:54 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller;

import com.tlu.qlsuckhoe.service.criteria.BenhCriteria;
import org.demo.controller.assembler.BenhResourceAssembler;
import org.demo.controller.resource.BenhResource;
import com.tlu.qlsuckhoe.entity.Benh;
import com.tlu.qlsuckhoe.service.BenhServiceImpl;
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
@RequestMapping(value = "/benh", produces = "application/hal+json")
public class BenhController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BenhController.class);

	private static final String NOT_FOUND ="Benh not found";

	@Autowired
	private BenhServiceImpl benhService;

	@Autowired
	private PagedResourcesAssembler<Benh> pageAssember;

	private BenhResourceAssembler benhResourceAssembler = new BenhResourceAssembler();

	@GetMapping
	public ResponseEntity<PagedResources<BenhResource>> search(Pageable pageable, BenhCriteria criteria) {
		LOGGER.info("Benhs search [pageable={}|BenhCriteria={}", pageable, criteria);
		final Page<Benh> result = benhService.search(pageable, criteria);
		LOGGER.info("Found {} benhs !", result.getSize());
		return new ResponseEntity<>(pageAssember.toResource(result, benhResourceAssembler), HttpStatus.OK);
	}

	@GetMapping("{idbenh}")
	public ResponseEntity<BenhResource> get(@PathVariable("idbenh") Integer idbenh) {
		LOGGER.info("Benh get with id {}", resolveIdForLogger(idbenh));
		final Benh benh = benhService.get(idbenh);
		if (benh == null) {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>((BenhResource) null, HttpStatus.NOT_FOUND);
		}
		LOGGER.info("Benh found : {}", benh);
		final BenhResource benhResource = benhResourceAssembler.toResource(benh);
		return new ResponseEntity<>(benhResource, HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<BenhResource> create(@RequestBody Benh benh) {
		LOGGER.info("Benh creation request : {}", benh);
		if (benhService.exist(benh)) {
			LOGGER.info("Benh already exist ! : {}", benh);
			return new ResponseEntity<>((BenhResource) null, HttpStatus.CONFLICT);
		} else {
			final Benh created = benhService.create(benh);
			LOGGER.info("Created benh {}", created);
			return new ResponseEntity<>(benhResourceAssembler.toResource(created), HttpStatus.OK);
		}
	}

	@PutMapping(value = "{idbenh}", consumes = "application/json")
	public ResponseEntity<Void> update(@PathVariable("idbenh") Integer idbenh, @RequestBody Benh benh) {
		LOGGER.info("Benh update request [id={} | benh={}}", resolveIdForLogger(idbenh), benh);
		// force the id (use the id provided by the URL)
		benh.setIdbenh(idbenh);
		if (benhService.save(benh)) {
			LOGGER.info("Benh succesfully updated");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{idbenh}")
	public ResponseEntity<Void> delete(@PathVariable("idbenh") Integer idbenh) {
		LOGGER.info("Benh deletion request : {}", resolveIdForLogger(idbenh));
		if (benhService.delete(idbenh)) {
			LOGGER.info("Benh succesfully deleted");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer idbenh) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(idbenh));
		return ids.toString();
	}

}