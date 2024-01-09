/* thread-example.c */

#include <pthread.h>
#include <stdio.h>
#include <unistd.h>
#include <stdint.h>
#include <inttypes.h>
#include <malloc.h>

// вы можете реализовать эти функции для более удобного считывания чисел
int64_t read_int64();
size_t read_size();

// заполнить уже выделенный массив array размера size числами
// числа нужно считывать из потока ввода
void array_int_fill( int64_t* array, size_t size ) {

}

// Считать размер массива в *size, выделить память под массив и заполнить его числами, вызвав array_int_fill
int64_t* array_int_read( size_t* size ) {
    int64_t* arr = malloc(sizeof( int64_t ) * (*size));

    return arr;
}

int main(){
    int32_t a = 12;
    int32_t* b = &a;
    int32_t* c = &b;

    printf("%d %d %d", a, b, c);

    return 0;
}
