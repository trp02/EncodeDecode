/*
Tirth Patel
CPSC 2310 F21 Section 001
tirthp@g.clemson.edu

TRIAL 2
*/
#include <stdio.h>
#include "utils.h"
#include "EncodeDecode.h"
#include "ppm.h"
int main(int argc, char* argv[])
{
    checkArgs(argc, 2);
    FILE* in = fopen(argv[1], "r");
    checkFile(in);
    FILE* out = fopen(argv[2], "w");
    checkFile(out);
    char* msg = "I hope this works!";
    encodeMsg(in, out, msg);
    FILE* dec = fopen(argv[2], "r");
    checkFile(dec);
    decodeMsg(dec);

    fclose(in);
    fclose(out);
    fclose(dec);

    return 0; //was EXIT_SUCCESS
}


