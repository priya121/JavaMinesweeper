import com.mycompany.app.resources.Display;
import com.mycompany.app.resources.FakeIO;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;


public class DisplayTest {
    ArrayList<Integer> mineLocations;
    private Display newGrid;

    private FakeIO getFakeIO(List<String> numbers) {
        return new FakeIO(numbers);
    }

    @Before
    public void setup() {
        List<Integer> mineLocations = new ArrayList<Integer>();
        mineLocations.add(1);
        mineLocations.add(2);
    }

    @Test
    @Ignore
    public void placesASymbolForMine() {
        mineLocations.add(1);
        mineLocations.add(2);
        FakeIO io = getFakeIO(asList("A2"));
        newGrid = new Display(io, mineLocations, 4);
    }
}
