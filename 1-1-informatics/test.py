"""
from itertools import *

cnt = -1
for i in permutations("12345", r = 5):
    cnt += 1
    print(i,cnt)
    if cnt == 93:
        print(i,cnt)
print(cnt)

for w in range(10):
    for x in range(10):
        for y in range(10):
            for z in range(10):
                if w*24+x*6+y*2+z == 44:
                    print(w,x,y,z)

print(2*(-10)**3 + 1*(-10)**1 + 8)"""
x = ['I','like','to','study','at','ITMO']
print(x[1:5:2])
q = [None,1,2, (),3, [],]
print(len(q))
