package starter.soapapi;


import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenFetchingSoap {
    CountryInfoSoapActions action;
    @Test
    public void fetchCountrySoap(){
        action.iSendCapitalCitySoapRequest();
        action.responseShouldContainManagua();
    }
}
