package starter.petstore;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenFetchingAlreadyAvailableCat {
    Long newPetId = null;
    PetApiActions petApi;
    @Test
    public void fetchAlreadyAvailableCats() {
        newPetId = petApi.givenKittyIsAvailableInPetStore();
        petApi.whenIAskForAPetWithId(newPetId);
        petApi.thenISeeCatAsResult();
    }
}
