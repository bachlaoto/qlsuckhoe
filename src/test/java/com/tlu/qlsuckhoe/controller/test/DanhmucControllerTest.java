/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:54 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller.test;
import static org.assertj.core.api.Assertions.assertThat;

import org.demo.controller.resource.DanhmucResource;
import com.tlu.qlsuckhoe.entity.Danhmuc;
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
public class DanhmucControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;


	private static final String TENDANHMUC = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	@Test
	public void createDanhmucTest() {
		// Create an danhmuc
		Danhmuc danhmuc = createMocKDanhmuc(Integer.valueOf(100) , TENDANHMUC);
		// Recover this danhmuc
		ResponseEntity<DanhmucResource> result = this.restTemplate.getForEntity("/danhmuc/1", DanhmucResource.class);
		// The response can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/danhmuc/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getTendanhmuc()).isEqualTo(TENDANHMUC);
		// Try to create the same danhmuc, must return a CONFLICT status code
		result = this.restTemplate.postForEntity("/danhmuc", danhmuc, DanhmucResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
		// Response body must not be null
		assertThat(result.getBody()).isNull();
	}

	@Test
	public void updateTest() {
		// Create an danhmuc and assert field
		Danhmuc danhmuc = createMocKDanhmuc(Integer.valueOf(100)  , TENDANHMUC);
		// Recover this danhmuc
		ResponseEntity<DanhmucResource> result = this.restTemplate.getForEntity("/danhmuc/1", DanhmucResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/danhmuc/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getTendanhmuc()).isEqualTo(TENDANHMUC);

		// Change field value

		danhmuc.setTendanhmuc("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
		// Process update
		RequestEntity<Danhmuc> request = new RequestEntity<Danhmuc>(danhmuc, HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/danhmuc/1", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be OK
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Recover the danhmuc and ensure field are correct
		result = this.restTemplate.getForEntity("/danhmuc/1", DanhmucResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		link = new Link("http://localhost:9999/danhmuc/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);

		assertThat(result.getBody().getTendanhmuc()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
	}

	@Test
	public void updateNotFoundTest() {
		// Process update
		RequestEntity<Danhmuc> request = new RequestEntity<Danhmuc>(new Danhmuc(), HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/danhmuc/999", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteTest() {
		// Create an danhmuc
		createMocKDanhmuc(Integer.valueOf(100)  , TENDANHMUC);
		// Recover this danhmuc and test if all is ok
		ResponseEntity<DanhmucResource> result = this.restTemplate.getForEntity("/danhmuc/1", DanhmucResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Delete the danhmuc
		RequestEntity<Danhmuc> request = new RequestEntity<Danhmuc>(new Danhmuc(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/danhmuc/1", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_CONTENT
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

		// Try to recover the danhmuc and ensure it's don't exist
		// Recover this danhmuc and test if all is ok
		result = this.restTemplate.getForEntity("/danhmuc/1", DanhmucResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteNotFound() {
		// Delete the danhmuc
		RequestEntity<Danhmuc> request = new RequestEntity<Danhmuc>(new Danhmuc(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/danhmuc/999", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void getDanhmucsTest() {
		// First call assert no element
		ResponseEntity<PagedResources<DanhmucResource>> result = this.search("/danhmuc");
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		PagedResources<DanhmucResource> page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata()).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(0);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(0);
		// By default page size is 20
		assertThat(page.getMetadata().getSize()).isEqualTo(20);

		// Insert 21 danhmuc
		for (int i = 1; i < 22; i++) {
			createMocKDanhmuc(new Integer((int)i),String.valueOf(i));
		}
		result = this.search("/danhmuc");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(2);

		// Change the number of element per page and assert the page number
		result = this.search("/danhmuc?size=3");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(7);
	}

	@Test
	public void getDanhmucsTestFilter() {
		// Create an danhmuc
		Danhmuc danhmuc = createMocKDanhmuc(Integer.valueOf(100) , TENDANHMUC);
		RequestEntity<Danhmuc> request = null;
		ResponseEntity<PagedResources<DanhmucResource>> result = null;
		PagedResources<DanhmucResource> page = null;
		// Test tendanhmuc filter
		// Set the value on entity and update
		danhmuc.setTendanhmuc("c");
		// Process update
		request = new RequestEntity<Danhmuc>(danhmuc, HttpMethod.PUT, null);
		this.restTemplate.exchange("/danhmuc/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test tendanhmuc filter
		result = this.search("/danhmuc?size=20&tendanhmuc=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (DanhmucResource danhmucResource : page.getContent()) {
			assertThat(danhmucResource.getTendanhmuc()).startsWith("c");
		}
	}

	private Danhmuc createMocKDanhmuc(Integer iddanhmuc, String tendanhmuc) {
		Danhmuc danhmucMock = new Danhmuc();
		danhmucMock.setIddanhmuc(iddanhmuc);
		danhmucMock.setTendanhmuc(tendanhmuc);
		this.restTemplate.postForLocation("/danhmuc", danhmucMock);
		return danhmucMock;
	}

	private ResponseEntity<PagedResources<DanhmucResource>> search(String uri) {
		return this.restTemplate.exchange(uri, HttpMethod.GET, null, getTypeRef());
	}

	private ParameterizedTypeReference<PagedResources<DanhmucResource>> getTypeRef() {
		return new ParameterizedTypeReference<PagedResources<DanhmucResource>>() {
		};
	}

	private ParameterizedTypeReference<Void> getTypeRefVoid() {
		return new ParameterizedTypeReference<Void>() {
		};
	}
}