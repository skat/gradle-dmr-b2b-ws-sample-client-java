package dk.skat.dmr.b2b.sample;

import dk.skat.dmr._2007._05._31.KoeretoejRegistreringStatusType;
import dk.skat.dmr._2007._05._31.RegistreringNummerStatusType;
import dk.skat.dmr._2007._05._31.USKoeretoejRegistreringHentO;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * USKoeretoejRegistreringHentClient Test
 *
 * @author SKAT
 * @since 1.0
 */
public class USKoeretoejRegistreringHentClientTest {
    @Test
    public void invoke() throws Exception {
        String endpointURL = System.getProperty("dk.skat.dmr.b2b.sample.USImportoerService.ENDPOINT");
        String registreringNummerNummer = "AB12345";
        USKoeretoejRegistreringHentClient usKoeretoejRegistreringHentClient = new USKoeretoejRegistreringHentClient(endpointURL);
        USKoeretoejRegistreringHentO invoke = usKoeretoejRegistreringHentClient.invoke(registreringNummerNummer);
        assertTrue(invoke.getHovedOplysningerSvar().getSvarStruktur().getAdvisStrukturOrFejlStruktur().isEmpty());
        assertSame(KoeretoejRegistreringStatusType.REGISTRERET, invoke.getIndhold().getKoeretoejRegistreringStruktur().getKoeretoejRegistreringStatus());
    }
}