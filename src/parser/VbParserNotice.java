/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;
import java.awt.Color;
import org.fife.ui.rsyntaxtextarea.parser.Parser;
import org.fife.ui.rsyntaxtextarea.parser.ParserNotice;

/**
 *
 * @author Armando
 */
public class VbParserNotice implements ParserNotice{
	/*
	private VbParserWrapper vbSyntaxParser;
	private final String message;
	private final int line;
	private final int column;
	private final int length;
	
	public VbParserNotice(String message, int line, int column, int length){
		this.message = message;
		this.line = line - 1;
		this.column = column - 1;
		this.length = length;
	}
	
	public VbParserNotice(VbParserWrapper vbSyntaxParser, String message, int line, int column, int length){
		this.vbSyntaxParser = vbSyntaxParser;
		this.message = message;
		this.line = line - 1;
		this.column = column - 1;
		this.length = length;
	}
	
	@Override
	public boolean containsPosition(int i) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return false;
	}

	@Override
	public Color getColor() {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return java.awt.Color.RED;
	}

	@Override
	public int getLength() {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return this.length;
	}

	@Override
	public int getLevel() {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return 2;
	}

	@Override
	public int getLine() {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return this.line;
	}

	@Override
	public String getMessage() {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return "Hay un problemita!";
	}

	@Override
	public int getOffset() {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return this.column;
	}

	@Override
	public Parser getParser() {
		return this.vbSyntaxParser;
	}

	@Override
	public boolean getShowInEditor() {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return true;
	}

	@Override
	public String getToolTipText() {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return this.message;
	}

	@Override
	public int compareTo(ParserNotice t) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return -1;
	}
	*/
	
	private Parser parser;
	private int level;
	private int line;
	private int offset;
	private int length;
	private boolean showInEditor;
	private Color color;
	private String message;
	private String toolTipText;
	private static final Color[] DEFAULT_COLORS = { new Color(255, 0, 128), new Color(244, 200, 45), Color.gray };

	public VbParserNotice(Parser parser, String msg, int line){
	  this(parser, msg, line, -1, -1, true);
	}

	public VbParserNotice(Parser parser, String message, int line, int offset, int length, boolean show)
	{
	  this.parser = parser;
	  this.message = message;
	  this.line = line;
	  this.offset = offset;
	  this.length = length;
	  setLevel(0);
	  setShowInEditor(show);
	}
	
	@Override
	public int compareTo(ParserNotice other)
	{
	  int diff = -1;
	  if (other != null)
	  {
		diff = this.level - other.getLevel();
		if (diff == 0)
		{
		  diff = this.line - other.getLine();
		  if (diff == 0) {
			diff = this.message.compareTo(other.getMessage());
		  }
		}
	  }
	  return diff;
	}

	@Override
	public boolean containsPosition(int pos)
	{
	  return (this.offset <= pos) && (pos < this.offset + this.length);
	}

	@Override
	public boolean equals(Object obj)
	{
	  if (!(obj instanceof ParserNotice)) {
		return false;
	  }
	  return compareTo((ParserNotice)obj) == 0;
	}

	@Override
	public Color getColor()
	{
	  Color c = this.color;
	  if (c == null) {
		c = DEFAULT_COLORS[getLevel()];
	  }
	  return c;
	}

	@Override
	public int getLength()
	{
	  return this.length;
	}

	@Override
	public int getLevel()
	{
	  return this.level;
	}

	@Override
	public int getLine()
	{
	  return this.line;
	}

	@Override
	public String getMessage()
	{
	  return this.message;
	}

	@Override
	public int getOffset()
	{
	  return this.offset;
	}

	@Override
	public Parser getParser()
	{
	  return this.parser;
	}

	@Override
	public boolean getShowInEditor()
	{
	  return this.showInEditor;
	}

	@Override
	public String getToolTipText()
	{
	  //return this.toolTipText != null ? this.toolTipText : getMessage();
		String[] partes = this.message.split(":");
		if (partes.length > 0){
			return partes[partes.length - 1];
		}else{
			return this.getMessage();
		}
		
	}

	@Override
	public int hashCode()
	{
	  return this.line << 16 | this.offset;
	}

	public void setColor(Color color)
	{
	  this.color = color;
	}

	public void setLevel(int level)
	{
	  if (level > 2) {
		level = 2;
	  } else if (level < 0) {
		level = 0;
	  }
	  this.level = level;
	}

	public void setShowInEditor(boolean show)
	{
	  this.showInEditor = show;
	}

	public void setToolTipText(String text)
	{
	  this.toolTipText = text;
	}

	@Override
	public String toString()
	{
	  return "Line " + getLine() + ": " + getMessage();
	}
}
