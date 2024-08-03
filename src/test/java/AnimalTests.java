import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnimalTests {

    private Animal animal = new Animal();


    @Test
    public void getFoodForGrassEatersReturnsCorrectFoodList() throws Exception {
        List<String> actual = animal.getFood("Травоядное");
        List<String> expected =   List.of("Трава", "Различные растения");
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getFoodForPredatorsReturnsCorrectFoodList() throws Exception {
        List<String> actual = animal.getFood("Хищник");
        List<String> expected =   List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getFoodOnWrongAnimalTypeThrowsCorrectException() throws Exception{
        Exception thrown = Assert.assertThrows(Exception.class, () -> {animal.getFood("не хищник и не травоядное");});
        Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", thrown.getMessage());
    }

    @Test
    public void getFamilyReturnsCorrectText() throws Exception {
        String actual = animal.getFamily();
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", actual);

    }
}
