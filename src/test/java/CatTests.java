import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {
    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getFoodInvokesFelineEatMeat() throws Exception{
        List<String> mockExpected = List.of("мясо1", "Мясо2");
        Mockito.when(feline.eatMeat()).thenReturn(mockExpected);
        List<String> actual = cat.getFood();
        Assert.assertEquals(mockExpected, actual);
    }

    @Test
    public void getSoundReturnsMeow(){
        Assert.assertEquals("Мяу", cat.getSound());
    }
}
