import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*
Numero = {Digito} ({Digito})*

/* Número */
Numero = 0 | [1-9][0-9]*
%%

/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }


/*Numero*/
{Numero} "." {Numero} { return token(yytext(), "REAL", yyline, yycolumn); }
{Numero} { return token(yytext(), "NUMERO", yyline, yycolumn); }

/*Operadores*/
"+" { return token(yytext(), "SUMA", yyline, yycolumn); }
"%" { return token(yytext(), "MODULO", yyline, yycolumn); }
"-" { return token(yytext(), "RESTA", yyline, yycolumn); }
"/" { return token(yytext(), "DIVISION", yyline, yycolumn); }
"*" { return token(yytext(), "MULTIPLICACION", yyline, yycolumn); }

/*aritmeticos*/
"==" { return token(yytext(), "IGUAL", yyline, yycolumn); }
"!=" { return token(yytext(), "DIFERENTE", yyline, yycolumn); }
">" { return token(yytext(), "MAYORQUE", yyline, yycolumn); }
"<" { return token(yytext(), "MENORQUE", yyline, yycolumn); }
">=" { return token(yytext(), "MAYORIGUALQUE", yyline, yycolumn); }
"<=" { return token(yytext(), "MENORIGUALQUE", yyline, yycolumn); }
/*signos*/
"." { return token(yytext(), "PUNTO", yyline, yycolumn); }
"||" { return token(yytext(), "O", yyline, yycolumn); }
"," { return token(yytext(), "COMA", yyline, yycolumn); }
":" { return token(yytext(), "DOSPUNTOS", yyline, yycolumn); }
";" { return token(yytext(), "PUNTOCOMA", yyline, yycolumn); }
\' { return token(yytext(), "COMILLASIMPLE", yyline, yycolumn); }
\" [a-zA-Z0-9_.-]* \" { return token(yytext(), "CADENA", yyline, yycolumn); }
/*asignacion*/
"=" { return token(yytext(), "ASIGNACION", yyline, yycolumn); }


\" { return token(yytext(), "COMILLADOBLE", yyline, yycolumn); }
\( { return token(yytext(), "PARENTESISABIERTO", yyline, yycolumn); }
\) { return token(yytext(), "PARENTESISCERRADO", yyline, yycolumn); }
\{ { return token(yytext(), "LLAVEABIERTO", yyline, yycolumn); }
\} { return token(yytext(), "LLAVECERRADO", yyline, yycolumn); }
\[ { return token(yytext(), "CORCHETEABIERTO", yyline, yycolumn); }
\] { return token(yytext(), "CORCHETECERRADO", yyline, yycolumn); }
/*incrementos*/
"++" { return token(yytext(), "INCREMENTO", yyline, yycolumn); }
"--" { return token(yytext(), "DECREMENTO", yyline, yycolumn); }

/*Palabras reservadas*/
"IMPORTAR" | "importar" | "Importar" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"ESTATICO" | "estatico" | "Estatico" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"PUBLICO" | "publico" | "Publico" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"VACIO" | "vacio" | "Vacio" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"PRIVADO" | "privado" | "Privado" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"CLASE" | "clase" | "Clase" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"SI" | "si" | "Si" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"SINO" | "sino" | "Sino" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"PARA" | "para" | "Para" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"EN" | "en" | "En" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"RANGO" | "rango" | "Rango" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"MISMO" | "mismo" | "Mismo" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"MIENTRAS" | "mientras" | "Mientras" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"INTENTAR" | "intentar" | "Intentar" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"EXCEPTO" | "excepto" | "Excepto" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"RETORNAR" | "retornar" | "Retornar" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"ROMPER" | "romper" | "Romper" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"SIGUIENTE" | "siguiente" | "Siguiente" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"ENTRADA" | "entrada" | "Entrada" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"SALIDA" | "salida" | "Salida" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"IMPRIMIR" | "imprimir" | "Imprimir" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"CASO" | "caso" | "Caso" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"EVALUAR" | "evaluar" | "Evaluar" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"REAL" | "real" | "Real" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"COMUN" | "comun" | "Comun" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"HEREDA" | "hereda" | "Hereda" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"PRINCIPAL" | "principal" | "Principal" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
/*Tipo de dato*/
"ENTERO" | "entero" | "Entero" { return token(yytext(), "TIPODEDATO", yyline, yycolumn); }
"FLOTANTE" | "fotante" | "Fotantet" { return token(yytext(), "TIPODEDATO", yyline, yycolumn); }
"DECIMAL" | "decimal" | "Decimal" { return token(yytext(), "TIPODEDATO", yyline, yycolumn); }
"BOLEANO" | "booleano" | "Booleano" { return token(yytext(), "TIPODEDATO", yyline, yycolumn); }
"TEXTO" | "texto" | "Texto" { return token(yytext(), "TIPODEDATO", yyline, yycolumn); }
/*booleano*/
"VERDADERO" | "verdadero" | "Verdadero" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
"FALSO" | "falso" | "Falso" { return token(yytext(), "RESERVADA", yyline, yycolumn); }
/*Matematicos*/
"RAIZ" | "raiz" | "Raiz" { return token(yytext(), "RAIZ", yyline, yycolumn); }
/*logicos*/
"Y" | "y" { return token(yytext(), "Y", yyline, yycolumn); }
"O" | "o" { return token(yytext(), "O", yyline, yycolumn); }
"NO" | "no" | "No" { return token(yytext(), "NO", yyline, yycolumn); }
/*data base*/
"INICIO" | "inicio" | "Inicio" { return token(yytext(), "INICIO", yyline, yycolumn); }
"FINAL" | "final" | "FINAL" { return token(yytext(), "FINAL", yyline, yycolumn); }
/*identificadores o IDs*/
{Identificador} { return token(yytext(), "ID", yyline, yycolumn); }

/**/
. { return token(yytext(), "ERROR", yyline, yycolumn); }
