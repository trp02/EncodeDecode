/*
Tirth Patel
CPSC 2310 F21 Section 001
tirthp@g.clemson.edu
*/

#include "EncodeDecode.h"
#include "ppm.h"
#include <string.h>
#include <stdio.h>
#include <math.h>
 /*
 Parameters: ASCII characters and an int to send val back to
 Changes a character to the binary value
 */
void charToBianary(char letter, int *x){
    int u = *x;
    int decChar = (int)letter;
    int finalNum = 0;
    int rem = 0;
    int temp = 1;
 
    while (decChar != 0){
        rem = decChar % 2;
        decChar = decChar / 2;
        finalNum = finalNum + rem * temp;
        temp = temp * 10;
    }  
    *x = finalNum;
 
}
/*
parameters: array of ints(binary number)
converts values in array to an int and converts in to decimal
prints the decimal value as char
*/
void binToCharacter(int array[]){
int bin = 0; 
for(int i = 0; i < 9; i++){
    if(array[i] == 0){
        bin = bin * 10; 
    }
    if(array[i] == 1){
        bin = bin * 10 + 1;
    }
}
int temp = 0;
int finalDec = 0;
int baseExpo = 1; 
int leastSig = 0;
while(bin > 0){
    leastSig = bin % 10;
    finalDec = (baseExpo * leastSig) + finalDec;
    bin = bin / 10;
    baseExpo = baseExpo * 2; 
}
printf("%c", finalDec);
}
 /*
 Parameters: input/output file and a message
 */
void encodeMsg(FILE* in, FILE* out, char* msg){
    int pixelsRead = 0;
    int charCounter = 0; 
    unsigned char changeNum[9] = {'0','0','0','0','0','0','0','0','0'}; 
    header_t headerSend = readHeader(in);
    writeHeader(out, headerSend);
    int bianaryNum = 0; 
    int numCounter = 0;
    for(int i = 0; i < strlen(msg); i++){
        charToBianary(msg[i], &bianaryNum);
        //reads pixels that will be changed
        for(int i = 0; i < 9; i++){
            fscanf(in, "%c", &changeNum[i]);
            pixelsRead++;
        }
            //replaces last digit of each value w/ 1 or 0
            for(int i = 8; i >= 0; i--){
                int replacement = bianaryNum % 10; 
                if(replacement == 1){
                    changeNum[i] = (changeNum[i]/10) * 10 + 1;
                }
                else{
                    changeNum[i] = (changeNum[i]/10 * 10);
                }
                bianaryNum = bianaryNum/10;
            }
            //prints changed vals
            for(int i = 0; i < 9; i++){
                fprintf(out,"%c",changeNum[i]);
                numCounter++;
            }
        
    }
        //basically a copy paste function from input to output file for rest of pixels
        for(int ii = (pixelsRead/3); ii < (headerSend.height * headerSend.width); ii++){
            unsigned char a,b,c;
            fscanf(in,"%c%c%c",&a,&b,&c);
            fprintf(out,"%c%c%c",a,b,c);
           }
}

/*
Parameter: encoded file
reads the binary stored in the pixels
*/
void decodeMsg(FILE* file){
    header_t hInfo = readHeader(file);
    pixel_t **allPix;
    int binArray[9];
    int binIndex = -1;
    allPix = readPixel(file, hInfo);
    int chkr = 0;
     for(int i = 0; i < hInfo.height; i++){
        for(int u = 0; u < hInfo.width; u++){
            if(chkr == 0){
                int r,g,b;
                r = allPix[i][u].r % 10;
                g = allPix[i][u].g % 10;
                b = allPix[i][u].b % 10;
                //checks if the message is over yet
                if(r == 1 || r == 0){
                    if(g == 1 || g == 0){
                        if(b == 1 || b == 0){
                            binIndex++;
                            binArray[binIndex] = r;
                            binIndex++;
                            binArray[binIndex] = g;
                            binIndex++;
                            binArray[binIndex] = b;
                        }
                        else{
                            chkr = 1;
                        }
                    }
                }
                if(binIndex == 8){
                    for(int i = 0; i < 9; i++){
                    }
                    binToCharacter(binArray);
                    binIndex = -1;
                }
            }
        }
    }
    printf("\n");
    freeMemory(allPix, hInfo);
}