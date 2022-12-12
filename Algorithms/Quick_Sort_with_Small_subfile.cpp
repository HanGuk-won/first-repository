#include <iostream.h>
#include <time.h>
#include <stdlib.h>
#include "sort.h"

const int N = 100000;
const int M =20;

void InsertionSort(int a[], int l, int r)
{
  int i, j, v;
  for (i=l+1; i<=r; i++) {
    v = a[i]; j=i;
    while (a[j-1]>v) {
      a[j]=a[j-1]; j--;
    }
    a[j]=v;
  }
}

void QuickSort(int a[], int l, int r)
{
  int i, j, v;
  if (r-l <=M) InsertionSort(a,l,r);
  else {
    v = a[r]; i=l-1; j=r;
    for (;;) {
      while (a[++i]<v);
      while (a[--j]>v);
      if (i>=j) break;
      swap(a, i, j);
    }
    swap(a, i, r);
    QuickSort(a, l, i-1);
    QuickSort
