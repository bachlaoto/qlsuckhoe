/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:53 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller.test;
import static org.assertj.core.api.Assertions.assertThat;

import org.demo.controller.resource.AdminResource;
import com.tlu.qlsuckhoe.entity.Admin;
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
public class AdminControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;


	private static final String TENDANGNHAP = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	private static final String MATKHAU = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	private static final Integer IDROLE = Integer.valueOf(100);

	@Test
	public void createAdminTest() {
		// Create an admin
		Admin admin = createMocKAdmin(Integer.valueOf(100) , TENDANGNHAP, MATKHAU, IDROLE);
		// Recover this admin
		ResponseEntity<AdminResource> result = this.restTemplate.getForEntity("/admin/1", AdminResource.class);
		// The response can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/admin/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getTendangnhap()).isEqualTo(TENDANGNHAP);
		assertThat(result.getBody().getMatkhau()).isEqualTo(MATKHAU);
		assertThat(result.getBody().getIdrole()).isEqualTo(IDROLE);
		// Try to create the same admin, must return a CONFLICT status code
		result = this.restTemplate.postForEntity("/admin", admin, AdminResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
		// Response body must not be null
		assertThat(result.getBody()).isNull();
	}

	@Test
	public void updateTest() {
		// Create an admin and assert field
		Admin admin = createMocKAdmin(Integer.valueOf(100)  , TENDANGNHAP, MATKHAU, IDROLE);
		// Recover this admin
		ResponseEntity<AdminResource> result = this.restTemplate.getForEntity("/admin/1", AdminResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/admin/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getTendangnhap()).isEqualTo(TENDANGNHAP);
		assertThat(result.getBody().getMatkhau()).isEqualTo(MATKHAU);
		assertThat(result.getBody().getIdrole()).isEqualTo(IDROLE);

		// Change field value

		admin.setTendangnhap("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		admin.setMatkhau("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		admin.setIdrole(Integer.valueOf(200));
		// Process update
		RequestEntity<Admin> request = new RequestEntity<Admin>(admin, HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/admin/1", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be OK
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Recover the admin and ensure field are correct
		result = this.restTemplate.getForEntity("/admin/1", AdminResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		link = new Link("http://localhost:9999/admin/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);

		assertThat(result.getBody().getTendangnhap()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		assertThat(result.getBody().getMatkhau()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		assertThat(result.getBody().getIdrole()).isEqualTo(Integer.valueOf(200));
	}

	@Test
	public void updateNotFoundTest() {
		// Process update
		RequestEntity<Admin> request = new RequestEntity<Admin>(new Admin(), HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/admin/999", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteTest() {
		// Create an admin
		createMocKAdmin(Integer.valueOf(100)  , TENDANGNHAP, MATKHAU, IDROLE);
		// Recover this admin and test if all is ok
		ResponseEntity<AdminResource> result = this.restTemplate.getForEntity("/admin/1", AdminResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Delete the admin
		RequestEntity<Admin> request = new RequestEntity<Admin>(new Admin(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/admin/1", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_CONTENT
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

		// Try to recover the admin and ensure it's don't exist
		// Recover this admin and test if all is ok
		result = this.restTemplate.getForEntity("/admin/1", AdminResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteNotFound() {
		// Delete the admin
		RequestEntity<Admin> request = new RequestEntity<Admin>(new Admin(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/admin/999", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void getAdminsTest() {
		// First call assert no element
		ResponseEntity<PagedResources<AdminResource>> result = this.search("/admin");
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		PagedResources<AdminResource> page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata()).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(0);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(0);
		// By default page size is 20
		assertThat(page.getMetadata().getSize()).isEqualTo(20);

		// Insert 21 admin
		for (int i = 1; i < 22; i++) {
			createMocKAdmin(new Integer((int)i),String.valueOf(i),String.valueOf(i),IDROLE + i);
		}
		result = this.search("/admin");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(2);

		// Change the number of element per page and assert the page number
		result = this.search("/admin?size=3");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(7);
	}

	@Test
	public void getAdminsTestFilter() {
		// Create an admin
		Admin admin = createMocKAdmin(Integer.valueOf(100) , TENDANGNHAP, MATKHAU, IDROLE);
		RequestEntity<Admin> request = null;
		ResponseEntity<PagedResources<AdminResource>> result = null;
		PagedResources<AdminResource> page = null;
		// Test tendangnhap filter
		// Set the value on entity and update
		admin.setTendangnhap("c");
		// Process update
		request = new RequestEntity<Admin>(admin, HttpMethod.PUT, null);
		this.restTemplate.exchange("/admin/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test tendangnhap filter
		result = this.search("/admin?size=20&tendangnhap=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (AdminResource adminResource : page.getContent()) {
			assertThat(adminResource.getTendangnhap()).startsWith("c");
		}
		// Test matkhau filter
		// Set the value on entity and update
		admin.setMatkhau("c");
		// Process update
		request = new RequestEntity<Admin>(admin, HttpMethod.PUT, null);
		this.restTemplate.exchange("/admin/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test matkhau filter
		result = this.search("/admin?size=20&matkhau=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (AdminResource adminResource : page.getContent()) {
			assertThat(adminResource.getMatkhau()).startsWith("c");
		}
	}

	private Admin createMocKAdmin(Integer idadmin, String tendangnhap, String matkhau, Integer idrole) {
		Admin adminMock = new Admin();
		adminMock.setIdadmin(idadmin);
		adminMock.setTendangnhap(tendangnhap);
		adminMock.setMatkhau(matkhau);
		adminMock.setIdrole(idrole);
		this.restTemplate.postForLocation("/admin", adminMock);
		return adminMock;
	}

	private ResponseEntity<PagedResources<AdminResource>> search(String uri) {
		return this.restTemplate.exchange(uri, HttpMethod.GET, null, getTypeRef());
	}

	private ParameterizedTypeReference<PagedResources<AdminResource>> getTypeRef() {
		return new ParameterizedTypeReference<PagedResources<AdminResource>>() {
		};
	}

	private ParameterizedTypeReference<Void> getTypeRefVoid() {
		return new ParameterizedTypeReference<Void>() {
		};
	}
}