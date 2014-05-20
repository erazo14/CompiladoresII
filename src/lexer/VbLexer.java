/* The following code was generated by JFlex 1.4.3 on 5/18/14 3:26 AM */

package lexer;
import java_cup.runtime.*;
import parser.sym;
import parser.MyToken;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 5/18/14 3:26 AM from the specification file
 * <tt>src/jflex/VbLexer.flex</tt>
 */
public class VbLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int COMENTARIO = 4;
  public static final int CADENA = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\52\1\51\1\0\1\52\1\51\22\0\1\52\1\0\1\46"+
    "\3\0\1\45\1\47\1\42\1\43\1\31\1\27\1\40\1\30\1\41"+
    "\1\32\1\36\11\37\2\0\1\34\1\26\1\33\2\0\1\12\1\7"+
    "\1\13\1\24\1\4\1\21\1\5\1\14\1\1\2\50\1\11\1\25"+
    "\1\2\1\10\1\17\1\50\1\6\1\15\1\3\1\20\1\23\1\35"+
    "\1\22\1\16\1\50\4\0\1\44\1\0\1\12\1\7\1\13\1\24"+
    "\1\4\1\21\1\5\1\14\1\1\2\50\1\11\1\25\1\2\1\10"+
    "\1\17\1\50\1\6\1\15\1\3\1\20\1\23\1\35\1\22\1\16"+
    "\1\50\1\0\1\51\uff83\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\17\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\2\2\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\2\1\32\3\2\1\33\7\2"+
    "\1\34\2\2\1\35\13\2\1\36\1\37\1\40\1\2"+
    "\1\41\2\2\1\42\3\2\1\43\6\2\1\44\4\2"+
    "\1\45\3\2\1\46\2\2\1\47\2\2\1\50\1\51"+
    "\1\52\1\53\1\54\1\55\3\2\1\56\1\57\1\60"+
    "\1\61\12\2\1\62\1\63\3\2\1\64\1\65\1\2"+
    "\1\66\1\2\1\67\1\2\1\70\1\2\1\71\1\2"+
    "\1\72\1\73\1\74\1\2\1\75";

  private static int [] zzUnpackAction() {
    int [] result = new int[149];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\53\0\126\0\201\0\254\0\327\0\u0102\0\u012d"+
    "\0\u0158\0\u0183\0\u01ae\0\u01d9\0\u0204\0\u022f\0\u025a\0\u0285"+
    "\0\u02b0\0\u02db\0\u0306\0\201\0\201\0\201\0\201\0\201"+
    "\0\u0331\0\u035c\0\u0387\0\201\0\u03b2\0\201\0\201\0\201"+
    "\0\201\0\u0158\0\201\0\201\0\201\0\u03dd\0\u0408\0\201"+
    "\0\u0433\0\201\0\201\0\201\0\u045e\0\u0158\0\u0489\0\u04b4"+
    "\0\u04df\0\u0158\0\u050a\0\u0535\0\u0560\0\u058b\0\u05b6\0\u05e1"+
    "\0\u060c\0\u0158\0\u0637\0\u0662\0\u0158\0\u068d\0\u06b8\0\u06e3"+
    "\0\u070e\0\u0739\0\u0764\0\u078f\0\u07ba\0\u07e5\0\u0810\0\u083b"+
    "\0\u0158\0\201\0\201\0\u0866\0\201\0\u0891\0\u08bc\0\u0158"+
    "\0\u08e7\0\u0912\0\u093d\0\u0158\0\u0968\0\u0993\0\u09be\0\u09e9"+
    "\0\u0a14\0\u0a3f\0\u0158\0\u0a6a\0\u0a95\0\u0ac0\0\u0aeb\0\u0158"+
    "\0\u0b16\0\u0b41\0\u0b6c\0\u0158\0\u0b97\0\u0bc2\0\u0158\0\u0bed"+
    "\0\u0c18\0\u0158\0\u0158\0\u0158\0\u0158\0\u0c43\0\u0158\0\u0c6e"+
    "\0\u0c99\0\u0cc4\0\u0158\0\u0158\0\u0158\0\u0158\0\u0cef\0\u0d1a"+
    "\0\u0d45\0\u0d70\0\u0d9b\0\u0dc6\0\u0df1\0\u0e1c\0\u0e47\0\u0e72"+
    "\0\u0158\0\u0158\0\u0e9d\0\u0ec8\0\u0ef3\0\u0158\0\u0158\0\u0f1e"+
    "\0\u0158\0\u0f49\0\u0158\0\u0f74\0\u0158\0\u0f9f\0\u0158\0\u0fca"+
    "\0\u0158\0\u0158\0\u0158\0\u0ff5\0\u0158";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[149];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\1\6\1\7\1\10\2\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\11\1\17\1\11\1\20\1\21"+
    "\1\22\2\11\1\23\1\11\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\43\1\44\1\45\1\11\1\46"+
    "\1\47\46\50\1\51\2\50\1\52\1\50\51\53\1\54"+
    "\1\53\54\0\1\11\1\55\16\11\1\56\4\11\7\0"+
    "\3\11\4\0\1\11\3\0\1\11\3\0\3\11\1\57"+
    "\3\11\1\60\15\11\7\0\3\11\4\0\1\11\3\0"+
    "\1\11\3\0\5\11\1\61\1\11\1\62\3\11\1\63"+
    "\1\11\1\64\7\11\7\0\3\11\4\0\1\11\3\0"+
    "\1\11\3\0\1\11\1\65\6\11\1\66\10\11\1\67"+
    "\3\11\7\0\3\11\4\0\1\11\3\0\1\11\3\0"+
    "\25\11\7\0\3\11\4\0\1\11\3\0\1\11\3\0"+
    "\7\11\1\70\5\11\1\71\7\11\7\0\3\11\4\0"+
    "\1\11\3\0\1\11\3\0\5\11\1\72\17\11\7\0"+
    "\3\11\4\0\1\11\3\0\1\11\3\0\7\11\1\73"+
    "\15\11\7\0\3\11\4\0\1\11\3\0\1\11\3\0"+
    "\1\11\1\74\12\11\1\75\10\11\7\0\3\11\4\0"+
    "\1\11\3\0\1\11\3\0\11\11\1\76\1\11\1\77"+
    "\11\11\7\0\3\11\4\0\1\11\3\0\1\11\3\0"+
    "\2\11\1\100\14\11\1\101\5\11\7\0\3\11\4\0"+
    "\1\11\3\0\1\11\3\0\5\11\1\102\11\11\1\103"+
    "\5\11\7\0\3\11\4\0\1\11\3\0\1\11\3\0"+
    "\1\11\1\104\23\11\7\0\3\11\4\0\1\11\3\0"+
    "\1\11\3\0\7\11\1\105\1\11\1\106\5\11\1\107"+
    "\5\11\7\0\3\11\4\0\1\11\3\0\1\11\3\0"+
    "\1\110\6\11\1\111\15\11\7\0\3\11\4\0\1\11"+
    "\3\0\1\11\30\0\1\112\52\0\1\113\25\0\13\11"+
    "\1\114\11\11\7\0\3\11\4\0\1\11\3\0\1\11"+
    "\40\0\2\35\64\0\1\46\53\0\1\47\46\0\1\115"+
    "\5\0\2\11\1\116\22\11\7\0\3\11\4\0\1\11"+
    "\3\0\1\11\3\0\21\11\1\117\3\11\7\0\3\11"+
    "\4\0\1\11\3\0\1\11\3\0\2\11\1\120\22\11"+
    "\7\0\3\11\4\0\1\11\3\0\1\11\3\0\17\11"+
    "\1\121\5\11\7\0\3\11\4\0\1\11\3\0\1\11"+
    "\3\0\3\11\1\122\21\11\7\0\3\11\4\0\1\11"+
    "\3\0\1\11\3\0\16\11\1\123\6\11\7\0\3\11"+
    "\4\0\1\11\3\0\1\11\3\0\23\11\1\124\1\11"+
    "\7\0\3\11\4\0\1\11\3\0\1\11\3\0\14\11"+
    "\1\125\10\11\7\0\3\11\4\0\1\11\3\0\1\11"+
    "\3\0\1\126\24\11\7\0\3\11\4\0\1\11\3\0"+
    "\1\11\3\0\7\11\1\127\15\11\7\0\3\11\4\0"+
    "\1\11\3\0\1\11\3\0\5\11\1\130\14\11\1\131"+
    "\2\11\7\0\3\11\4\0\1\11\3\0\1\11\3\0"+
    "\7\11\1\132\15\11\7\0\3\11\4\0\1\11\3\0"+
    "\1\11\3\0\23\11\1\133\1\11\7\0\3\11\4\0"+
    "\1\11\3\0\1\11\3\0\10\11\1\134\14\11\7\0"+
    "\3\11\4\0\1\11\3\0\1\11\3\0\11\11\1\135"+
    "\13\11\7\0\3\11\4\0\1\11\3\0\1\11\3\0"+
    "\3\11\1\136\1\11\1\137\17\11\7\0\3\11\4\0"+
    "\1\11\3\0\1\11\3\0\6\11\1\140\16\11\7\0"+
    "\3\11\4\0\1\11\3\0\1\11\3\0\1\141\24\11"+
    "\7\0\3\11\4\0\1\11\3\0\1\11\3\0\6\11"+
    "\1\142\16\11\7\0\3\11\4\0\1\11\3\0\1\11"+
    "\3\0\2\11\1\143\22\11\7\0\3\11\4\0\1\11"+
    "\3\0\1\11\3\0\5\11\1\144\17\11\7\0\3\11"+
    "\4\0\1\11\3\0\1\11\3\0\10\11\1\145\14\11"+
    "\7\0\3\11\4\0\1\11\3\0\1\11\3\0\1\11"+
    "\1\146\23\11\7\0\3\11\4\0\1\11\3\0\1\11"+
    "\3\0\24\11\1\147\7\0\3\11\4\0\1\11\3\0"+
    "\1\11\3\0\1\150\24\11\7\0\3\11\4\0\1\11"+
    "\3\0\1\11\3\0\3\11\1\151\21\11\7\0\3\11"+
    "\4\0\1\11\3\0\1\11\3\0\2\11\1\152\22\11"+
    "\7\0\3\11\4\0\1\11\3\0\1\11\3\0\3\11"+
    "\1\153\21\11\7\0\3\11\4\0\1\11\3\0\1\11"+
    "\3\0\1\11\1\154\23\11\7\0\3\11\4\0\1\11"+
    "\3\0\1\11\3\0\3\11\1\155\21\11\7\0\3\11"+
    "\4\0\1\11\3\0\1\11\3\0\3\11\1\156\21\11"+
    "\7\0\3\11\4\0\1\11\3\0\1\11\3\0\2\11"+
    "\1\157\22\11\7\0\3\11\4\0\1\11\3\0\1\11"+
    "\3\0\10\11\1\160\14\11\7\0\3\11\4\0\1\11"+
    "\3\0\1\11\3\0\3\11\1\161\21\11\7\0\3\11"+
    "\4\0\1\11\3\0\1\11\3\0\11\11\1\162\13\11"+
    "\7\0\3\11\4\0\1\11\3\0\1\11\3\0\16\11"+
    "\1\163\6\11\7\0\3\11\4\0\1\11\3\0\1\11"+
    "\3\0\10\11\1\164\14\11\7\0\3\11\4\0\1\11"+
    "\3\0\1\11\3\0\5\11\1\165\17\11\7\0\3\11"+
    "\4\0\1\11\3\0\1\11\3\0\16\11\1\166\6\11"+
    "\7\0\3\11\4\0\1\11\3\0\1\11\3\0\1\167"+
    "\24\11\7\0\3\11\4\0\1\11\3\0\1\11\3\0"+
    "\22\11\1\170\2\11\7\0\3\11\4\0\1\11\3\0"+
    "\1\11\3\0\10\11\1\171\14\11\7\0\3\11\4\0"+
    "\1\11\3\0\1\11\3\0\1\172\24\11\7\0\3\11"+
    "\4\0\1\11\3\0\1\11\3\0\14\11\1\173\10\11"+
    "\7\0\3\11\4\0\1\11\3\0\1\11\3\0\12\11"+
    "\1\174\12\11\7\0\3\11\4\0\1\11\3\0\1\11"+
    "\3\0\10\11\1\175\14\11\7\0\3\11\4\0\1\11"+
    "\3\0\1\11\3\0\4\11\1\176\20\11\7\0\3\11"+
    "\4\0\1\11\3\0\1\11\3\0\1\177\24\11\7\0"+
    "\3\11\4\0\1\11\3\0\1\11\3\0\3\11\1\200"+
    "\21\11\7\0\3\11\4\0\1\11\3\0\1\11\3\0"+
    "\20\11\1\201\4\11\7\0\3\11\4\0\1\11\3\0"+
    "\1\11\3\0\10\11\1\202\14\11\7\0\3\11\4\0"+
    "\1\11\3\0\1\11\3\0\1\11\1\203\23\11\7\0"+
    "\3\11\4\0\1\11\3\0\1\11\3\0\11\11\1\204"+
    "\13\11\7\0\3\11\4\0\1\11\3\0\1\11\3\0"+
    "\1\205\24\11\7\0\3\11\4\0\1\11\3\0\1\11"+
    "\3\0\10\11\1\206\14\11\7\0\3\11\4\0\1\11"+
    "\3\0\1\11\3\0\3\11\1\207\21\11\7\0\3\11"+
    "\4\0\1\11\3\0\1\11\3\0\2\11\1\210\22\11"+
    "\7\0\3\11\4\0\1\11\3\0\1\11\3\0\3\11"+
    "\1\211\21\11\7\0\3\11\4\0\1\11\3\0\1\11"+
    "\3\0\3\11\1\212\21\11\7\0\3\11\4\0\1\11"+
    "\3\0\1\11\3\0\20\11\1\213\4\11\7\0\3\11"+
    "\4\0\1\11\3\0\1\11\3\0\11\11\1\214\13\11"+
    "\7\0\3\11\4\0\1\11\3\0\1\11\3\0\4\11"+
    "\1\215\20\11\7\0\3\11\4\0\1\11\3\0\1\11"+
    "\3\0\2\11\1\216\22\11\7\0\3\11\4\0\1\11"+
    "\3\0\1\11\3\0\12\11\1\217\12\11\7\0\3\11"+
    "\4\0\1\11\3\0\1\11\3\0\1\220\24\11\7\0"+
    "\3\11\4\0\1\11\3\0\1\11\3\0\5\11\1\221"+
    "\17\11\7\0\3\11\4\0\1\11\3\0\1\11\3\0"+
    "\1\11\1\222\23\11\7\0\3\11\4\0\1\11\3\0"+
    "\1\11\3\0\3\11\1\223\21\11\7\0\3\11\4\0"+
    "\1\11\3\0\1\11\3\0\7\11\1\224\15\11\7\0"+
    "\3\11\4\0\1\11\3\0\1\11\3\0\1\11\1\225"+
    "\23\11\7\0\3\11\4\0\1\11\3\0\1\11\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4128];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\17\1\5\11\3\1\1\11\1\1\4\11"+
    "\1\1\3\11\2\1\1\11\1\1\3\11\35\1\2\11"+
    "\1\1\1\11\110\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[149];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
	private StringBuffer strBuff = new StringBuffer("");

	private MyToken symbol(int type) { 
		return new MyToken(type, yyline + 1, yycolumn + 1, yychar); 
	}

	private MyToken symbol(int type, Object value) { 
		return new MyToken(type, yyline + 1, yycolumn + 1, yychar, value); 
	}


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public VbLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public VbLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 168) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 3: 
          { return symbol(sym.Igual, yytext());
          }
        case 62: break;
        case 13: 
          { return symbol(sym.ParI, yytext());
          }
        case 63: break;
        case 40: 
          { return symbol(sym.Next, yytext());
          }
        case 64: break;
        case 5: 
          { return symbol(sym.Menos, yytext());
          }
        case 65: break;
        case 50: 
          { return symbol(sym.ByRef, yytext());
          }
        case 66: break;
        case 45: 
          { return symbol(sym.Exit, yytext());
          }
        case 67: break;
        case 41: 
          { return symbol(sym.True, yytext());
          }
        case 68: break;
        case 29: 
          { return symbol(sym.As, yytext());
          }
        case 69: break;
        case 48: 
          { return symbol(sym.Char, yytext());
          }
        case 70: break;
        case 19: 
          { return symbol(sym.FinDeLinea, yytext());
          }
        case 71: break;
        case 27: 
          { return symbol(sym.To, yytext());
          }
        case 72: break;
        case 58: 
          { return symbol(sym.Integer, yytext());
          }
        case 73: break;
        case 20: 
          { /* ignorar */
          }
        case 74: break;
        case 1: 
          { return symbol(sym.error, yytext());
          }
        case 75: break;
        case 4: 
          { return symbol(sym.Mas, yytext());
          }
        case 76: break;
        case 56: 
          { return symbol(sym.String, yytext());
          }
        case 77: break;
        case 8: 
          { return symbol(sym.Mayor, yytext());
          }
        case 78: break;
        case 22: 
          { strBuff.setLength(0); yybegin(YYINITIAL); return symbol(sym.StrLiteral, strBuff);
          }
        case 79: break;
        case 31: 
          { return symbol(sym.MayorIgual, yytext());
          }
        case 80: break;
        case 11: 
          { return symbol(sym.Coma, yytext());
          }
        case 81: break;
        case 25: 
          { yybegin(YYINITIAL);
          }
        case 82: break;
        case 21: 
          { strBuff.append(yytext());
          }
        case 83: break;
        case 35: 
          { return symbol(sym.End, yytext());
          }
        case 84: break;
        case 39: 
          { return symbol(sym.Dim, yytext());
          }
        case 85: break;
        case 9: 
          { return symbol(sym.Menor, yytext());
          }
        case 86: break;
        case 49: 
          { return symbol(sym.Step, yytext());
          }
        case 87: break;
        case 52: 
          { return symbol(sym.Until, yytext());
          }
        case 88: break;
        case 38: 
          { return symbol(sym.For, yytext());
          }
        case 89: break;
        case 59: 
          { return symbol(sym.Boolean, yytext());
          }
        case 90: break;
        case 7: 
          { return symbol(sym.Entre, yytext());
          }
        case 91: break;
        case 2: 
          { return symbol(sym.Id, yytext());
          }
        case 92: break;
        case 18: 
          { yybegin(COMENTARIO);
          }
        case 93: break;
        case 14: 
          { return symbol(sym.ParD, yytext());
          }
        case 94: break;
        case 30: 
          { return symbol(sym.Do, yytext());
          }
        case 95: break;
        case 44: 
          { return symbol(sym.Else, yytext());
          }
        case 96: break;
        case 53: 
          { return symbol(sym.False, yytext());
          }
        case 97: break;
        case 37: 
          { return symbol(sym.Sub, yytext());
          }
        case 98: break;
        case 6: 
          { return symbol(sym.Por, yytext());
          }
        case 99: break;
        case 16: 
          { return symbol(sym.Ampersand, yytext());
          }
        case 100: break;
        case 42: 
          { return symbol(sym.Then, yytext());
          }
        case 101: break;
        case 55: 
          { return symbol(sym.ElseIf, yytext());
          }
        case 102: break;
        case 28: 
          { return symbol(sym.Or, yytext());
          }
        case 103: break;
        case 12: 
          { return symbol(sym.Punto, yytext());
          }
        case 104: break;
        case 47: 
          { return symbol(sym.Call, yytext());
          }
        case 105: break;
        case 32: 
          { return symbol(sym.MenorIgual, yytext());
          }
        case 106: break;
        case 43: 
          { return symbol(sym.Type, yytext());
          }
        case 107: break;
        case 57: 
          { return symbol(sym.Public, yytext());
          }
        case 108: break;
        case 34: 
          { return symbol(sym.Not, yytext());
          }
        case 109: break;
        case 10: 
          { return symbol(sym.IntLiteral, yytext());
          }
        case 110: break;
        case 54: 
          { return symbol(sym.While, yytext());
          }
        case 111: break;
        case 23: 
          { return symbol(sym.error, "runaway string");
          }
        case 112: break;
        case 33: 
          { strBuff.append("\"");	/* asi se escapan las comillas en vb6 wtf */
          }
        case 113: break;
        case 51: 
          { return symbol(sym.ByVal, yytext());
          }
        case 114: break;
        case 17: 
          { yybegin(CADENA);
          }
        case 115: break;
        case 36: 
          { return symbol(sym.And, yytext());
          }
        case 116: break;
        case 60: 
          { return symbol(sym.Private, yytext());
          }
        case 117: break;
        case 24: 
          { /* que se venga lo que sea */
          }
        case 118: break;
        case 61: 
          { return symbol(sym.Function, yytext());
          }
        case 119: break;
        case 26: 
          { return symbol(sym.If, yytext());
          }
        case 120: break;
        case 46: 
          { return symbol(sym.Loop, yytext());
          }
        case 121: break;
        case 15: 
          { return symbol(sym.GuionBajo, yytext());
          }
        case 122: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
