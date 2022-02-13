/*
Tirth Patel
CPSC 2310 F21 Section 001
tirthp@g.clemson.edu
*/
#include <stdio.h>
#pragma once
typedef struct
{
    unsigned char r;
    unsigned char g;
    unsigned char b;
}pixel_t;

typedef struct
{
    char magicNum[3];
    int width;
    int height;
    int maxVal;
}header_t;

header_t readHeader(FILE* file);
pixel_t** readPixel(FILE* file, header_t);
void writeHeader(FILE* file, header_t x);
void freeMemory(pixel_t** pixels, header_t header);
