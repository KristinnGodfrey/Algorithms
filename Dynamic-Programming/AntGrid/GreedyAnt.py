import re 
import math

def GreedyAnt():
    text_file = open("grind-5-6.txt", "r")    
    text = text_file.read().split('\n')        
    text_file.close()
    text = [line.replace(' ', '') for line in text]


    lines = text[0].split(',')[0] #5
    columns = text[0].split(',')[1] #6    
    
    antY = int(lines)
    antY = math.ceil(antY/2)
    antX = 3

    molar = text[1:]
    molar = molar[:-1]
    rett = 0
    output = ""


    for i in range(2,int(columns)+1):
        antY = i

        if(",".join([str(antX+1), str(antY)]) in molar):
            rett = rett+1
            antX = antX+1
            output += "N"
        elif(",".join([str(antX-1), str(antY)]) in molar):
            rett = rett+1
            antX = antX-1
            output += "U"
        elif(",".join([str(antX), str(antY)]) in molar):
            rett = rett+1
            output += "B"
        else:
            output += "B"

             
        

    tmp = ("{} gave us {} sugar cubes")
    return(tmp.format(output,rett))

    """
        1,3
        2,2
        4,4
        5,3
        5,5
        5,6
    """

print(GreedyAnt())