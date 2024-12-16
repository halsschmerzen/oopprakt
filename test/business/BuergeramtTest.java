package business;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Executable;

import org.junit.experimental.theories.internal.BooleanSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuergeramtTest {
	// Testfall: 10, Esszimmerteppich, 160, 250, grau,-blau
	// zweiter Test: farben sind null
	Teppich th;
	@BeforeEach
	private void setUp() {
		// TODO Auto-generated method stub
		String[] farben = {"grau","blau"};
		th = new Teppich("10", (float) 260.0, (float) 160.0,"Esszimmerteppich", farben);
	}
	
	
	@Test
	void ersterTest() {

		BooleanSupplier br = new BooleanSupplier();
		//assertTrue(br.equals(th.getKategorie().equals("Esszimmerteppich")), th.getKategorie());
		//assertEquals("Esszimmerteppich", th.getKategorie());
		assertTrue("Esszimmerteppich".equals(th.getKategorie()), th.getKategorie());
	}
	
	@Test
	void zweiterTest() {
		Executable exc = null;
		Exception sep = null;
		assertThrows(new IllegalArgumentException().getClass(), () -> {new Teppich("10", (float) 260.0, (float) 160.0,"Esszimmerteppich", null);});
	}

	

}
