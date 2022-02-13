#include "ppm.h"
#include <stdbool.h>
#include <stdlib.h>
/*
Prameters: input file
scans file information at the top
*/
header_t readHeader(FILE* file){
    header_t headerR;
    fscanf(file,"%s",headerR.magicNum);
    fscanf(file,"%d %d ",&headerR.width,&headerR.height);
    fscanf(file,"%d\n",&headerR.maxVal);

    return headerR;
}
//takes header object and output file to replicate like in the input file
void writeHeader(FILE* file, header_t x){
    fprintf(file, "%s\n%d %d %d\n",x.magicNum, x.width, x.height, x.maxVal);
}
/*
parameters: input file, header function
returns: 2d pixel array
this function allocates enough memory to store all the pixels, reads them, and returns a 
2d pixel array. 
*/
pixel_t** readPixel(FILE* file, header_t header){
    int r = header.height;
    int c = header.width;
    pixel_t **arr = malloc(r * sizeof(pixel_t*));
    for(int i = 0; i < r; i++){
        arr[i] = (pixel_t *)malloc(c * sizeof(pixel_t));
    }
    int z = 0;
    for(int i = 0; i < r; i++){
        for(int u = 0; u < c; u++){
            fscanf(file,"%c%c%c",&arr[i][u].r, &arr[i][u].g, &arr[i][u].b);
        }
    }
    return arr;
}
/*
parameters: 2d array of type pixels and header
frees allocated space
*/
void freeMemory(pixel_t** pixels, header_t header){
    for(int i = 0; i < header.height; i++){
        free(pixels[i]);
    }
    free(pixels);
}
