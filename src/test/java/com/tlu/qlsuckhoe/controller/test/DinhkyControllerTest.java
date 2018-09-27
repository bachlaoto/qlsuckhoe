/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:55 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.controller.test;
import static org.assertj.core.api.Assertions.assertThat;

import org.demo.controller.resource.DinhkyResource;
import com.tlu.qlsuckhoe.entity.Dinhky;
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
public class DinhkyControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;


	private static final Integer IDSINHVIEN = Integer.valueOf(100);

	private static final Integer IDHOCKI = Integer.valueOf(100);

	private static final Integer IDBENH = Integer.valueOf(100);

	private static final String CHIEUCAO = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	private static final String CANNANG = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	private static final String HUYETAP = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	private static final String LOAISUCKHOE = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	private static final String KETLUAN = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	private static final String CHUANDOAN = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	@Test
	public void createDinhkyTest() {
		// Create an dinhky
		Dinhky dinhky = createMocKDinhky(Integer.valueOf(100) , IDSINHVIEN, IDHOCKI, IDBENH, CHIEUCAO, CANNANG, HUYETAP, LOAISUCKHOE, KETLUAN, CHUANDOAN);
		// Recover this dinhky
		ResponseEntity<DinhkyResource> result = this.restTemplate.getForEntity("/dinhky/1", DinhkyResource.class);
		// The response can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/dinhky/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getIdsinhvien()).isEqualTo(IDSINHVIEN);
		assertThat(result.getBody().getIdhocki()).isEqualTo(IDHOCKI);
		assertThat(result.getBody().getIdbenh()).isEqualTo(IDBENH);
		assertThat(result.getBody().getChieucao()).isEqualTo(CHIEUCAO);
		assertThat(result.getBody().getCannang()).isEqualTo(CANNANG);
		assertThat(result.getBody().getHuyetap()).isEqualTo(HUYETAP);
		assertThat(result.getBody().getLoaisuckhoe()).isEqualTo(LOAISUCKHOE);
		assertThat(result.getBody().getKetluan()).isEqualTo(KETLUAN);
		assertThat(result.getBody().getChuandoan()).isEqualTo(CHUANDOAN);
		// Try to create the same dinhky, must return a CONFLICT status code
		result = this.restTemplate.postForEntity("/dinhky", dinhky, DinhkyResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
		// Response body must not be null
		assertThat(result.getBody()).isNull();
	}

	@Test
	public void updateTest() {
		// Create an dinhky and assert field
		Dinhky dinhky = createMocKDinhky(Integer.valueOf(100)  , IDSINHVIEN, IDHOCKI, IDBENH, CHIEUCAO, CANNANG, HUYETAP, LOAISUCKHOE, KETLUAN, CHUANDOAN);
		// Recover this dinhky
		ResponseEntity<DinhkyResource> result = this.restTemplate.getForEntity("/dinhky/1", DinhkyResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/dinhky/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getIdsinhvien()).isEqualTo(IDSINHVIEN);
		assertThat(result.getBody().getIdhocki()).isEqualTo(IDHOCKI);
		assertThat(result.getBody().getIdbenh()).isEqualTo(IDBENH);
		assertThat(result.getBody().getChieucao()).isEqualTo(CHIEUCAO);
		assertThat(result.getBody().getCannang()).isEqualTo(CANNANG);
		assertThat(result.getBody().getHuyetap()).isEqualTo(HUYETAP);
		assertThat(result.getBody().getLoaisuckhoe()).isEqualTo(LOAISUCKHOE);
		assertThat(result.getBody().getKetluan()).isEqualTo(KETLUAN);
		assertThat(result.getBody().getChuandoan()).isEqualTo(CHUANDOAN);

		// Change field value

		dinhky.setIdsinhvien(Integer.valueOf(200));

		dinhky.setIdhocki(Integer.valueOf(200));

		dinhky.setIdbenh(Integer.valueOf(200));

		dinhky.setChieucao("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		dinhky.setCannang("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		dinhky.setHuyetap("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		dinhky.setLoaisuckhoe("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		dinhky.setKetluan("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		dinhky.setChuandoan("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
		// Process update
		RequestEntity<Dinhky> request = new RequestEntity<Dinhky>(dinhky, HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/dinhky/1", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be OK
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Recover the dinhky and ensure field are correct
		result = this.restTemplate.getForEntity("/dinhky/1", DinhkyResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		link = new Link("http://localhost:9999/dinhky/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);

		assertThat(result.getBody().getIdsinhvien()).isEqualTo(Integer.valueOf(200));

		assertThat(result.getBody().getIdhocki()).isEqualTo(Integer.valueOf(200));

		assertThat(result.getBody().getIdbenh()).isEqualTo(Integer.valueOf(200));

		assertThat(result.getBody().getChieucao()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		assertThat(result.getBody().getCannang()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		assertThat(result.getBody().getHuyetap()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		assertThat(result.getBody().getLoaisuckhoe()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		assertThat(result.getBody().getKetluan()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		assertThat(result.getBody().getChuandoan()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
	}

	@Test
	public void updateNotFoundTest() {
		// Process update
		RequestEntity<Dinhky> request = new RequestEntity<Dinhky>(new Dinhky(), HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/dinhky/999", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteTest() {
		// Create an dinhky
		createMocKDinhky(Integer.valueOf(100)  , IDSINHVIEN, IDHOCKI, IDBENH, CHIEUCAO, CANNANG, HUYETAP, LOAISUCKHOE, KETLUAN, CHUANDOAN);
		// Recover this dinhky and test if all is ok
		ResponseEntity<DinhkyResource> result = this.restTemplate.getForEntity("/dinhky/1", DinhkyResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Delete the dinhky
		RequestEntity<Dinhky> request = new RequestEntity<Dinhky>(new Dinhky(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/dinhky/1", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_CONTENT
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

		// Try to recover the dinhky and ensure it's don't exist
		// Recover this dinhky and test if all is ok
		result = this.restTemplate.getForEntity("/dinhky/1", DinhkyResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteNotFound() {
		// Delete the dinhky
		RequestEntity<Dinhky> request = new RequestEntity<Dinhky>(new Dinhky(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/dinhky/999", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void getDinhkysTest() {
		// First call assert no element
		ResponseEntity<PagedResources<DinhkyResource>> result = this.search("/dinhky");
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		PagedResources<DinhkyResource> page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata()).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(0);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(0);
		// By default page size is 20
		assertThat(page.getMetadata().getSize()).isEqualTo(20);

		// Insert 21 dinhky
		for (int i = 1; i < 22; i++) {
			createMocKDinhky(new Integer((int)i),IDSINHVIEN + i,IDHOCKI + i,IDBENH + i,String.valueOf(i),String.valueOf(i),String.valueOf(i),String.valueOf(i),String.valueOf(i),String.valueOf(i));
		}
		result = this.search("/dinhky");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(2);

		// Change the number of element per page and assert the page number
		result = this.search("/dinhky?size=3");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(7);
	}

	@Test
	public void getDinhkysTestFilter() {
		// Create an dinhky
		Dinhky dinhky = createMocKDinhky(Integer.valueOf(100) , IDSINHVIEN, IDHOCKI, IDBENH, CHIEUCAO, CANNANG, HUYETAP, LOAISUCKHOE, KETLUAN, CHUANDOAN);
		RequestEntity<Dinhky> request = null;
		ResponseEntity<PagedResources<DinhkyResource>> result = null;
		PagedResources<DinhkyResource> page = null;
		// Test chieucao filter
		// Set the value on entity and update
		dinhky.setChieucao("c");
		// Process update
		request = new RequestEntity<Dinhky>(dinhky, HttpMethod.PUT, null);
		this.restTemplate.exchange("/dinhky/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test chieucao filter
		result = this.search("/dinhky?size=20&chieucao=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (DinhkyResource dinhkyResource : page.getContent()) {
			assertThat(dinhkyResource.getChieucao()).startsWith("c");
		}
		// Test cannang filter
		// Set the value on entity and update
		dinhky.setCannang("c");
		// Process update
		request = new RequestEntity<Dinhky>(dinhky, HttpMethod.PUT, null);
		this.restTemplate.exchange("/dinhky/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test cannang filter
		result = this.search("/dinhky?size=20&cannang=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (DinhkyResource dinhkyResource : page.getContent()) {
			assertThat(dinhkyResource.getCannang()).startsWith("c");
		}
		// Test huyetap filter
		// Set the value on entity and update
		dinhky.setHuyetap("c");
		// Process update
		request = new RequestEntity<Dinhky>(dinhky, HttpMethod.PUT, null);
		this.restTemplate.exchange("/dinhky/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test huyetap filter
		result = this.search("/dinhky?size=20&huyetap=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (DinhkyResource dinhkyResource : page.getContent()) {
			assertThat(dinhkyResource.getHuyetap()).startsWith("c");
		}
		// Test loaisuckhoe filter
		// Set the value on entity and update
		dinhky.setLoaisuckhoe("c");
		// Process update
		request = new RequestEntity<Dinhky>(dinhky, HttpMethod.PUT, null);
		this.restTemplate.exchange("/dinhky/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test loaisuckhoe filter
		result = this.search("/dinhky?size=20&loaisuckhoe=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (DinhkyResource dinhkyResource : page.getContent()) {
			assertThat(dinhkyResource.getLoaisuckhoe()).startsWith("c");
		}
		// Test ketluan filter
		// Set the value on entity and update
		dinhky.setKetluan("c");
		// Process update
		request = new RequestEntity<Dinhky>(dinhky, HttpMethod.PUT, null);
		this.restTemplate.exchange("/dinhky/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test ketluan filter
		result = this.search("/dinhky?size=20&ketluan=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (DinhkyResource dinhkyResource : page.getContent()) {
			assertThat(dinhkyResource.getKetluan()).startsWith("c");
		}
		// Test chuandoan filter
		// Set the value on entity and update
		dinhky.setChuandoan("c");
		// Process update
		request = new RequestEntity<Dinhky>(dinhky, HttpMethod.PUT, null);
		this.restTemplate.exchange("/dinhky/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test chuandoan filter
		result = this.search("/dinhky?size=20&chuandoan=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (DinhkyResource dinhkyResource : page.getContent()) {
			assertThat(dinhkyResource.getChuandoan()).startsWith("c");
		}
	}

	private Dinhky createMocKDinhky(Integer idkhamdinhky, Integer idsinhvien, Integer idhocki, Integer idbenh, String chieucao, String cannang, String huyetap, String loaisuckhoe, String ketluan, String chuandoan) {
		Dinhky dinhkyMock = new Dinhky();
		dinhkyMock.setIdkhamdinhky(idkhamdinhky);
		dinhkyMock.setIdsinhvien(idsinhvien);
		dinhkyMock.setIdhocki(idhocki);
		dinhkyMock.setIdbenh(idbenh);
		dinhkyMock.setChieucao(chieucao);
		dinhkyMock.setCannang(cannang);
		dinhkyMock.setHuyetap(huyetap);
		dinhkyMock.setLoaisuckhoe(loaisuckhoe);
		dinhkyMock.setKetluan(ketluan);
		dinhkyMock.setChuandoan(chuandoan);
		this.restTemplate.postForLocation("/dinhky", dinhkyMock);
		return dinhkyMock;
	}

	private ResponseEntity<PagedResources<DinhkyResource>> search(String uri) {
		return this.restTemplate.exchange(uri, HttpMethod.GET, null, getTypeRef());
	}

	private ParameterizedTypeReference<PagedResources<DinhkyResource>> getTypeRef() {
		return new ParameterizedTypeReference<PagedResources<DinhkyResource>>() {
		};
	}

	private ParameterizedTypeReference<Void> getTypeRefVoid() {
		return new ParameterizedTypeReference<Void>() {
		};
	}
}