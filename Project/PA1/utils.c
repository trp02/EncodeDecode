/*
Tirth Patel
CPSC 2310 F21 Section 001
tirthp@g.clemson.edu
*/
#include "utils.h"
#include <stdio.h>
#include <stdlib.h>
//makes sure there are 3 arguments 
void checkArgs(int x, int y){
    if(x != 3){
        fprintf(stderr,"Not Enough Arguments\n");
        exit(1);
    }
}
//checks if input file is null
void checkFile(FILE* file){
    if(file == NULL){
        fprintf(stderr,"File did not open correctly\n");
        exit(1);
    }
}