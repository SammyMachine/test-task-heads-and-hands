package com.example.herovsmonster

import com.example.herovsmonster.data.model.Entity
import com.example.herovsmonster.data.model.Monster
import com.example.herovsmonster.data.model.Player
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class TestForModel {

    @Test
    fun testForValidInput() {
        assertTrue(Entity.checkValidInput(1, 1, 1, 1..1))
        assertTrue(Entity.checkValidInput(30, 30, 1, 1..30))
        assertTrue(Entity.checkValidInput(15, 20, 10, 5..10))
        assertFalse(Entity.checkValidInput(0, 1, 1, 1..1))
        assertFalse(Entity.checkValidInput(1, 31, 1, 1..1))
        assertFalse(Entity.checkValidInput(1, 1, 0, 1..1))
        assertFalse(Entity.checkValidInput(10, 5, 1, 5..1))
    }

    @Test(expected = IllegalArgumentException::class)
    fun testForEntityInitializing() {
        Entity(0, 0, 0, 5..0)
        Entity(1, 0, 0, 5..0)
        Entity(1, 1, 0, 5..0)
        Entity(1, 1, 1, 5..0)
        Entity(1, 1, 1, 1..2)
    }

    @Test
    fun testForAttacking() {
        val player = Player(30, 30, 50, 10..15)
        val monster = Monster(15, 1, 50, 5..7)
        val dmg = player.attack()
        monster.getDamage(dmg)
        assertTrue(dmg in 10..15 || dmg == 0)
        if (dmg != 0) assertEquals(50 - dmg, monster.getHealth())
        else assertEquals(50, monster.getHealth())
    }

    @Test
    fun testForHealing() {
        val player = Player()
        player.setPlayer(listOf(30, 1, 24, 10, 15))
        player.setHealth(24)
        val dmg = 8
        player.getDamage(dmg)
        player.restoreHealth()
        assertEquals(23, player.getHealth())
        assertEquals(1, player.getHealCount())
        player.getDamage(dmg)
        player.restoreHealth()
        player.getDamage(dmg)
        player.restoreHealth()
        player.getDamage(dmg)
        player.restoreHealth()
        assertEquals(4, player.getHealCount())
    }
}