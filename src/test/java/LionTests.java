import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    //развёл параметризованные и непараметризолванные по разным классам

    @Mock
    private Feline feline ;

    @Test
    public void lionConstructorOnWrongSexThrowsCorrectException() throws Exception{
        Exception thrown = Assert.assertThrows(Exception.class, () -> {
            Lion lionWithException = new Lion("Что ты такое?", feline);
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", thrown.getMessage());
    }

}
