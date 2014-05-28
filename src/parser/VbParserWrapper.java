/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;
import intermedio.CuadTable;
import intermedio.Cuadruplo;
import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import lexer.VbLexer;
import org.fife.ui.rsyntaxtextarea.RSyntaxDocument;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.parser.ExtendedHyperlinkListener;
import org.fife.ui.rsyntaxtextarea.parser.ParseResult;
import org.fife.ui.rsyntaxtextarea.parser.Parser;
import org.fife.ui.rsyntaxtextarea.parser.ParserNotice;
import symtable.Scope;
import symtable.SymTable;

/**
 *
 * @author Armando
 */
public class VbParserWrapper implements Parser{
	
	private final RSyntaxTextArea editor;
	private final JTextArea output;
	private VbParser vbParser;
	
	public VbParserWrapper(RSyntaxTextArea editor, JTextArea output){
		this.editor = editor;
		this.output = output;
	}
	
	@Override
	public ExtendedHyperlinkListener getHyperlinkListener() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public java.net.URL getImageBase() {
		URL url = null;
		
		try {
			url = new URL("");
		} catch (MalformedURLException ex) {
			//Logger.getLogger(VbParserWrapper.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return url;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public ParseResult parse(RSyntaxDocument rsd, String string) {
		String codigo = this.editor.getText() + "\n";
		VbParseResult parseResult = new VbParseResult(this, codigo);
		
		if (codigo.trim().isEmpty()){
			this.output.setForeground(new Color(0,0,0));
			this.output.setText("");
		}else{
			List<ParserNotice> notices = parseResult.getNotices();
			
			if (notices.size() > 0){
				String errMsgBuffer = "";

				this.output.setForeground(java.awt.Color.RED);

				for (int i = 0; i < notices.size(); i++){
					errMsgBuffer += notices.get(i).getMessage() + "\n";
				}

				this.output.setText(errMsgBuffer);
			}else{
				this.output.setForeground(new Color(0,128,0));
				this.output.setText("OK, 0 Errores");
				for (Cuadruplo c:CuadTable.cuadruplos){
					System.out.println(c.operator + " " + c.operand1 + " " + c.operand2 + " " + c.dest);
				}
			}
		}
		for (Scope s:SymTable.allScopes()){
			System.out.println(s.toString());
		}
		return new VbParseResult(this, codigo);
	}
	
	public VbParser getVbParser(){
		return this.vbParser;
	}
}
