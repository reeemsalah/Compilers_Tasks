package csen1002.main.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Write your info here
 * 
 * @name Reem Salah
 * @id 43-3979
 * @labNumber 09
 */
public class FDFA {
	Map<String,State>states;
	ArrayList<Character>alphabet;
	TranisitionFunction gamma;
	String startState;
	ArrayList<String>acceptStates;
	
	/**
	 * FDFA constructor
	 * 
	 * @param description is the string describing a FDFA
	 */
	public FDFA(String description) {
		String [] descriptionSplitted = description.split("#");
		String P ="" ;
		String S="" ;
		if(descriptionSplitted.length==2) {
			 P = descriptionSplitted[0];
			 S = descriptionSplitted[1];
		}
		else {
			P = descriptionSplitted[0];
		}
		this.alphabet=new ArrayList<Character>(Arrays.asList('0','1'));
		this.startState="0";
		this.gamma = new TranisitionFunction(P);
		this.states=new HashMap<String,State>();
		this.acceptStates=new ArrayList<String>();
		this.occupyStatesList(P);
		this.occupyAcceptStates(S);
	}

	private void occupyAcceptStates(String s) {
		String [] states = s.split(",");	
		for(int i=0;i<states.length;i++)
		{
			if(states[i]!=""){
			this.acceptStates.add(states[i]);
			}
		}		
	}
	private void occupyStatesList(String p) {
		String [] splitted = p.split(";");
		for(int i=0;i<splitted.length;i++) {
			String [] stateSplitted = splitted[i].split(",");
			String stateNumber = stateSplitted[0];
			String action = stateSplitted[3];
			State state = new State(stateNumber,action);
			System.out.println(stateNumber+","+action);
			this.states.put(stateNumber,state);
		}
	}

	/**
	 * Returns a string of actions.
	 * 
	 * @param input is the string to simulate by the FDFA.
	 * @return string of actions.
	 */
	public String run(String input) {
		int r = 0;
		int l = 0;
		Stack<State> stack = new Stack<State>();
		String res = "";
		String currentState = this.startState;
		while(r<input.length()) {
			String lex="";
			stack = new Stack<State>();
			currentState = this.startState;
			
			for(l=r;l<input.length();l++) {
				stack.push(this.states.get(currentState));
				lex+=input.charAt(l)+"";
				currentState=this.gamma.getNextState(currentState, input.charAt(l));
			}
			stack.push(this.states.get(currentState));
			State lastPushedState = stack.peek();
			String tempLex=lex;
			boolean foundAcceptState = false;
			while(stack.size()>1) {
				State poppedState = stack.pop();
				System.out.println(stack.size());
				String stateNumber = poppedState.stateNumber;
				if(this.acceptStates.contains(stateNumber)) {
					foundAcceptState = true;
					res+=lex+","+poppedState.action+";";
					break;
				}
				l--;
				lex = lex.substring(0, lex.length()-1);
			}
			if(!foundAcceptState) {
				res+=tempLex+","+lastPushedState.action+";";
				break;
			}
			r=l;
		}
		return res;
	}
	public static void main(String[] args) {
		FDFA fdfa2 = new FDFA("0,1,4,N;1,10,2,O;2,3,10,P;3,10,10,A;4,5,7,Q;5,10,6,R;6,10,6,B;7,8,7,S;8,9,10,T;9,10,6,C;10,10,10,U#3,6,9");
		System.out.println(fdfa2.run("010101"));
		
	}
}
class State{
	String stateNumber;
	String action;
	public State(String state,String action) {
		this.stateNumber = state;
		this.action=action;
	}
}
class TranisitionFunction{
	Map<String,String> gamma;
	public TranisitionFunction (String P) {
		this.gamma=new HashMap<String,String>();
		String [] transitions = P.split(";");
		for(int i=0;i<transitions.length;i++)
		{
			String [] singleTransition = transitions[i].split(",");
			String currentState = singleTransition[0];
			String zeroTransition = singleTransition[1];
			String oneTransition = singleTransition[2];
			String keyZero = currentState+""+'0';
			String keyOne = currentState+""+'1';
			gamma.put(keyZero, zeroTransition);
			gamma.put(keyOne, oneTransition);
		}
		System.out.println(gamma.keySet());
		System.out.println(gamma.values());
	}
	public String getNextState(String currentState,char input) {
		String key = currentState+""+input;
		System.out.println(key);
		System.out.println(gamma.get(key));
		return gamma.get(key);
	}
}


