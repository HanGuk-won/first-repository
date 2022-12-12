#include <iostream.h>
#include <time.h>
#include <stdlib.h>
#include "sort.h"

const int M = 1000;
const int N = 100000;

void CountingSort(int a[], int n, int m)
{
  int i, j, b[n+1], count[m+1];
  for (j=1; j<=m; j++) count[j]=0;
  for (i=1; i<=n; i++) count[a[i]]++;
  for (j=2; j<=m; j++) count[j]+=count[j-1];
  for (i=n; i>=1; i--) b[count[a[i]]--]=a[i];
  for (i=1; i<=n; i++) a[i]=b[i];
}

main()
{
  int i, a[N+1];
  double start_time;
  srand(time(NULL));
  for (i=1; i<=N; i++) a[i] = rand() % M + 1;
  
  start_time = clock();
  CountingSort(a, N, M);
  cout << "계수 정렬의 실행 시간 (N = " << N << ") : " <<
    clock()-start_time << endl;
  CheckSort(a, N);
}
