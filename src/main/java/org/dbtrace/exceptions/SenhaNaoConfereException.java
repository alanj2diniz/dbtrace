package org.dbtrace.exceptions;

public class SenhaNaoConfereException extends Exception {
    
    public SenhaNaoConfereException() {
        super("Senhas não conferem.");  
    }
 
}
