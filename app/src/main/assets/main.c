#include <stdio.h>
#include <stdlib.h>

void main()
{
    const int currentyear=2020;
    printf("please enter your year of birth\n");
    int yob=0;
    scanf("%d",&yob);
    int age=currentyear-yob;
    printf("your age is:%d",age);

}
