grammar Assignment2;
@members {
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
}

s returns[int check, int a , int b]: '(' s1=s '|' s2=s ')'{$check = check($s1.a,$s2.b); $a=$s1.a+$s2.a;$b=$s1.b+$s2.b;}
| '('s1=s s2=s ')'{$a=$s1.a+$s2.a;$b=$s1.b+$s2.b;$check=$s1.check * $s2.check;}
| '(' s '*' ')'{$a=$s.a; $b=$s.b;$check=$s.check;}
|'a'{$a=1;$b=0;$check=1;}
|'b' {$b=1;$a=0;$check=1;}
| 'e'{$b=0;$a=0;$check=1;}
| 'p' {$b=0;$a=0;$check=1;};