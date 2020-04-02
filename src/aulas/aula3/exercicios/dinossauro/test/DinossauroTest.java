package aulas.aula3.exercicios.dinossauro.test;

import aulas.aula3.exercicios.dinossauro.Dinossauro;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DinossauroTest {
    Dinossauro dino;

    @BeforeEach
    public void setup() {
        dino = new Dinossauro(1, 0, 35, true);
    }

    /*
//    O dinossauro precisa tomar Sol para ter velocidade, além de deixa-lo com o humor feliz
//    Precisa comer para ter energia, e comer deixa o humor feliz
//    Para cada ponto de velocidade ganho ele perde um ponto de energia
//    Correr gasta energia deixa o humor feliz
//    ficarNaSombra recupera energia deixa o humor triste
    atirar gasta energia e deixa o humor feliz
    pular gasta energia e deixa o humor feliz
     */

    @Test
    public void deveAumentarVelocidadeNoSol() {
        dino.tomarSol();
        assertEquals(1, dino.getVelocidade(), "Velocidade diferente da esperada");
    }


    @Test
    public void naoDeveAumentarPularSemEnergia() {
        dino.pular();
        assertEquals(0, (int) dino.getVelocidade(), "Velocidade incorreta");
    }

    @Test
    public void naoDeveAumentarAtirarSemEnergia() {
        dino.atirar();
        assertEquals(0, (int) dino.getVelocidade(), "Velocidade incorreta");
    }

    @Test
    public void deveFicarFelizNoSol() {
        dino.setHumor(false);
        dino.tomarSol();
        assertTrue(dino.isHumor());
    }

    @Test
    public void deveComerParaTerEnergia() {
        dino.comer();
        assertEquals(2, dino.getEnergia(), "energia diferente da esperada");
    }

    @Test
    public void deveFicarFelizAoComer() {
        dino.setHumor(false);
        dino.comer();
        assertTrue(dino.isHumor());
    }

    @Test
    public void devePerderUmPontoDeEnergiaPorPontoDeVelocidade() {
        int energiaAntesDoSol = dino.getEnergia();
        int velocidadeAntesDoSol = (int) dino.getVelocidade();
        dino.tomarSol();
        int alteracaoDeVelocidade = (int) (velocidadeAntesDoSol - dino.getVelocidade());
        int alteracaoDeEnergia = (int) (dino.getEnergia() - energiaAntesDoSol);

        assertEquals(1, energiaAntesDoSol - dino.getEnergia(), "energia diferente da esperada");
        assertEquals(1, dino.getVelocidade() - velocidadeAntesDoSol, "velocidade diferente da esperada");
        assertEquals(alteracaoDeVelocidade, alteracaoDeEnergia);
    }

    @Test
    public void deveGastarEnergiaAoCorrer() {
        dino.correr();
        assertEquals(0, dino.getEnergia(), "Energia diferente da esperada");
    }

    @Test
    public void deveFicarFelizAoCorrer() {
        dino.setHumor(false);
        dino.correr();
        assertTrue(dino.isHumor());
    }

    @Test
    public void deveRecuperarEnergiaNaSombra() {
        dino.ficarNaSombra();
        assertEquals(2, dino.getEnergia(), "Energia diferente da esperada");
    }

    @Test
    public void deveFicarTristeNaSombra() {
        dino.setHumor(true);
        dino.ficarNaSombra();
        assertTrue(!dino.isHumor());
    }

    @Test
    public void deveGastarEnergiaAoAtirar() {
        dino.atirar();
        assertEquals(0, dino.getEnergia(), "energia diferente da esperada");
    }

    @Test
    public void deveFicaFelizAoAtirar() {
        dino.setHumor(false);
        dino.atirar();
        assertTrue(dino.isHumor());
    }

    @Test
    public void deveGastarEnergiaAoPular() {
        dino.pular();
        assertEquals(0, dino.getEnergia(), "Energia diferente da esperada");
    }

    @Test
    public void deveFicaFelizAoPular() {
        dino.setHumor(false);
        dino.pular();
        assertTrue(dino.isHumor());
    }
}