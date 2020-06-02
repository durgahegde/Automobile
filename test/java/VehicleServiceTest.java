
import org.junit.Test;
import org.sdsu.automobile.service.*;
import org.sdsu.automobile.model.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class VehicleServiceTest {
	
	@Test
	public void testAddVehicle() {
		Vehicle vehicle = new Vehicle(123, 2019, "Ford", "Fiesta");
        given()
        .contentType("application/xml")
        .body(vehicle)
	      .when()
	      .request("POST", "/Automobile/rest/vehicles")
	      .then()
	      .statusCode(200);
	}
	
	@Test
	public void testEditVehicle() {
		Vehicle vehicle = new Vehicle(123, 2030, "Ford", "Fiesta");
        given()
        .contentType("application/xml")
        .body(vehicle)
	      .when()
	      .request("PUT", "/Automobile/rest/vehicles")
	      .then()
	      .statusCode(200);
	}
	
	@Test
	public void testGetVehicle() {
        given()
        .contentType("application/xml")
	      .when()
	      .request("GET", "/Automobile/rest/vehicles/123")
	      .then()
	      .statusCode(200);
	}
	
	@Test
	public void testGetVehicles() {
        given()
        .contentType("application/xml")
	      .when()
	      .request("GET", "/Automobile/rest/vehicles")
	      .then()
	      .statusCode(200);
	}
	
	@Test
	public void testDeleteVehicle() {
        given()
        .contentType("application/xml")
	      .when()
	      .request("DELETE", "/Automobile/rest/vehicles/123")
	      .then()
	      .statusCode(204);
	}
}
