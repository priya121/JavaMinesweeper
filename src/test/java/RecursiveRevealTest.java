import com.mycompany.app.game.NeighbourCalculation;
import com.mycompany.app.game.RecursiveReveal;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecursiveRevealTest {

    private NeighbourCalculation neighbourCalculation;

    @Before
    public void setUp() throws Exception {
        neighbourCalculation = new NeighbourCalculation(4, 0);
    }

    @Test
    public void getNeighbourCellsFroFirstPosition() {
        List<String> board = Arrays.asList("•", "•", "•", "•");
        RecursiveReveal reveal = new RecursiveReveal(0, board);
        assertEquals(3, reveal.getNeighbours(0).size());
    }

   } 
