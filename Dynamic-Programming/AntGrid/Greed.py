import numpy as np
import math
#Lesum inn textaskrá
input = open("grind-5-6.txt", "r")
data = []
for line in input:
    data.append([ int(x) for x in line.split(", ") ])
    m = data[0][0]
    n = data[0][1]
    k = data[0][2]
    data = data[1:]

    #Búum til grindina
    sugar = np.zeros([m, n], dtype=int)
    for x in range(len(data)) :
        i = data[x][0]
        j = data[x][1] -1
        sugar[i][j] = 1

def GreedyMaur():
    #upphafsgildi fyrir staðsetningu á maur
    x = 0
    y = math.floor((m-1)/2)
    leid =" "
    molar= sugar[y][x]
    #Hegðun fyrir gráðugan maur
    while(x <(n-1)):
        if((y>0)and sugar[y-1][x+1]==1):
            molar +=1
            x +=1
            y -=1
            leid += "U"
        elif(sugar[y][x+1]==1):
            molar +=1
            x +=1
            leid += "B"
        elif((y<m-1)and sugar[y+1][x+1]):
            molar +=1
            x +=1
            leid += "N"
        else:
            x +=1
            leid += "B"
            print("leid: ",leid)
            print("Fjöldi mola: ",molar)

#Búum til dynamic maur
def DynamicMaur():
#Upphafsgildi
    x = 0
    y = math.floor((m-1)/2)
    bestaleid = np.array(sugar) #fylki úr b)lið
    leid =" "
    for a in range(n-2,0,-1):
        for b in range(m-1,-1,-1):
            if(b<1):
                bestaleid[b][a] += max(bestaleid[b][a+1],bestaleid[b+1][a+1])
            elif(b==m-1):
                bestaleid[b][a] += max(bestaleid[b][a+1],bestaleid[b-1][a+1])
            else:
                bestaleid[b][a] += max(bestaleid[b][a+1],
                bestaleid[b-1][a+1],bestaleid[b+1][a+1])
    molar= max((bestaleid[y+1][x+1]),(bestaleid[y][x+1]),(bestaleid[y-1][x+1]))

    #Hegðun maurs
    while(x <(n-1)):
    #Skilyrði fyrir efri jaðar
        if(y==0):
            maximum = np.argmax([bestaleid[y][x+1],bestaleid[y+1][x+1]])
        if(maximum ==0):
            x +=1
            leid += "B"
        elif(maximum==1):
            x+=1
            y+=1
            leid += "N"
        #Skilyrði fyrir neðri jaðar
        elif(y==m-1):
            maximum = np.argmax([bestaleid[y][x+1],bestaleid[y-1][x+1]])
        if(maximum==0):
            x+=1
            leid += "B"
        elif(maximum==1):
            x+=1
            y-=1
            leid +="U"
        else:
            maximum = np.argmax([bestaleid[y][x+1],bestaleid[y-1][x+1],bestaleid[y+1][x+1]]
            )
        if(maximum==0):
            x+=1
            leid += "B"
        elif(maximum==1):
            x+=1
            y-=1
            leid +="U"
        elif(maximum==2):
            x+=1
            y+=1
            leid += "N"
    print("leid: ",leid)
    print("Fjöldi mola: ",molar)



    print("Gráðugur Maur")
    GreedyMaur()
    print("Dynamic Maur")
    DynamicMaur()