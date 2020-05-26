package aulas.collections.exercícios.empresa.partei;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RhTest {

    private Funcionario f;
    private Rh rh;
    private Funcionario f2;

    @BeforeEach
    public void setup(){
        rh = new Rh();

        f = new Funcionario();
        f.setNome("ze");
        f.setSalario(100);

        f2 = new Funcionario();
        f2.setNome("Maria");
        f2.setSalario(100);
    }

    @Test
    public void testaAdicionaFuncionario(){
        rh.adicionarFuncionario(f);
        rh.adicionarFuncionario(f2);
        assertEquals(2, rh.getFuncionarios().size());
    }

    @Test
    public void testaRemoveFuncionario(){
        rh.adicionarFuncionario(f);
        assertEquals(1, rh.getFuncionarios().size());
        rh.removerFuncionario(f);
        assertEquals(0, rh.getFuncionarios().size());
    }
    @Test
    public void testaValorBonusMenosDuasFaltas(){
        f.adicionarFalta();
        assertTrue(f.getFaltasNoAno()<2);
        double bonusEsperado = 30;
        assertEquals(bonusEsperado, rh.valorBonus(f));
    }

    @Test
    public void testaValorBonusIgualDuasFaltas(){
        f.adicionarFalta();
        f.adicionarFalta();
        assertEquals(2, f.getFaltasNoAno());
        double bonusEsperado = 15;
        assertEquals(bonusEsperado, rh.valorBonus(f));
    }

    @Test
    public void testaValorBonusMenosQuatroEMaisQueDuasFaltas(){
        f.adicionarFalta();
        f.adicionarFalta();
        f.adicionarFalta();
        assertEquals(3, f.getFaltasNoAno());
        double bonusEsperado = 15;
        assertEquals(bonusEsperado, rh.valorBonus(f));
    }

    @Test
    public void testaValorBonusIgualQuatroFaltas(){
        f.adicionarFalta();
        f.adicionarFalta();
        f.adicionarFalta();
        f.adicionarFalta();
        assertEquals(4, f.getFaltasNoAno());
        double bonusEsperado = 15;
        assertEquals(bonusEsperado, rh.valorBonus(f));
    }

    @Test
    public void testaValorBonusMaisQuatroFaltas(){
        f.adicionarFalta();
        f.adicionarFalta();
        f.adicionarFalta();
        f.adicionarFalta();
        f.adicionarFalta();
        assertTrue(f.getFaltasNoAno()>4);
        double bonusEsperado = 5;
        assertEquals(bonusEsperado, rh.valorBonus(f));
    }

    @Test
    public void testeMostrarBonusTodosOsFuncionarios(){
        rh.adicionarFuncionario(f);
        rh.adicionarFuncionario(f2);
        f.adicionarFalta();
        f.adicionarFalta();
        f.adicionarFalta();
        rh.mostarBonusTodosFuncionarios();
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(f);
        funcionarios.add(f2);
        String expectedOutput = "ze bonus: 15.0\r\n" + "Maria bonus: 30.0\r\n";

        PrintStream oldOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        rh.mostarBonusTodosFuncionarios();
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(oldOut);

    }

}