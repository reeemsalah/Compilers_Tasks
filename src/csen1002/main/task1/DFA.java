package csen1002.main.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import java.util.Arrays;

/**
 * Write your info here
 * 
 * @name Reem Salah Mansour
 * @id 43-3969
 * @labNumber 09
 */
public class DFA {
	ArrayList<Character>states;
	ArrayList<Character>alphabet;
	TranisitionFunction gamma;
	char startState;
	ArrayList<Character>acceptStates;
	
	/**
	 * DFA constructor
	 * 
	 * @param description is the string describing a DFA
	 */
	public DFA(String description) {
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
		this.gamma = new TranisitionFunction(P);
		this.states=new ArrayList<Character>();
		this.acceptStates=new ArrayList<Character>();
		this.occupyStatesList(P);
		this.occupyAcceptStates(S);
		
	}
	private void occupyAcceptStates(String S) {
		String [] states = S.split(",");
		
		for(int i=0;i<states.length;i++)
		{
			if(states[i]!=""){
			this.acceptStates.add(states[i].charAt(0));
			}
			
		}
	}
	private void occupyStatesList(String P) {
		String [] states = P.split(";");
		for(int i=0;i<states.length;i++)
		{
			String [] signleState = states[i].split(",");
			char currentState = signleState[0].charAt(0);
			if(!this.states.contains(currentState)) {
				this.states.add(currentState);
			}
		}
	}

	/**
	 * Returns true if the string is accepted by the DFA and false otherwise.
	 * 
	 * @param input is the string to check by the DFA.
	 * @return if the string is accepted or not.
	 */
	public boolean run(String input) {
		char currentState='0';
		for(int i=0;i<input.length();i++) {
			char currentInputSymbol = input.charAt(i);
			currentState = this.gamma.getNextState(currentState, currentInputSymbol);
		}
		
		
		System.out.println(currentState);
		System.out.println(this.acceptStates);
		return this.acceptStates.contains(currentState);
	}
}
class TranisitionFunction{
	Map<String,Character> gamma;
	public TranisitionFunction (String P) {
		this.gamma=new HashMap<String,Character>();
		String [] transitions = P.split(";");
		for(int i=0;i<transitions.length;i++)
		{
			System.out.println(transitions[i]);

			
			String [] singleTransition = transitions[i].split(",");
			System.out.println(singleTransition[0]);

			char currentState = singleTransition[0].charAt(0);
			char zeroTransition = singleTransition[1].charAt(0);
			char oneTransition = singleTransition[2].charAt(0);
			String keyZero = currentState+""+'0';
			String keyOne = currentState+""+'1';
			gamma.put(keyZero, zeroTransition);
			gamma.put(keyOne, oneTransition);

 
		}
	}
	public char getNextState(char currentState,char input) {
		String key = currentState+""+input;
		System.out.println(key);
		System.out.println(gamma.get(key));
		return gamma.get(key);
		
	}
	
	
}

