grammar task8_original;

//Parser Rule start to parse the input and check whether it is accepted or rejected
start: (Q2 | Q3 | Q4) + EOF ;

//Lexer Rule Q2 which has the Regular Expression of the accepted state Q2
Q2: ONE * ZERO LOOP10* ZERO
    | ONE * ZERO LOOP10* ZERO ZERO LOOP34* LOOP30*  ZERO ONE* ZERO LOOP10* ZERO;

//Lexer Rule Q3 which has the Regular Expression of the accepted state Q3
Q3:  Q2 ((ONE+ ZERO) | ZERO) (LOOP30|LOOP34)*;
//Lexer Rule Q4 which has the Regular Expression of the accepted state Q4
Q4: Q2 ONE + LOOP43* ONE *
    |Q2 ZERO ONE+ LOOP43* ONE* ;

//Fragments representing the zeros and ones
fragment ZERO: '0' ;
fragment ONE: '1' ;
//Fragments repesenting loops in the DFA
fragment LOOP10: ONE+ZERO;
fragment LOOP30: ZERO ONE * ZERO LOOP10* ZERO ZERO ;
fragment LOOP34: ONE+ ZERO;
fragment LOOP43: ZERO ONE+;
