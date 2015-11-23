import com.mycompany.app.resources.ConsoleIO;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ConsoleIOTest {
    OutputStream recordedOutput = new ByteArrayOutputStream();
    PrintStream actualOutput = new PrintStream(recordedOutput);

    @Test
    public void testsInput() {
        InputStream input = new ByteArrayInputStream("A1\n".getBytes());
        ConsoleIO newInput = new ConsoleIO(input, actualOutput);
        assertEquals("A1", (newInput.takeInput()));
    }

    @Test
    public void testsMultipleInputs() {
        InputStream input = new ByteArrayInputStream("A1\nA2".getBytes());
        ConsoleIO newInput = new ConsoleIO(input, actualOutput);
        newInput.takeInput();
        assertEquals("A2", (newInput.takeInput()));
    }
}
