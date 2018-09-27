/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller;

import org.demo.controller.assembler.SinhvienResourceAssembler;
import org.demo.controller.resource.SinhvienResource;
import com.tlu.qlsuckhoe.entity.Sinhvien;
import com.tlu.qlsuckhoe.service.SinhvienServiceImpl;
import com.tlu.qlsuckhoe.service.criteria.SinhvienCriteria;
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
@RequestMapping(value = "/sinhvien", produces = "application/hal+json")
public class SinhvienController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SinhvienController.class);

	private static final String NOT_FOUND ="Sinhvien not found";

	@Autowired
	private SinhvienServiceImpl sinhvienService;

	@Autowired
	private PagedResourcesAssembler<Sinhvien> pageAssember;

	private SinhvienResourceAssembler sinhvienResourceAssembler = new SinhvienResourceAssembler();

	@GetMapping
	public ResponseEntity<PagedResources<SinhvienResource>> search(Pageable pageable, SinhvienCriteria criteria) {
		LOGGER.info("Sinhviens search [pageable={}|SinhvienCriteria={}", pageable, criteria);
		final Page<Sinhvien> result = sinhvienService.search(pageable, criteria);
		LOGGER.info("Found {} sinhviens !", result.getSize());
		return new ResponseEntity<>(pageAssember.toResource(result, sinhvienResourceAssembler), HttpStatus.OK);
	}

	@GetMapping("{idsinhvien}")
	public ResponseEntity<SinhvienResource> get(@PathVariable("idsinhvien") Integer idsinhvien) {
		LOGGER.info("Sinhvien get with id {}", resolveIdForLogger(idsinhvien));
		final Sinhvien sinhvien = sinhvienService.get(idsinhvien);
		if (sinhvien == null) {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>((SinhvienResource) null, HttpStatus.NOT_FOUND);
		}
		LOGGER.info("Sinhvien found : {}", sinhvien);
		final SinhvienResource sinhvienResource = sinhvienResourceAssembler.toResource(sinhvien);
		return new ResponseEntity<>(sinhvienResource, HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<SinhvienResource> create(@RequestBody Sinhvien sinhvien) {
		LOGGER.info("Sinhvien creation request : {}", sinhvien);
		if (sinhvienService.exist(sinhvien)) {
			LOGGER.info("Sinhvien already exist ! : {}", sinhvien);
			return new ResponseEntity<>((SinhvienResource) null, HttpStatus.CONFLICT);
		} else {
			final Sinhvien created = sinhvienService.create(sinhvien);
			LOGGER.info("Created sinhvien {}", created);
			return new ResponseEntity<>(sinhvienResourceAssembler.toResource(created), HttpStatus.OK);
		}
	}

	@PutMapping(value = "{idsinhvien}", consumes = "application/json")
	public ResponseEntity<Void> update(@PathVariable("idsinhvien") Integer idsinhvien, @RequestBody Sinhvien sinhvien) {
		LOGGER.info("Sinhvien update request [id={} | sinhvien={}}", resolveIdForLogger(idsinhvien), sinhvien);
		// force the id (use the id provided by the URL)
		sinhvien.setIdsinhvien(idsinhvien);
		if (sinhvienService.save(sinhvien)) {
			LOGGER.info("Sinhvien succesfully updated");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{idsinhvien}")
	public ResponseEntity<Void> delete(@PathVariable("idsinhvien") Integer idsinhvien) {
		LOGGER.info("Sinhvien deletion request : {}", resolveIdForLogger(idsinhvien));
		if (sinhvienService.delete(idsinhvien)) {
			LOGGER.info("Sinhvien succesfully deleted");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer idsinhvien) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(idsinhvien));
		return ids.toString();
	}

}
