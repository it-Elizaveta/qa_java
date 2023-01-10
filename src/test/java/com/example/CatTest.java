package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Test
    public void getSoundShouldBeMeow() {
        Feline feline = new Feline();
        Cat cat=new Cat(feline);
        String actualSound= cat.getSound();
        Assert.assertEquals("Мяу",actualSound);
    }
    @Mock
    Feline felineMock;

    @Test
    public void getFoodCallsEatMeat() throws Exception {
        Cat cat = new Cat(felineMock);
        cat.getFood();
        Mockito.verify(felineMock,Mockito.times(1)).eatMeat();
    }
}