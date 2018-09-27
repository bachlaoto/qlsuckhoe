/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller.test;
import static org.assertj.core.api.Assertions.assertThat;

import org.demo.controller.resource.RoleResource;
import com.tlu.qlsuckhoe.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// Junit specific runner
@RunWith(SpringJUnit4ClassRunner.class)
// Declare as spring boot test and define the port according to properties in
// src/test/resources/application.properties
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
// Ensure all are clean between two method test execution
@SqlGroup({ @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:clean.sql") })
public class RoleControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;


	private static final String NAME = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	@Test
	public void createRoleTest() {
		// Create an role
		Role role = createMocKRole(Integer.valueOf(100) , NAME);
		// Recover this role
		ResponseEntity<RoleResource> result = this.restTemplate.getForEntity("/role/1", RoleResource.class);
		// The response can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/role/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getName()).isEqualTo(NAME);
		// Try to create the same role, must return a CONFLICT status code
		result = this.restTemplate.postForEntity("/role", role, RoleResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
		// Response body must not be null
		assertThat(result.getBody()).isNull();
	}

	@Test
	public void updateTest() {
		// Create an role and assert field
		Role role = createMocKRole(Integer.valueOf(100)  , NAME);
		// Recover this role
		ResponseEntity<RoleResource> result = this.restTemplate.getForEntity("/role/1", RoleResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/role/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getName()).isEqualTo(NAME);

		// Change field value

		role.setName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
		// Process update
		RequestEntity<Role> request = new RequestEntity<Role>(role, HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/role/1", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be OK
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Recover the role and ensure field are correct
		result = this.restTemplate.getForEntity("/role/1", RoleResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		link = new Link("http://localhost:9999/role/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);

		assertThat(result.getBody().getName()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
	}

	@Test
	public void updateNotFoundTest() {
		// Process update
		RequestEntity<Role> request = new RequestEntity<Role>(new Role(), HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/role/999", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteTest() {
		// Create an role
		createMocKRole(Integer.valueOf(100)  , NAME);
		// Recover this role and test if all is ok
		ResponseEntity<RoleResource> result = this.restTemplate.getForEntity("/role/1", RoleResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Delete the role
		RequestEntity<Role> request = new RequestEntity<Role>(new Role(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/role/1", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_CONTENT
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

		// Try to recover the role and ensure it's don't exist
		// Recover this role and test if all is ok
		result = this.restTemplate.getForEntity("/role/1", RoleResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteNotFound() {
		// Delete the role
		RequestEntity<Role> request = new RequestEntity<Role>(new Role(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/role/999", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void getRolesTest() {
		// First call assert no element
		ResponseEntity<PagedResources<RoleResource>> result = this.search("/role");
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		PagedResources<RoleResource> page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata()).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(0);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(0);
		// By default page size is 20
		assertThat(page.getMetadata().getSize()).isEqualTo(20);

		// Insert 21 role
		for (int i = 1; i < 22; i++) {
			createMocKRole(new Integer((int)i),String.valueOf(i));
		}
		result = this.search("/role");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(2);

		// Change the number of element per page and assert the page number
		result = this.search("/role?size=3");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(7);
	}

	@Test
	public void getRolesTestFilter() {
		// Create an role
		Role role = createMocKRole(Integer.valueOf(100) , NAME);
		RequestEntity<Role> request = null;
		ResponseEntity<PagedResources<RoleResource>> result = null;
		PagedResources<RoleResource> page = null;
		// Test name filter
		// Set the value on entity and update
		role.setName("c");
		// Process update
		request = new RequestEntity<Role>(role, HttpMethod.PUT, null);
		this.restTemplate.exchange("/role/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test name filter
		result = this.search("/role?size=20&name=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (RoleResource roleResource : page.getContent()) {
			assertThat(roleResource.getName()).startsWith("c");
		}
	}

	private Role createMocKRole(Integer idrole, String name) {
		Role roleMock = new Role();
		roleMock.setIdrole(idrole);
		roleMock.setName(name);
		this.restTemplate.postForLocation("/role", roleMock);
		return roleMock;
	}

	private ResponseEntity<PagedResources<RoleResource>> search(String uri) {
		return this.restTemplate.exchange(uri, HttpMethod.GET, null, getTypeRef());
	}

	private ParameterizedTypeReference<PagedResources<RoleResource>> getTypeRef() {
		return new ParameterizedTypeReference<PagedResources<RoleResource>>() {
		};
	}

	private ParameterizedTypeReference<Void> getTypeRefVoid() {
		return new ParameterizedTypeReference<Void>() {
		};
	}
}