/* The following code was generated by JFlex 1.4.3 on 26/02/18 03:58 PM */

package testmaven;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 26/02/18 03:58 PM from the specification file
 * <tt>C:/Users/Marisol/CosasPros/Compiladores-master/Practicas/Practica_2/codigo/src/main/jflex/AnalizadorC.jflex</tt>
 */
public class AlexicoC {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\12\0\1\40\37\0\1\41\2\0\1\3\1\1\1\37\1\2\11\4"+
    "\7\0\32\35\4\0\1\36\1\0\1\6\1\12\1\16\1\23\1\14"+
    "\1\5\1\27\1\20\1\22\1\35\1\15\1\24\1\25\1\21\1\11"+
    "\1\33\1\35\1\13\1\17\1\10\1\7\1\34\1\31\1\26\1\32"+
    "\1\30\57\0\1\35\12\0\1\35\4\0\1\35\5\0\27\35\1\0"+
    "\37\35\1\0\u01ca\35\4\0\14\35\16\0\5\35\7\0\1\35\1\0"+
    "\1\35\201\0\5\35\1\0\2\35\2\0\4\35\10\0\1\35\1\0"+
    "\3\35\1\0\1\35\1\0\24\35\1\0\123\35\1\0\213\35\10\0"+
    "\236\35\11\0\46\35\2\0\1\35\7\0\47\35\110\0\33\35\5\0"+
    "\3\35\55\0\53\35\25\0\12\35\4\0\2\35\1\0\143\35\1\0"+
    "\1\35\17\0\2\35\7\0\2\35\12\35\3\35\2\0\1\35\20\0"+
    "\1\35\1\0\36\35\35\0\131\35\13\0\1\35\16\0\12\35\41\35"+
    "\11\0\2\35\4\0\1\35\5\0\26\35\4\0\1\35\11\0\1\35"+
    "\3\0\1\35\27\0\31\35\107\0\1\35\1\0\13\35\127\0\66\35"+
    "\3\0\1\35\22\0\1\35\7\0\12\35\4\0\12\35\1\0\7\35"+
    "\1\0\7\35\5\0\10\35\2\0\2\35\2\0\26\35\1\0\7\35"+
    "\1\0\1\35\3\0\4\35\3\0\1\35\20\0\1\35\15\0\2\35"+
    "\1\0\3\35\4\0\12\35\2\35\23\0\6\35\4\0\2\35\2\0"+
    "\26\35\1\0\7\35\1\0\2\35\1\0\2\35\1\0\2\35\37\0"+
    "\4\35\1\0\1\35\7\0\12\35\2\0\3\35\20\0\11\35\1\0"+
    "\3\35\1\0\26\35\1\0\7\35\1\0\2\35\1\0\5\35\3\0"+
    "\1\35\22\0\1\35\17\0\2\35\4\0\12\35\25\0\10\35\2\0"+
    "\2\35\2\0\26\35\1\0\7\35\1\0\2\35\1\0\5\35\3\0"+
    "\1\35\36\0\2\35\1\0\3\35\4\0\12\35\1\0\1\35\21\0"+
    "\1\35\1\0\6\35\3\0\3\35\1\0\4\35\3\0\2\35\1\0"+
    "\1\35\1\0\2\35\3\0\2\35\3\0\3\35\3\0\14\35\26\0"+
    "\1\35\25\0\12\35\25\0\10\35\1\0\3\35\1\0\27\35\1\0"+
    "\12\35\1\0\5\35\3\0\1\35\32\0\2\35\6\0\2\35\4\0"+
    "\12\35\25\0\10\35\1\0\3\35\1\0\27\35\1\0\12\35\1\0"+
    "\5\35\3\0\1\35\40\0\1\35\1\0\2\35\4\0\12\35\1\0"+
    "\2\35\22\0\10\35\1\0\3\35\1\0\51\35\2\0\1\35\20\0"+
    "\1\35\21\0\2\35\4\0\12\35\12\0\6\35\5\0\22\35\3\0"+
    "\30\35\1\0\11\35\1\0\1\35\2\0\7\35\72\0\60\35\1\0"+
    "\2\35\14\0\7\35\11\0\12\35\47\0\2\35\1\0\1\35\2\0"+
    "\2\35\1\0\1\35\2\0\1\35\6\0\4\35\1\0\7\35\1\0"+
    "\3\35\1\0\1\35\1\0\1\35\2\0\2\35\1\0\4\35\1\0"+
    "\2\35\11\0\1\35\2\0\5\35\1\0\1\35\11\0\12\35\2\0"+
    "\4\35\40\0\1\35\37\0\12\35\26\0\10\35\1\0\44\35\33\0"+
    "\5\35\163\0\53\35\24\0\1\35\12\35\6\0\6\35\4\0\4\35"+
    "\3\0\1\35\3\0\2\35\7\0\3\35\4\0\15\35\14\0\1\35"+
    "\1\0\12\35\6\0\46\35\1\0\1\35\5\0\1\35\2\0\53\35"+
    "\1\0\u014d\35\1\0\4\35\2\0\7\35\1\0\1\35\1\0\4\35"+
    "\2\0\51\35\1\0\4\35\2\0\41\35\1\0\4\35\2\0\7\35"+
    "\1\0\1\35\1\0\4\35\2\0\17\35\1\0\71\35\1\0\4\35"+
    "\2\0\103\35\45\0\20\35\20\0\125\35\14\0\u026c\35\2\0\21\35"+
    "\1\0\32\35\5\0\113\35\25\0\15\35\1\0\4\35\16\0\22\35"+
    "\16\0\22\35\16\0\15\35\1\0\3\35\17\0\64\35\43\0\1\35"+
    "\4\0\1\35\3\0\12\35\46\0\12\35\6\0\130\35\10\0\51\35"+
    "\1\0\1\35\5\0\106\35\12\0\35\35\51\0\12\35\36\35\2\0"+
    "\5\35\13\0\54\35\25\0\7\35\10\0\12\35\46\0\27\35\11\0"+
    "\65\35\53\0\12\35\6\0\12\35\15\0\1\35\135\0\57\35\21\0"+
    "\7\35\4\0\12\35\51\0\36\35\15\0\2\35\12\35\54\35\32\0"+
    "\44\35\34\0\12\35\3\0\3\35\12\35\44\35\153\0\4\35\1\0"+
    "\4\35\3\0\2\35\11\0\300\35\100\0\u0116\35\2\0\6\35\2\0"+
    "\46\35\2\0\6\35\2\0\10\35\1\0\1\35\1\0\1\35\1\0"+
    "\1\35\1\0\37\35\2\0\65\35\1\0\7\35\1\0\1\35\3\0"+
    "\3\35\1\0\7\35\3\0\4\35\2\0\6\35\4\0\15\35\5\0"+
    "\3\35\1\0\7\35\164\0\1\35\15\0\1\35\20\0\15\35\145\0"+
    "\1\35\4\0\1\35\2\0\12\35\1\0\1\35\3\0\5\35\6\0"+
    "\1\35\1\0\1\35\1\0\1\35\1\0\4\35\1\0\13\35\2\0"+
    "\4\35\5\0\5\35\4\0\1\35\64\0\2\35\u0a7b\0\57\35\1\0"+
    "\57\35\1\0\205\35\6\0\4\35\3\0\2\35\14\0\46\35\1\0"+
    "\1\35\5\0\1\35\2\0\70\35\7\0\1\35\20\0\27\35\11\0"+
    "\7\35\1\0\7\35\1\0\7\35\1\0\7\35\1\0\7\35\1\0"+
    "\7\35\1\0\7\35\1\0\7\35\120\0\1\35\u01d5\0\2\35\52\0"+
    "\5\35\5\0\2\35\4\0\126\35\6\0\3\35\1\0\132\35\1\0"+
    "\4\35\5\0\51\35\3\0\136\35\21\0\33\35\65\0\20\35\u0200\0"+
    "\u19b6\35\112\0\u51cd\35\63\0\u048d\35\103\0\56\35\2\0\u010d\35\3\0"+
    "\20\35\12\35\2\35\24\0\57\35\20\0\31\35\10\0\106\35\61\0"+
    "\11\35\2\0\147\35\2\0\4\35\1\0\4\35\14\0\13\35\115\0"+
    "\12\35\1\0\3\35\1\0\4\35\1\0\27\35\35\0\64\35\16\0"+
    "\62\35\34\0\12\35\30\0\6\35\3\0\1\35\4\0\12\35\34\35"+
    "\12\0\27\35\31\0\35\35\7\0\57\35\34\0\1\35\12\35\46\0"+
    "\51\35\27\0\3\35\1\0\10\35\4\0\12\35\6\0\27\35\3\0"+
    "\1\35\5\0\60\35\1\0\1\35\3\0\2\35\2\0\5\35\2\0"+
    "\1\35\1\0\1\35\30\0\3\35\2\0\13\35\7\0\3\35\14\0"+
    "\6\35\2\0\6\35\2\0\6\35\11\0\7\35\1\0\7\35\221\0"+
    "\43\35\15\0\12\35\6\0\u2ba4\35\14\0\27\35\4\0\61\35\u2104\0"+
    "\u016e\35\2\0\152\35\46\0\7\35\14\0\5\35\5\0\1\35\1\0"+
    "\12\35\1\0\15\35\1\0\5\35\1\0\1\35\1\0\2\35\1\0"+
    "\2\35\1\0\154\35\41\0\u016b\35\22\0\100\35\2\0\66\35\50\0"+
    "\14\35\164\0\5\35\1\0\207\35\23\0\12\35\7\0\32\35\6\0"+
    "\32\35\13\0\131\35\3\0\6\35\2\0\6\35\2\0\6\35\2\0"+
    "\3\35\43\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\1\20\3\2\1\1\4\1\0"+
    "\1\2\20\3\1\5\1\3\1\5\4\3\1\0\1\6"+
    "\2\0\30\3\1\0\1\7\17\3\1\6\12\3";

  private static int [] zzUnpackAction() {
    int [] result = new int[104];
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
    "\0\0\0\42\0\104\0\146\0\210\0\252\0\314\0\356"+
    "\0\u0110\0\u0132\0\u0154\0\u0176\0\u0198\0\u01ba\0\u01dc\0\u01fe"+
    "\0\u0220\0\u0242\0\u0264\0\u0286\0\u02a8\0\u02ca\0\42\0\u02ec"+
    "\0\u030e\0\u0330\0\u0352\0\u0374\0\u0396\0\u03b8\0\u03da\0\u03fc"+
    "\0\u041e\0\u0440\0\u0462\0\u0484\0\u04a6\0\u04c8\0\u04ea\0\u050c"+
    "\0\u052e\0\u0110\0\u0550\0\u0572\0\u0594\0\u05b6\0\u05d8\0\u05fa"+
    "\0\u02a8\0\u061c\0\u063e\0\u0660\0\u0682\0\u06a4\0\u06c6\0\u06e8"+
    "\0\u070a\0\u072c\0\u074e\0\u0770\0\u0792\0\u07b4\0\u07d6\0\u07f8"+
    "\0\u081a\0\u083c\0\u085e\0\u0880\0\u08a2\0\u08c4\0\u08e6\0\u0908"+
    "\0\u092a\0\u094c\0\u096e\0\u0990\0\u09b2\0\42\0\u09d4\0\u09f6"+
    "\0\u0a18\0\u0a3a\0\u0a5c\0\u0a7e\0\u0aa0\0\u0ac2\0\u0ae4\0\u0b06"+
    "\0\u0b28\0\u0b4a\0\u0b6c\0\u0b8e\0\u0bb0\0\u063e\0\u0bd2\0\u0bf4"+
    "\0\u0c16\0\u0c38\0\u0c5a\0\u0c7c\0\u0c9e\0\u0cc0\0\u0ce2\0\u0d04";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[104];
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
    "\2\2\1\3\1\4\1\3\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\11\1\15\1\16\2\11"+
    "\1\17\1\20\1\21\2\11\1\22\1\11\1\23\2\11"+
    "\1\24\1\11\1\25\1\26\1\27\1\2\43\0\1\30"+
    "\1\3\1\0\1\3\32\11\7\0\1\31\37\0\1\11"+
    "\1\0\5\11\1\32\12\11\1\33\12\11\5\0\1\11"+
    "\1\0\3\11\1\34\27\11\5\0\1\11\1\0\15\11"+
    "\1\35\15\11\5\0\1\11\1\0\26\11\1\36\4\11"+
    "\5\0\1\11\1\0\33\11\5\0\1\11\1\0\7\11"+
    "\1\37\23\11\5\0\1\11\1\0\10\11\1\40\22\11"+
    "\5\0\1\11\1\0\15\11\1\41\2\11\1\42\1\11"+
    "\1\43\10\11\5\0\1\11\1\0\2\11\1\42\2\11"+
    "\1\44\6\11\1\45\16\11\5\0\1\11\1\0\4\11"+
    "\1\46\7\11\1\47\1\11\1\50\6\11\1\51\5\11"+
    "\5\0\1\11\1\0\1\11\1\52\13\11\1\53\15\11"+
    "\5\0\1\11\1\0\5\11\1\54\2\11\1\55\22\11"+
    "\5\0\1\11\1\0\5\11\1\56\25\11\5\0\1\11"+
    "\1\0\5\11\1\34\25\11\5\0\1\11\1\0\14\11"+
    "\1\57\16\11\5\0\1\11\1\0\5\11\1\60\25\11"+
    "\5\0\1\11\1\0\32\11\1\61\42\0\1\62\1\0"+
    "\1\63\2\0\1\64\1\0\1\64\36\0\1\30\1\31"+
    "\1\0\1\31\37\0\1\11\1\0\7\11\1\52\23\11"+
    "\5\0\1\11\1\0\5\11\1\65\25\11\5\0\1\11"+
    "\1\0\4\11\1\66\26\11\5\0\1\11\1\0\13\11"+
    "\1\67\2\11\1\70\14\11\5\0\1\11\1\0\27\11"+
    "\1\71\3\11\5\0\1\11\1\0\10\11\1\72\22\11"+
    "\5\0\1\11\1\0\4\11\1\73\16\11\1\74\7\11"+
    "\5\0\1\11\1\0\3\11\1\75\27\11\5\0\1\11"+
    "\1\0\13\11\1\76\17\11\5\0\1\11\1\0\4\11"+
    "\1\77\26\11\5\0\1\11\1\0\15\11\1\100\15\11"+
    "\5\0\1\11\1\0\2\11\1\32\30\11\5\0\1\11"+
    "\1\0\2\11\1\101\4\11\1\102\23\11\5\0\1\11"+
    "\1\0\5\11\1\103\25\11\5\0\1\11\1\0\23\11"+
    "\1\104\1\105\6\11\5\0\1\11\1\0\16\11\1\106"+
    "\14\11\5\0\1\11\1\0\4\11\1\52\26\11\5\0"+
    "\1\11\1\0\3\11\1\107\27\11\5\0\1\11\1\0"+
    "\1\11\1\110\31\11\5\0\1\11\1\0\15\11\1\111"+
    "\15\11\5\0\1\11\1\0\16\11\1\112\14\11\5\0"+
    "\1\11\1\0\16\11\1\113\1\11\1\114\12\11\3\0"+
    "\40\62\1\0\1\62\41\63\1\115\2\0\1\64\1\0"+
    "\1\64\1\116\36\0\1\11\1\0\2\11\1\53\30\11"+
    "\5\0\1\11\1\0\5\11\1\52\25\11\5\0\1\11"+
    "\1\0\16\11\1\117\14\11\5\0\1\11\1\0\5\11"+
    "\1\120\25\11\5\0\1\11\1\0\10\11\1\121\22\11"+
    "\5\0\1\11\1\0\2\11\1\122\30\11\5\0\1\11"+
    "\1\0\3\11\1\123\27\11\5\0\1\11\1\0\16\11"+
    "\1\124\14\11\5\0\1\11\1\0\21\11\1\52\11\11"+
    "\5\0\1\11\1\0\10\11\1\52\22\11\5\0\1\11"+
    "\1\0\10\11\1\123\22\11\5\0\1\11\1\0\4\11"+
    "\1\125\6\11\1\126\17\11\5\0\1\11\1\0\4\11"+
    "\1\127\26\11\5\0\1\11\1\0\3\11\1\130\27\11"+
    "\5\0\1\11\1\0\7\11\1\53\23\11\5\0\1\11"+
    "\1\0\15\11\1\131\15\11\5\0\1\11\1\0\10\11"+
    "\1\132\22\11\5\0\1\11\1\0\4\11\1\133\26\11"+
    "\5\0\1\11\1\0\6\11\1\112\24\11\5\0\1\11"+
    "\1\0\2\11\1\134\30\11\5\0\1\11\1\0\23\11"+
    "\1\52\7\11\5\0\1\11\1\0\20\11\1\76\12\11"+
    "\5\0\1\11\1\0\17\11\1\52\13\11\5\0\1\11"+
    "\1\0\2\11\1\135\30\11\3\0\37\63\1\136\1\63"+
    "\1\115\2\0\1\11\1\0\23\11\1\104\7\11\5\0"+
    "\1\11\1\0\15\11\1\52\15\11\5\0\1\11\1\0"+
    "\17\11\1\137\13\11\5\0\1\11\1\0\11\11\1\52"+
    "\21\11\5\0\1\11\1\0\7\11\1\120\23\11\5\0"+
    "\1\11\1\0\13\11\1\140\17\11\5\0\1\11\1\0"+
    "\16\11\1\141\14\11\5\0\1\11\1\0\4\11\1\142"+
    "\26\11\5\0\1\11\1\0\16\11\1\143\14\11\5\0"+
    "\1\11\1\0\12\11\1\53\20\11\5\0\1\11\1\0"+
    "\10\11\1\113\22\11\5\0\1\11\1\0\5\11\1\144"+
    "\25\11\5\0\1\11\1\0\12\11\1\145\20\11\5\0"+
    "\1\11\1\0\3\11\1\146\27\11\5\0\1\11\1\0"+
    "\4\11\1\57\26\11\5\0\1\11\1\0\10\11\1\144"+
    "\22\11\5\0\1\11\1\0\4\11\1\147\26\11\5\0"+
    "\1\11\1\0\15\11\1\150\15\11\5\0\1\11\1\0"+
    "\13\11\1\52\17\11\5\0\1\11\1\0\12\11\1\52"+
    "\20\11\5\0\1\11\1\0\1\11\1\52\31\11\5\0"+
    "\1\11\1\0\14\11\1\52\16\11\5\0\1\11\1\0"+
    "\20\11\1\53\12\11\5\0\1\11\1\0\10\11\1\32"+
    "\22\11\5\0\1\11\1\0\3\11\1\76\27\11\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3366];
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
    "\1\0\1\11\24\1\1\11\1\0\30\1\1\0\1\1"+
    "\2\0\30\1\1\0\1\11\32\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[104];
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


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AlexicoC(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public AlexicoC(java.io.InputStream in) {
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
    while (i < 1664) {
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
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
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
          { System.out.print("ID_C("+yytext() + ")");
          }
        case 8: break;
        case 2: 
          { System.out.print("ENTERO("+yytext() + ")");
          }
        case 9: break;
        case 6: 
          { System.out.print("COMENTARIO("+yytext() + ")");
          }
        case 10: break;
        case 5: 
          { System.out.print("-");
          }
        case 11: break;
        case 1: 
          { System.out.print("--");
          }
        case 12: break;
        case 4: 
          { System.out.print(yytext());
          }
        case 13: break;
        case 7: 
          { System.out.print("FLOTANTE("+yytext() + ")");
          }
        case 14: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return YYEOF;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java AlexicoC <inputfile>");
    }
    else {
      for (int i = 0; i < argv.length; i++) {
        AlexicoC scanner = null;
        try {
          scanner = new AlexicoC( new java.io.FileReader(argv[i]) );
          while ( !scanner.zzAtEOF ) scanner.yylex();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
