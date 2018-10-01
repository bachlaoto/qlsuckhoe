/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 22:38:42 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller;

import com.tlu.qlsuckhoe.entity.Role;
import com.tlu.qlsuckhoe.service.RoleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/role", produces = "application/hal+json")
public class RoleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

	private static final String NOT_FOUND ="Role not found";

	@Autowired
	private RoleServiceImpl roleService;

	@RequestMapping(value = "/",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Role> findAll() {
		List<Role> list = roleService.findAll();
		return list;
	}


	@GetMapping("{idrole}")
	public Role get(@PathVariable("idrole") Integer idrole) {
		final Role role = roleService.getOne(idrole);
		LOGGER.info("Role found : {}", role);
		return role;
	}

	@PostMapping(consumes = "application/json")
	public Role create(@RequestBody Role role) {
		LOGGER.info("Role creation request : {}", role);
		if (roleService.exist(role)) {
			LOGGER.info("Role already exist ! : {}", role);
			return null;
		} else {
			final Role created = roleService.create(role);
			LOGGER.info("Created role {}", created);
			return created;
		}
	}

	@PutMapping(value = "{idrole}", consumes = "application/json")
	public Role update(@PathVariable("idrole") Integer idrole, @RequestBody Role role) {
		return roleService.update(role);
	}

	@DeleteMapping("{idrole}")
	public void delete(@PathVariable("idrole") Integer idrole) {
		LOGGER.info("Role deletion request : {}", resolveIdForLogger(idrole));
		if (roleService.delete(idrole)) {
			LOGGER.info("Role succesfully deleted");
		} else {
			LOGGER.info(NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer idrole) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(idrole));
		return ids.toString();
	}

}

