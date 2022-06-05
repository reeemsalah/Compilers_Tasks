package csen1002.main.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Write your info here
 * 
 * @name Reem Salah
 * @id 43-3969
 * @labNumber 09
 */
public class CFG {
	//Hashmap contains each and its corresponding rule
	Map<String,String> productionRules;
	//The original ordering of variables for printing the output
	ArrayList <String> originialVariables;
	/**
	 * CFG constructor
	 * 
	 * @param description is the string describing a CFG
	 */
	public CFG(String description) {
		productionRules = new HashMap<String,String>();
		originialVariables = new ArrayList <String>();
		//Splitting using ; to get the rules
		String [] rules= description.split(";");
		for(int i=0;i<rules.length;i++) {
			String variable = rules[i].charAt(0)+"";
			//Adding the variables in orderS
			originialVariables.add(variable);
			String variableRule = rules[i].substring(2);
			productionRules.put(variable, variableRule);
		}
		System.out.println(originialVariables);
		
	}

	/**
	 * Returns a string of eliminated left recursion.
	 * 
	 * @param input is the string to simulate by the CFG.
	 * @return string of eliminated left recursion.
	 */
	public String lre() {
		//Main Loop
		for(int i=0;i<originialVariables.size();i++) {
			//Looping over previous variables
			for(int j=0;j<i;j++) {
				//Outer loop variable
				String mainLoopRule = productionRules.get(originialVariables.get(i));
				//Inner loop variable
				String secLoopRule = productionRules.get(originialVariables.get(j));
				//Replacing rules of the form Ai --> AjX with the right hand side of Aj
				String newRule =replaceVariableWithRules(originialVariables.get(j),mainLoopRule,secLoopRule);
				productionRules.put(originialVariables.get(i), newRule);
			}
			//Removing immediate left recursion of outer loop variable
			if(hasImmediateLeftRecursion(originialVariables.get(i)))
				removeImmediateLeftRecursion(originialVariables.get(i));
		}

		return getOutput();
	}
	/**
	 * if we have rule of the form Ai --> AjX and Aj --> A1 | A2 |...|An, we should
	 * replace Aj with each of A1, A2, ..., An to output Ai --> A1X | A2X |...| AnX
	 * 
	 * @param variable (Aj) the variable name to replace in whatToReplaceIn
	 * @param whatToReplaceIn (AjX) the rule in which the variable will be replaced with
	 * every rule in whatToPutInstead
	 * @param whatToPutInstead (Aj --> A1 | A2 |...|An)
	 * @return
	 */
	private String replaceVariableWithRules(String variable, String whatToReplaceIn, String whatToPutInstead) {
		String [] whatToReplaceInSplitted = whatToReplaceIn.split(",");
		String [] whatToPutInsteadSplitted = whatToPutInstead.split(",");
		
		for(int i=0;i<whatToReplaceInSplitted.length;i++) {
			if(whatToReplaceInSplitted[i].charAt(0) == variable.charAt(0)) {
				String result="";
				for(String gamma: whatToPutInsteadSplitted) {
					result+=gamma+whatToReplaceInSplitted[i].substring(1)+",";
				}
				result=result.substring(0, result.length()-1);
				whatToReplaceInSplitted[i]=result;
			}
			
		}
		return String.join(",", whatToReplaceInSplitted);
	}
	/**
	 * 
	 * @param string remove immediate left recursion of the variable string in 
	 * the productionRules hashmap
	 */

	private void removeImmediateLeftRecursion(String string) {
		ArrayList<String> alphas = getAlphas(string);
		ArrayList<String> betas = getBetas(string);
		
		String newAddedVariable = string+"'";

		String newVariableRule="";
		for(String beta:betas) {
			newVariableRule+=beta+newAddedVariable+",";
			
		}
		newVariableRule=newVariableRule.substring(0, newVariableRule.length()-1);
		productionRules.put(string, newVariableRule);
		
		String newAddedRule ="";
		for(String alpha:alphas) {
			newAddedRule += alpha+newAddedVariable+",";

		}
		newAddedRule+="e";
		productionRules.put(newAddedVariable, newAddedRule);



	}
	/**
	 * if we have a rule of the form A --> B1 | B2 |..|Bn where B is a sentential 
	 * form that doesn't start with A
	 * @param string variable A in the productionRules Hashamp
	 * @return a list of all sentential forms in A's that doesn't start with A
	 */

	private ArrayList<String> getBetas(String string) {
		ArrayList<String> result = new ArrayList<String>();
		String [] rules = productionRules.get(string).split(",");
		for(String rule:rules) {
			if(!string.equals(rule.charAt(0)+"") ) 
				result.add(rule);
		}

		return result;
	}
	/**
	 * if we have rules of the form A --> Aa1 | Aa2 |...| Aan where ai is't an empty string
	 * @param string variable A in the productionRules Hashamp 
	 * @return a list of all sentential forms in A's production rules that follow A
	 */

	private ArrayList<String> getAlphas(String string) {
		ArrayList<String> result = new ArrayList<String>();
		String [] rules = productionRules.get(string).split(",");
		for(String rule:rules) {
			if(string.equals(rule.charAt(0)+"") ) 
				result.add(rule.substring(1));
		}
		System.out.println(string+"///"+result);

		return result;
	}
	/**
	 * 
	 * @param string a variable in the hashmap of production rules
	 * @return true if the variablehas immediate left recursion 
	 *         false otherwise
	 */

	private boolean hasImmediateLeftRecursion(String string) {
		boolean flag = false;
		String [] rules = productionRules.get(string).split(",");
		for(String rule:rules) {
			if(string.equals(rule.charAt(0)+""))
				flag=true;
		}
		return flag;
	}
	/**
	 * 
	 * @return a context free grammar that doesn't contain left recursion 
	 * in the standard form for test cases
	 */

	public String getOutput() {
		
		String res="";
		for(Object keyObj:originialVariables ) {
			String key = (String) keyObj;
			System.out.println(key);
			res+=key+","+productionRules.get(key)+";";
			String keyPrime = key+"'";
			if(productionRules.containsKey(keyPrime))
				res+=keyPrime+","+productionRules.get(keyPrime)+";";
				
		}
		res=res.substring(0, res.length()-1);
		return res;
		
	}
	public static void main(String[] args) {
		CFG c1=new CFG("S,LW,Wd;L,SW,LS,m;W,SL,m");
	
		System.out.println(c1.lre());
		System.out.println("S,LW,Wd;L,WdWL',mL';L',WWL',SL',e;W,mL'WLW',mW';W',dWL'WLW',dLW',e");
		

	}
}
