package Labs.Lab_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SummatorTest {

    @Test
    void summ() {
        long checkNumber = ((long) Integer.MAX_VALUE + 1);
        int testNumber = new Summator().summ(Integer.MAX_VALUE, 1);

        Assertions.assertNotEquals(testNumber, checkNumber);
    }
}