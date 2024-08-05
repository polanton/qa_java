import com.example.Animal;
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
public class AnimalParametrizedTest {

    String animalKind;
    List<String> expectedFoodList ;

    public AnimalParametrizedTest (String animalKind, List<String> expectedFoodList) throws Exception {
        this.animalKind = animalKind;
        this.expectedFoodList = expectedFoodList;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][] {
                {"Травоядное",List.of("Трава", "Различные растения")},
                {"Хищник",List.of("Животные", "Птицы", "Рыба")}
        };
    }

    private Animal animal = new Animal() ;

    @Test
    public void getFoodForGrassEatersReturnsCorrectFoodList() throws Exception {
        List<String> actual = animal.getFood(animalKind);
        List<String> expected =  expectedFoodList;
        Assert.assertEquals(expected, actual);

    }

}
