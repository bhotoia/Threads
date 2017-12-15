//Assignment 3 Question 1
//OS Design and Systems Programming
//December 15th 2017
//Amrit Bhotoia and Yilitaerxi Yiliyaer

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <stdint.h>
 
int* data;
int amount, size, avg= 0, sum =0 , min, max, i;



void *avgNumbers(void *vargp)   //Thread for avg
{
    for(i = 0; i < size; i++)  
    {
        sum = sum + data[i];        //Find avg of numbers for command line input
    }
    
    avg = sum/size;
}
 
void *maxNumbers(void *vargp)   //Thread for max
{  
    for(i=0; i<size; i++)
    {
        if(data[i]>max)
        {
            max = data[i];          //Find max of numbers
        }
    }
}
 
void *minNumbers(void *vargp)   //Thread for min
{  
    min = data[1];
   
     for(i=0; i<size; i++)
    {
          if(data[i] <= min)        //Find min of numbers
        {
            min = data[i];
        }
    }  
}
 
int main(int argc, char *argv[])
{
   
    if(argc < 3)
    {
        printf("Error Not Enough Values Given: Please enter more than two numbers\n");  //Error handling for number of values entered
        exit(0);
    }
   
   
    size = argc - 1 ;   //Excludes program name from command line arguments
   
    data  = (int*)calloc( size, sizeof(int) );
 
    for( int i = 0; i < size; i++)  //For loop to go through command line inputs
    {
        sscanf( argv[i + 1], "%d", &data[i] );  //Convert string to an integer
    }
   
    pthread_t avgNum;                                   //Initialize thread
    pthread_create(&avgNum, NULL, avgNumbers, NULL);    //Create thread
    pthread_join(avgNum, NULL);                         //Join thread
   
    printf("Average of Numbers: %d\n", avg);            //Outputs Average
   
    pthread_t maxNum;                                   //Initialize thread
    pthread_create(&maxNum, NULL, maxNumbers, NULL);    //Create thread
    pthread_join(maxNum, NULL);                         //Join thread
   
    printf("Max of Numbers: %d\n", max);                //Outputs Max
   
    pthread_t minNum;                                   //Initialize thread
    pthread_create(&minNum, NULL, minNumbers, NULL);    //Create thread
    pthread_join(minNum, NULL);                         //Join thread
   
    printf("Min of Numbers: %d\n", min);                //Outputs Min
   
   
    exit(0); //Exit Program
}
