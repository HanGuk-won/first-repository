#include <iostream.h>
#include <time.h>
#include <stdlib.h>


inline void swap(int a[], int i, int j)
{
  int t = a[i]; a[i] = a[j]; a[j] = t;
}

void CheckSort(int a[], int n)
{
  int i, Sorted;
  Sorted = 1;
  for (i=1; i<n; i++){
    if (a[i]>a[i+1]) Sorted = 0;
    if (!Sorted) break;
    }
  if (Sorted) 
  std::cout << "Sort Finished Successfully." << std::endl;
  else 
  std::cout << "Sort error Occured." << std::endl;
}

void SelectionSort(int a[], int n)
{
int i, j, min;
for (i=1; i<n; i++) {
  min = i;
  for (j=i+1; j<=n; j++)
   if (a[j] < a[min]) min = j;
  swap(a, min, i);
  }
}

main()
{
  int N = 10;
  int i, a[N+1];
  double start_time;
  
  srand(time(NULL));
  for (i=1; i<=N; i++) a[i] = rand();
  
  start_time = clock();
  selectionSort(a, N);
  cout << "execution time of Selection Sort (N = " << N << ") : " << clock() - start_time << endl;
  checkSort(a,N);
  }
