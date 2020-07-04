package aulas.aula3.exercicios.aluno.teste;

import aulas.aula3.exercicios.aluno.Aluno;
import aulas.aula3.exercicios.aluno.GestaoAlunos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GestaoAlunosTest {

    private LocalDate dataNascimento;
    private Aluno aluno;
    private List<Aluno> alunos;
    @Mock
    private GestaoAlunos gestao;
    @BeforeEach
    public void setup(){
        dataNascimento = LocalDate.of(1989, 2, 23);
        aluno = new Aluno("Aluno Teste", "123456", dataNascimento);
        alunos = new ArrayList<>();
        gestao = new GestaoAlunos();
//        alunos.add(aluno);
    }


    @Test
    public void criar() {
        gestao.criar(anyInt());
        assertTrue(alunos.size() > 0);
    }

    @Test
    public void atualizar() {
        String ra = "123456";
        String novoNome = "Teste Aluno";
        int dia = 18;
        int mes = 7;
        int ano = 2019;
        LocalDate nasc = LocalDate.of(ano, mes, dia);

        Aluno filtrado = alunos.stream()
                .filter(alunoBuscado -> ra.equals(alunoBuscado.getRa()))
                .findFirst()
                .orElse(null);
        filtrado.setNascimento(nasc);
        filtrado.setNome(novoNome);

//        GestaoAlunos ga = mock(GestaoAlunos.class);
//        doNothing().when(ga).atualizar();
//        ga.atualizar();

        assertNotNull(filtrado);
        assertEquals(ra, filtrado.getRa());
        assertEquals(novoNome, filtrado.getNome());
        assertEquals(nasc, filtrado.getNascimento());

    }

    @Test
    public void naoDeveExcluir() {
        String ra = "123456";
        gestao.excluir(ra);

        assertFalse(alunos.contains(ra));
    }

    @Test
    public void deveExcluir() {
        String ra = "123456";
        GestaoAlunos ga = mock(GestaoAlunos.class);
//        gestao.criar(1L, "teste aluno", "123456", 1989, 02, 23);
        Aluno al = alunos.stream()
                .filter(alunoBuscado -> ra.equals(alunoBuscado.getRa()))
                .findAny()
                .orElse(null);

//        assertTrue(alunos.contains(alunos.stream()
//                .filter(alunoBuscado -> ra.equals(alunoBuscado.getRa()))
//                .findAny()
//                .orElse(null)));
        assertTrue(alunos.contains(al));

        alunos.removeIf(remove -> remove.equals(alunos.contains(al)));
        assertEquals(0, alunos.size());
    }

    @Test
    public void exibir() {
    }

    @Test
    public void menu() {
    }
}