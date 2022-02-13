/*
Tirth Patel
CPSC 2310 F21 Section 001
tirthp@g.clemson.edu
*/
#pragma once 
#include <stdio.h>
#include "ppm.h"


void encodeMsg(FILE* in, FILE* out, char* msg);
void charToBinary(char u , int *x);
void binToCharacter(int array[]);
void dec2bin(int*, int);
void decodeMsg(FILE* file);


