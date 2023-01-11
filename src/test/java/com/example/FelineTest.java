package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

public class FelineTest {

   @Test
    public void eatMeatReturnsWithoutMock() throws Exception{
        Feline feline=new Feline();
        List<String> actual = feline.eatMeat();
        List<String> expected = new ArrayList<>();
        expected.add("Животные");
        expected.add("Птицы");
        expected.add("Рыба");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFamilyShouldReturnsFelineFamily() {
        Feline feline= new Feline();
        String actual=feline.getFamily();
        Assert.assertEquals("Кошачьи", actual);
    }

    @Test
    public void getKittensShouldReturnsOneKitten() {
        Feline feline= new Feline();
        int actual=feline.getKittens();
        Assert.assertEquals(1, actual);
    }

    @Test
    public void getKittensShouldReturnsArgumentKittensCount() {
        Feline feline= new Feline();
        int kittensCount=4;
        int actual=feline.getKittens(kittensCount);
        Assert.assertEquals(4, actual);

    }
}