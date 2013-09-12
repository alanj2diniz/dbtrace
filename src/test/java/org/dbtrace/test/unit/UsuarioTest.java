
package org.dbtrace.test.unit;
import org.junit.Assert;
import br.com.mrg.dbtracemodel.entity.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UsuarioTest {
    
    @Test
    public void test() {
        
        // Criar Usuario
        Usuario usuario1 = new Usuario();
        usuario1.setSenha("123");
        usuario1.setConfirmaSenha("123");
        Assert.assertTrue(usuario1.isConfirmaSenha());
        
        // Alterar Senha
        Usuario usuario2 = new Usuario();
        usuario2.setSenha("123");
        usuario2.setNovaSenha("aaaa");
        usuario2.setConfirmaSenha("aaaa");
        Assert.assertTrue(usuario2.isNovaSenhaValida());
        
         // Criar Usuario - erro
        Usuario usuario3 = new Usuario();
        usuario3.setSenha("123");
        usuario3.setConfirmaSenha("321");
        Assert.assertFalse(usuario3.isConfirmaSenha());
    }
    
}
