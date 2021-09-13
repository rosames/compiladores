
package br.ufscar.dc.compiladores.laT2;

/**
 *
 * @author Rodrigo Sato Gomes 619809
 * não consegui fazer imprimir certo 
 */


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Principal {
     public static void main(String args[]) throws IOException {
       
        try(PrintWriter pw = new PrintWriter(new File("saida.txt"))) { 
        CharStream cs = CharStreams.fromFileName(args[0]);
        laT2Lexer lex = new laT2Lexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        laT2Parser parser = new laT2Parser(tokens);
       
        MyCustomErrorListener mcel = new MyCustomErrorListener(pw);
        parser.addErrorListener(mcel);
    
        parser.programa();
         }
        
    }
}
