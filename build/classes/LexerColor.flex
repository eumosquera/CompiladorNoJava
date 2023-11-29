import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
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

/* Número */
Numero = 0 | [1-9][0-9]*
%%

/* Comentarios o espacios en blanco */
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146)); }
{EspacioEnBlanco} {/*IGNORAR*/}

/*Palabras reservadas*/
"IMPORTAR" | "importar" | "Importar" { return textColor( yychar, yylength(), new Color(255, 140, 0)); }
"CLASE" | "clase" | "Clase" { return textColor(yychar, yylength(), new Color(30,148,195)); }
"PUBLICO" | "publico" | "Publico" { return textColor(yychar, yylength(), new Color(30,148,195)); }
"PRIVADO" | "privado" | "Privado" { return textColor(yychar, yylength(), new Color(30,148,195)); }
"VACIO" | "vacio" | "Vacio" { return textColor(yychar, yylength(), new Color(80,149,194)); }
"ESTATICO" | "estatico" | "Estatico"  { return textColor(yychar, yylength(), new Color(89,179,192)); }
"PRINCIPAL" | "principal" | "Principal" { return textColor(yychar, yylength(), new Color(89,179,192)); }
/* condicion */
"SI" | "si" | "Si" { return textColor(yychar, yylength(), new Color(0, 0, 139)); }
"SINO" | "sino" | "Sino" { return textColor(yychar, yylength(), new Color(0, 0, 139));}

/* ciclos */
"PARA" | "para" | "Para" { return textColor(yychar, yylength(), new Color(0, 0, 139)); }
"EN" | "en" | "En" { return textColor(yychar, yylength(), new Color(0, 0, 139)); }
"MIENTRAS" | "mientras" | "Mientras" { return textColor(yychar, yylength(), new Color(0, 0, 139)); }
"RANGO" | "rango" | "Rango" { return textColor(yychar, yylength(), new Color(0, 0, 139));  }

"INTENTAR" | "intentar" | "Intentar" { return textColor(yychar, yylength(), new Color(0, 0, 139)); }
"EXCEPTO" | "excepto" | "Excepto" { return textColor(yychar, yylength(), new Color(0, 0, 139)); }
"RETORNAR" | "retornar" | "Retornar" { return textColor(yychar, yylength(), new Color(148, 58, 173)); }
"ROMPER" | "romper" | "Romper" { return textColor(yychar, yylength(), new Color(0, 0, 139)); }
"CASO" | "caso" | "caso" { return textColor(yychar, yylength(), new Color(255, 140, 0));  }
"EVALUAR" | "evaluar" | "evaluar" { return textColor(yychar, yylength(), new Color(0, 0,139));  }
"ENTRADA" | "entrada" | "Entrada" | "IMPRIMIR" | "imprimir" | "Imprimir" { return textColor(yychar, yylength(), new Color(255, 140, 0));  }
"HEREDA" | "hereda" | "Hereda" { return textColor( yychar, yylength(), new Color(255, 140, 0)); }
/* Tipos de dato */
"TEXTO" | "texto" | "Texto" { return textColor(yychar, yylength(), new Color(148, 58, 173)); }
"ENTERO" | "entero" | "Entero" {return textColor(yychar, yylength(), new Color(148, 58, 173));}
"FLOTANTE" | "fotante" | "Fotantet" { return textColor(yychar, yylength(), new Color(148, 58, 173)); }
"DECIMAL" | "decimal" | "Decimal" { return textColor(yychar, yylength(), new Color(148, 58, 173)); }
"BOLEANO" | "booleano" | "Booleano" { return textColor(yychar, yylength(), new Color(0, 0, 139)); }

"VERDADERO" | "verdadero" | "Verdadero" { return textColor(yychar, yylength(), new Color(148, 58, 173)); }
"FALSO" | "falso" | "Falso" { return textColor(yychar, yylength(), new Color(148, 58, 173)); }

"RAIZ" | "raiz" | "Raiz" { return textColor(yychar, yylength(), new Color(255, 140, 0)); }
"Y" | "y"  { return textColor(yychar, yylength(), new Color(178, 34, 34)); }
"O" | "o" { return textColor(yychar, yylength(), new Color(178, 34, 34)); }
"NO" | "no" | "No" { return textColor(yychar, yylength(), new Color(178, 34, 34)); }
"INICIO" | "inicio" | "Inicio" { return textColor(yychar, yylength(), new Color(255, 140, 0)); }
"FINAL" | "final" | "FINAL" { return textColor(yychar, yylength(), new Color(255, 140, 0)); }


\( { return textColor(yychar, yylength(), new Color(96, 96, 96)); }
\) { return textColor(yychar, yylength(), new Color(96, 96, 96)); }
\{ { return textColor(yychar, yylength(), new Color(96, 96, 96)); }
\} { return textColor(yychar, yylength(), new Color(96, 96, 96)); }
\[ { return textColor(yychar, yylength(), new Color(96, 96, 96)); }
\] { return textColor(yychar, yylength(), new Color(96, 96, 96)); }
"++" { return textColor(yychar, yylength(), new Color(96, 96, 96)); }
"--" { return textColor(yychar, yylength(), new Color(96, 96, 96)); }

\" [a-zA-Z0-9_.-]* \" {return textColor(yychar, yylength(), new Color(68, 196, 30));}

/* IDs */
{Identificador} {return textColor(yychar, yylength(), new Color(0, 0, 0));}

. { /* Ignorar */ }