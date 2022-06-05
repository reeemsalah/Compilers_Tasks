package csen1002.main.task7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;


/**
 * Write your info here
 * 
 * @name Reem Salah
 * @id 43-3969
 * @labNumber 09
 */
public class LL1CFG {
	
	HashMap<Character,HashMap<String,String>> first;
	HashMap<Character,String > productionRules;
	HashMap<Character,String> follow;
	HashSet<Character> alphabet;
	HashSet<Character> variables;
	HashMap<Character,HashMap<Character,String>> parsingTable;

	
	/**
	 * LL1 CFG constructor
	 * 
	 * @param description is the string describing an LL(1) CFG, first, and follow as represented in the task description.
	 * A string encoding a CFG together with its First and Follow sets is a #-separated
	sequence of three items. The first item is a string encoding of the CFG, the second item
	is a string encoding of the First sets, and the third is a string encoding of the Follow
	sets.
	 * 
	 */
	
	public LL1CFG(String description) {
		//Instance Variable initialization
		first = new HashMap<Character,HashMap<String,String>>();
		productionRules = new HashMap<Character,String>();
		follow = new HashMap<Character,String>();
		alphabet = new HashSet<Character> ();
		variables = new HashSet<Character> ();
		parsingTable = new HashMap<Character,HashMap<Character,String>> ();
		//Parsing input
		String [] descriptionHashSplitted = description.split("#");
		String [] rulesSplitted = descriptionHashSplitted[0].split(";");
		String [] firstSplitted = descriptionHashSplitted[1].split(";");
		String [] followSplitted = descriptionHashSplitted[2].split(";");
		
		for(int i=0;i<rulesSplitted.length;i++) {
			//Getting current variable rules, first of production rules and follow of the variable
			String [] currentRules = rulesSplitted[i].split(",");
			String [] currentFirst = firstSplitted[i].split(",");
			String [] currentFollow = followSplitted[i].split(",");
			//Getting the variable from the rules
			Character currentVariable = currentRules[0].charAt(0);
			variables.add(currentVariable);
			//Putting the rules of that Variable
			productionRules.put(currentVariable, rulesSplitted[i]);
			//Setting the follow of that variable
			follow.put(currentVariable, currentFollow[1]);
			//Looping over the follow of the variable to add it to the alphabet of the grammar
			for(int k = 0;k<currentFollow[1].length();k++) {
				Character currentChar = currentFollow[1].charAt(k);
				if(!alphabet.contains(currentChar) ) {
					alphabet.add(currentChar);
				}
			}
			//Setting the first of the rules
			HashMap<String,String> currentVariableFirstHashMap = new HashMap<String,String>();
			for(int j=1;j<currentRules.length;j++) {
				currentVariableFirstHashMap.put(currentRules[j], currentFirst[j]);
				//Looping over all the firsts of rules to add it to the alphabet of the grammar
				for(int k = 0;k<currentRules[j].length();k++) {
					Character currentChar = currentRules[j].charAt(k);
					if(!alphabet.contains(currentChar) && currentChar!='e' && Character.isLowerCase(currentChar)) {
						alphabet.add(currentChar);
					}
				}
			}
			first.put(currentVariable, currentVariableFirstHashMap);	
		}
		
		fillParsingTable();

	}
	private void fillParsingTable() {
		for(char var : variables) {
			HashMap<Character,String> currentVarRow = new HashMap<Character,String>();
			for(char a:alphabet) {
				HashMap<String,String> currentVarRulesFirsts = first.get(var);
				String currentVarFollow = follow.get(var);
				String cellRule="";
				//Checking if the current alphabet symbol belongs to the first 
				//of any rule of the current variable
				for(String rule: currentVarRulesFirsts.keySet()) {
					String currentRuleFirst = currentVarRulesFirsts.get(rule);
					if(currentRuleFirst.contains(a+""))
						cellRule=rule;
					//Checking if the current character belongs to the follow 
					//of the current variable if epsilon belongs to the first
					//of the current rule
					if(currentRuleFirst.contains("e") && currentVarFollow.contains(a+""))
						cellRule=rule;
				}
				if(!cellRule.equals(""))
					currentVarRow.put(a, cellRule);
				
			}
			parsingTable.put(var, currentVarRow);
		}
		
	}
	/**
	 * Returns A string encoding a derivation is a comma-separated sequence of sentential forms each representing a step in the derivation..
	 * 
	 * @param input is the string to be parsed by the LL(1) CFG.
	 * @return returns a string encoding a left-most derivation.
	 */
	public String parse(String input) {
		//Adding dollar sign to the input 
		input += "$";
		Stack <Character> stack = new Stack<Character>();
		//Pushing $  and Start variable
		stack.push('$');
		stack.push('S');
		
		boolean accept = false;
		//We start derivation from the start variable
		String result = "S";
		//The head is at the start of the input
		int head =0;
		//
		while(!accept) {
			System.out.println(stack);
			String [] resultStrings = result.split(",");
			char top = stack.peek();
			System.out.println(Character.isUpperCase(top));
			char lookAhead = input.charAt(head);
			//If the look ahead symbol is equal to the top of the stack
			if(lookAhead == top) {
				//pop the symbol
				stack.pop();
				//move the head to the right
				head++;
			}
			else {
				//the top the stack is a variable
				if(Character.isUpperCase(top)) {
					String rule = parsingTable.get(top).get(lookAhead);
					//the parsing table cell is empty
					if(rule==null) {
							//Error
							result+=",ERROR";
							return result.replace("e", "");
							
						}
						
					
					//the parsing table cell contains an entry
					else {
						String lastItem = resultStrings[resultStrings.length-1];
						String newItem = lastItem.replaceFirst(top+"", rule);
						result+=","+newItem;
						//pop the variable
						stack.pop();
						//check first if it isn't epsilon
						if(!rule.equals("e")) {
							//push the rule backwards
							for(int j=rule.length()-1;j>=0;j--) {
								stack.push(rule.charAt(j));
								
							}
						}
						
					}
					
				}
				//it is a terminal that doesn't match the look ahead symbol
				else {
					//Error
					result+=",ERROR";
					return result.replace("e", "");
				}
				
			}
			

		System.out.println(stack);
		//If the top of the stack is dollar sign
		if(stack.peek()=='$') {
			//we reached the end of the input
			if(input.charAt(head) == '$')
				accept = true;
			else
				return result.replace("e", "")+",ERROR";
				
		}
			
		}
		System.out.println(head);		
		return result.replace("e", "");
	
		
	}

	public static void main(String[] args) {
		LL1CFG ll1cfg1 = new LL1CFG("S,oLc,a;L,oLcD,aD;D,mSD,e#S,o,a;L,o,a;D,m,e#S,cm$;L,c;D,c");
		System.out.println(ll1cfg1.parsingTable);
		LL1CFG ll1cfg2 = new LL1CFG("S,ipD,oSmDc,e;D,VmS,LxS;V,n,e;L,oSc,e#S,i,o,e;D,mn,ox;V,n,e;L,o,e#S,cm$;D,cm$;V,m;L,x");
		System.out.println(ll1cfg2.parsingTable);



	}

}
