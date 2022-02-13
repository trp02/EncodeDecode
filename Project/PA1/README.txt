/*
Tirth Patel
CPSC 2310 F21 Section 001
tirthp@g.clemson.edu
*/

The program will take two files. One image to encode a secret message into 
and the other a file for it to output the encoded image into. The biggest issue
was keeping track of how the characters were read, changed, and printed. Converting
from char to double to int and back to char did get a bit confusing at times but 
not terribly so. Conceptually, drawing out how I wanted my program to work helped a 
lot with the implementation part. For the decoder part I wasn't sure how I wanted 
to read and print the message at once so instead I went through all the pixels and 
as long as all 3 rgb values of the pixels ended in a 1 or 0 it added them to an array. 
Once the array had 9 values it sent it to a different function to translate the binary 
to decimal and print it as a char. 
Overall the assignment was good and covered a lot of useful topics, although I do personally
wish the due date could've been pushed back to after we came back from the break since there 
are a lot of exams the two weeks prior.
