//inicio import

import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
//fin de los import 

/**
 *
 * @author Ender Mosquera
 */
public class NoCompilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private String codigoIntermedio;
    private String codigoOptimizado;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private ArrayList<Production> ifProd;
    private ArrayList<Production> whileProd;
    private ArrayList<String> codObj;
    private ArrayList<String> codObjComp;
    private ArrayList<String> variables;

    private ArrayList<Production> funcProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;
    private ArrayList<Production> asigProd;
    private ArrayList<Production> asigProdConID;
    private ArrayList<Production> compaProdIzq;
    private ArrayList<Production> compaProdDer;
    private ArrayList<Production> compaProdDoble;
    private ArrayList<Production> operProdIzq;
    private ArrayList<Production> operProdDer;
    private ArrayList<Production> operProdDoble;

    private ArrayList<Production> identProdCopia;
    private ArrayList<Production> asigProdCopia;
    ArrayList<ArrayList<Token>> prods = new ArrayList<ArrayList<Token>>(); //para optimización, vienen de 

    /**
     * Creates new form Compilador
     */
    public NoCompilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "Compilador No Java :)";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".piel");
        addWindowListener(new WindowAdapter() {//cerrar ventana
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer(300, (ActionEvent e) -> {
            timerKeyReleased.stop();
            int posicion = jtpCode.getCaretPosition();
            jtpCode.setText(jtpCode.getText().replaceAll("[\r]+", ""));
            jtpCode.setCaretPosition(posicion);
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        ifProd = new ArrayList<>();
        whileProd = new ArrayList<>();
        asigProd = new ArrayList<>();
        asigProdConID = new ArrayList<>();
        compaProdIzq = new ArrayList<>();
        compaProdDer = new ArrayList<>();
        compaProdDoble = new ArrayList<>();
        operProdIzq = new ArrayList<>();
        operProdDer = new ArrayList<>();
        operProdDoble = new ArrayList<>();
        funcProd = new ArrayList<>();
        codObj = new ArrayList<>();
        codObjComp = new ArrayList<>();
        variables = new ArrayList<>();

        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        btnCompilar = new javax.swing.JButton();
        btnCompilar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        LabelTecNM = new javax.swing.JLabel();
        LabelITT = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane1.setViewportView(jtpCode);

        btnCompilar.setText("Nuevo");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnCompilar1.setText("Compilar");
        btnCompilar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilar1ActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Abrir");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCompilar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCompilar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompilar)
                    .addComponent(btnCompilar1)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Bauhaus 93", 1, 18)); // NOI18N
        jLabel2.setText("Compilador No java :) Karol - Ender - Javier ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        LabelTecNM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Logo TecNM.png"))); // NOI18N

        LabelITT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Logo ITT.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTecNM)
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(LabelITT)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelITT)
                    .addComponent(LabelTecNM)))
        );

        jLabel5.setFont(new java.awt.Font("Bauhaus 93", 1, 18)); // NOI18N
        jLabel5.setText("Tabla de Tokens");

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                    .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)))
                    .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //boton compilar
    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnCompilar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilar1ActionPerformed
        codObjComp.clear();
        variables.clear();
        compile();
    }//GEN-LAST:event_btnCompilar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public void archivoT(String ruta, String Objeto) {
        try {
            //String ruta = "D:\\Pollo\\Descargas\\COMPILADORES COMPAÑEROS\\MicroCompiler_09\\src\\MicroC\\codigoTres.txt";
            String contenido = Objeto;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//archivoT

    public void abrirarchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//fin_AbrirArchivo
    //inicio metodo compilar

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();

        printConsole();
        /*int resp = JOptionPane.showConfirmDialog(null, "¿Presentó algún Error?", "", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
        } else {
            codigoIntermedio();
        }*/

        //codigoIntermedio();
        codeHasBeenCompiled = true;
    } // fin metodo compilar
    //metodo analizador lexico

    private void lexicalAnalysis() {
        // Extraer tokens de la clase lexer
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    } // fin metodo analizador lexico

    //metodo analizador syntatico
    private void syntacticAnalysis() {
        //instancia de la clase  gramar para deficnir la gramatica recibe como parametro los teokens y los  errores
        Grammar gramatica = new Grammar(tokens, errors);
     
        /*error general*/
        gramatica.delete(new String[]{"ERROR"}, 1);

        /* DEFINIR GRAMATICA */
        //gramatica de un decimal
        gramatica.group("REAL", "NUMERO PUNTO NUMERO");

        // forma correcta de crear una operacion basica   
        gramatica.group("OPERACION", "REAL (SUMA|RESTA|MULTIPLICACION|DIVISION) REAL");
        gramatica.group("OPERACION", "REAL (SUMA|RESTA|MULTIPLICACION|DIVISION) NUMERO");
        gramatica.group("OPERACION", "REAL (SUMA|RESTA|MULTIPLICACION|DIVISION) ID");
        gramatica.group("OPERACION", "NUMERO (SUMA|RESTA|MULTIPLICACION|DIVISION) REAL");
        gramatica.group("OPERACION", "ID (SUMA|RESTA|MULTIPLICACION|DIVISION) NUMERO", operProdIzq);
        gramatica.group("OPERACION", "ID (SUMA|RESTA|MULTIPLICACION|DIVISION) REAL");
        gramatica.group("OPERACION", "NUMERO (SUMA|RESTA|MULTIPLICACION|DIVISION) NUMERO");
        gramatica.group("OPERACION", "NUMERO (SUMA|RESTA|MULTIPLICACION|DIVISION) ID", operProdDer);
        gramatica.group("OPERACION", "ID (SUMA|RESTA|MULTIPLICACION|DIVISION) NUMERO", operProdIzq);
        gramatica.group("OPERACION", "ID (SUMA|RESTA|MULTIPLICACION|DIVISION) ID", operProdDoble);
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) REAL");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) NUMERO");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) ID", operProdDer);
        gramatica.group("OPERACION", "REAL (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "NUMERO (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "ID (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION", operProdIzq);
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        gramatica.group("OPERACION", "OPERACION (SUMA|RESTA|MULTIPLICACION|DIVISION) OPERACION");
        //ERRORES operacion
        gramatica.group("OPERACION_ER", "NUMERO (SUMA|RESTA|MULTIPLICACION|DIVISION)", 2, "ERROR_SINTACTICO: se necesita un minimo de 2 valores para ralizar la operacion [#, %]");
        gramatica.group("OPERACION_ER", "(SUMA|RESTA|MULTIPLICACION|DIVISION) NUMERO", 2, "ERROR SINTACTICO: se necesita un minimo de 2 valores para ralizar la operacion [#, %]");
        gramatica.group("OPERACION_ER", "ID (SUMA|RESTA|MULTIPLICACION|DIVISION)", 2, "ERROR SINTACTICO: se necesita un minimo de 2 valores para ralizar la operacion [#, %]");
        gramatica.group("OPERACION_ER", "(SUMA|RESTA|MULTIPLICACION|DIVISION) ID", 2, "ERROR SINTACTICO: se necesita un minimo de 2 valores para ralizar la operacion [#, %]");

        //FORMA CORRECTA DE DECLARAR UNA VARIABLE------------------------------------------------------------
        gramatica.group("DECL_FLOTANTE", "FLOTANTE ID PUNTOCOMA", identProd);
        gramatica.group("DECL_FLOTANTE", "FLOTANTE ID ASIGNACION ID PUNTOCOMA", identProd);
        gramatica.group("DECL_FLOTANTE", "FLOTANTE ID ASIGNACION REAL PUNTOCOMA", identProd);
        gramatica.group("DECL_FLOTANTE", "FLOTANTE ID ASIGNACION OPERACION PUNTOCOMA", identProd);

        gramatica.group("DECL_ENTERO", "ENTERO ID PUNTOCOMA", identProd);
        gramatica.group("DECL_ENTERO", "ENTERO ID ASIGNACION ID PUNTOCOMA", identProd);
        gramatica.group("DECL_ENTERO", "ENTERO ID ASIGNACION NUMERO PUNTOCOMA", identProd);
        gramatica.group("DECL_ENTERO", "ENTERO ID ASIGNACION OPERACION PUNTOCOMA", identProd);
        gramatica.group("DECL_ENTERO", "ID PARENTESISABIERTO ENTERO ID PARENTESISCERRADO", identProd);
        gramatica.group("DECL_ID", "PARENTESISABIERTO ID PARENTESISCERRADO", 2, "ERROR SINTACTICO: NO SE HA DEFINIDO EL TIPO [#, %]");
        //gramatica.group("DECL_ID", "ID PARENTESISCERRADO", 2, "ERROR_SINTACTICO: FALTA PARENTESIS ABIERTO [#, %]"); volver a colocar
        //DEFINIR GRAMATICA DE LOS METODOS y CLASES
        gramatica.group("CLASE", "CLASE ID LLAVEABIERTO METODO LLAVECERRADO");

        gramatica.group("METODO", "TIPO ID PARENTESISABIERTO PARENTESISCERRADO LLAVEABIERTO LLAVECERRADO");
        gramatica.group("METODO", "TIPO ID PARENTESISABIERTO PARAMETROS PARENTESISCERRADO LLAVEABIERTO LLAVECERRADO");

        gramatica.group("PARAMETROS", "TIPO ID");
        gramatica.group("PARAMETROS", "TIPO ID COMA PARAMETROS");

        gramatica.group("TIPO", "ENTERO");
        gramatica.group("TIPO", "FLOTANTE");
        gramatica.group("TIPO", "VOID");
        gramatica.group("TIPO", "CLASE");
        gramatica.group("TIPO", "PUBLIC");

        // ERRORES EN EL LOS METODOS
        //gramatica.group("ERROR_METO", "PUBLIC|PRIVATE VOID PARENTESISABIERTO ID PARENTESISCERRADO", 1 ,"ERROR_SINTACTICO: ID NO SE ESPERA EN ESA POSICION: [#,%]");
        //gramatica.group("ERROR_METO", "PUBLIC|PRIVATE VOID PARENTESISABIERTO PARENTESISCERRADO", 2 ,"ERROR_SINTACTICO: NO HAY ID: [#,%]");
        //gramatica.group("ERROR_METO", "PUBLIC|LLAVEABIERTO PRIVATE VOID PARENTESISABIERTO PARENTESISCERRADO LLAVECERRADA", 2 ,"ERROR_SINTACTICO: LLAVE MAL ABIERTA [#,%]");
        // gramatica.group("ERROR_METO", "PUBLIC|VOID PARENTESISABIERTO PARENTESISCERRADO", 2 ,"ERROR_SINTACTICO: FALTA IDENTIFICADOR: [#,%]");
        //DEFINIR GRAMATICA DE LOS METODOS y CLASES
        gramatica.group("CLASE", "CLASE ID LLAVEABIERTO METODO LLAVECERRADO");
        gramatica.group("CLASE", "PUBLIC CLASE ID LLAVEABIERTO METODO LLAVECERRADO");
        gramatica.group("METODO", "TIPO ID PARENTESISABIERTO PARENTESISCERRADO LLAVEABIERTO LLAVECERRADO");
        gramatica.group("METODO", "TIPO ID PARENTESISABIERTO PARAMETROS PARENTESISCERRADO LLAVEABIERTO LLAVECERRADO");

        gramatica.group("PARAMETROS", "TIPO ID");
        gramatica.group("PARAMETROS", "TIPO ID COMA PARAMETROS");

        gramatica.group("TIPO", "ENTERO");
        gramatica.group("TIPO", "FLOTANTE");
        gramatica.group("TIPO", "VOID");
        gramatica.group("TIPO", "CLASE");
        gramatica.group("TIPO", "PRIVATE");

        // ERRORES EN EL LOS METODO
        gramatica.group("CLASE", "ID LLAVEABIERTO METODO LLAVECERRADO", 1, "ERROR_SINTACTICO: Se espera la palabra clave 'class' [#, %]");
        gramatica.group("METODO", "ID PARENTESISABIERTO PARENTESISCERRADO LLAVEABIERTO LLAVECERRADO", 2, "ERROR_SINTACTICO: Falta el tipo de retorno del método [#, %]");
        gramatica.group("METODO", "TIPO PARENTESISABIERTO PARENTESISCERRADO LLAVEABIERTO LLAVECERRADO", 2, "ERROR_SINTACTICO: Falta el identificador del método [#, %]");
        gramatica.group("METODO", "TIPO ID LLAVEABIERTO LLAVECERRADO", 2, "ERROR_SINTACTICO: Falta el bloque de paréntesis en la declaración del método [#, %]");
        gramatica.group("METODO", "TIPO ID PARENTESISABIERTO LLAVEABIERTO LLAVECERRADO", 2, "ERROR_SINTACTICO: Falta la lista de parámetros del método [#, %]");

        gramatica.group("PARAMETROS", "ID COMA PARAMETROS", 2, "ERROR_SINTACTICO: Falta el tipo de un parámetro [#, %]");
        gramatica.group("PARAMETROS", "TIPO COMA PARAMETROS", 2, "ERROR_SINTACTICO: Falta el identificador de un parámetro [#, %]");

        //gramatica.group("TIPO", "ID ", 2, "ERROR_SINTACTICO: Tipo no reconocido [#, %]"); volver a aplicar
        // BOLEAN
        gramatica.group("DECL_BOOL", "BOOLEANO ID PUNTOCOMA", identProd);
        gramatica.group("DECL_BOOL", "BOOLEANO ID ASIGNACION ID PUNTOCOMA", identProd);
        gramatica.group("DECL_BOOL", "BOOLEANO ID ASIGNACION (TRUE|FALSE) PUNTOCOMA", identProd);

        gramatica.group("DECL_PRIVATE", "PRIVATE ID PUNTOCOMA", identProd);
        gramatica.group("ERROR_PRIVATE", "PRIVATE PUNTOCOMA ", 2, "ERROR_SENTEROATICO NO SE HA DECLARADO EL ID [#,%]");
        gramatica.group("ERROR_PRIVATE", "PRIVATE ID", 2, "ERROR_SENTEROATICO FALTA EL PUNTO Y COMA [#,%]");
        gramatica.group("DECL_TEXTO", "TEXTO ID PUNTOCOMA", identProd);
        gramatica.group("DECL_TEXTO", "TEXTO ID ASIGNACION ID PUNTOCOMA", identProd);
        gramatica.group("DECL_TEXTO", "TEXTO ID ASIGNACION CADENA PUNTOCOMA", identProd);
        gramatica.group("DECL_TEXTO", "TEXTO ID PUNTOCOMA", identProd);
        gramatica.group("DECL_TEXTO", "PRIVATE TEXTO ID PUNTOCOMA", identProd);
        //FORMA CORRECTA DE DECLARAR UN METODO VACIO
        gramatica.group("DECL_TEXTO", "TEXTO ID PARENTESISABIERTO PARENTESISCERRADO LLAVEABIERTO LLAVECERRADO", identProd);
        //PARAMETRO DE LA CLASE
        gramatica.group("DECL_CLASE", "PRIVATE|PUBLIC ID PUNTOCOMA", identProd);
        //POSIBLE ERROR
        gramatica.group("ERROR_CLASE", "PRIVATE|PUBLIC ID ", 3, "ERROR_SINTACTICO FALTA EL PUNTO Y COMA  [#, %]");
        //ERRORES SINTACTICOS---------------------------------------------------------------------------
        //POSIBLES ERRORES AL DECLARAR UNA VARIABLE ENTERO O FLOTANTE  
        gramatica.group("DECL_ENTERO", "ENTERO ID ASIGNACION PUNTOCOMA", 2, "ERROR_SINTACTICO: FALTA ASIGNAR UN VALOR A LA VARIABLE [#, %]");
        gramatica.group("DECL_ENTERO", "ENTERO ID NUMERO PUNTOCOMA", 2, "ERROR_SINTACTICO: FALTA DEL TOKEN DE ASIGNACION EN LA DECLARACION [#, %]");
        gramatica.group("DECL_ENTERO", "ENTERO ID ID PUNTOCOMA", 2, "ERROR_SINTACTICO: FALTA DEL TOKEN DE ASIGNACION EN LA DECLARACION [#, %]");
        gramatica.group("DECL_ENTERO", "ENTERO ID NUMERO", 2, "ERROR_SINTACTICO: FALTA DEL TOKEN DE ASIGNACION EN LA DECLARACION [#, %]");
        gramatica.group("DECL_ENTERO", "ENTERO ID ID", 2, "ERROR_SINTACTICO: FALTA DEL TOKEN DE ASIGNACION EN LA DECLARACION [#, %]");
        gramatica.group("DECL_ENTERO", "ENTERO ID OPERACION PUNTOCOMA", 2, "ERROR_SINTACTICO: FALTA DEL TOKEN DE ASIGNACION EN LA DECLARACION [#, %]");
        gramatica.group("DECL_ENTERO", "ENTERO ID OPERACION", 2, "ERROR_SINTACTICO: FALTA DEL TOKEN DE ASIGNACION EN LA DECLARACION [#, %]");
        gramatica.group("DECL_ENTERO", "ENTERO ID ASIGNACION ID", 2, "ERROR_SINTACTICO: PUNTOCOMA(;) NO AGREGADO EN LA DECLARACION [#, %]");
        gramatica.group("DECL_ENTERO", "ENTERO ID ASIGNACION REAL", 2, "ERROR_SINTACTICO: VALOR NO ENTERO [#, %]");

        //gramatica.group("DECL_ENTERO", "ENTERO ID ASIGNACION NUMERO",2,"ERROR_SINTACTICO: PUNTOCOMA(;) NO AGREGADO EN LA DECLARACION [#, %]");
        gramatica.group("DECL_ENTERO", "ENTERO ID ASIGNACION OPERACION", 2, "ERROR_SINTACTICO: PUNTOCOMA(;) NO AGREGADO EN LA DECLARACION [#, %]");
        gramatica.group("DECL_ENTERO", "ENTERO  ASIGNACION NUMERO PUNTOCOMA", 2, "ERROR_SINTACTICO: ID NO AGREGADO EN LA DECLARACION [#, %]");
        gramatica.group("DECL_ENTERO", "ENTERO  ASIGNACION ID PUNTOCOMA", 2, "ERROR_SINTACTICO: ID NO AGREGADO EN LA DECLARACION [#, %]");
        gramatica.group("DECL_ENTERO", "ENTERO  ASIGNACION OPERACION PUNTOCOMA", 2, "ERROR_SINTACTICO: ID NO AGREGADO EN LA DECLARACION [#, %]");

        //POSIBLES ERRORES AL DECLARAR UN FLOTANTE
        gramatica.group("DECL_FLOTANTE", "FLOTANTE ID ASIGNACION PUNTOCOMA", 2, "ERROR_SINTACTICO: FALTA ASIGNAR UN VALOR A LA VARIABLE [#, %]");
        gramatica.group("DECL_FLOTANTE", "FLOTANTE ID REAL PUNTOCOMA", 2, "ERROR_SINTACTICO: FALTA DEL TOKEN DE ASIGNACION EN LA DECLARACION [#, %]");
        gramatica.group("DECL_FLOTANTE", "FLOTANTE ID REAL", 2, "ERROR_SINTACTICO: FALTA DEL TOKEN DE ASIGNACION EN LA DECLARACION [#, %]");
        gramatica.group("DECL_FLOTANTE", "FLOTANTE ID ASIGNACION REAL", 2, "ERROR_SINTACTICO: PUNTOCOMA(;) NO AGREGADO EN LA DECLARACION [#, %]");
        gramatica.group("DECL_FLOTANTE", "FLOTANTE ASIGNACION REAL PUNTOCOMA", 2, "ERROR_SINTACTICO: ID NO AGREGADO EN LA DECLARACION [#, %]");
        gramatica.group("DECL_FLOTANTE", "FLOTANTE ID ASIGNACION NUMERO PUNTOCOMA", 2, "Error sintáctico: Valor float sin punto decimal [#, %]");

        //POSIBLES ERRORES AL DECLARAR UN TEXTO
        gramatica.group("DECL_TEXTO", "TEXTO ID ASIGNACION PUNTOCOMA", 2, "ERROR_SINTACTICO: FALTA ASIGNAR UN VALOR A LA VARIABLE [#, %]");
        gramatica.group("DECL_TEXTO", "TEXTO ID CADENA PUNTOCOMA", 2, "ERROR_SINTACTICO: FALTA DEL TOKEN DE ASIGNACION EN LA DECLARACION [#, %]");
        gramatica.group("DECL_TEXTO", "TEXTO ID CADENA", 2, "ERROR_SINTACTICO: FALTA DEL TOKEN DE ASIGNACION EN LA DECLARACION [#, %]");
        gramatica.group("DECL_TEXTO", "TEXTO ID ASIGNACION CADENA", 2, "ERROR_SINTACTICO: PUNTOCOMA(;) NO AGREGADO EN LA DECLARACION [#, %]");
        gramatica.group("DECL_TEXTO", "TEXTO ASIGNACION CADENA PUNTOCOMA", 2, "ERROR_SINTACTICO: ID NO AGREGADO EN LA DECLARACION [#, %]");
        gramatica.group("DECL_TEXTO", "TEXTO  PUNTOCOMA", 2, "ERROR_SINTACTICO: FALTA EL ID [#, %]");
        gramatica.group("DECL_TEXTO", "TEXTO  ID", 2, "ERROR_SINTACTICO: FALTA EL PUNTO Y COMA [#, %]");
        //ERRORES SEMANTICOS DE VARIABLES -------------------------------------------------------------
        gramatica.group("RESERV_INDEB", "(TEXTO|ENTERO|FLOTANTE|BOOLEANO) (IMPORT|DEF|CLASE|IF|ELSE|FOR|IN|MIENTRAS|RETURN)", 2, "ERROR SEMANTICO \\{}: USO INDEBIDO DE PALABRAS RESERVADAS [#,%]");

        gramatica.group("ERROR_OP_TEXTO", "(SUMA|RESTA|MULTIPLICACION|DIVISION) CADENA", 2, "ERROR SEMANTICO \\{}: OPERACION NO PERMITIDA PARA CADENA [#,%]");
        gramatica.group("ERROR_OP_TEXTO", "CADENA (SUMA|RESTA|MULTIPLICACION|DIVISION)", 2, "ERROR SEMANTICO \\{}: OPERACION NO PERMITIDA PARA CADENA [#,%]");
        gramatica.group("ERROR_OP_BOOLEANO", "(SUMA|RESTA|MULTIPLICACION|DIVISION) (TRUE|FALSE)", 2, "ERROR SEMANTICO \\{}: OPERACION NO PERMITIDA PARA BOOLEANOO [#,%]");
        gramatica.group("ERROR_OP_BOOLEANO", "(TRUE|FALSE) (SUMA|RESTA|MULTIPLICACION|DIVISION)", 2, "ERROR SEMANTICO \\{}: OPERACION NO PERMITIDA PARA BOOLEANOO [#,%]");

        gramatica.group("DECL_ENTERO", "(ENTERO ID ASIGNACION REAL PUNTOCOMA)", 2, "ERROR SEMANTICO \\{}: VALOR ASIGNADO NO ES ENTERO [#,%]");
        gramatica.group("DECL_ENTERO", "(ENTERO ID ASIGNACION CADENA)", 2, "ERROR SEMANTICO \\{}: VALOR ASIGNADO NO ES ENTERO [#,%]");
        gramatica.group("DECL_ENTERO", "(ENTERO ID ASIGNACION (TRUE|FALSE))", 2, "ERROR SEMANTICO \\{}: VALOR ASIGNADO NO ES ENTERO [#,%]");
        gramatica.group("DECL_ENTERO", "ENTERO", 2, "ERROR");

        gramatica.group("DECL_FLOTANTE", "(FLOTANTE ID ASIGNACION CADENA)", 2, "ERROR SEMANTICO \\{}: VALOR ASIGNADO NO ES DECIMAL [#,%]");
        gramatica.group("DECL_FLOTANTE", "(FLOTANTE ID ASIGNACION (TRUE|FALSE))", 2, "ERROR SEMANTICO \\{}: VALOR ASIGNADO NO ES DECIMAL [#,%]");
        gramatica.group("DECL_FLOTANTE", "(FLOTANTE ID ASIGNACION NUMERO PUNTOCOMA)", 2, "ERROR SEMANTICO \\{}: VALOR ASIGNADO NO ES DECIMAL [#,%]");
        gramatica.group("ERROR_FLOTANTE", "FLOTANTE", 2, "ERROR");

        gramatica.group("DECL_TEXTO", "(TEXTO ID ASIGNACION NUMERO)", 2, "ERROR SEMANTICO \\{}: VALOR ASIGNADO NO ES CADENA [#,%]");
        gramatica.group("DECL_TEXTO", "(TEXTO ID ASIGNACION (TRUE|FALSE))", 2, "ERROR SEMANTICO \\{}: VALOR ASIGNADO NO ES CADENA [#,%]");
        gramatica.group("DECL_TEXTO", "TEXTO ID", 2, "ERROR SINTACTICO : FALTA ASIGNAR EL ID [#, %] ");

        gramatica.group("ERROR_ASIG_BOOL", "(BOOLEANO ID ASIGNACION NUMERO)", 2, "ERROR SEMANTICO \\{}: VALOR ASIGNADO NO ES BOOLEANOO [#,%]");
        gramatica.group("ERROR_ASIG_BOOL", "(BOOLEANO ID ASIGNACION (TRUE|FALSE))", 2, "ERROR SEMANTICO \\{}: VALOR ASIGNADO NO ES BOOLEANOO [#,%]");
        gramatica.group("ERROR_ASIG_BOOL", "(BOOLEANO ID ASIGNACION CADENA)", 2, "ERROR SEMANTICO \\{}: VALOR ASIGNADO NO ES BOOLEANOO [#,%]");

        //ASIGNACION DE UN ID
        gramatica.group("PROD_ASIG", "ID ASIGNACION (CADENA|REAL|NUMERO|TRUE|FALSE) PUNTOCOMA", asigProd);
        gramatica.group("PROD_ASIG", "ID ASIGNACION OPERACION PUNTOCOMA", asigProd);
        gramatica.group("PROD_ASIG_ID", "ID ASIGNACION ID PUNTOCOMA", asigProdConID);

        //--------------------------------------------------------------------------------------------
        //-------------CONDICION--------------------------
        //FORMAS CORRECTAS DE CREAR UNA CONDICION
        gramatica.group("CONDICION", "NUMERO (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) NUMERO");
        gramatica.group("CONDICION", "NUMERO (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) OPERACION");
        gramatica.group("CONDICION", "REAL (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) OPERACION");

        gramatica.group("CONDICION", "REAL (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) NUMERO");
        gramatica.group("CONDICION", "NUMERO (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) REAL");
        gramatica.group("CONDICION", "REAL (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) REAL");
        gramatica.group("CONDICION", "(TRUE|FALSE) (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) (TRUE|FALSE)");
        gramatica.group("CONDICION", "NUMERO (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) ID", compaProdDer);
        gramatica.group("CONDICION", "REAL (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) ID", compaProdDer);
        gramatica.group("CONDICION", "ID (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) NUMERO", compaProdIzq);
        gramatica.group("CONDICION", "ID (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) OPERACION", compaProdIzq);
        gramatica.group("CONDICION", "ID (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) REAL", compaProdIzq);
        gramatica.group("CONDICION", "ID (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) ID", compaProdDoble);
        gramatica.group("CONDICION", "(TRUE|FALSE) (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) ID", compaProdDer);
        gramatica.group("CONDICION", "ID (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) (TRUE|FALSE)", compaProdIzq);

        gramatica.group("CONDICION", "CONDICION (AND|OR) CONDICION");

        //ERRORES SEMANTICOS
        gramatica.group("CONDICION", "NUMERO (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) CADENA", 2, "ERROR_SEMANTICO \\{}: DATOS INCOMPATIBLES PARA SU COMPARACION [#, %]");
        gramatica.group("CONDICION", "REAL (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) CADENA", 2, "ERROR_SEMANTICO \\{}: DATOS INCOMPATIBLES PARA SU COMPARACION [#, %]");
        gramatica.group("CONDICION", "CADENA (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) NUMERO", 2, "ERROR_SEMANTICO \\{}: DATOS INCOMPATIBLES PARA SU COMPARACION [#, %]");
        gramatica.group("CONDICION", "CADENA (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) REAL", 2, "ERROR_SEMANTICO \\{}: DATOS INCOMPATIBLES PARA SU COMPARACION [#, %]");
        gramatica.group("CONDICION", "NUMERO (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) (TRUE|FALSE)", 2, "ERROR_SEMANTICO \\{}: DATOS INCOMPATIBLES PARA SU COMPARACION [#, %]");
        gramatica.group("CONDICION", "REAL (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) (TRUE|FALSE)", 2, "ERROR_SEMANTICO \\{}: DATOS INCOMPATIBLES PARA SU COMPARACION [#, %]");

        //----------------------------------------------------------------------------------------------
        //----------------MIENTRAS Y IF-----------------------
        //FORMAS CORRECTAS DE DECLARAR UN IF
        gramatica.group("INSTR_SI", "SI PARENTESISABIERTO CONDICION PARENTESISCERRADO LLAVEABIERTO", true, ifProd);
        //FORMAS CORRECTAS DE DECLARAR UN MIENTRAS
        gramatica.group("INSTR_MIENTRAS", "MIENTRAS PARENTESISABIERTO CONDICION PARENTESISCERRADO LLAVEABIERTO", whileProd);
        //POSIBLES ERRORES AL DECLARAR UN IF
        gramatica.group("INSTR_SI", "SI PARENTESISABIERTO PARENTESISCERRADO LLAVEABIERTO", true, 4, "ERROR_SINTACTICO: FALTA LA CONDICION [#, %]");
        gramatica.group("INSTR_SI", "SI CONDICION PARENTESISCERRADO LLAVEABIERTO", true, 4, "ERROR_SINTACTICO: FALTA EL PARENTESIS ABIERTO EN LA CONDICION [#, %]");
        gramatica.group("INSTR_SI", "SI PARENTESISABIERTO CONDICION PARENTESISCERRADO", true, 4, "ERROR_SINTACTICO: FALTA DE LLAVE DE APERTURA [#, %]");
        gramatica.finalLineColumn();
        gramatica.group("INSTR_SI", "SI PARENTESISABIERTO CONDICION", true, 4, "ERROR_SINTACTICO: ERROR EN LA CONDICION O FALTA DEL PARENTESIS [#, %]");
        gramatica.initialLineColumn();
        gramatica.group("INSTR_SI", "SI", 2, "ERROR_SENTEROATICO : ERROR SI");

        //POSIBLES ERRORES DE MIENTRAS
        gramatica.group("INSTR_MIENTRAS", "MIENTRAS PARENTESISABIERTO PARENTESISCERRADO", true, 4, "ERROR_SINTACTICO: FALTA LA CONDICION [#, %]");
        gramatica.group("INSTR_MIENTRAS", "MIENTRAS CONDICION PARENTESISCERRADO", true, 4, "ERROR_SINTACTICO: FALTA EL PARENTESIS ABIERTO EN LA CONDICION [#, %]");
        gramatica.group("INSTR_MIENTRAS", "MIENTRAS PARENTESISABIERTO CONDICION PARENTESISCERRADO", true, 4, "ERROR_SINTACTICO: FALTA DE LLAVE DE APERTURA [#, %]");
        gramatica.finalLineColumn();
        gramatica.group("INSTR_MIENTRAS", "MIENTRAS PARENTESISABIERTO CONDICION", true, 4, "ERROR_SINTACTICO: ERROR EN LA CONDICION O FALTA DEL PARENTESIS [#, %]");
        gramatica.initialLineColumn();
        gramatica.group("INSTR_MIENTRAS", "MIENTRAS", 2, "ERROR MIENTRAS");
        //POSIBLES ERRORES EN LAS CODICIONES
        gramatica.group("CONDICION", "NUMERO (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) ", 2, "ERROR_SINTACTICO: ERROR EN LA CONDICION [#, %]");
        gramatica.group("CONDICION", "ID (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) ", 2, "ERROR_SINTACTICO: ERROR EN LA CONDICION [#, %]");
        gramatica.group("CONDICION", " (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) NUMERO ", 2, "ERROR_SINTACTICO: ERROR EN LA CONDICION [#, %]");
        gramatica.group("CONDICION", " (IGUAL|DIFERENTE|MAYORQUE|MENORQUE|MAYORIGUALQUE|MENORIGUALQUE) ID ", 2, "ERROR_SINTACTICO: ERROR EN LA CONDICION [#, %]");
        gramatica.group("CONDICION", "CONDICION (AND|OR)", 2, "ERROR_SINTACTICO: ERROR EN LA CONDICION [#, %]");

        gramatica.show();
    } //fin metodo analizador syntactico

    //inicio metodo analizador semantico
    private void semanticAnalysis() {
        HashMap<String, String> tiposDatos = new HashMap<>();
        tiposDatos.put("NUMERO", "ENTERO");
        tiposDatos.put("REAL", "FLOTANTE");
        tiposDatos.put("REAL", "DECIMAL");
        tiposDatos.put("CADENA", "TEXTO");
        tiposDatos.put("TRUE", "BOOLEANO");
        tiposDatos.put("FALSE", "BOOLEANO");
        int i = 0;
        for (Production id : identProd) {

            if (!identificadores.containsKey(id.lexemeRank(1))) {
                identificadores.put(id.lexemeRank(1), id.lexicalCompRank(0));
                i++;
            } else {
                errors.add(new ErrorLSSL(1, "Error semántico: Ya existe un identificador llamado " + id.lexemeRank(1), id, true));
            }

        }
        System.out.println(Arrays.asList(identificadores)); // muestra identificadores
        for (Production id : asigProd) {
            if (!identificadores.containsKey(id.lexemeRank(0))) {
                errors.add(new ErrorLSSL(1, "Error semántico: Variable \"" + id.lexemeRank(0) + "\" no declarada. [#, %]", id, true));
            } else {
                if (!identificadores.get(id.lexemeRank(0)).equals(tiposDatos.get(id.lexicalCompRank(2)))) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(0) + "\" es de tipo " + identificadores.get(id.lexemeRank(0)) + " [#, %]", id, true));

                }
            }

        }
        for (Production id : asigProdConID) {
            if (!identificadores.containsKey(id.lexemeRank(0)) || !identificadores.containsKey(id.lexemeRank(2))) {
                errors.add(new ErrorLSSL(1, "Error semántico: Variable no declarada. [#, %]", id, true));
            } else {
                if (!identificadores.get(id.lexemeRank(0)).equals(identificadores.get(id.lexemeRank(2)))) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(0) + "\" es de tipo " + identificadores.get(id.lexemeRank(0)) + " [#, %]", id, true));

                }
            }

        }
        //comparacion cuando ID está en la izquierda
        for (Production id : compaProdIzq) {

            if (!identificadores.containsKey(id.lexemeRank(0))) {
                errors.add(new ErrorLSSL(1, "Error semántico: Variable " + id.lexemeRank(0) + " no declarada. [#, %]", id, true));
            } else {
                if (identificadores.get(id.lexemeRank(0)).matches("TEXTO")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(0) + "\" es de tipo TEXTO, imposible comparar [#, %]", id, true));
                }
                if (identificadores.get(id.lexemeRank(0)).matches("BOOLEANO") && !id.lexicalCompRank(1).matches("IGUAL|DIFERENTE")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(0) + "\" es de tipo BOOLEANO, sólo posible comparar con operadores IGUAL y DIFERENTE [#, %]", id, true));
                }
                if (identificadores.get(id.lexemeRank(0)).matches("BOOLEANO") && !id.lexicalCompRank(2).matches("VERDADERO|FALSO")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(0) + "\" es de tipo BOOLEANO, sólo posible comparar con valores booleanos [#, %]", id, true));
                }
                if (identificadores.get(id.lexemeRank(0)).matches("ENTERO|FLOTANTE")) {
                    if (!id.lexicalCompRank(2).matches("NUMERO|REAL|ID")) {
                        errors.add(new ErrorLSSL(1, "Error semántico : Valor numérico de variable \"" + id.lexemeRank(0) + "\" no se puede comparar con valor no numérico [#, %]", id, true));
                    }
                }

            }

        }// FOR  COMPAPRODIZQ

        for (Production id : compaProdDer) {

            if (!identificadores.containsKey(id.lexemeRank(2))) {
                errors.add(new ErrorLSSL(1, "Error semántico: Variable " + id.lexemeRank(2) + " no declarada. [#, %]", id, true));
            } else {
                if (identificadores.get(id.lexemeRank(2)).matches("TEXTO")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(2) + "\" es de tipo TEXTO, imposible comparar [#, %]", id, true));
                }
                if (identificadores.get(id.lexemeRank(2)).matches("BOOLEANO") && !id.lexicalCompRank(1).matches("IGUAL|DIFERENTE")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(2) + "\" es de tipo BOOLEANO, sólo posible comparar con operadores IGUAL y DIFERENTE [#, %]", id, true));
                }
                if (identificadores.get(id.lexemeRank(2)).matches("BOOLEANO") && !id.lexicalCompRank(0).matches("VERDADER|FALSO")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(2) + "\" es de tipo BOOLEANO, sólo posible comparar con valores booleanos [#, %]", id, true));
                }
                if (identificadores.get(id.lexemeRank(2)).matches("ENTERO|FLOTANTE")) {
                    if (!id.lexicalCompRank(0).matches("NUMERO|REAL")) {
                        errors.add(new ErrorLSSL(1, "Error semántico : Valor numérico de variable \"" + id.lexemeRank(2) + "\" no se puede comparar con valor no numérico [#, %]", id, true));
                    }
                }

            }

        }// FOR  COMPAPRODDER
        for (Production id : compaProdDoble) {

            if (!identificadores.containsKey(id.lexemeRank(0)) || !identificadores.containsKey(id.lexemeRank(2))) {
                errors.add(new ErrorLSSL(1, "Error semántico: Variable " + id.lexemeRank(0) + " no declarada. [#, %]", id, true));
            } else {
                if (identificadores.get(id.lexemeRank(0)).matches("TEXTO") || identificadores.get(id.lexemeRank(2)).matches("TEXTO")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(0) + "\" es de tipo TEXTO, imposible comparar [#, %]", id, true));
                }
                if (identificadores.get(id.lexemeRank(0)).matches("BOOLEANO") && !id.lexicalCompRank(1).matches("IGUAL|DIFERENTE")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(0) + "\" es de tipo BOOLEANO, sólo posible comparar con operadores IGUAL y DIFERENTE [#, %]", id, true));
                }
                if (identificadores.get(id.lexemeRank(2)).matches("BOOLEANO") && !id.lexicalCompRank(1).matches("IGUAL|DIFERENTE")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(2) + "\" es de tipo BOOLEANO, sólo posible comparar con operadores IGUAL y DIFERENTE [#, %]", id, true));
                }
                if (identificadores.get(id.lexemeRank(0)).matches("BOOLEANO") && !identificadores.get(id.lexemeRank(2)).matches("BOOLEANO")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(0) + "\" es de tipo BOOLEANO, sólo posible comparar con valores booleanos [#, %]", id, true));
                }
                if (identificadores.get(id.lexemeRank(2)).matches("BOOLEANO") && !identificadores.get(id.lexemeRank(0)).matches("BOOLEANO")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(2) + "\" es de tipo BOOLEANO, sólo posible comparar con valores booleanos [#, %]", id, true));
                }
                if (identificadores.get(id.lexemeRank(0)).matches("ENTERO|FLOTANTE")) {
                    if (!identificadores.get(id.lexemeRank(2)).matches("ENTERO|FLOTANTE")) {
                        errors.add(new ErrorLSSL(1, "Error semántico : Valor numérico de variable \"" + id.lexemeRank(0) + "\" no se puede comparar con valor no numérico [#, %]", id, true));
                    }
                }
                if (identificadores.get(id.lexemeRank(2)).matches("ENTERO|FLOTANTE")) {
                    if (!identificadores.get(id.lexemeRank(0)).matches("ENTERO|FLOTANTE")) {
                        errors.add(new ErrorLSSL(1, "Error semántico : Valor numérico de variable \"" + id.lexemeRank(0) + "\" no se puede comparar con valor no numérico [#, %]", id, true));
                    }
                }

            }

        }// FOR  COMPAPRODdoble
        for (Production id : operProdIzq) {

            if (!identificadores.containsKey(id.lexemeRank(0))) {
                errors.add(new ErrorLSSL(1, "Error semántico: Variable " + id.lexemeRank(0) + " no declarada. [#, %]", id, true));
            } else {
                if (identificadores.get(id.lexemeRank(0)).matches("TEXTO|BOOLEANO")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(0) + "\" es de tipo " + identificadores.get(id.lexemeRank(0)) + ", imposible hacer operaciones aritméticas [#, %]", id, true));
                }

            }
            if (identificadores.get(id.lexemeRank(0)).matches("ENTERO") && id.lexicalCompRank(1).matches("DIVISION")) {
                errors.add(new ErrorLSSL(1, "Error semántico : División en valor entero [#, %]", id, true));
            }
        }// FOR  OPERPRODIZQ
        for (Production id : operProdDer) {

            if (!identificadores.containsKey(id.lexemeRank(2))) {
                errors.add(new ErrorLSSL(1, "Error semántico: Variable " + id.lexemeRank(2) + " no declarada. [#, %]", id, true));
            } else {
                if (identificadores.get(id.lexemeRank(2)).matches("TEXTO|BOOLEANO")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(2) + "\" es de tipo " + identificadores.get(id.lexemeRank(0)) + ", imposible hacer operaciones aritméticas [#, %]", id, true));
                }

            }

        }// FOR  OPERPRODDER
        for (Production id : operProdDoble) {

            if (!identificadores.containsKey(id.lexemeRank(0)) || !identificadores.containsKey(id.lexemeRank(2))) {
                errors.add(new ErrorLSSL(1, "Error semántico: Variable " + id.lexemeRank(0) + " no declarada. [#, %]", id, true));
            } else {
                if (identificadores.get(id.lexemeRank(0)).matches("TEXTO|BOOLEANO") || identificadores.get(id.lexemeRank(2)).matches("TEXTO|BOOLEANO")) {
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(0) + "\" es de tipo " + identificadores.get(id.lexemeRank(0)) + ", imposible hacer operaciones aritméticas [#, %]", id, true));
                    errors.add(new ErrorLSSL(1, "Error semántico : Variable \"" + id.lexemeRank(2) + "\" es de tipo " + identificadores.get(id.lexemeRank(2)) + ", imposible hacer operaciones aritméticas [#, %]", id, true));

                }

            }

        }// FOR  OPERPRODDOBLE
    } // fin metodo analizador semantico

    private void codigoIntermedio() {
        ArrayList<Token> toks = new ArrayList<Token>();
        codigoIntermedio = ("--Código intermedio--\n");
        int temp;
        //revisa las declaraciones
        for (Production id : identProd) {
            temp = 1;
            if (id.lexicalCompRank(2).equals("ASIGNACION") && id.getSizeTokens() > 5) {
                codigoIntermedio = codigoIntermedio + ("\n\n=============================\n" + id.lexemeRank(0, -1) + "\n=============================");
                codObj.add("\n\n=============================\n;" + id.lexemeRank(0, -1) + "\n=============================");

                toks = id.getTokens();
                for (int i = 0; i < toks.size(); i++) {
                    if (toks.get(i).getLexeme().equals("*") || toks.get(i).getLexeme().equals("/")) {
                        i--;
                        codigoIntermedio = codigoIntermedio + ("\nT" + temp + " = " + toks.get(i).getLexeme() + toks.get(i + 1).getLexeme() + toks.get(i + 2).getLexeme());

                        codObj.add("\nT" + temp + " = " + toks.get(i).getLexeme() + toks.get(i + 1).getLexeme() + toks.get(i + 2).getLexeme());

                        toks.remove(i);
                        toks.remove(i);
                        toks.remove(i);
                        toks.add(i, new Token("T" + temp, "ID", i, i));
                        temp++;
                    }//if token = * /

                }//for cada 
                for (int i = 0; i < toks.size(); i++) {
                    if (toks.get(i).getLexeme().equals("+") || toks.get(i).getLexeme().equals("-")) {
                        i--;
                        codigoIntermedio = codigoIntermedio + ("\nT" + temp + " = " + toks.get(i).getLexeme() + toks.get(i + 1).getLexeme() + toks.get(i + 2).getLexeme());

                        codObj.add("\nT" + temp + " = " + toks.get(i).getLexeme() + toks.get(i + 1).getLexeme() + toks.get(i + 2).getLexeme());

                        toks.remove(i);
                        toks.remove(i);
                        toks.remove(i);
                        toks.add(i, new Token("T" + temp, "ID", i, i));
                        temp++;
                    }//if token = + -
                }
                codigoIntermedio = codigoIntermedio + ("\n" + id.lexemeRank(1) + " = " + "T" + (temp - 1));
                //para guardar las variables declaradas para posteriormente utilizarlo en el metodo ensamblador               
                variables.add(id.lexemeRank(1));
                //codigo Objeto
                codObjComp.add(objectCode(codObj));
                System.out.println(codObjComp.get(0));
                codObj.clear();
            }//if hay asignacion

        }//for producciones
        //revisa asignaciones
        for (Production id : asigProd) {
            temp = 1;
            if (id.lexicalCompRank(1).equals("ASIGNACION") && id.getSizeTokens() > 5) {
                codigoIntermedio = codigoIntermedio + ("\n\n=============================\n" + id.lexemeRank(0, -1) + "\n=============================");
                codObj.add("\n\n=============================\n;" + id.lexemeRank(0, -1) + "\n=============================");

                toks = id.getTokens();
                for (int i = 0; i < toks.size(); i++) {
                    if (toks.get(i).getLexeme().equals("*") || toks.get(i).getLexeme().equals("/")) {
                        i--;
                        codigoIntermedio = codigoIntermedio + ("\nT" + temp + " = " + toks.get(i).getLexeme() + toks.get(i + 1).getLexeme() + toks.get(i + 2).getLexeme());

                        codObj.add("\nT" + temp + " = " + toks.get(i).getLexeme() + toks.get(i + 1).getLexeme() + toks.get(i + 2).getLexeme());

                        toks.remove(i);
                        toks.remove(i);
                        toks.remove(i);
                        toks.add(i, new Token("T" + temp, "ID", i, i));
                        temp++;
                    }//if token = * /

                }//for cada 
                for (int i = 0; i < toks.size(); i++) {
                    if (toks.get(i).getLexeme().equals("+") || toks.get(i).getLexeme().equals("-")) {
                        i--;
                        codigoIntermedio = codigoIntermedio + ("\nT" + temp + " = " + toks.get(i).getLexeme() + toks.get(i + 1).getLexeme() + toks.get(i + 2).getLexeme());

                        codObj.add("\nT" + temp + " = " + toks.get(i).getLexeme() + toks.get(i + 1).getLexeme() + toks.get(i + 2).getLexeme());

                        toks.remove(i);
                        toks.remove(i);
                        toks.remove(i);
                        toks.add(i, new Token("T" + temp, "ID", i, i));
                        temp++;
                    }//if token = + -
                }
                codigoIntermedio = codigoIntermedio + ("\n" + id.lexemeRank(0) + " = " + "T" + (temp - 1));
                //para guardar las variables declaradas para posteriormente utilizarlo en el metodo ensamblador
                variables.add(id.lexemeRank(0));
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
                //codigo Objeto
                codObjComp.add(objectCode(codObj));
                System.out.println(codObjComp.get(0));
                codObj.clear();
                //System.out.println(objectCode(codObj));
            }//if hay asignacion

        }
        //INPUT Y OUTPUT
        for (Production id : funcProd) {
            codigoIntermedio = codigoIntermedio + ("\n\n=============================\n" + id.lexemeRank(0, -1) + "\n=============================");
            codigoIntermedio = codigoIntermedio + ("\nparam " + id.lexemeRank(2) + "\ncall " + id.lexemeRank(0) + ", 1");

        }//FOR FUNCPROD
        //IF
        for (Production id : ifProd) {
            codigoIntermedio = codigoIntermedio + ("\n\n=============================\n" + id.lexemeRank(0, -1) + "\n=============================");
            codigoIntermedio = codigoIntermedio + ("\nT1 = " + id.lexemeRank(2, -3) + "\nif_false T1 goto L1 " + "\n.\n.\n.\nlabel L1");

        }//FOR IFPROD
        //MIENTRAS
        for (Production id : whileProd) {
            codigoIntermedio = codigoIntermedio + ("\n\n=============================\n" + id.lexemeRank(0, -1) + "\n=============================");
            codigoIntermedio = codigoIntermedio + ("\nlabel L1\nT1 = " + id.lexemeRank(2, -3) + "\nif_false T1 goto L2 " + "\n.\n.\n.\ngoto L1\nlabel L2");

        }//FOR MIENTRASPROD
        //System.out.print(codigoIntermedio);
    }//codigoIntermedio

    //////////////////GENERACION DE CODIGO OBJETO///////////////////
    private String objectCode(ArrayList<String> tripletas1) {
        ArrayList<String> tripletas = new ArrayList<String>();
        tripletas = tripletas1;
        String tl = tripletas.get(0) + "\n";
        tripletas.remove(0);

        String inst, R0, R1, R2, R3, op, m;
        int caso = 0;
        inst = R1 = R0 = R2 = R3 = op = m = "";
        int index = 0;
        //oCode

        for (String tripleta : tripletas) {

            tripleta = tripleta.replaceAll("T[1-9] = ", "").replaceAll("\\n", "");

            //JOptionPane.showMessageDialog(null,tripleta);
            // Definimos que operacion es
            if (tripleta.contains("*")) {
                inst = "MUL";
                op = "*";
            }
            if (tripleta.contains("/")) {
                inst = "DIV";
                op = "/";
            }
            if (tripleta.contains("-")) {
                inst = "SUB";
                op = "-";
            } else if (tripleta.contains("+")) {
                inst = "ADD";
                op = "+";
            }
            // Definimos que operacion es

            //Condicionales para ver el orden de la operacion
            if (R0.isEmpty() && R1.isEmpty()) {
                //JOptionPane.showMessageDialog(null,"caso 0");
                R0 = (tripleta.substring(0, tripleta.indexOf(op))).replaceAll(" ", "");
                R1 = (tripleta.substring(tripleta.indexOf(op) + 1)).replaceAll(" ", "");

            } else if ((tripleta.substring(0, tripleta.indexOf(op))).contains("T") && (tripleta.substring(tripleta.indexOf(op) + 1)).contains("T")) {//2 TEMPORALES
                R0 = "R0";
                R1 = "R1";
                caso = 4;
                //JOptionPane.showMessageDialog(null,"caso 4");
            } else if ((tripleta.substring(0, tripleta.indexOf(op))).contains("T")) {//temporal izquierdo
                R1 = (tripleta.substring(tripleta.indexOf(op) + 1)).replaceAll(" ", "");
                caso = 1;
                //JOptionPane.showMessageDialog(null,"caso 1");
            } else if ((tripleta.substring(tripleta.indexOf(op) + 1)).contains("T")) {//temporal derecho
                R1 = (tripleta.substring(0, tripleta.indexOf(op))).replaceAll(" ", "");
                caso = 2;
                //JOptionPane.showMessageDialog(null,"caso 2");
            } else {
                R1 = (tripleta.substring(0, tripleta.indexOf(op))).replaceAll(" ", "");
                R2 = (tripleta.substring(tripleta.indexOf(op) + 1)).replaceAll(" ", "");
                caso = 5;
                //JOptionPane.showMessageDialog(null,"caso 5");
            }

            //Condicionales para ver el orden de la operacion
            switch (caso) {
                case 1:
                    m += "LD R1," + R1 + "\n";
                    m += inst + " R0,R0,R1" + "\n";
                    break;
                case 2:
                    m += "LD R1," + R1 + "\n";
                    m += inst + " R0,R1,R0" + "\n";
                    break;
                case 3:
                    m += "LD R1," + R2 + "\n";
                    m += "LD R2," + R2 + "\n";
                    m += inst + " R1,R1,R2" + "\n";
                    break;
                case 4:
                    m += inst + " " + R0 + "," + R0 + "," + R1;
                    break;
                case 5:
                    m += "LD R1," + R1 + "\n";
                    m += "LD R2," + R2 + "\n";
                    m += inst + " R1,R1,R2" + "\n";
                    caso = 0;
                    break;
                default:
                    m += "LD R0," + R0 + "\n";
                    m += "LD R1," + R1 + "\n";
                    m += inst + " R0,R0,R1" + "\n";
                    caso = 0;
            }

            // caso = true;
        }//Recorrer tripletas
        //System.out.println(tl+m);
        return (tl + m);
    }//fin_codObjeto

    private void imprimirToks(ArrayList<Token> prod) {
        int i = 0;
        String str = "";
        for (Token tok : prod) {
            str += tok.getLexeme() + "\n";
        }
        System.out.print(str);
    }

    //metodo para el color de las clases   
    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada... Sin Errores!");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        if (identProdCopia != null) {
            identProdCopia.clear();
        }
        if (identProd != null) {
            identProd.clear();
        }
        if (asigProd != null) {
            asigProd.clear();
        }
        if (asigProdConID != null) {
            asigProdConID.clear();
        }
        if (compaProdIzq != null) {
            compaProdIzq.clear();
        }
        if (compaProdDer != null) {
            compaProdDer.clear();
        }
        if (compaProdDoble != null) {
            compaProdDoble.clear();
        }
        if (operProdIzq != null) {
            operProdIzq.clear();
        }
        if (operProdDer != null) {
            operProdDer.clear();
        }
        if (operProdDoble != null) {
            operProdDoble.clear();
        }
        if (funcProd != null) {
            funcProd.clear();
        }
        if (ifProd != null) {
            ifProd.clear();
        }
        if (whileProd != null) {
            whileProd.clear();
        }
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NoCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NoCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NoCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NoCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new NoCompilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelITT;
    private javax.swing.JLabel LabelTecNM;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnCompilar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
