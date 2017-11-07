package Lucky;

import org.junit.Assert;
import org.junit.Test;

public class LuckyTest {
    @Test
    public void testLuckyEdad() {
        Lucky lucky = new Lucky("Lucas Lois", 22);
        int edad = lucky.getEdad();
        Assert.assertEquals(edad, 22);
    }

    @Test
    public void testJorgeEdad() {
        Lucky lucky = new Lucky("Jorge Jorjo", 24);
        int edad = lucky.getEdad();
        Assert.assertEquals(edad, 24);
    }
    
    @Test
    public void testOliviaEdad() {
    	Lucky oli = new Lucky("Olivia Fernandez",20);
    	String nombre = oli.getNombre();
    	Assert.assertEquals(nombre, "Olivia Fernandez");
    }
}
