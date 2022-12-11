import matplotlib.pyplot as plt
import numpy as np
def f(t, x_d_0, x_d_1):
    return (-(x_d_0)*100*np.log(x_d_0)+50*(x_d_0))**2/x_d_0
def g(t, x_d_0, x_d_1):
    return -100*x_d_1/x_d_0
def explicit_euler(t0, t1, x0, x1, y0, y1, N):
    h = (t1 - t0)/(N+1)
    td = list()
    xd = list()
    yd = list()
    td.append(t0)
    xd.append(np.array([x0, x1]))
    yd.append(np.array([y0, y1]))
    for i in range (1,N+1) :
        x = xd[-1] + h * np.array([xd[-1][1], f(td[-1], xd[-1][0], xd[-1][1])]) 
        y = yd[-1] + h * np.array([yd[-1][1], g(td[-1], xd[-1][0], xd[-1][1])]) 
        print(x,y)
        t = td[-1] + h 
        yd.append(y)
        xd.append(x)
        td.append(t)
    return xd, yd
t0 = 0
t1 = 10
x0 = 2
x1 = 250
y0 = 2
y1 = 250
N = 12000
xd, yd = explicit_euler(t0, t1, x0, x1, y0, y1, N)
xd_1 = list(map(lambda x: x[0], xd))
yd_1 = list(map(lambda y: y[0], yd))
plt.subplot(111, projection='polar')
plt.ylim([0,10])
plt.plot(yd_1, xd_1, linestyle='-', marker='o')
plt.show()
