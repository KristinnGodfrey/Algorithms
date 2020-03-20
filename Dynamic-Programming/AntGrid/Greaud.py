import numpy as np
import sys
def maur(grind):
    m,n = grind.shape
    # Upphafsstillum hnit og molafjölda
    j = 0
    i = int(m/2)
    molar = 0
    leid = ''
    # Förum í gegnum alla dálka
    while j < n-1:
        if i != n-1 and grind[i+1][j+1] == 1:
            molar += 1
            i += 1
            leid += 'N'
        elif i != 0 and grind[i-1][j+1] == 1:
            molar += 1
            i -= 1
            leid += 'U'
        else:
            if grind[i][j+1] == 1:
                molar += 1
                leid += 'B'
                j += 1
    return (molar, leid)
    # Kóði sem les inn grind
main = sys.stdin.readline().strip().split(', ')
n = int(main[0])
m = int(main[1])
c = int(main[2])
grind = np.zeros([n,m])
for i in range(c):
    l = sys.stdin.readline().strip().split(', ')
    grind[int(l[0])-1, int(l[1])-1] = 1
print(maur(grind))