import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {
    @Spy
    private Feline feline = new Feline();

    @Test
    public void eatMeatInvokesGetFoodForPredators() throws Exception {
        List<String> actual= feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyReturnsCorrectValue(){
        Assert.assertEquals("Кошачьи",feline.getFamily());
    }

    @Test
    public void getKittensReturnsArgumentValue2(){
        Assert.assertEquals(2, feline.getKittens(2));
    }
    @Test
    public void getKittensReturnsArgumentValue1(){
        Assert.assertEquals(1, feline.getKittens(1));
    }

    @Test
    public void getKittensNoArgInvokesGetKittensWith1(){
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getFoodWithNoArgInvokesGetFoodForPredator() throws Exception {
        List<String> actual= feline.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");

    }
}
