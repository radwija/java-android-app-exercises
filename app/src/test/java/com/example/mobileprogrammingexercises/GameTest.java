package com.example.mobileprogrammingexercises;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GameTest {
    @Test
    public void testPickRandomOption() {
        List<String> options = List.of("ROCK", "SCISSORS", "PAPER");

        Assert.assertTrue(options.contains(Game.pickRandomOption()));
        Assert.assertTrue(options.contains(Game.pickRandomOption()));
        Assert.assertTrue(options.contains(Game.pickRandomOption()));
        Assert.assertTrue(options.contains(Game.pickRandomOption()));
        Assert.assertTrue(options.contains(Game.pickRandomOption()));
        Assert.assertTrue(options.contains(Game.pickRandomOption()));
        Assert.assertTrue(options.contains(Game.pickRandomOption()));
        Assert.assertTrue(options.contains(Game.pickRandomOption()));
    }

    @Test
    public void testPickDrawable() {
        Assert.assertEquals(R.drawable.paper, Game.pickDrawable("PAPER"));
        Assert.assertEquals(R.drawable.rock, Game.pickDrawable("ROCK"));
        Assert.assertEquals(R.drawable.scissors, Game.pickDrawable("SCISSORS"));
    }

    @Test
    public void testIsDraw() {
        Assert.assertTrue(Game.isDraw("PAPER", "PAPER"));
        Assert.assertTrue(Game.isDraw("ROCK", "ROCK"));
        Assert.assertTrue(Game.isDraw("SCISSORS", "SCISSORS"));

        Assert.assertFalse(Game.isDraw("ROCK", "PAPER"));
        Assert.assertFalse(Game.isDraw("PAPER", "SCISSORS"));
        Assert.assertFalse(Game.isDraw("SCISSORS", "ROCK"));
    }

    @Test
    public void testIsWin() {
        Assert.assertTrue(Game.isWin("ROCK", "SCISSORS"));
        Assert.assertTrue(Game.isWin("SCISSORS", "PAPER"));
        Assert.assertTrue(Game.isWin("PAPER", "ROCK"));

        Assert.assertFalse(Game.isWin("ROCK", "PAPER"));
        Assert.assertFalse(Game.isWin("PAPER", "SCISSORS"));
        Assert.assertFalse(Game.isWin("ROCK", "PAPER"));
    }
}
