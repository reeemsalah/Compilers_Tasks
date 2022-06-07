// Generated from D:/University/Semester10/CSEN 1002/Lab9/src/csen1002/main/assignment2\Assignment2.g4 by ANTLR 4.10.1
package csen1002.main.assignment2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Assignment2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8;
	public static final int
		RULE_s = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"s"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'|'", "')'", "'*'", "'a'", "'b'", "'e'", "'p'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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

	@Override
	public String getGrammarFileName() { return "Assignment2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		/**
		 * Compares two integer numbers
		 *
		 * @param x the first number to compare
		 * @param y the second number to compare
		 * @return 1 if x is equal to y, and 0 otherwise
		 */
		public static int check(int x, int y) {
		    return x == y ? 1 : 0;
		}

	public Assignment2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SContext extends ParserRuleContext {
		public int check;
		public int a;
		public int b;
		public SContext s1;
		public SContext s2;
		public SContext s;
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Assignment2Listener ) ((Assignment2Listener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Assignment2Listener ) ((Assignment2Listener)listener).exitS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Assignment2Visitor ) return ((Assignment2Visitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			setState(29);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2);
				match(T__0);
				setState(3);
				((SContext)_localctx).s1 = s();
				setState(4);
				match(T__1);
				setState(5);
				((SContext)_localctx).s2 = s();
				setState(6);
				match(T__2);
				((SContext)_localctx).check =  check(((SContext)_localctx).s1.a,((SContext)_localctx).s2.b); ((SContext)_localctx).a = ((SContext)_localctx).s1.a+((SContext)_localctx).s2.a;((SContext)_localctx).b = ((SContext)_localctx).s1.b+((SContext)_localctx).s2.b;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(9);
				match(T__0);
				setState(10);
				((SContext)_localctx).s1 = s();
				setState(11);
				((SContext)_localctx).s2 = s();
				setState(12);
				match(T__2);
				((SContext)_localctx).a = ((SContext)_localctx).s1.a+((SContext)_localctx).s2.a;((SContext)_localctx).b = ((SContext)_localctx).s1.b+((SContext)_localctx).s2.b;((SContext)_localctx).check = ((SContext)_localctx).s1.check * ((SContext)_localctx).s2.check;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(15);
				match(T__0);
				setState(16);
				((SContext)_localctx).s = s();
				setState(17);
				match(T__3);
				setState(18);
				match(T__2);
				((SContext)_localctx).a = ((SContext)_localctx).s.a; ((SContext)_localctx).b = ((SContext)_localctx).s.b;((SContext)_localctx).check = ((SContext)_localctx).s.check;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(21);
				match(T__4);
				((SContext)_localctx).a = 1;((SContext)_localctx).b = 0;((SContext)_localctx).check = 1;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(23);
				match(T__5);
				((SContext)_localctx).b = 1;((SContext)_localctx).a = 0;((SContext)_localctx).check = 1;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(25);
				match(T__6);
				((SContext)_localctx).b = 0;((SContext)_localctx).a = 0;((SContext)_localctx).check = 1;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(27);
				match(T__7);
				((SContext)_localctx).b = 0;((SContext)_localctx).a = 0;((SContext)_localctx).check = 1;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\b \u0002\u0000\u0007\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0003\u0000\u001e\b\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0000"+
		"\u0000$\u0000\u001d\u0001\u0000\u0000\u0000\u0002\u0003\u0005\u0001\u0000"+
		"\u0000\u0003\u0004\u0003\u0000\u0000\u0000\u0004\u0005\u0005\u0002\u0000"+
		"\u0000\u0005\u0006\u0003\u0000\u0000\u0000\u0006\u0007\u0005\u0003\u0000"+
		"\u0000\u0007\b\u0006\u0000\uffff\uffff\u0000\b\u001e\u0001\u0000\u0000"+
		"\u0000\t\n\u0005\u0001\u0000\u0000\n\u000b\u0003\u0000\u0000\u0000\u000b"+
		"\f\u0003\u0000\u0000\u0000\f\r\u0005\u0003\u0000\u0000\r\u000e\u0006\u0000"+
		"\uffff\uffff\u0000\u000e\u001e\u0001\u0000\u0000\u0000\u000f\u0010\u0005"+
		"\u0001\u0000\u0000\u0010\u0011\u0003\u0000\u0000\u0000\u0011\u0012\u0005"+
		"\u0004\u0000\u0000\u0012\u0013\u0005\u0003\u0000\u0000\u0013\u0014\u0006"+
		"\u0000\uffff\uffff\u0000\u0014\u001e\u0001\u0000\u0000\u0000\u0015\u0016"+
		"\u0005\u0005\u0000\u0000\u0016\u001e\u0006\u0000\uffff\uffff\u0000\u0017"+
		"\u0018\u0005\u0006\u0000\u0000\u0018\u001e\u0006\u0000\uffff\uffff\u0000"+
		"\u0019\u001a\u0005\u0007\u0000\u0000\u001a\u001e\u0006\u0000\uffff\uffff"+
		"\u0000\u001b\u001c\u0005\b\u0000\u0000\u001c\u001e\u0006\u0000\uffff\uffff"+
		"\u0000\u001d\u0002\u0001\u0000\u0000\u0000\u001d\t\u0001\u0000\u0000\u0000"+
		"\u001d\u000f\u0001\u0000\u0000\u0000\u001d\u0015\u0001\u0000\u0000\u0000"+
		"\u001d\u0017\u0001\u0000\u0000\u0000\u001d\u0019\u0001\u0000\u0000\u0000"+
		"\u001d\u001b\u0001\u0000\u0000\u0000\u001e\u0001\u0001\u0000\u0000\u0000"+
		"\u0001\u001d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}