grammar task8;

//Parser Rule start to parse the input and check whether it is accepted or rejected
start: (Q2 | Q3 | Q4) + EOF ;

//Lexer Rule Q2 which has the Regular Expression of the accepted state Q2
Q2:Q0 '00';
//Lexer Rule Q3 which has the Regular Expression of the accepted state Q3
Q3: Q0 '000'
   |LOOP3'0';
//Lexer Rule Q4 which has the Regular Expression of the accepted state Q4
Q4: LOOP3;

//Fragments representing the zeros and ones
fragment ZERO: '0' ;
fragment ONE: '1' ;
//Fragments repesenting loops in the DFA
fragment Q0: ('1' | '01' | '0000' | LOOP2 LOOP1*'00')*;
fragment LOOP1: '01'|'1';
fragment LOOP2:'001'|'0001';
fragment LOOP3: Q0 LOOP2 LOOP1*;



