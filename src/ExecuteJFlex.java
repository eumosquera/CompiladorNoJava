import jflex.exceptions.SilentExit;

/**
 *
 * @author Ender Mosquera
 */
public class ExecuteJFlex {

    public static void main(String compi[]) {
        //rutas de los archivos 
        //C:\Users\Ender Mosquera\Documents\NetBeansProjects\CompiladorNoJava\src\main\java\com\mycompany\compiladornojava
        String lexerFile = System.getProperty("user.dir") + "/src/Lexer.flex",
                lexerColor = System.getProperty("user.dir") + "/src/LexerColor.flex";
        //String lexerFile = System.getProperty("user.dir") + "/src/main/java/com/mycompany/compiladornojava/Lexer.flex",
                //lexerColor = System.getProperty("user.dir") + "/src/main/java/com/mycompany/compiladornojava//LexerColor.flex";
        try {
            jflex.Main.generate(new String[]{lexerFile, lexerColor});
        } catch (SilentExit ex) {
            System.out.println("Error al compilar/generar el archivo flex: " + ex);
        }
    }

}
