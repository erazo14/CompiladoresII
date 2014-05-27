/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.SymbolFactory;
import lexer.VbLexer;
import org.fife.ui.rsyntaxtextarea.parser.ParseResult;
import org.fife.ui.rsyntaxtextarea.parser.Parser;
import org.fife.ui.rsyntaxtextarea.parser.ParserNotice;
import symtable.SymTable;

/**
 *
 * @author Armando
 */
public class VbParseResult implements ParseResult{
	/*
	private VbParserWrapper vbSyntaxParser;
	private VbParser vbParser;
	private int firstLineParsed;
	private int lastLineParsed;
	
	public VbParseResult(VbParserWrapper vbSyntaxParser, VbParser vbParser){
		this.vbSyntaxParser = vbSyntaxParser;
		this.vbParser = vbParser;
		this.firstLineParsed = 0;
		this.lastLineParsed = 0;
	}
	
	@Override
	public Exception getError() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getFirstLineParsed() {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return this.firstLineParsed;
	}

	@Override
	public int getLastLineParsed() {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return this.lastLineParsed;
	}

	@Override
	public List<ParserNotice> getNotices() {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		ArrayList<VbSyntaxError> errLst = this.vbParser.getErrLst();
		ArrayList noticeLst = new ArrayList();
		//System.out.println("errors: " + errLst.size());

		for (int i = 0; i < errLst.size(); i++){
			//System.out.println("error " + i + ": " + errLst.get(i).message);
		
			VbSyntaxError se = errLst.get(i);
			VbParserNotice pn = new VbParserNotice(this.vbSyntaxParser, se.message, se.line, se.column, se.length);
			noticeLst.add(pn);
		}
		
		return noticeLst;
	}

	@Override
	public Parser getParser() {
		return this.vbSyntaxParser;
	}

	@Override
	public long getParseTime() {
		return 0;
	}
	*/
	private final VbParserWrapper vbParserWrapper;
	private int firstLineParsed;
	private int lastLineParsed;
	private final List<ParserNotice> notices;
	private final String codigo;
	private long parseTime;
	private Exception error;
	
	public VbParseResult(VbParserWrapper vbParserWrapper, String codigo){
	  this.vbParserWrapper = vbParserWrapper;
	  this.notices = new ArrayList<>();
	  this.codigo = codigo;
	}

	public void addNotice(ParserNotice notice)	{
	  this.notices.add(notice);
	}

	public void clearNotices(){
	  this.notices.clear();
	}

	@Override
	public Exception getError()	{
	  return this.error;
	}

	@Override
	public int getFirstLineParsed(){
	  return this.firstLineParsed;
	}

	@Override
	public int getLastLineParsed(){
	  return this.lastLineParsed;
	}

	@Override
	public List<ParserNotice> getNotices(){
		if (this.codigo.trim().isEmpty()){
			this.notices.clear();
		}else{
			VbParser parser = new VbParser(new VbLexer(new java.io.StringReader(codigo)));
			
			try {
				parser.parse();
				System.out.println("ParseResult.parse()");
			} catch (Exception ex) {
				Logger.getLogger(VbParseResult.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			ArrayList<VbSyntaxError> errLst = parser.getErrLst();
			
			for (int i = 0; i < errLst.size(); i++){		
				VbSyntaxError se = errLst.get(i);
				VbParserNotice pn = new VbParserNotice(this.vbParserWrapper, se.message, se.line, se.offset, se.length, true);
				this.notices.add(pn);
			}
			
			if (!SymTable.existeMain){
				this.notices.add(new VbParserNotice(this.vbParserWrapper, "Error General: La declaracion de Sub Main es requerida!", 0, 0, 0, false));
			}
		}
		
		return this.notices;
		/*
		System.out.println("vb parse result getNotices()");
		ArrayList<VbSyntaxError> errLst = this.vbParser.getErrLst();
		ArrayList<ParserNotice> noticeLst = new ArrayList();
		System.out.println("aqui viene el problema");
		
		for (int i = 0; i < errLst.size(); i++){		
			VbSyntaxError se = errLst.get(i);
			VbParserNotice pn = new VbParserNotice(this.vbParserWrapper, se.message, se.line, se.offset, se.length);
			noticeLst.add(pn);
		}
		
		return noticeLst;
		*/
	}

	@Override
	public long getParseTime(){
	  return this.parseTime;
	}

	@Override
	public Parser getParser(){
	  return this.vbParserWrapper;
	}

	public void setError(Exception e){
	  this.error = e;
	}

	public void setParseTime(long time){
	  this.parseTime = time;
	}

	public void setParsedLines(int first, int last){
	  this.firstLineParsed = first;
	  this.lastLineParsed = last;
	}
}