package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;


@RunWith(Parameterized.class)
public class LionTest {
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Feline felineMock;

    private final String sex;
    private final boolean expectedHasMane;

    public LionTest(String sex,boolean expectedHasMane){
        this.sex=sex;
        this.expectedHasMane=expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSexAndExpectedHasMane(){
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeWithValidParametersParametrized() throws Exception {
            Lion lion = new Lion(felineMock, sex);
            boolean actual = lion.doesHaveMane();
            Assert.assertEquals(expectedHasMane, actual);
    }

    @Test
    public void doesHaveManeWithNotValidSexThrowsExeption()  {
        String actualExeptionMessage="";
        try {
            Lion lion = new Lion(felineMock, "Неизвестный науке пол");
            lion.doesHaveMane();
        } catch (Exception exeption) {
            actualExeptionMessage = exeption.getMessage();
        }
        String expectedExeptionMessage = "Используйте допустимые значения пола животного - Самец или Самка";
        Assert.assertEquals(expectedExeptionMessage, actualExeptionMessage);
    }

    @Test
    public void getKittensReturnsOneKitten() throws Exception{
        Lion lion=new Lion(felineMock,sex);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        int actual=lion.getKittens();
        Assert.assertEquals(1,actual);
    }

    @Test
    public void getFoodIsCalledWithArgumentPredator() throws Exception{
        Lion lion = new Lion(felineMock, sex);
        lion.getFood();
        Mockito.verify(felineMock, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFoodReturnsListOfPredatorsDishes() throws Exception{
        Lion lion = new Lion(felineMock, sex);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        Assert.assertEquals(expected,actual);
    }


}