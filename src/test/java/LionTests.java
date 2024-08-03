import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTests {
    String sex;
    Boolean shouldHaveMane;

    public LionTests (String sex, Boolean shouldHaveMane) throws Exception {
        this.sex = sex;
        this.shouldHaveMane = shouldHaveMane;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][] {
                {"Самец",true},
                {"Самка",false}
        };
    }

    @Mock
    private Feline feline =  Mockito.mock(Feline.class);

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion =  new Lion(sex, feline) ;
    }

    @Test
    public  void doesHaveManeReturnCorrectValue() throws Exception {
        Assert.assertEquals(shouldHaveMane, lion.doesHaveMane());
    }

    @Test
    public void getKittensInvokesFamilyGetKittens() throws Exception{
        int mockExpected = 11;
        Mockito.when(feline.getKittens()).thenReturn(mockExpected);
        int actual = lion.getKittens();
        Assert.assertEquals(mockExpected, actual);
    }

    @Test
    public void getFoodInvokesFamilyGetFood() throws Exception{
        List<String> mockExpected = List.of("мясо11", "Мясо21");
        Mockito.when(feline.getFood()).thenReturn(mockExpected);
        List<String> actual = lion.getFood();
        Assert.assertEquals(mockExpected, actual);
    }

    @Test
    public void lionConstructorOnWrongSexThrowsCorrectException() throws Exception{
        Exception thrown = Assert.assertThrows(Exception.class, () -> {
            Lion lionWithException = new Lion("Что ты такое?", feline);
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", thrown.getMessage());
    }
}
