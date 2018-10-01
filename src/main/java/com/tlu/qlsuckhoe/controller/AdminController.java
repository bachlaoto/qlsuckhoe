/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 22:38:40 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller;

import com.tlu.qlsuckhoe.entity.Admin;
import com.tlu.qlsuckhoe.service.AdminServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/admin", produces = "application/hal+json")
public class AdminController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	private static final String NOT_FOUND ="Admin not found";

	@Autowired
	private AdminServiceImpl adminService;

	@RequestMapping(value = "/",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Admin> findAll() {
		List<Admin> list = adminService.findAll();
		return list;
	}


	@GetMapping("{idadmin}")
	public Admin get(@PathVariable("idadmin") Integer idadmin) {
		final Admin admin = adminService.getOne(idadmin);
		LOGGER.info("Admin found : {}", admin);
		return admin;
	}

	@PostMapping(consumes = "application/json")
	public Admin create(@RequestBody Admin admin) {
		LOGGER.info("Admin creation request : {}", admin);
		if (adminService.exist(admin)) {
			LOGGER.info("Admin already exist ! : {}", admin);
			return null;
		} else {
			final Admin created = adminService.create(admin);
			LOGGER.info("Created admin {}", created);
			return created;
		}
	}

	@PutMapping(value = "{idadmin}", consumes = "application/json")
	public Admin update(@PathVariable("idadmin") Integer idadmin, @RequestBody Admin admin) {
		return adminService.update(admin);
	}

	@DeleteMapping("{idadmin}")
	public void delete(@PathVariable("idadmin") Integer idadmin) {
		LOGGER.info("Admin deletion request : {}", resolveIdForLogger(idadmin));
		if (adminService.delete(idadmin)) {
			LOGGER.info("Admin succesfully deleted");
		} else {
			LOGGER.info(NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer idadmin) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(idadmin));
		return ids.toString();
	}

}

