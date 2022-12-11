from mpl_toolkits.axes_grid1 import make_axes_locatable
from mpl_toolkits.mplot3d import Axes3D
import matplotlib.pyplot as plt
import numpy as np
import math

def S(m,k,B) :
    x=[0]*(m); y=[0]*(m)
    for i in range(0,m):
            x[i]=i; y[i]=i
    f=[[0 for _ in range(0,m)]for _ in range(0,m)]
    g=[[0 for _ in range(0,m)]for _ in range(0,m)]
    p=[[0 for _ in range(0,m)]for _ in range(0,m)]
    h_1=[[0 for _ in range(0,m)]for _ in range(0,m)]
    h_2=[[0 for _ in range(0,m)]for _ in range(0,m)]
    for i in range(0,m):
         for j in range(0,m):
                f[i][j]=(math.sin(k*x[i]/m))*(math.cos(k*y[j]/m))

    g[0][0]=(f[0][0])*(f[1][0])+(f[0][0])*(f[0][1])
    g[0][m-1]=(f[0][m-1])*(f[0][m-2])+(f[0][m-1])*(f[1][m-1])
    g[m-1][0]=(f[m-1][0])*(f[m-2][0])+(f[m-1][0])*(f[m-1][1])
    g[m-1][m-1]=(f[m-1][m-1])*(f[m-1][m-2])+(f[m-1][m-1])*(f[m-2][m-1])
    p[0][0]=(f[0][0])*(f[1][1])
    p[0][m-1]=(f[0][m-1])*(f[1][m-2])
    p[m-1][0]=(f[m-1][0])*(f[m-2][1])
    p[m-1][m-1]=(f[m-1][m-1])*(f[m-2][m-2])
    for i in range(1,m-1):
         g[i][0]=(f[i][0])*(f[i-1][0])+(f[i][0])*(f[i+1][0])+(f[i][0])*(f[i][1])
         g[i][m-1]=(f[i][m-1])*(f[i+1][m-1])+(f[i][m-1])*(f[i-1][m-1]) \
                   +(f[i][m-1])*(f[i][m-2])
         g[0][i]=(f[0][i])*(f[0][i-1])+(f[0][i])*(f[0][i+1])+(f[0][i])*(f[1][i])
         g[m-1][i]=(f[m-1][i])*(f[m-1][i-1])+(f[m-1][i])*(f[m-1][i+1]) \
                   +(f[m-1][i])*(f[m-2][i])          
         p[i][0]=(f[i][0])*(f[i-1][1])+(f[i][0])*(f[i+1][1])
         p[i][m-1]=(f[i][m-1])*(f[i-1][m-2])+(f[i][m-1])*(f[i+1][m-2])
         p[0][i]=(f[0][i])*(f[1][i-1])+(f[0][i])*(f[1][i+1])
         p[m-1][i]=(f[m-1][i])*(f[m-2][i-1])+(f[m-1][i])*(f[m-2][i+1])   
    for k in range(1,m-1):
        for l in range(1,m-1):
         g[k][l]=(f[k][l])*(f[k-1][l])+(f[k][l])*(f[k+1][l])+(f[k][l])*(f[k][l-1]) \
                 +(f[k][l])*(f[k][l+1])     
         p[k][l]=(f[k][l])*(f[k-1][l-1])+(f[k][l])*(f[k-1][l+1])+(f[k][l])*(f[k+1][l+1]) \
                 +(f[k][l])*(f[k+1][l-1])    

    for a in range(0,m):
        for b in range(0,m):
            h_1[a][b]=B*f[a][b]+(g[a][b]/2)
            h_2[a][b]=h_1[a][b]+(1/math.sqrt(2))*(p[a][b]/2)

              
    return f,h_1,h_2

m=100; L=1  
k=(2*np.pi)/L; B=2
F,H_1,H_2=S(m,k,B)
"""
fig=plt.figure(figsize=(8,8))
plt.subplot(111,projection='rectilinear')
mappable = plt.cm.ScalarMappable(cmap=plt.cm.viridis)
mappable.set_array(F)
u=[0]*m; v=[0]*m
for i in range(0,m):
 u[i]=i; v[i]=i 
x,y=np.meshgrid(u,v)
cs=plt.contourf(x,y,F,cmap='viridis')
plt.xlabel('$X$', fontsize=12)
plt.ylabel('$Y$', fontsize=12)
plt.title('Distribution of F in 2D', fontsize=15)
plt.colorbar(mappable)
F.set_clim(-1.0,0.5,1.0)
plt.tight_layout()
plt.show()
"""
fig=plt.figure(figsize=(7,7))
ax_0=plt.subplot(111,projection='3d')
u=[0]*m; v=[0]*m
for i in range(0,m):
 u[i]=i; v[i]=i 
x,y=np.meshgrid(u,v)
ax_0.plot_surface(x,y,np.array(F),linewidth=0.2,antialiased=True)
plt.xlabel('$X(0,1,2,...,m-1)$', fontsize=9)
plt.ylabel('$Y(0,1,2,...,m-1)$', fontsize=9)
plt.title('S at magnetic field B=2T', fontsize=15)
plt.tight_layout()
fig=plt.figure(figsize=(7,7))
ax=plt.subplot(111,projection='3d')
u=[0]*m; v=[0]*m
for i in range(0,m):
 u[i]=i; v[i]=i 
x,y=np.meshgrid(u,v)
ax.plot_surface(x,y,np.array(H_1),linewidth=0.2,antialiased=True,color='gray')
plt.xlabel('$X(0,1,2,...,m-1)$', fontsize=9)
plt.ylabel('$Y(0,1,2,...,m-1)$', fontsize=9)
plt.title('H_1 at magnetic field B=2T', fontsize=15)
plt.tight_layout()
fig=plt.figure(figsize=(7,7))
ax_1=plt.subplot(111,projection='3d')
c=[0]*m; d=[0]*m
for i in range(0,m):
 c[i]=i; d[i]=i 
q,r=np.meshgrid(c,d)
ax_1.plot_surface(q,r,np.array(H_2), linewidth=0.2, antialiased=True,cmap='viridis')
plt.xlabel('$X(0,1,2,...,m-1)$', fontsize=9)
plt.ylabel('$Y(0,1,2,...,m-1)$', fontsize=9)
plt.title('H_2 at magnetic field B=2T', fontsize=15)
plt.tight_layout()
plt.show()
