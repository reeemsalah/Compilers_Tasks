// Generated from D:/University/Semester 10/CSEN 1002/Lab9/src/csen1002/main/task8\task8.g4 by ANTLR 4.10.1
package csen1002.main.task8;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class task8Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Q2=1, Q3=2, Q4=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Q2", "Q3", "Q4", "ZERO", "ONE", "Q0", "LOOP1", "LOOP2", "LOOP3"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Q2", "Q3", "Q4"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public task8Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "task8.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0003S\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u00051\b\u0005\n\u0005\f\u00054\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u00059\b\u0005\n\u0005\f\u0005<\t"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006A\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007J\b\u0007\u0001\b\u0001\b\u0001\b\u0005\bO\b\b\n\b\f"+
		"\bR\t\b\u0000\u0000\t\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0000"+
		"\t\u0000\u000b\u0000\r\u0000\u000f\u0000\u0011\u0000\u0001\u0000\u0000"+
		"U\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0001\u0013\u0001\u0000\u0000\u0000"+
		"\u0003\u001f\u0001\u0000\u0000\u0000\u0005!\u0001\u0000\u0000\u0000\u0007"+
		"#\u0001\u0000\u0000\u0000\t%\u0001\u0000\u0000\u0000\u000b:\u0001\u0000"+
		"\u0000\u0000\r@\u0001\u0000\u0000\u0000\u000fI\u0001\u0000\u0000\u0000"+
		"\u0011K\u0001\u0000\u0000\u0000\u0013\u0014\u0003\u000b\u0005\u0000\u0014"+
		"\u0015\u00050\u0000\u0000\u0015\u0016\u00050\u0000\u0000\u0016\u0002\u0001"+
		"\u0000\u0000\u0000\u0017\u0018\u0003\u000b\u0005\u0000\u0018\u0019\u0005"+
		"0\u0000\u0000\u0019\u001a\u00050\u0000\u0000\u001a\u001b\u00050\u0000"+
		"\u0000\u001b \u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0011\b\u0000"+
		"\u001d\u001e\u00050\u0000\u0000\u001e \u0001\u0000\u0000\u0000\u001f\u0017"+
		"\u0001\u0000\u0000\u0000\u001f\u001c\u0001\u0000\u0000\u0000 \u0004\u0001"+
		"\u0000\u0000\u0000!\"\u0003\u0011\b\u0000\"\u0006\u0001\u0000\u0000\u0000"+
		"#$\u00050\u0000\u0000$\b\u0001\u0000\u0000\u0000%&\u00051\u0000\u0000"+
		"&\n\u0001\u0000\u0000\u0000\'9\u00051\u0000\u0000()\u00050\u0000\u0000"+
		")9\u00051\u0000\u0000*+\u00050\u0000\u0000+,\u00050\u0000\u0000,-\u0005"+
		"0\u0000\u0000-9\u00050\u0000\u0000.2\u0003\u000f\u0007\u0000/1\u0003\r"+
		"\u0006\u00000/\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001"+
		"\u0000\u0000\u000023\u0001\u0000\u0000\u000035\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000056\u00050\u0000\u000067\u00050\u0000\u00007"+
		"9\u0001\u0000\u0000\u00008\'\u0001\u0000\u0000\u00008(\u0001\u0000\u0000"+
		"\u00008*\u0001\u0000\u0000\u00008.\u0001\u0000\u0000\u00009<\u0001\u0000"+
		"\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;\f\u0001"+
		"\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=>\u00050\u0000\u0000>A\u0005"+
		"1\u0000\u0000?A\u00051\u0000\u0000@=\u0001\u0000\u0000\u0000@?\u0001\u0000"+
		"\u0000\u0000A\u000e\u0001\u0000\u0000\u0000BC\u00050\u0000\u0000CD\u0005"+
		"0\u0000\u0000DJ\u00051\u0000\u0000EF\u00050\u0000\u0000FG\u00050\u0000"+
		"\u0000GH\u00050\u0000\u0000HJ\u00051\u0000\u0000IB\u0001\u0000\u0000\u0000"+
		"IE\u0001\u0000\u0000\u0000J\u0010\u0001\u0000\u0000\u0000KL\u0003\u000b"+
		"\u0005\u0000LP\u0003\u000f\u0007\u0000MO\u0003\r\u0006\u0000NM\u0001\u0000"+
		"\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001"+
		"\u0000\u0000\u0000Q\u0012\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000"+
		"\u0000\b\u0000\u001f28:@IP\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}