package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String animalKind;
    private final List<String> expectedList;
    private final String expectedExceptionMessage;

    public AnimalTest(String animalKind,List<String> expectedList,String expectedExceptionMessage){
        this.animalKind=animalKind;
        this.expectedList=expectedList;
        this.expectedExceptionMessage=expectedExceptionMessage;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {"Травоядное", List.of("Трава","Различные растения"),""},
                {"Хищник", List.of("Животные","Птицы","Рыба"),""},
                {"Что-то другое", List.of(""),"Неизвестный вид животного, используйте значение Травоядное или Хищник"},
        };
    }

    @Test
    public void getFoodParameterized() {
    String actualExceptionMessage="";
    Animal animal = new Animal();
    try{
    List <String> actualList = animal.getFood(animalKind);
        Assert.assertEquals(expectedList,actualList);
    } catch (Exception exception){
        actualExceptionMessage=exception.getMessage();
        Assert.assertEquals(expectedExceptionMessage,actualExceptionMessage);
    }
    }

    @Test
    public void getFamilyReturnsLongString() {
        Animal animal = new Animal();
        String actual= animal.getFamily();
        String expected="Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expected,actual);

    }
}