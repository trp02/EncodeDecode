CC = gcc
target = out

C_SRCS := driver.c EncodeDecode.c ppm.c utils.c
HDRS := ppm.h utils.h EncodeDecode.HDR

run:
	@gcc driver.c EncodeDecode.c ppm.c utils.c -o $(target)
	@./$(target) input.ppm output.ppm