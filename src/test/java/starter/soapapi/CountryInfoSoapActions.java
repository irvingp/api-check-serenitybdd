package starter.soapapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static net.serenitybdd.rest.SerenityRest.*;
import net.serenitybdd.core.steps.UIInteractions;


import static org.hamcrest.xml.HasXPath.hasXPath;
import static org.hamcrest.Matchers.equalTo;


public class CountryInfoSoapActions extends UIInteractions {

    private final String SOAP_ENDPOINT = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";

    private final String soapAction = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/CapitalCity";

    private final String soapBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" \n" +
            "               xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n" +
            "               xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
            "  <soap:Body>\n" +
            "    <CapitalCity xmlns=\"http://www.oorsprong.org/websamples.countryinfo\">\n" +
            "      <sCountryISOCode>NI</sCountryISOCode>\n" +  // Nicaragua
            "    </CapitalCity>\n" +
            "  </soap:Body>\n" +
            "</soap:Envelope>";

    @When("I send a CapitalCity SOAP request")
    public void iSendCapitalCitySoapRequest() {
        given()
                .baseUri(SOAP_ENDPOINT)
                .header("Content-Type", "text/xml")
                .header("SOAPAction", soapAction)
                .body(soapBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .log().all(); // Esto es opcional, para ver la respuesta completa en consola
    }

    @Then("The response should contain Managua")
    public void responseShouldContainManagua() {
        then().body(hasXPath("//*[local-name()='CapitalCityResult']", equalTo("Managua")));
    }
}
