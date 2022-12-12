#include <iostream.h>
#include <time.h>
#include <stdlib.h>
#include "sort.h"

const int N = 100000;

void QuickSort(int a[], int l, int r)
{
  int i, j, m, v;
  if (r-l >1) {
    m = (l+r)/2;
    if (a[l]>a[m]) swap(a, l, m);
    if (a[l]>a[r]) swap(a, l, r);
    if (a[m]>a[r]) swap(a, m, r);
    swap(a, m, r-1);
    v = a[r-1]; i=l, j=r-`;
    for (;;) {
      while(a[++i]<v);
      while(a[--j]>v);
      if (i>=j) break;
      swap(a, i, j);
    }
    swap(a, i, r-1);
    QuickSort(a, l, i-1);
    QuickSort(a, i+1, r);
  }
  else if (a[l]>a[r]) swap(a, l, r);
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
  cout << "중간 값 분할을 사용한 퀵 정렬의 실행 시간 (N = " << N << ") : " <<
    clock()-start_time << endl;
  CheckSort(a, N);
}
