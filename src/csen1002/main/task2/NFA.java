package csen1002.main.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


/**
 * Write your info here
 * 
 * @name Reem Salah
 * @id 43-3969
 * @labNumber 09
 */
public class NFA{
	
	ArrayList<String>states;
	ArrayList<Character>alphabet;
	TranisitionFunction gamma;
	String startState;
	ArrayList<String>acceptStates;
	Map<String,String> epsilonClosures;
	/**
	 * NFA constructor
	 * 
	 * @param description is the string describing a NFA
	 */
	public NFA(String description) {
		
		this.alphabet=new ArrayList<Character>(Arrays.asList('0','1'));

		
		String [] descriptionSplittedUsingHash = description.split("#");
	
		String zeroTransitions= descriptionSplittedUsingHash[0];
		String oneTransitions = descriptionSplittedUsingHash[1];
		String epsilonTransitions = descriptionSplittedUsingHash[2];
		String acceptStatesStr = descriptionSplittedUsingHash[3];
		//Calculating epsilon closures
		this.getEpsilonClosures(epsilonTransitions);
//		System.out.println(epsilonClosures.values());
		//If the start state has an epsilon closure set the start state to that closure
		if(epsilonClosures.containsKey("0"))
			startState=epsilonClosures.get("0");
		else
			startState="0";
		//Calculating the transition function
		gamma = new TranisitionFunction(zeroTransitions,oneTransitions,epsilonClosures,startState);
		
		//Occupying accept states
		acceptStates = new ArrayList<String>();
		this.occupyAcceptStates(acceptStatesStr);
	}

	private void getEpsilonClosures(String epsilonTransitions) {
		epsilonClosures = new HashMap<String,String>();
		String[] epsilonTransitionsSplitted = epsilonTransitions.split(";");
		for(int i=0;i<epsilonTransitionsSplitted.length;i++) {
			String[] states=epsilonTransitionsSplitted[i].split(",");
			if(states.length==2) {
			String s1=states[0];
			String s2=states[1];
			if(epsilonClosures.containsKey(s1)) {
				String oldValue = epsilonClosures.get(s1);
				String res = TranisitionFunction.augmentString(oldValue,s2);
				epsilonClosures.put(s1, res);
			}
			else {
				String res = TranisitionFunction.augmentString(s1,s2);
				epsilonClosures.put(s1, res);
			}
			}
		}
		
		Set <String> keys = epsilonClosures.keySet();
		for(String outerKey:keys) {
			for(String innerKey:keys){
				if(!outerKey.equals(innerKey)) {
					String newValue = combineEpsilonCLosures(outerKey, epsilonClosures.get(innerKey), epsilonClosures.get(outerKey));
					
					epsilonClosures.put(innerKey, newValue);
				}
			}
		}

		
	}
	public static String combineEpsilonCLosures(String state,String whatToRemoveFrom,String whatToPut) {
		String  [] splitted=whatToRemoveFrom.split(",");
//		System.out.println(state+" "+whatToRemoveFrom+" "+whatToPut);
		for(int i=0;i<splitted.length;i++) {
			if(splitted[i].equals(state))
				splitted[i]=whatToPut;
		}
		return String.join(",",splitted);
	}

	
	private void occupyAcceptStates(String S) {
		String [] states = S.split(",");
		
		for(int i=0;i<states.length;i++)
		{
			if(states[i]!=""){
			this.acceptStates.add(states[i]);
			}
			
		}
	}

	/**
	 * Returns true if the string is accepted by the NFA and false otherwise.
	 * 
	 * @param input is the string to check by the NFA.
	 * @return if the string is accepted or not.
	 */
	public boolean run(String input) {
		String currentState=this.startState;
		for(int i=0;i<input.length();i++) {
			String currentInputSymbol = input.charAt(i)+"";
			currentState = this.gamma.getNextState(currentState, currentInputSymbol);
		}
//		System.out.println(currentState);
		String[] finalStateSplitted = currentState.split(",");
		for(String interState:finalStateSplitted) {
			if(this.acceptStates.contains(interState))
				return true;
		}
		return false;
	
	}
	
}
class TranisitionFunction{
	//The Hashmap consists of keys of the form currentState#input and values of the form nextState
	//States are comma separated. For example, 0,1,2

	Map<String,String> gamma;
	Map<String,String> zeroTransitions;
	Map<String,String> oneTransitions;
	

	public TranisitionFunction(String zeros,String ones,Map<String,String>epsilonClosure,String startState) {
		gamma = new HashMap<String,String>();
		zeroTransitions = new HashMap<String,String>();
		oneTransitions = new HashMap<String,String>();
		this.fillTransitions(zeros,"0");
		this.fillTransitions(ones,"1");
		Stack<String> unresolvedTransitions=new Stack<String>();
		unresolvedTransitions.add(startState+"#0");
		unresolvedTransitions.add(startState+"#1");
		while(!unresolvedTransitions.isEmpty()) {
			String currentTransition=unresolvedTransitions.pop();
			String[] currentTransitionSplitted=currentTransition.split("#");
			String state=currentTransitionSplitted[0];
			String input = currentTransitionSplitted[1];
			String nextState="";
			String [] interStates= state.split(",");
			
			for(String s:interStates) {
				if(input.equals("0")) {
					if(zeroTransitions.containsKey(s)) 
						if(epsilonClosure.containsKey(zeroTransitions.get(s)))
							nextState=augmentString(nextState, epsilonClosure.get(zeroTransitions.get(s)));
						else
							nextState=augmentString(nextState, zeroTransitions.get(s));
					
					
				}else {
					if(oneTransitions.containsKey(s))
						if(epsilonClosure.containsKey(oneTransitions.get(s)))
							nextState=augmentString(nextState, epsilonClosure.get(oneTransitions.get(s)));
						else
							nextState=augmentString(nextState, oneTransitions.get(s));
					
				}
				
			}
			if(nextState!="" && nextState.charAt(0)==',') {
				nextState=nextState.substring(1);
			}
			gamma.put(currentTransition, nextState);
			if(!gamma.containsKey(nextState+"#1"))
				unresolvedTransitions.push(nextState+"#1");
			if(!gamma.containsKey(nextState+"#0"))
				unresolvedTransitions.push(nextState+"#0");
		}
//		System.out.println(gamma.keySet());
//		System.out.println(gamma.values());

		
	}
	public static String augmentString(String currentState,String nextState) {
		ArrayList<String> currentStateSplitted = new ArrayList<String>(Arrays.asList(currentState.split(",")));
		String [] nextStateSplitted = nextState.split(",");
		for( int i=0;i<nextStateSplitted.length;i++) {
			if(!currentStateSplitted.contains(nextStateSplitted[i]))
				currentState+=","+nextStateSplitted[i];
		}
		return currentState;
	}


	private void fillTransitions(String transitionDescription, String input) {
		String [] transitionSplitted = transitionDescription.split(";");
		
		switch(input) {
			case "0":
				for(int i =0;i<transitionSplitted.length;i++) {
					String[] states=transitionSplitted[i].split(",");
					if(states.length==2) {
					if(zeroTransitions.containsKey(states[0]))
						zeroTransitions.put(states[0], zeroTransitions.get(states[0])+","+states[1]);
					else
						zeroTransitions.put(states[0], states[1]);
					}
				}
			break;
			case "1":
				for(int i =0;i<transitionSplitted.length;i++) {
					String[] states=transitionSplitted[i].split(",");
					if(states.length==2) {
					if(oneTransitions.containsKey(states[0]))
						oneTransitions.put(states[0], oneTransitions.get(states[0])+","+states[1]);
					else
						oneTransitions.put(states[0], states[1]);
					}
				}
			break;
			
		}
				
		
	}
	public String getNextState(String currentState,String input) {
		return gamma.get(currentState+"#"+input);
	}


	
	
}
