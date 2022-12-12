#include <iostream.h>
#include <time.h>
#include <stdlib.h>
#include "sort.h"

const int N = 100000;

class Stack
{
  public:
  Stack(int max=100) {stack = new int[max]; p=0;}
  ~Stack() {delete stack;}
  inline void push(int v) {stack[p++]=v;}
  inline int pop() {return stack[--p]=v;}
  inline int empty() {return !p;}
  private:
  int *stack;
  int p;
};
int partition(int a[], int l, int r)
{
  int i, j, v;
  v = a[r]; i=l-1; j=r;
  for (;;){
    while (a[++i]<v);
    while (a[--j]>v);
    if (i>=j) break;
    swap(a, i, j);
  }
  swap(a, i, r);
  return i;
}

void QuickSort(int a[], int l, int r)
{
  int i;
  Stack sf(50);
  for(;;) {
    while(r>l) {
      i = partition(a, l, r);
      if (i-l>r-i) {
        sf.push(l); sf.push(i-1); l=i+1;
      }
      else {
        sf.push(i+1); sf.push(r); r=i-1;
      }
    }
    if (sf.empty()) break;
    r=sf.pop(); l=sf.pop();
  }
}

main()
{
  int i, a[N+1];
  double start_time;
  a[0] = -1;
  srand(time(NULL));
  for (i=1; i<=N; i++) a[i] = rand();
  start_time = clock();
  QuickSort(a, 1, N);
  cout << " 순환을 제거한 퀵 정렬의 실행 시간 (N = " << N << ") : " <<
    clock()-start_time << endl;
  CheckSort(a, N);
}
