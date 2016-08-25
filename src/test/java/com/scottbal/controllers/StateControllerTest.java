package com.scottbal.controllers;

import io.restassured.RestAssured;
        import io.restassured.http.ContentType;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.jdbc.Sql;
        import org.springframework.test.context.junit4.SpringRunner;

        import java.util.HashMap;
        import java.util.Map;

        import static io.restassured.RestAssured.*;
        import static org.junit.Assert.*;
        import static io.restassured.matcher.RestAssuredMatchers.*;
        import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Sql(value = {"/prepare-db.sql"})
public class StateControllerTest {
    @Before
    public void setUp() throws Exception {
        RestAssured.port = 8001;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    // GET /api/states
    public void shouldGetAllStatesOnPage0() throws Exception {
        given().log().all().and().given().
                get("/api/states")
                .then().log().all()
                .statusCode(200)
                .body(
                        "numberOfElements", is(2),
                        "totalPages", is(2),
                        "content[0].name", equalTo("Illinois"),
                        "content[0].id", is(1),
                        "content[0].version", is(1)
                );
    }

    @Test
    // GET /api/states?page=1
    public void shouldGetAllStatesOnPage1() throws Exception {
        given().log().all().and().given().
                get("/api/states?page=1")
                .then().log().all()
                .statusCode(200)
                .body(
                        "numberOfElements", is(2),
                        "totalPages", is(2),
                        "content[0].name", equalTo("Alaska"),
                        "content[0].id", is(3),
                        "content[0].version", is(1)
                );
    }

    @Test
    // GET /api/states/1
    public void shouldGetStudioById() throws Exception {
        given().log().all().and().given().
                get("/api/states/1")
                .then().log().all()
                .statusCode(200)
                .body(
                        "name", equalTo("Illinois")
                );
    }

    @Test
    // POST /api/states
    public void shouldCreateNewState() throws Exception {
        Map<String, Object> json = new HashMap<>();
        json.put("name", "Arkansas");
        json.put("electVotes", "6");

        given().log().all().and().given().
                contentType(ContentType.JSON).
                body(json).
                post("/api/states")
                .then().log().all()
                .statusCode(200)
                .body(
                        "name", equalTo("Arkansas"),
                        "id", is(5),
                        "version", is(0),
                        "createdAt", greaterThan(1L),
                        "updatedAt", greaterThan(1L)
                );
    }

    @Test
    // DELETE /api/states/:id
    public void shouldDeleteState() throws Exception {
        given().log().all().and().given().
                delete("/api/states/3")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    // PUT /api/states/:id
    public void shouldUpdateState() throws Exception {
        Map<String, Object> json = new HashMap<>();
        json.put("name", "Arizona 2");
        json.put("electVotes", "99");

        given().log().all().and().given().
                contentType(ContentType.JSON).
                body(json).
                put("/api/states/4")
                .then().log().all()
                .statusCode(200)
                .body(
                        "name", equalTo("Arizona 2"),
                        "version", is(2),
                        "electVotes", is(99)
                );
    }
}