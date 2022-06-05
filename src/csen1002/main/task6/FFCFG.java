package csen1002.main.task6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Write your info here
 * 
 * @name Reem Salah
 * @id 43-3969
 * @labNumber 09
 */

public class FFCFG {
	// Hashmap contains each and its corresponding rule
	Map<String, String> productionRules;
	ArrayList<String> originialVariables;
	Map<String, ArrayList<Character>> first;
	Map<String, ArrayList<Character>> follow;
	int longestRuleLength = 0;

	/**
	 * Constructs a CFG for which the First and Follow are to be computed
	 * 
	 * @param description A string representation of a CFG as specified in the task
	 *                    description
	 */
	public FFCFG(String description) {
		productionRules = new HashMap<String, String>();
		originialVariables = new ArrayList<String>();
		first = new HashMap<String, ArrayList<Character>>();
		follow = new HashMap<String, ArrayList<Character>>();

		// Splitting using ; to get the rules
		String[] rules = description.split(";");
		for (int i = 0; i < rules.length; i++) {
			String variable = rules[i].charAt(0) + "";
			// Adding the variables in orderS
			String variableRule = rules[i].substring(2);
			productionRules.put(variable, variableRule);
			originialVariables.add(variable);
			ArrayList<Character> emptyFirst = new ArrayList<Character>();
			ArrayList<Character> emptyFollow = new ArrayList<Character>();
			first.put(variable, emptyFirst);
			if(i==0)
				emptyFollow.add('$');
			follow.put(variable, emptyFollow);
			getLongestRuleLength();
		}
	}

	private void getLongestRuleLength() {

		Set<String> variables = productionRules.keySet();
		for (String variable : variables) {
			String[] variableRules = productionRules.get(variable).split(",");
			for (String rule : variableRules) {
				if (rule.length() > longestRuleLength)
					longestRuleLength = rule.length();
			}

		}

	}

	/**
	 * Calculates the First of each variable in the CFG.
	 * 
	 * @return A string representation of the First of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String first() {

		Set<String> variables = productionRules.keySet();
		for (int j = 0; j <longestRuleLength; j++) {
			for (String variable : variables) {
				String[] variableRule = productionRules.get(variable).split(",");
				ArrayList<Character> variableFirst = first.get(variable);

				for (int i = 0; i < variableRule.length; i++) {
					char firstOfRule = variableRule[i].charAt(0);
					//First character of the rule is a terminal
					if (Character.isLowerCase(firstOfRule)) {
						if (!variableFirst.contains(firstOfRule)) {
							variableFirst.add(firstOfRule);
						}
					} else {
						//First Character of the rule is non-terminal
						if (first.containsKey(firstOfRule + "")) {
							//Getting the first of that variable and add it to the current variable
							ArrayList<Character> firstVariableFirst = first.get(firstOfRule + "");
							for (char terminal : firstVariableFirst) {
								//Adding terminal that don't exist already 
								if (!variableFirst.contains(terminal) && terminal != 'e') {

									variableFirst.add(terminal);
								}
								
							}
							//If the first character is non-terminal and contains e in its first
							if (firstVariableFirst.contains('e')) {
								//Looping over all symbols in the rule after that variable
								for (int k = 0; k < variableRule[i].length(); k++) {
									//If it is another variable
									if (Character.isUpperCase(variableRule[i].charAt(k))) {
										//Check if we know the first of it
										if (first.containsKey(variableRule[i].charAt(k) + "")) {

											ArrayList<Character> kThVariableFirst = first
													.get(variableRule[i].charAt(k) + "");
											//Add the first of the kTh variable to the current variable
											for (char terminal : kThVariableFirst) {
												if (!variableFirst.contains(terminal) && terminal != 'e') {
												
													variableFirst.add(terminal);
												}

											}
											//if the kTh variable doesn't contain e, don't continue
											if (!kThVariableFirst.contains('e'))
												break;
											//if the kTh varibale is the last symbol of the rule and it has e in its first, 
											//add e to the first of the current variable
											if (k == variableRule[i].length() - 1 && kThVariableFirst.contains('e') && !variableFirst.contains('e')) {
												//system.out.println(variableFirst);
												variableFirst.add('e');
											}

										}

									}else {
										//The kTh symbol is terminal and the first of the current variable
										//doesn't contain it
										//add it to the first list
										if (!variableFirst.contains(variableRule[i].charAt(k))) {
											variableFirst.add(variableRule[i].charAt(k));
	
										}
										break;
										
									}

								}
							}

						}
					}
				}

			}
		}
		return getFirstOutput();
	}

	private String getFirstOutput() {
		String result = "";

		for (String variable : originialVariables) {
			result += variable + ",";
			ArrayList<Character> firstArrayList = first.get(variable);
			Character[] firstArray = firstArrayList.toArray(new Character[0]);
			Arrays.sort(firstArray);
			for (int i = 0; i < firstArray.length; i++) {
				result += firstArray[i] + "";
			}
			result += ";";
		}
		return result.substring(0, result.length()-1);
	}

	private String getFollowOutput() {
		String result = "";

		for (String variable : originialVariables) {
			result += variable + ",";
			ArrayList<Character> followArrayList = follow.get(variable);
			Character[] followArray = followArrayList.toArray(new Character[0]);
			Arrays.sort(followArray);
			boolean containsDollarSign = false;
			for (int i = 0; i < followArray.length; i++) {
				if (followArray[i] == '$')
					containsDollarSign = true;
				else
					result += followArray[i] + "";
			}
			if (containsDollarSign)
				result += '$' + "";
			result += ";";
		}
		return result.substring(0, result.length()-1);
	}

	/**
	 * Calculates the Follow of each variable in the CFG.
	 * 
	 * @return A string representation of the Follow of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String follow() {
		first();
		Set<String> variables = productionRules.keySet();
		for (int l = 0; l < longestRuleLength; l++) {
		for (String variable : variables) {
			String[] variableRule = productionRules.get(variable).split(",");
			//Looping over each rule of the current variable
			for(int i=0;i<variableRule.length;i++)
			{
				//looping over every character in that rule (variable rule)
				for(int j=0;j<variableRule[i].length();j++) {
					//if we encountered a variable
					if(Character.isUpperCase(variableRule[i].charAt(j)))
					{
						String jThVariable = variableRule[i].charAt(j)+"";
						ArrayList<Character> jThFollow = follow.get(jThVariable);
						//Check if it isn't the last symbol
						if(j!=variableRule[i].length()-1) {
							//Add the first of the next variable to the follow
							//of the current variable
							
								//Looping after all variables after that variable
								for(int k=j+1;k<variableRule[i].length();k++) {
									//getting the first of the kth variable after jth variable
									if(Character.isUpperCase(variableRule[i].charAt(k))) {
									ArrayList<Character> kThFirst = first.get( variableRule[i].charAt(k)+"");
									//Adding all the first of kth variable to follow of jth variable
									for(char terminal:kThFirst)
										if(!jThFollow.contains(terminal) && terminal!='e') {
											jThFollow.add(terminal);
											
										}
									//if there is no epsilon in the first of the kth variable
									//break and don't check following variables
									if(kThFirst.contains('e')) {
										if(k== variableRule[i].length()-1) {
											
													//Put the follow of the current
											//to the follow of the k-1Th variable
											if(follow.containsKey(variable) && !(variableRule[i].charAt(k-1)+"").equals(variable) ) {
												ArrayList<Character> currVarFollow = follow.get(variable);
												ArrayList<Character> k_1ThFollow = follow.get(variableRule[i].charAt(k-1)+"");
												for(char terminal:currVarFollow) {
													if(!k_1ThFollow.contains(terminal)) {
														k_1ThFollow.add(terminal);
													}
												}
												
											}
										}
										
									}
									else
										break;
										
								
									}
									//It is a terminal
									else {
										if(!jThFollow.contains(variableRule[i].charAt(k)))
											jThFollow.add(variableRule[i].charAt(k));
										break;
									}
									
								}
								
							
						}
						//it is the last symbol in the rule
						else {
							if(Character.isUpperCase(variableRule[i].charAt(j))) {
							//Put the follow of the current
							//to the follow of the jTh variable
							if(follow.containsKey(variable) && !jThVariable.equals(variable) ) {
								ArrayList<Character> currVarFollow = follow.get(variable);
								for(char terminal:currVarFollow) {
									if(!jThFollow.contains(terminal) && terminal!='e') {
										jThFollow.add(terminal);
									}
								}
								
							}
							}
							
							
							
							
							
						}
						
					}
					
				}
			}
			
		}
		
	}
		return getFollowOutput();
	}

	public static void main(String[] args) {
		FFCFG cfg = new FFCFG("S,u,aYSV;Y,V,sYzSS,t;V,EuEu,uV,t,E;W,z,zE;X,bE,E,SuWV,tV;E,SaXt,tV,e");
//		//system.out.println(cfg.first());
		//system.out.println(cfg.follow());

	}

}
