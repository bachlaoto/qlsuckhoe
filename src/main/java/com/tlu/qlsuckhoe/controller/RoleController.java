/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller;

import org.demo.controller.assembler.RoleResourceAssembler;
import org.demo.controller.resource.RoleResource;
import com.tlu.qlsuckhoe.entity.Role;
import com.tlu.qlsuckhoe.service.RoleServiceImpl;
import com.tlu.qlsuckhoe.service.criteria.RoleCriteria;
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
@RequestMapping(value = "/role", produces = "application/hal+json")
public class RoleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

	private static final String NOT_FOUND ="Role not found";

	@Autowired
	private RoleServiceImpl roleService;

	@Autowired
	private PagedResourcesAssembler<Role> pageAssember;

	private RoleResourceAssembler roleResourceAssembler = new RoleResourceAssembler();

	@GetMapping
	public ResponseEntity<PagedResources<RoleResource>> search(Pageable pageable, RoleCriteria criteria) {
		LOGGER.info("Roles search [pageable={}|RoleCriteria={}", pageable, criteria);
		final Page<Role> result = roleService.search(pageable, criteria);
		LOGGER.info("Found {} roles !", result.getSize());
		return new ResponseEntity<>(pageAssember.toResource(result, roleResourceAssembler), HttpStatus.OK);
	}

	@GetMapping("{idrole}")
	public ResponseEntity<RoleResource> get(@PathVariable("idrole") Integer idrole) {
		LOGGER.info("Role get with id {}", resolveIdForLogger(idrole));
		final Role role = roleService.get(idrole);
		if (role == null) {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>((RoleResource) null, HttpStatus.NOT_FOUND);
		}
		LOGGER.info("Role found : {}", role);
		final RoleResource roleResource = roleResourceAssembler.toResource(role);
		return new ResponseEntity<>(roleResource, HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<RoleResource> create(@RequestBody Role role) {
		LOGGER.info("Role creation request : {}", role);
		if (roleService.exist(role)) {
			LOGGER.info("Role already exist ! : {}", role);
			return new ResponseEntity<>((RoleResource) null, HttpStatus.CONFLICT);
		} else {
			final Role created = roleService.create(role);
			LOGGER.info("Created role {}", created);
			return new ResponseEntity<>(roleResourceAssembler.toResource(created), HttpStatus.OK);
		}
	}

	@PutMapping(value = "{idrole}", consumes = "application/json")
	public ResponseEntity<Void> update(@PathVariable("idrole") Integer idrole, @RequestBody Role role) {
		LOGGER.info("Role update request [id={} | role={}}", resolveIdForLogger(idrole), role);
		// force the id (use the id provided by the URL)
		role.setIdrole(idrole);
		if (roleService.save(role)) {
			LOGGER.info("Role succesfully updated");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{idrole}")
	public ResponseEntity<Void> delete(@PathVariable("idrole") Integer idrole) {
		LOGGER.info("Role deletion request : {}", resolveIdForLogger(idrole));
		if (roleService.delete(idrole)) {
			LOGGER.info("Role succesfully deleted");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			LOGGER.info(NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer idrole) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(idrole));
		return ids.toString();
	}

}
