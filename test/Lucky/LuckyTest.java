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
        Lucky lucky = new Lucky("Jorge Jorjo", 18);
        int edad = lucky.getEdad();
        Assert.assertEquals(edad, 24);
    }
}
