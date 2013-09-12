
package org.dbtrace.test.unit;
import org.junit.Assert;
import org.dbtrace.entity.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UsuarioTest {
    
    @Test
    public void validacaoDeSenhas() {
        // Criar Usuario
        Usuario usuario1 = new Usuario("José", "123", "123");
        usuario1.setConfirmaSenha("123");
        Assert.assertTrue(usuario1.isConfirmaSenha());
        
        // Alterar Senha
        Usuario usuario2 = new Usuario("João", "joao", "aaaa");
        usuario2.setNovaSenha("aaaa");
        Assert.assertTrue(usuario2.isNovaSenhaValida());
        
         // Criar Usuario - erro
        Usuario usuario3 = new Usuario("Maria", "maria", "123");
        usuario3.setConfirmaSenha("321");
        Assert.assertFalse(usuario3.isConfirmaSenha());
    }
    
}