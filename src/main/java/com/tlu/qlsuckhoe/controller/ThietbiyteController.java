/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller;

import org.demo.controller.assembler.ThietbiyteResourceAssembler;
import org.demo.controller.resource.ThietbiyteResource;
import com.tlu.qlsuckhoe.entity.Thietbiyte;
import com.tlu.qlsuckhoe.service.ThietbiyteServiceImpl;
import com.tlu.qlsuckhoe.service.criteria.ThietbiyteCriteria;
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
@RequestMapping(value = "/thietbiyte", produces = "application/hal+json")
public class ThietbiyteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThietbiyteController.class);

	private static final String NOT_FOUND ="Thietbiyte not found";

	@Autowired
	private ThietbiyteServiceImpl thietbiyteService;

	@Autowired
	private PagedResourcesAssembler<Thietbiyte> pageAssember;

	private ThietbiyteResourceAssembler thietbiyteResourceAssembler = new ThietbiyteResourceAssembler();

	@GetMapping
	public ResponseEntity<PagedResources<ThietbiyteResource>> search(Pageable pageable, ThietbiyteCriteria criteria) {
		LOGGER.info("Thietbiytes search [pageable={}|ThietbiyteCriteria={}", pageable, criteria);
		final Page<Thietbiyte> result = thietbiyteService.search(pageable, criteria);
		LOGGER.info("Found {} thietbiytes !", result.getSize());
		return new ResponseEntity<>(pageAssember.toResource(result, thietbiyteResourceAssembler), HttpStatus.OK);
	}

	@GetMapping("{idthietbiyte}")
	public ResponseEntity<ThietbiyteResource> get(@PathVariable("idthietbiyte") Integer idthietbiyte) {
		LOGGER.info("Thietbiyte get with id {}", resolveIdForLogger(idthietbiyte));
		final Thietbiyte thietbiyte = thietbiyteService.get(idthietbiyte);
		if (thietbiyte == null) {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>((ThietbiyteResource) null, HttpStatus.NOT_FOUND);
		}
		LOGGER.info("Thietbiyte found : {}", thietbiyte);
		final ThietbiyteResource thietbiyteResource = thietbiyteResourceAssembler.toResource(thietbiyte);
		return new ResponseEntity<>(thietbiyteResource, HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<ThietbiyteResource> create(@RequestBody Thietbiyte thietbiyte) {
		LOGGER.info("Thietbiyte creation request : {}", thietbiyte);
		if (thietbiyteService.exist(thietbiyte)) {
			LOGGER.info("Thietbiyte already exist ! : {}", thietbiyte);
			return new ResponseEntity<>((ThietbiyteResource) null, HttpStatus.CONFLICT);
		} else {
			final Thietbiyte created = thietbiyteService.create(thietbiyte);
			LOGGER.info("Created thietbiyte {}", created);
			return new ResponseEntity<>(thietbiyteResourceAssembler.toResource(created), HttpStatus.OK);
		}
	}

	@PutMapping(value = "{idthietbiyte}", consumes = "application/json")
	public ResponseEntity<Void> update(@PathVariable("idthietbiyte") Integer idthietbiyte, @RequestBody Thietbiyte thietbiyte) {
		LOGGER.info("Thietbiyte update request [id={} | thietbiyte={}}", resolveIdForLogger(idthietbiyte), thietbiyte);
		// force the id (use the id provided by the URL)
		thietbiyte.setIdthietbiyte(idthietbiyte);
		if (thietbiyteService.save(thietbiyte)) {
			LOGGER.info("Thietbiyte succesfully updated");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{idthietbiyte}")
	public ResponseEntity<Void> delete(@PathVariable("idthietbiyte") Integer idthietbiyte) {
		LOGGER.info("Thietbiyte deletion request : {}", resolveIdForLogger(idthietbiyte));
		if (thietbiyteService.delete(idthietbiyte)) {
			LOGGER.info("Thietbiyte succesfully deleted");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer idthietbiyte) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(idthietbiyte));
		return ids.toString();
	}

}