package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.MyRandomStub;
import dominio.NonPlayableCharacter;

public class TestNPC {

  @Test
  public void testOtorgarExp() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
    Assert.assertEquals(30, npc.otorgarExp());
  }

  @Test
  public void testDificultad0() {
    NonPlayableCharacter npcEasy = new NonPlayableCharacter("Goblin", 2, 0);
    Assert.assertEquals(npcEasy.getFuerza(), 13);
    Assert.assertEquals(npcEasy.getSalud(), 45);
    Assert.assertEquals(npcEasy.getDefensa(), 3);
  }

  @Test
  public void testDificultad1() {
    NonPlayableCharacter npcNormal = new NonPlayableCharacter("Goblin", 2, 1);
    Assert.assertEquals(npcNormal.getFuerza(), 26);
    Assert.assertEquals(npcNormal.getSalud(), 60);
    Assert.assertEquals(npcNormal.getDefensa(), 7);
  }

  @Test
  public void testDificultad2() {
    NonPlayableCharacter npcHard = new NonPlayableCharacter("Goblin", 2, 2);
    Assert.assertEquals(npcHard.getFuerza(), 40);
    Assert.assertEquals(npcHard.getSalud(), 75);
    Assert.assertEquals(npcHard.getDefensa(), 8);
  }

  @Test
  public void testDificultadDefault() {
    NonPlayableCharacter npcDefault = new NonPlayableCharacter("Goblin", 2, 3);
    Assert.assertEquals(npcDefault.getFuerza(), 0);
    Assert.assertEquals(npcDefault.getSalud(), 0);
    Assert.assertEquals(npcDefault.getDefensa(), 0);
  }

  @Test
  public void testGetterSetterAtaque() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Goblin", 1, 1);
    npc.setAtaque(10);
    Assert.assertEquals(10, npc.getAtaqueTotal());
  }

  @Test
  public void testGetterSetterNombre() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Goblin", 1, 1);
    npc.setNombre("Prueba");
    Assert.assertEquals(npc.getNombre(), "Prueba");
  }

  @Test
  public void testSerAtacadoyDañado() {
    NonPlayableCharacter goblin = new NonPlayableCharacter("Goblin", 1, 1);
    Assert.assertEquals(40, goblin.getSalud());
    Assert.assertEquals(5, goblin.getDefensa());
    goblin.setRandgen(new MyRandomStub(0.5));
    goblin.serAtacado(10);
    Assert.assertEquals(32, goblin.getSalud());
  }

  @Test
  public void testSerAtacadoyMorir() {
    NonPlayableCharacter goblin = new NonPlayableCharacter("Goblin", 1, 1);
    Assert.assertEquals(40, goblin.getSalud());
    Assert.assertEquals(5, goblin.getDefensa());
    goblin.setRandgen(new MyRandomStub(0.1));
    goblin.serAtacado(100);
    Assert.assertTrue(goblin.estaVivo());
    goblin.setRandgen(new MyRandomStub(0.5));
    goblin.serAtacado(100);
    Assert.assertFalse(goblin.estaVivo());
  }

  @Test
  public void testSerAtacadoyNoDañado() {
    NonPlayableCharacter goblin = new NonPlayableCharacter("Goblin", 1, 1);
    Assert.assertEquals(40, goblin.getSalud());
    Assert.assertEquals(5, goblin.getDefensa());
    goblin.setRandgen(new MyRandomStub(0.5));
    goblin.serAtacado(1);
    Assert.assertEquals(40, goblin.getSalud());
  }

  @Test
  public void testSerAtacadoyEsquivar() {
    NonPlayableCharacter goblin = new NonPlayableCharacter("Goblin", 1, 1);
    Assert.assertEquals(40, goblin.getSalud());
    Assert.assertEquals(5, goblin.getDefensa());
    goblin.setRandgen(new MyRandomStub(0.1));
    goblin.serAtacado(100);
    Assert.assertEquals(40, goblin.getSalud());
  }

  @Test
  public void testAtacarSinCritico() {
    NonPlayableCharacter goblin = new NonPlayableCharacter("Goblin", 1, 1);
    NonPlayableCharacter ogro = new NonPlayableCharacter("Ogro", 1, 1);
    ogro.setRandgen(new MyRandomStub(0.5));
    goblin.setRandgen(new MyRandomStub(0.5));
    ogro.atacar(goblin);
    Assert.assertEquals(goblin.getSalud(), 22);
  }

  @Test
  public void testAtacarCritico() {
    NonPlayableCharacter goblin = new NonPlayableCharacter("Goblin", 1, 1);
    NonPlayableCharacter ogro = new NonPlayableCharacter("Ogro", 1, 1);
    ogro.setRandgen(new MyRandomStub(0.1));
    goblin.setRandgen(new MyRandomStub(0.5));
    ogro.atacar(goblin);
    Assert.assertEquals(goblin.getSalud(), 12);
  }

  @Test
  public void testDespuesdeTurno() {
  }

  @Test
  public void testGanarExperiencia() {
  }
}
