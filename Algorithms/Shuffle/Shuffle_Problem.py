import numpy as np
N=16; M=30
a=[0]*(N)
for i in range(N):
    a[i]=i                                          #원 수열을 0~15의 순서로 정의
def shuffle(a,N) :
    b=[0]*(N)
    for j in range(N):
        if (j>(N-2)/2 and not j==N-1) :             #원 수열의 중간위치 초과의 원소들
            b[2*j-N]=a[j]
        elif (j==N-1):                              #끝 원소의 처리   
            b[N-2]=a[j]
        elif (j<((N-2)/2)):                         #원 수열의 중간위치 미만의 원소들  
            b[2*j+1]=a[j]
        elif (j==((N-2)/2)):                        #원 수열의 중간원소 처리
            b[N-1]=a[j]
        else :
         continue
    return b 
d=0
c=[[0 for _ in range(M)] for _ in range(N)]
c[0][:]=a
cc=list()
cc.append(np.array(a))
for i in range(30):
   c=shuffle(cc[-1],N); d=d+1                          #셔플을 for 문으로 반복적으로 수행
   print(c)
   cc.append(c)    
   if np.array_equal(c,a) :                             #원래의 수열로 돌아왔을 때 처리
    print(d,'iteration spent')
    break
